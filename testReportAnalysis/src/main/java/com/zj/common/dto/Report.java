package com.zj.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by zhoujun on 2017/11/7.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    private String reportId;
    private String reportDescription;

    private List<ReportItem> reportItemList;

}
