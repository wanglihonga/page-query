package com.mju.ssm.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mju.ssm.service.BaseService;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private Mapper<T> mapper;

    public void setMapper(Mapper<T> mapper) {
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public void save(T t) {
        this.mapper.insert(t);
    }

    @Transactional
    @Override
    public void delete(T t) {
        this.mapper.delete(t);
    }

    @Transactional
    @Override
    public void update(T t) {
        this.mapper.updateByPrimaryKey(t);
    }

    @Override
    public List<T> findByExample(Example example) {
        return this.mapper.selectByExample(example);
    }

    @Override
    public T findByPrimaryKey(Serializable id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAll() {
        return this.mapper.selectAll();
    }

    @Override
    public void deleteByPrimaryKey(Serializable id) {
        this.mapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<T> findWithPageInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<T> list = this.mapper.selectAll();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
