package com.squirrel.controller;

import com.squirrel.dao.UserDao;
import com.squirrel.entity.Result;
import com.squirrel.entity.User;
import com.squirrel.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping("/getName")
    public List<User> getName (){
        log.info("访问/user/getName接口成功");
        List<User> users = userDao.findByName("哈哈");
        return users;
    }

    @RequestMapping("/insert")
    public String insert (){
        log.info("访问/user/insert接口成功");
        User user = new User();
        user.setName("是我");
        user.setAge(18);
        userDao.save(user);
        return "插入成功";
    }

    @RequestMapping("/sort")
    public List<User> sort (){
        log.info("访问/user/sort接口成功");
        List<User> users = userDao.findAll(new Sort(Sort.Direction.DESC,"age"));
        return users;
    }

    @RequestMapping("/page")
    public  Page<User> page (){
        log.info("访问/user/sort接口成功");
        Page<User> userPage = userDao.findAll(new PageRequest(10, 2));
        return userPage;
    }

    @RequestMapping("/auto")
    public Result auto(User user){
        log.info("访问/user/auto接口成功");
        Page<User> userPage = userDao.findByAuto(user, new PageRequest(0, 10));
        return ResultUtils.success(userPage);
    }
}
