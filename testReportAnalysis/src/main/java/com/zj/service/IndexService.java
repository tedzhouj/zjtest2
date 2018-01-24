package com.zj.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zj.common.dto.IndexAnalysisInfo;
import com.zj.common.dto.IndexDataItem;
import com.zj.common.dto.IndexData;
import com.zj.common.enums.IndexTypeEnum;
import com.zj.common.req.IndexValueReq;
import com.zj.dao.mapper.IdxInfoMapper;
import com.zj.dao.mapper.IdxValueManualMapper;
import com.zj.dao.mapper.IdxValueMapper;
import com.zj.dao.model.IdxInfo;
import com.zj.dao.model.IdxValue;
import com.zj.dao.model.IdxValueManual;
import com.zj.util.DateCalculateUtil;
import com.zj.util.DateUtil;
import com.zj.util.IndexUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by zhoujun on 2017/11/4.
 */
@Service
@Slf4j
public class IndexService {

    @Autowired
    IdxInfoMapper infoMapper;

    @Autowired
    IdxValueMapper idxValueMapper;

    @Autowired
    IdxValueManualMapper idxValueManualMapper;


    //get single index value : by day and label and productCode and orgCode and  indexId
    public IndexData getIndexs(IndexValueReq req) throws Exception {
        Map<String, String> reqMap = new HashMap<>();
        setReqMap(req, reqMap);

        IndexData indexValues = new IndexData();
        indexValues.setIndexId(req.getIndexId());

        String indexId = req.getIndexId();

        IdxInfo idxInfo = infoMapper.selectByPrimaryKey(indexId);
        if (idxInfo == null) {
            return indexValues;
        }

        IndexTypeEnum indexTypeEnum = IndexTypeEnum.explain(idxInfo.getIndexType());
        switch (indexTypeEnum) {
            //基础指标
            case BASIC:
                setDataList(reqMap, indexValues);
                break;
            //复合指标
            case COMPLEX:
                String func = idxInfo.getIndexFunction();
                List<String> indexIds = IndexUtil.explainIndex(func);

                HashMap<String, IndexData> indexValuesList = new HashMap<>();
                //查询所有涉及的指标的值
                for (String subIdx : indexIds) {
                    IndexValueReq newReq = (IndexValueReq) req.clone();
                    newReq.setIndexId(subIdx);
                    indexValuesList.put(subIdx, getIndexs(newReq));//递归查询值

                }
                List<String> dateList = DateCalculateUtil.findDates(DateUtil.parse(req.getBeginDate(), "yyyy-MM-dd"),
                        DateUtil.parse(req.getEndDate(), "yyyy-MM-dd"));

                List<IndexDataItem> complexIdxValueList = new ArrayList<>();
                //遍历每天的数据
                for (String date : dateList) {
                    Map<String, BigDecimal> map = Maps.newHashMap();
                    //复合指标子指标聚集
                    for (String subIdx : indexIds) {
                        List<IndexDataItem> findValueItems = indexValuesList.get(subIdx).getDataList().stream().filter(r -> r.getDate().equals(date)).collect(Collectors.toList());
                        if (CollectionUtils.isNotEmpty(findValueItems)) {
                            map.put(subIdx, findValueItems.get(0).getIndex_value());
                        } else {
                            map.put(subIdx, new BigDecimal(0L));
                        }
                    }
                    //计算一天的数据
                    IndexDataItem items = new IndexDataItem(date, IndexUtil.evaluate(func, map));
                    complexIdxValueList.add(items);
                    map = null;
                }
                indexValues.setDataList(complexIdxValueList);
                break;
            //手工录入指标
            case MANUAL:
                setManualDataList(reqMap, indexValues);
                break;
            case RANK:
                break;

        }
        return indexValues;
    }

    private void setManualDataList(Map<String, String> reqMap, IndexData indexValues) {
        List<IdxValueManual> ManualValueList = idxValueManualMapper.selectByCondition(reqMap);
        List<IndexDataItem> ManualResult = ManualValueList.stream().map(r -> {
            return new IndexDataItem(DateUtil.format(r.getCreatedDate(), "yyyy-MM-dd"), r.getValue());
        }).collect(Collectors.toList());
        indexValues.setDataList(ManualResult);
    }

    private void setDataList(Map<String, String> reqMap, IndexData indexValues) {
        List<IdxValue> valueList = idxValueMapper.selectByCondition(reqMap);
        List<IndexDataItem> result = valueList.stream().map(r -> {
            return new IndexDataItem(DateUtil.format(r.getCreatedDate(), "yyyy-MM-dd"), r.getValue());
        }).collect(Collectors.toList());
        indexValues.setDataList(result);
    }

    private void setReqMap(IndexValueReq req, Map<String, String> reqMap) {
        reqMap.put("startDate", req.getBeginDate());
        reqMap.put("endDate", req.getEndDate());
        reqMap.put("orgCode", req.getOrgCode());
        reqMap.put("productCode", req.getProductCode());
        reqMap.put("label", req.getLabel());
        reqMap.put("indexId", req.getIndexId());
        reqMap.put("regChannel", "ALL");
        reqMap.put("subChannel", "ALL");
    }

    //获取一个指标的所有相关信息
    public IndexAnalysisInfo getIndexInfo(String indexId) {
        IndexAnalysisInfo indexAnalysisInfo = new IndexAnalysisInfo();
        IdxInfo idxInfo = infoMapper.selectByPrimaryKey(indexId);

        if (idxInfo == null) {
            return indexAnalysisInfo;
        }

        IndexTypeEnum indexTypeEnum = IndexTypeEnum.explain(idxInfo.getIndexType());
        indexAnalysisInfo.setIndexId(indexId);
        indexAnalysisInfo.setIndexName(idxInfo.getIndexName());
        indexAnalysisInfo.setIndexContent(idxInfo.getIndexContent());
        indexAnalysisInfo.setIndexConvertInfo("");//todo

        indexAnalysisInfo.setIndexType(idxInfo.getIndexType());
        String func = idxInfo.getIndexFunction();
        if (indexTypeEnum.equals(IndexTypeEnum.COMPLEX)) {
            List<String> indexIds = IndexUtil.explainIndex(func);
            List<IndexAnalysisInfo> subIdxList = Lists.newArrayList();
            for (String subIdx : indexIds) {
                subIdxList.add(getIndexInfo(subIdx));
            }
            indexAnalysisInfo.setRelativeIndexs(subIdxList);
        }
        indexAnalysisInfo.setIndexfunc(func);

        return indexAnalysisInfo;
    }




















}
