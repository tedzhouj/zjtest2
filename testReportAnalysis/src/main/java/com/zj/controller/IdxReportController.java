package com.zj.controller;

import com.google.common.collect.Lists;
import com.google.common.net.HttpHeaders;
import com.zj.common.dto.IndexAnalysisInfo;
import com.zj.common.dto.IndexContentWithValueDayInfo;
import com.zj.common.dto.IndexData;
import com.zj.common.dto.Report;
import com.zj.common.req.IndexValueReq;
import com.zj.service.IndexService;
import com.zj.service.ReportService;
import com.zj.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by zhoujun on 2017/11/6.
 */

@RestController
@RequestMapping(value = "/report/v1")
@Api(tags = "Query", description = "查询")
@CrossOrigin
@Slf4j
public class IdxReportController {

    @Autowired
    IndexService indexService;

    @Autowired
    ReportService reportService;


    @ApiOperation(value = "查询指标值(历史区间,单值)")
    @PostMapping("/getIndexValue")
    public IndexData getIndexValue(@RequestBody @Valid IndexValueReq req) {
        IndexData rsp = new IndexData();
        try {
            rsp = indexService.getIndexs(req);
            rsp.getDataList().sort((a, b) ->
                    DateUtil.parse(a.getDate(), "yyyy-MM-dd").after(DateUtil.parse(b.getDate(), "yyyy-MM-dd")) ? 1 : -1);
            return rsp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsp;
    }

    @ApiOperation(value = "查询报表内容")
    @GetMapping("/getReportInfo")
    public Report getReportInfo(String reportId) {
        return reportService.getReportById(reportId);
    }

    @ApiOperation(value = "查询单一指标内容")
    @GetMapping("/getSingleIndexInfo")
    public IndexAnalysisInfo getSingleIndexInfo(String indexId) {
        return indexService.getIndexInfo(indexId);
    }

    @ApiOperation(value = "查询单一指标某日相关涉及数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "date", required = true, value = "date", dataType = "String", example = "2017-11-23")
    })
    @GetMapping("/getSingleIndexDayValue")
    public IndexContentWithValueDayInfo getSinglIndexValueByDay(String indexId, String date) {
        IndexContentWithValueDayInfo indexContentWithValueDayInfo = new IndexContentWithValueDayInfo();

        Date ocDate = DateUtil.parse(date, "yyyy-MM-dd");
        //简化版本
        IndexValueReq req = new IndexValueReq();
        req.setOrgCode("8018000000000498");
        req.setBeginDate(date);
        req.setEndDate(date);
        req.setChannel("ALL");
        req.setLabel("ALL");
        req.setProductCode("ZFQPDLOAN001");

        IndexAnalysisInfo indexAnalysisInfo = getSingleIndexInfo(indexId);
        if (indexAnalysisInfo == null) {
            return indexContentWithValueDayInfo;
        }
        indexContentWithValueDayInfo = convertToDayValueInfo(indexAnalysisInfo, date);

        return indexContentWithValueDayInfo;
    }


    public IndexContentWithValueDayInfo convertToDayValueInfo(IndexAnalysisInfo indexAnalysisInfo, String date) {
        IndexContentWithValueDayInfo indexContentWithValueDayInfo = new IndexContentWithValueDayInfo();
        indexContentWithValueDayInfo.setIndexContent(indexAnalysisInfo.getIndexContent());
        indexContentWithValueDayInfo.setIndexConvertInfo(indexAnalysisInfo.getIndexConvertInfo());
        indexContentWithValueDayInfo.setIndexfunc(indexAnalysisInfo.getIndexfunc());
        indexContentWithValueDayInfo.setIndexId(indexAnalysisInfo.getIndexId());
        indexContentWithValueDayInfo.setIndexName(indexAnalysisInfo.getIndexName());
        indexContentWithValueDayInfo.setIndexType(indexAnalysisInfo.getIndexType());
        indexContentWithValueDayInfo.setDate(date);

        IndexValueReq req = new IndexValueReq();
        req.setOrgCode("8018000000000498");
        req.setBeginDate(date);
        req.setEndDate(date);
        req.setChannel("ALL");
        req.setLabel("ALL");
        req.setProductCode("ZFQPDLOAN001");

        req.setIndexId(indexAnalysisInfo.getIndexId());

        IndexData indexData = getIndexValue(req);
        if (indexData != null && indexData.getDataList() != null && indexData.getDataList().size() > 0) {
            indexContentWithValueDayInfo.setValue(indexData.getDataList().get(0).getIndex_value());
        } else {
            indexContentWithValueDayInfo.setValue(new BigDecimal(0L));
        }

        List<IndexContentWithValueDayInfo> lists = Lists.newArrayList();
        if (indexAnalysisInfo.getRelativeIndexs() != null) {
            indexAnalysisInfo.getRelativeIndexs().forEach(r -> {
                lists.add(convertToDayValueInfo(r, date));
            });
            indexContentWithValueDayInfo.setRelativeIndexs(lists);
        }


        return indexContentWithValueDayInfo;
    }


}
