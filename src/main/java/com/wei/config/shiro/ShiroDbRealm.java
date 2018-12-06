package com.wei.config.shiro;
import com.wei.model.user.UserModel;
import com.wei.service.role.IRoleService;
import com.wei.service.user.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName:权限认证
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/4 15:13
 * @Version: 1.0
 */
public class ShiroDbRealm extends AuthorizingRealm {
    private static final Logger log = LogManager.getLogger(ShiroDbRealm.class);
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    public ShiroDbRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
    }

    /**
     * 授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情，
     * 常见的如：验证某个用户是否拥有某个角色。或者细粒度的验证某个用户对某个资源是否具有某个权限；
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        ShiroUser shiroUser = (ShiroUser) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(shiroUser.getRoles());
        info.addStringPermissions(shiroUser.getUrlSet());
        return info;
    }


    /**
     * Shiro身份认证/登录，验证用户是不是拥有相应的身份
     * (原理：用户提交 用户名和密码  --- shiro 封装令牌 ----
     * realm 通过用户名将密码查询返回 ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        UserModel model = new UserModel();
        model.setLoginName(token.getUsername());
        List<UserModel> list = userService.selectByLoginName(model);
        // 账号不存在
        if (list == null || list.isEmpty()) {
            return null;
        }
        UserModel user = list.get(0);
        // 账号未启用
        if (user.getState() == 1) {
            return null;
        }
        // 读取用户的url和角色
        Map<String, Set<String>> resourceMap = roleService.selectResourceMapByUserId(user.getId());
        Set<String> urls = resourceMap.get("urls");
        Set<String> roles = resourceMap.get("roles");
        ShiroUser shiroUser = new ShiroUser(user.getId(), user.getLoginName(), user.getName(), urls);
        shiroUser.setRoles(roles);
        // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, user.getPassword().toCharArray(),
                ShiroByteSource.of(user.getSalt()), getName());
    }
    @Override
    protected Object getAuthenticationCacheKey(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) super.getAvailablePrincipal(principals);
        return shiroUser.toString();
    }

    @Override
    protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) super.getAvailablePrincipal(principals);
        return shiroUser.toString();
    }

    /**
     * 清除用户缓存
     * @param shiroUser
     */
    public void removeUserCache(ShiroUser shiroUser){
        SimplePrincipalCollection principals = new SimplePrincipalCollection();
        principals.add(shiroUser, super.getName());
        super.clearCache(principals);
    }

    /**
     * 清除用户缓存
     * @param loginName
     */
    public void removeUserCache(String loginName){
        removeUserCache(new ShiroUser(loginName));
    }
}
