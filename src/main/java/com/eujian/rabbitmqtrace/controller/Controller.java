package com.eujian.rabbitmqtrace.controller;

import com.eujian.rabbitmqtrace.config.Constant;
import com.eujian.rabbitmqtrace.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping
@RestController
public class Controller {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/demo")
    public String demo(){
        rabbitTemplate.convertAndSend(Constant.QUEUE,"rabbitmq");
        return "success";
    }
}
