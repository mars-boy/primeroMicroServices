package com.marsboy.microservices.primero.ExpensesService.Controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
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

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping(value = "/myghost")
    public String getMyGhost(){
        Application application = eurekaClient.getApplication("account-service");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://"+instanceInfo.getIPAddr()+ ":"+instanceInfo.getPort()+"/"+"ghost";
        String temp = restTemplate.getForObject(url,String.class);
        temp = temp+" he told";
        return temp;
    }
}
