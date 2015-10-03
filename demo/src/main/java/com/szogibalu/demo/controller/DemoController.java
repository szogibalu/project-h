package com.szogibalu.demo.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.szogibalu.demo.model.Demo;

@Component
@Path("/demo")
public class DemoController {

    @GET
    @Produces("application/json")
    public Demo getDemo() {
	return new Demo("Up and Running!");
    }

}
