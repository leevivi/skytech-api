package com.skytech.api.core.service;


import com.skytech.api.core.Pagination;
import com.skytech.api.core.model.BaseModel;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T extends BaseModel<PK>, PK extends Serializable> {
    int deleteByPrimaryKey(PK var1);

    int insert(T var1);

    int insertSelective(T var1);

    T selectByPrimaryKey(PK var1);

    int updateByPrimaryKeySelective(T var1);

    int updateByPrimaryKey(T var1);

    Pagination<T> queryByPage(T var1, int var2, int var3);

    List<T> queryAll();

    int countAll();
}

