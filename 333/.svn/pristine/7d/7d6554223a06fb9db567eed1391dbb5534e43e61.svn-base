package com.gcfd.consumer.controller;

import com.gcfd.common.DataCenter;
import com.gcfd.consumer.feign.HelloworldFeign;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/consumer/helloworld")
public class HelloWorldController {

    @Autowired
    private HelloworldFeign hellworldFeign;

    @RequestMapping(value = "/sayhello",method = RequestMethod.GET)
    public DataCenter<Object> sayhello(){

        System.out.println("---------------------------------");
        return hellworldFeign.sayhello();
    }




}
