package com.szogibalu.demo.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.szogibalu.demo.service.Receiver;

@Configuration
public class MessagingConfiguration {

    @Value("demo.queue.name")
    String queueName;

    @Value("demo.exchange.name")
    String exchangeName;

    @Bean
    Queue queue() {
	return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
	return new TopicExchange(exchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
	return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	    MessageListenerAdapter listenerAdapter) {
	SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	container.setConnectionFactory(connectionFactory);
	container.setQueueNames(queueName);
	container.setMessageListener(listenerAdapter);
	return container;
    }

    @Bean
    Receiver receiver() {
	return new Receiver();
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
	return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}
