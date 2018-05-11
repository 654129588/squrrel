package com.squirrel.dao;


import com.squirrel.entity.User;
import com.squirrel.support.CustomRepository;

import java.util.List;

public  interface UserDao extends CustomRepository<User, Long> {
    //@Transactional注解是事务处理.
    List<User> findByName(String name);

}
