package org.dmitriyprojects.bankapploggingservice.listeners;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    Queue queue() {
        return new Queue("log-queue");
    }

    @Bean
    Exchange exchange() {
        return new DirectExchange("log-exchange");
    }

    @Bean
    Binding binder() {
        return BindingBuilder.bind(queue()).to(exchange()).with("to.logService").noargs();
    }

    @Bean
    Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}
