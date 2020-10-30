package com.eujian.rabbitmqtrace;

import com.eujian.rabbitmqtrace.config.Constant;
import com.eujian.rabbitmqtrace.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqtraceApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName("gg");
        rabbitTemplate.convertAndSend(Constant.QUEUE,userInfo);
    }

}
