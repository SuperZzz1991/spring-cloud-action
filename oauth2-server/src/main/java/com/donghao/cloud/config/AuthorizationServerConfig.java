package com.donghao.cloud.config;

import com.donghao.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * 认证服务器配置
 * @Author: DongHao
 * @Date: 2022/1/18 14:19
 * @Description: 添加认证服务器配置，使用@EnableAuthorizationServer注解开启
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    /**
     * 使用密码模式需要配置此项
     * @param endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager).userDetailsService(userService);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")    //配置client_id
                .secret(passwordEncoder.encode("admin123456"))   //配置client_secret
                .accessTokenValiditySeconds(3600)   //配置访问token的有效期
                .refreshTokenValiditySeconds(864000)    //配置刷新token的有效期
                .redirectUris("http://www.baidu.com")   //配置redirect_uri，用于授权成功后跳转
                .scopes("all")  //配置申请的权限范围
                .authorizedGrantTypes("authorization_code", "password"); //配置grant_type，表示授权类型
        super.configure(clients);
    }
}
