package com.zj.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhoujun on 2017/11/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexContentWithValueDayInfo {


    private String indexId;
    private String indexName;
    private String indexType;
    private String indexfunc;
    private String date;
    private BigDecimal value;

    private List<IndexContentWithValueDayInfo> relativeIndexs;

    private String indexContent;
    private String indexConvertInfo;
}
