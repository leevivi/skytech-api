package com.skytech.api.core.service.impl;

import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericMapper;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.model.BaseModelExample;
import com.skytech.api.core.model.BaseModelOne;
import com.skytech.api.core.service.GenericOneService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiWei on 2019/3/31.
 */
public abstract class GenericOneServiceImpl<T extends BaseModelOne<PK>, TE extends BaseModelExample, PK extends Serializable> implements GenericOneService<T, PK> {
    public GenericOneServiceImpl() {
    }

    protected abstract GenericOneMapper<T, TE, PK> getGenericOneMapper();

    public int deleteByPrimaryKey(PK id) {
        return this.getGenericOneMapper().deleteByPrimaryKey(id);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public int insert(T entity) {
        return this.getGenericOneMapper().insert(entity);
    }

    public int insertSelective(T entity) {
        return this.getGenericOneMapper().insertSelective(entity);
    }

    public T selectByPrimaryKey(PK id) {
        return this.getGenericOneMapper().selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(T entity) {
        return this.getGenericOneMapper().updateByPrimaryKeySelective(entity);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public int updateByPrimaryKey(T entity) {
        return this.getGenericOneMapper().updateByPrimaryKey(entity);
    }

    public Pagination<T> queryByPage(T record, int start, int pageSize) {
        throw new RuntimeException("该方法需要在子类覆盖实现");
    }

    public List<T> queryAll() {
        return this.getGenericOneMapper().selectByExample(null);
    }

    public int countAll() {
        return this.getGenericOneMapper().countByExample(null);
    }

    protected List<T> selectByExample(TE entity) {
        return this.getGenericOneMapper().selectByExample(entity);
    }

    protected int countByExample(TE example) {
        return this.getGenericOneMapper().countByExample(example);
    }

    protected int deleteByExample(TE example) {
        return this.getGenericOneMapper().deleteByExample(example);
    }

    protected int updateByExampleSelective(T record, TE example) {
        return this.getGenericOneMapper().updateByExampleSelective(record, example);
    }

    protected int updateByExample(T record, TE example) {
        return this.getGenericOneMapper().updateByExample(record, example);
    }

    protected Pagination<T> queryByPage(TE example, int start, int pageSize, String orderByClause, boolean distinct) {
        Pagination<T> pagination = new Pagination(start, pageSize);
        example.setPagination(pagination);
        example.setOrderByClause(orderByClause);
        example.setDistinct(distinct);
        List<T> list = this.getGenericOneMapper().selectByExample(example);
        int count = this.getGenericOneMapper().countByExample(example);
        pagination.setDataList(list);
        pagination.setTotalRowNumber(count);
        return pagination;
    }

    protected Pagination<T> queryByPage(TE example, int start, int pageSize, String orderByClause) {
        return this.queryByPage(example, start, pageSize, orderByClause, false);
    }

    protected Pagination<T> queryByPage(TE example, int start, int pageSize) {
        return this.queryByPage(example, start, pageSize, (String) null, false);
    }
}
