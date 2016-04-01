package com.celloud.shiro;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.celloud.model.User;
import com.celloud.service.UserService;

public class UserRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(UserRealm.class);
    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("doGetAuthorizationInfo。。。");
        String username = (String) principals.getPrimaryPrincipal();
        logger.info("doGetAuthorizationInfo username:{}", username);
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UnknownAccountException();// 没找到帐号
        }
        if (user.getDisabled()) {
            throw new LockedAccountException(); // 帐号锁定
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findRoles(user.getId()));
        Set<String> permissions = userService.findPermissions(user.getId());
        logger.info("用户{}共有{}权限！", username, permissions.size());
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo...");
        String username = (String) token.getPrincipal();
        logger.info("doGetAuthenticationInfo username:{}", username);
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UnknownAccountException();// 没找到帐号
        }
        if (user.getDisabled()) {
            throw new LockedAccountException(); // 帐号锁定
        }
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
    }

}
