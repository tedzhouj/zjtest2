package com.zj.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by zhoujun on 2017/11/5.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexData {

    private String indexId;
    private List<IndexDataItem> dataList;

}
