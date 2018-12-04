package com.wei.config.shiro;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @ClassName:权限认证
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/4 15:13
 * @Version: 1.0
 */
public class ShiroDbRealm extends AuthorizingRealm {
    private static final Logger log = LogManager.getLogger(ShiroDbRealm.class);

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


        return null;
    }
}
