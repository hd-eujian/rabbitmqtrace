package com.eujian.rabbitmqtrace.lister;

import com.eujian.rabbitmqtrace.config.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Component
public class PublishTraceLister {
    @RabbitListener(queues = Constant.PUBLISH_TRACE_QUEUE)
    public void handle(Message message){
        log.info("PUBLISH_TRACE_QUEUE msg={}",new String(message.getBody()));
    }
}
