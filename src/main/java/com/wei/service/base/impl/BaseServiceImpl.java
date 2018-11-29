package com.wei.service.base.impl;/**
 * Created by Administrator on 2018/11/29.
 */

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.wei.mapper.base.BaseMapper;
import com.wei.service.base.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:BaseServiceImpl
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/11/29 11:37
 * @Version: 1.0
 */
public class BaseServiceImpl<M extends BaseMapper<T>,T> implements IBaseService<T>{
    private static final Log logger = LogFactory.getLog(BaseServiceImpl.class);
    @Autowired
    protected M baseMapper;

    public BaseServiceImpl() {
    }

    @Override
    public Integer insert(T var1) {
        return baseMapper.insert(var1);
    }

    @Override
    public Integer insertBatch(List<T> var1) {
        return null;
    }

    @Override
    public Integer insertBatch(List<T> var1, int var2) {
        return null;
    }

    @Override
    public Integer insertOrUpdateBatch(List<T> var1) {
        return null;
    }

    @Override
    public Integer insertOrUpdateBatch(List<T> var1, int var2) {
        return null;
    }

    @Override
    public Integer deleteById(Serializable var1) {
        return null;
    }

    @Override
    public Integer deleteByMap(Map<String, Object> var1) {
        return null;
    }

    @Override
    public Integer delete(T var1) {
        return null;
    }

    @Override
    public Integer deleteBatchIds(List<? extends Serializable> var1) {
        return null;
    }

    @Override
    public Integer update(T var1) {
        return null;
    }

    @Override
    public Integer updateById(Integer var1) {
        return null;
    }

    @Override
    public Integer updateBatchById(List<T> var1) {
        return null;
    }

    @Override
    public Integer updateBatchById(List<T> var1, int var2) {
        return null;
    }

    @Override
    public Integer insertOrUpdate(T var1) {
        return null;
    }

    @Override
    public T selectById(Serializable var1) {
        return null;
    }

    @Override
    public List<T> selectBatchIds(List<? extends Serializable> var1) {
        return null;
    }

    @Override
    public List<T> selectByMap(Map<String, Object> var1) {
        return null;
    }
}
