package com.squirrel.service;

import com.squirrel.dao.ExpressDao;
import com.squirrel.entity.Express;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExpressService {
    @Autowired
    ExpressDao expressDao;

    public List<Express> findAll (){
        return expressDao.findAll();
    }

    public List<Express> findExpressByExpressCode(String expressCode){
        return expressDao.findExpressByExpressCode(expressCode);
    }
}
