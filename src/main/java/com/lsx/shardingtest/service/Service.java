package com.lsx.shardingtest.service;

import com.lsx.shardingtest.controller.Controller;
import com.lsx.shardingtest.dao.Dao;
import com.lsx.shardingtest.entity.Maxflag;
import com.lsx.shardingtest.entity.User;
import io.shardingsphere.api.HintManager;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    Logger logger=LoggerFactory.getLogger(Service.class);
    @Autowired
    Dao dao;
    public List<User> list(){
        return dao.list();
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Object add(Integer increment){
        Maxflag maxflag=new Maxflag();
        maxflag.setIncrement(increment);
        this.maxflag(maxflag);
        if(true){
            List<User> list=new ArrayList<>();
            if(maxflag.getCount()!=null && maxflag.getCount()>0){
                for(int i=maxflag.getCount()-increment;i<maxflag.getCount();i++) {
                    User user = new User();
                    user.setCount(i);
                    user.setUsername("lang"+(i));
                    user.setPassword("1233edwd");
                    list.add(user);
                }
                dao.addBatch(list);
            }
        }else {
            if(maxflag.getCount()!=null && maxflag.getCount()>0){
                for(int i=maxflag.getCount()-increment;i<maxflag.getCount();i++) {
                    User user = new User();
                    user.setCount(i);
                    user.setUsername("lang"+(i));
                    user.setPassword("1233edwd");
                    Object resutl=   dao.add(user);
                    logger.info("insert:"+user.toString()+" result:"+resutl);
                }
            }
        }


        return "ok";
    }


    public int maxid(){
        return dao.maxid();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRES_NEW)
    public int maxflag(Maxflag maxflag){
        return dao.maxflag(maxflag);
    }

    public List<User> getUserByPage(int page, int num){
        return dao.getUserByPage(page, num);
    }
}
