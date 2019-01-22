package com.skytech.api.core.service.impl;


import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericMapper;
import com.skytech.api.core.model.BaseModel;
import com.skytech.api.core.model.BaseModelExample;
import com.skytech.api.core.service.GenericService;

import java.io.Serializable;
import java.util.List;

public abstract class GenericServiceImpl<T extends BaseModel<PK>, TE extends BaseModelExample, PK extends Serializable> implements GenericService<T, PK> {
    public GenericServiceImpl() {
    }

    protected abstract GenericMapper<T, TE, PK> getGenericMapper();

    public int deleteByPrimaryKey(PK id) {
        return this.getGenericMapper().deleteByPrimaryKey(id);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public int insert(T entity) {
        return this.getGenericMapper().insert(entity);
    }

    public int insertSelective(T entity) {
        return this.getGenericMapper().insertSelective(entity);
    }

    public T selectByPrimaryKey(PK id) {
        return this.getGenericMapper().selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(T entity) {
        return this.getGenericMapper().updateByPrimaryKeySelective(entity);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public int updateByPrimaryKey(T entity) {
        return this.getGenericMapper().updateByPrimaryKey(entity);
    }

    public Pagination<T> queryByPage(T record, int start, int pageSize) {
        throw new RuntimeException("该方法需要在子类覆盖实现");
    }

    public List<T> queryAll() {
        return this.getGenericMapper().selectByExample(null);
    }

    public int countAll() {
        return this.getGenericMapper().countByExample(null);
    }

    protected List<T> selectByExample(TE entity) {
        return this.getGenericMapper().selectByExample(entity);
    }

    protected int countByExample(TE example) {
        return this.getGenericMapper().countByExample(example);
    }

    protected int deleteByExample(TE example) {
        return this.getGenericMapper().deleteByExample(example);
    }

    protected int updateByExampleSelective(T record, TE example) {
        return this.getGenericMapper().updateByExampleSelective(record, example);
    }

    protected int updateByExample(T record, TE example) {
        return this.getGenericMapper().updateByExample(record, example);
    }

    protected Pagination<T> queryByPage(TE example, int start, int pageSize, String orderByClause, boolean distinct) {
        Pagination<T> pagination = new Pagination(start, pageSize);
        example.setPagination(pagination);
        example.setOrderByClause(orderByClause);
        example.setDistinct(distinct);
        List<T> list = this.getGenericMapper().selectByExample(example);
        int count = this.getGenericMapper().countByExample(example);
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
