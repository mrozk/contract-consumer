package com.example.consumer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${remoteservice.url}")
    String remoteServiceUrl;

    @GetMapping("/consumer")
    public String index(@RequestParam("number") Integer number) {
        return restTemplate.getForObject(URI.create(remoteServiceUrl + "validate/prime-number?number=" + number), String.class);
    }
}
