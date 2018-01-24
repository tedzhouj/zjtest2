package com.zj.service;

import com.google.common.collect.Lists;
import com.zj.common.dto.Report;
import com.zj.common.dto.ReportItem;
import com.zj.dao.mapper.IdxReportModelMapper;
import com.zj.dao.model.IdxReportModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhoujun on 2017/11/7.
 */
@Service
@Slf4j
public class ReportService {

    @Autowired
    IdxReportModelMapper idxReportModelMapper;
    @Autowired
    IndexService indexService;

    public Report getReportById(String reportId) {
        Report report = new Report();
        List<ReportItem> reportItems = Lists.newArrayList();
        report.setReportId(reportId);

        List<IdxReportModel> reportModelItems = idxReportModelMapper.selectByReportId(reportId);

        reportModelItems.forEach(r -> addReportItems(reportItems, r));
        report.setReportItemList(reportItems);

        return report;
    }


    private void addReportItems(List<ReportItem> reportItems, IdxReportModel r) {
        ReportItem reportItem = new ReportItem();
        reportItem.setItemId(r.getItemId().toString());
        reportItem.setItemName(r.getItemName());
        reportItem.setLabel(r.getLabel());
        reportItem.setIndexAnalysisInfo(indexService.getIndexInfo(r.getIndexId()));
        reportItems.add(reportItem);
    }


}
