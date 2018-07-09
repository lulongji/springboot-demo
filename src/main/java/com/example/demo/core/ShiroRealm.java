package com.example.demo.core;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * shiroRealm 重写权限过滤
 *
 * @author lu
 */
@Component
public class ShiroRealm extends AuthorizingRealm {


    public ShiroRealm() {
        super(new AllowAllCredentialsMatcher());
        setAuthenticationTokenClass(UsernamePasswordToken.class);

        //FIXME: 暂时禁用Cache
        setCachingEnabled(false);
    }

    /**
     * 登录信息和用户验证信息验证(non-Javadoc)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal(); // 得到用户名
        String password = new String((char[]) token.getCredentials()); // 得到密码

        if (null != username && null != password) {
            return new SimpleAuthenticationInfo(username, password, getName());
        } else {
            return null;
        }

    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        simpleAuthorInfo.addStringPermissions(getPermCodes());
        return simpleAuthorInfo;

    }

    /**
     * 获取权限，string存放的是权限编码
     *
     * @return
     */
    private List<String> getPermCodes() {
        List<String> list = new ArrayList<>();
        try {
            list.add("test");
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
