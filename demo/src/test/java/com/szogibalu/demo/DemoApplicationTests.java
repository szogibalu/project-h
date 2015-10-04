package com.szogibalu.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.szogibalu.demo.model.Demo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class DemoApplicationTests {

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void demo() {
	ResponseEntity<Demo> entity = restTemplate.getForEntity("http://localhost:9000/demo", Demo.class);

	assertTrue(entity.getStatusCode().is2xxSuccessful());
	assertEquals("Up and Running!", entity.getBody().getMessage());
    }

}