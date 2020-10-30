package com.eujian.rabbitmqtrace.lister;

import com.eujian.rabbitmqtrace.config.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class Lister {
    @RabbitListener(queues = Constant.QUEUE)
    public void handle(Message message) {
        byte[] body = message.getBody();
        log.info("lister msg={}",new String(body));

    }
}
