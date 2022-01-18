package com.donghao.cloud.service;

import com.donghao.cloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: DongHao
 * @Date: 2022/1/18 14:12
 * @Description:
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private List<User> userList;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();
        userList.add(new User("Tom", password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        userList.add(new User("Jack", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        userList.add(new User("Jerry", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = userList.stream().filter(user -> user.getUsername().equals(username)).findFirst();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
    }
}
