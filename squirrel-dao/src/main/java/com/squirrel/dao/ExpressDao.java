package com.squirrel.dao;


import com.squirrel.entity.Express;
import com.squirrel.support.CustomRepository;

import java.util.List;

public interface ExpressDao extends CustomRepository<Express,Long> {

    List<Express> findExpressByExpressCode(String expressCode);
}
