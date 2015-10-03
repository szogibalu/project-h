package com.szogibalu.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Demo {

    private final String message;

    public Demo(@JsonProperty("message") String message) {
	this.message = message;
    }

    public String getMessage() {
	return message;
    }

}
