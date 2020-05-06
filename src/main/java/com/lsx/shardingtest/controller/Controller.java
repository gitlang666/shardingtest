package com.lsx.shardingtest.controller;

import com.lsx.shardingtest.entity.Maxflag;
import com.lsx.shardingtest.entity.User;
import com.lsx.shardingtest.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    Logger logger= LoggerFactory.getLogger(Controller.class);
    @Autowired
    Service service;

    @RequestMapping("/list")
    public List<User> list(){
        return service.list();
    }
    @RequestMapping("/add")
    public Object add(User user){
        return "已经修改";
    }
    @GetMapping("/add2")
    public Object add2(Integer increment){

        return service.add(increment);
    }

    @GetMapping("/maxid")
    public int maxid(){
        return service.maxid();
    }

    @GetMapping("/maxflag")
    Maxflag maxflag(Maxflag maxflag){
        service.maxflag(maxflag);
        return maxflag;
    }

    @GetMapping("/getUserByPage")
    public List<User> getUserByPage(int page, int num){
        return service.getUserByPage(page,num);
    }
}
