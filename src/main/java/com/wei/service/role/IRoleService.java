package com.wei.service.role;

import java.util.Map;
import java.util.Set;

/**
 * @ClassName:IRoleService
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/5 14:54
 * @Version: 1.0
 */
public interface IRoleService {
    Map<String, Set<String>> selectResourceMapByUserId(Integer id);
}
