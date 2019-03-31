package com.skytech.api.core.service;

import com.skytech.api.core.Pagination;
import com.skytech.api.core.model.BaseModelOne;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiWei on 2019/3/31.
 */
public interface GenericOneService<T extends BaseModelOne<PK>, PK extends Serializable>  {

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
