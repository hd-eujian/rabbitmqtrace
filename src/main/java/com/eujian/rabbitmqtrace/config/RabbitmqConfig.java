package com.eujian.rabbitmqtrace.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.autoconfigure.amqp.RabbitRetryTemplateCustomizer;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

@Configuration
public class RabbitmqConfig {
    @Bean
    public Queue initRealQueue() {
        return new Queue(Constant.QUEUE);
    }


    @Bean
    public Queue initPublishTraceQueue() {
        return new Queue(Constant.PUBLISH_TRACE_QUEUE);
    }

    @Bean
    public Binding initTraceBinding() {
        TopicExchange topicExchange = new TopicExchange("amq.rabbitmq.trace");
        return BindingBuilder.bind(initPublishTraceQueue()).to(topicExchange).with("publish.#");
    }

    @Bean
    public Queue initDeliverTraceQueue() {
        return new Queue(Constant.DELIVER_TRACE_QUEUE);
    }

    @Bean
    public Binding initDeliverTraceBinding() {
        TopicExchange topicExchange = new TopicExchange("amq.rabbitmq.trace");
        return BindingBuilder.bind(initDeliverTraceQueue()).to(topicExchange).with("deliver.#");
    }
}
