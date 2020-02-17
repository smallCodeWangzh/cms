package com.briup.cms.service.impl;

import com.briup.cms.bean.Customer;
import com.briup.cms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>
 *      security 自定义登陆逻辑类
 *      用来做登陆认证，验证用户名与密码
 * </p>
 * 
 * @author wangzh
 *
 */
@Component("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {
    
    @Autowired
    private ICustomerService customerService;


    
    @Autowired
    private PasswordEncoder passwordEncoder;
    


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 根据用户名去查找用户信息
        Customer customer = customerService.findByName(username);
        
        if(customer == null) {
            throw new UsernameNotFoundException(String.format("Not user Found with '%s'", username));
        }


        return new User(customer.getUsername(),passwordEncoder.encode(customer.getPassword()), AuthorityUtils.createAuthorityList("admin"));
    }
}
