package com.xinbang.credit.zj.dao.auth.mapper;

import com.xinbang.credit.zj.dao.auth.model.CustomerImageAuthInfo;

public interface CustomerImageAuthInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(CustomerImageAuthInfo record);

    int insertSelective(CustomerImageAuthInfo record);

    CustomerImageAuthInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomerImageAuthInfo record);

    int updateByPrimaryKey(CustomerImageAuthInfo record);
}