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
public class IndexAnalysisInfo {

    private String indexId;
    private String indexName;
    private String indexType;
    private String indexfunc;
    private List<IndexAnalysisInfo> relativeIndexs;
    private String indexContent;
    private String indexConvertInfo;

}
