package com.example.mqspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MQController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("send")
    String send(){
        try{
            jmsTemplate.convertAndSend("DEV.QUEUE.2", "Hello Worldde!");
            return "OK";
        }catch(JmsException ex){
            ex.printStackTrace();
            return "FAIL";
        }
    }

    @GetMapping("recv")
    String recv(){
        try{
            return jmsTemplate.receiveAndConvert("DEV.QUEUE.2").toString();
        }catch(JmsException ex){
            ex.printStackTrace();
            return "FAIL";
        }
    }


}
