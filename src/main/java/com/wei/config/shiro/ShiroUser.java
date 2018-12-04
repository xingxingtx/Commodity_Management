/**
 *
 */
package com.wei.config.shiro;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @description：自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * @author：weipeng
 * @date：2018/12/4 15:25
 */
@Data
public class ShiroUser implements Serializable {
    private static final long serialVersionUID = -1373760761780840081L;
    
    private Long id;
    private final String loginName;
    private String name;
    private Set<String> urlSet;
    private Set<String> roles;

    public ShiroUser(String loginName) {
        this.loginName = loginName;
    }

    public ShiroUser(Long id, String loginName, String name, Set<String> urlSet) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.urlSet = urlSet;
    }
}