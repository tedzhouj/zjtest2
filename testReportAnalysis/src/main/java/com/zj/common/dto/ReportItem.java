package com.zj.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhoujun on 2017/11/7.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportItem {
    private String itemId;
    private String itemName;
    private IndexAnalysisInfo indexAnalysisInfo;
    private String label;
}
