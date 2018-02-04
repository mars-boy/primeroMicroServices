package com.marsboy.microservices.primero.ExpensesService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class ExpensesServiceRestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/myghost")
    public String getMyGhost(){
        String url = "http://192.168.0.104:6000/ghost";
        String temp = restTemplate.getForObject(url,String.class);
        temp = temp+" he told";
        return temp;
    }
}
