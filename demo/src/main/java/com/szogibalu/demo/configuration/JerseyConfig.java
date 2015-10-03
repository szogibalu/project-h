package com.szogibalu.demo.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.szogibalu.demo.controller.DemoController;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
	register(DemoController.class);
    }

}
