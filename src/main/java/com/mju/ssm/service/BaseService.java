package com.mju.ssm.service;

import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
    public void save(T t);

    public void delete(T t);

    public void update(T t);

    public List<T> findByExample(Example example);

    public T findByPrimaryKey(Serializable id);

    public List<T> findAll();

    public void deleteByPrimaryKey(Serializable id);

    public PageInfo<T> findWithPageInfo(Integer pageNum,Integer pageSize);
}

