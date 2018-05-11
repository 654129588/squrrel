package com.squirrel.service;

import com.squirrel.dao.SysUserDao;
import com.squirrel.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SysUserService implements UserDetailsService {
    @Autowired
    SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username){
        SysUser user = sysUserDao.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("用户名不存在");
        return user;
    }
}
