package com.marsboy.microservices.primero.AccountService.Controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
public class AccountServiceRestController {

    @GetMapping(value = "/ghost")
    public String getGhost(){
        return "Ghost is here";
    }
}
