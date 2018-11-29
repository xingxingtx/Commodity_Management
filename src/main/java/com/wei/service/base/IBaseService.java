package com.wei.service.base;

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
public interface IBaseService<T> {
    Integer insert(T var1);

    Integer insertBatch(List<T> var1);

    Integer insertBatch(List<T> var1, int var2);

    Integer insertOrUpdateBatch(List<T> var1);

    Integer insertOrUpdateBatch(List<T> var1, int var2);

    Integer deleteById(Serializable var1);

    Integer deleteByMap(Map<String, Object> var1);

    Integer delete(T var1);

    Integer deleteBatchIds(List<? extends Serializable> var1);

    Integer update(T var1);

    Integer updateById(Integer var1);

    Integer updateBatchById(List<T> var1);

    Integer updateBatchById(List<T> var1, int var2);

    Integer insertOrUpdate(T var1);

    T selectById(Serializable var1);

    List<T> selectBatchIds(List<? extends Serializable> var1);

    List<T> selectByMap(Map<String, Object> var1);


}
