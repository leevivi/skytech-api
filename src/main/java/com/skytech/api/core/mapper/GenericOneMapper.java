package com.skytech.api.core.mapper;

import com.skytech.api.core.model.BaseModelExample;
import com.skytech.api.core.model.BaseModelOne;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiWei on 2019/3/29.
 */
public interface GenericOneMapper <T extends BaseModelOne<PK>, TE extends BaseModelExample, PK extends Serializable> {
    int countByExample(TE example);

    int deleteByExample(TE example);

    int deleteByPrimaryKey(PK id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(TE example);

    T selectByPrimaryKey(PK id);

    int updateByExampleSelective(@Param("record") T record,
                                 @Param("example") TE example);

    int updateByExample(@Param("record") T record, @Param("example") TE example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
