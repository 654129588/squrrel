package com.squirrel.dao;

import com.squirrel.entity.SysUser;
import com.squirrel.support.CustomRepository;

public interface SysUserDao extends CustomRepository<SysUser,Long> {
    SysUser findByUsername(String username);
}
