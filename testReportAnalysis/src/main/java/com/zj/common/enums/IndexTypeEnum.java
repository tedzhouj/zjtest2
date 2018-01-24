package com.zj.common.enums;

import lombok.Getter;

/**
 * Created by zhoujun on 2017/11/4.
 */
@Getter
public enum IndexTypeEnum {


    BASIC("BASIC","基本类型"),
    COMPLEX("COMPLEX","复合类型"),
    MANUAL("MANUAL","手动录入"),
    RANK("RANK","排名类型")
    ;

    private String code;

    private String desc;

    IndexTypeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static IndexTypeEnum explain(String code) {
        for (IndexTypeEnum e : IndexTypeEnum.values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }



}
