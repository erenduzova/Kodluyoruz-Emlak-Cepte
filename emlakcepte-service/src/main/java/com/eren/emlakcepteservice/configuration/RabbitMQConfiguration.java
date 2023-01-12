package com.eren.emlakcepteservice.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Value("${rabbitmq.queue}")
    private String queueName;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    @Bean
    public Queue paymentQueue() {
        return new Queue(queueName, false);
    }

    @Bean
    public Queue publishQueue() {
        return new Queue("publishQueue", false);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange);
    }


    @Bean
    public Binding binding(Queue paymentQueue, DirectExchange exchange) {
        return BindingBuilder.bind(paymentQueue).to(exchange).with(routingKey);
    }

    @Bean
    public Binding publishBinding(Queue publishQueue, DirectExchange exchange) {
        return BindingBuilder.bind(publishQueue).to(exchange).with("publishRoute");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


}
