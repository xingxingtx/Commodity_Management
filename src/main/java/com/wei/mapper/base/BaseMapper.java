package com.wei.mapper.base;

import org.apache.shiro.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:service
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/11/29 10:56
 * @Version: 1.0
 */
public interface BaseMapper<T> {
    Integer insert(T var1)throws DataAccessException;

    Integer insertBatch(List<T> var1)throws DataAccessException;

    Integer insertBatch(List<T> var1, int var2)throws DataAccessException;

    Integer insertOrUpdateBatch(List<T> var1)throws DataAccessException;

    Integer insertOrUpdateBatch(List<T> var1, int var2)throws DataAccessException;

    Integer deleteById(Serializable var1)throws DataAccessException;

    Integer deleteByMap(Map<String, Object> var1)throws DataAccessException;

    Integer delete(T var1)throws DataAccessException;

    Integer deleteBatchIds(List<? extends Serializable> var1)throws DataAccessException;

    Integer update(T var1)throws DataAccessException;

    Integer updateById(Integer var1)throws DataAccessException;

    Integer updateBatchById(List<T> var1)throws DataAccessException;

    Integer updateBatchById(List<T> var1, int var2)throws DataAccessException;

    Integer insertOrUpdate(T var1)throws DataAccessException;

    T selectById(Serializable var1)throws DataAccessException;

    List<T> selectBatchIds(List<? extends Serializable> var1)throws DataAccessException;

    List<T> selectByMap(Map<String, Object> var1)throws DataAccessException;

    int getAllByPageCount(Map<String, Object> map) throws DataAccessException;

    List<T> getAllByPage(Map<String, Object> map) throws DataAccessException;

}
