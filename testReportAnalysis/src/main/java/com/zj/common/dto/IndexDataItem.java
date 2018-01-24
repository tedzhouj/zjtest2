package com.zj.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by zhoujun on 2017/11/5.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexDataItem {

    private String date;

    private BigDecimal index_value;

}
