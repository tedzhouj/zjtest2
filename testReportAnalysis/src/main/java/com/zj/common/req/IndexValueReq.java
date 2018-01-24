package com.zj.common.req;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * Created by zhoujun on 2017/11/5.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IndexValueReq implements Cloneable {
    @ApiModelProperty(value = "起始时间", required = true, example = "2017-11-01")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "时间格式不正确")
    private String beginDate = "2017-11-06";
    @ApiModelProperty(value = "截止时间", required = true, example = "2017-11-10")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "时间格式不正确")
    private String endDate = "2017-11-07";

    @ApiModelProperty(value = "标签", required = true, example = "ALL")
    private String label = "ALL";
    @ApiModelProperty(value = "产品号", required = true, example = "ZFQPDLOAN001")
    private String productCode = "ZFQPDLOAN001";
    @ApiModelProperty(value = "机构号", required = true, example = "8018000000000498")
    private String orgCode = "8018000000000498";
    @ApiModelProperty(value = "渠道", required = true, example = "ALL")
    private String channel = "ALL";
    @ApiModelProperty(value = "指标号", required = true)
    private String indexId;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
