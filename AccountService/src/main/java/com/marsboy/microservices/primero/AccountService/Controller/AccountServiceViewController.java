package com.marsboy.microservices.primero.AccountService.Controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AccountServiceViewController {


    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping(value = "/redirecttest")
    public RedirectView sendRedirect(HttpServletResponse httpServletResponse){
        Application application = eurekaClient.getApplication("expenses-service");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://"+instanceInfo.getIPAddr()+ ":"+instanceInfo.getPort()+"/"+"ExpenseService/expenses";
        //return new ModelAndView("redirect:"+url);
        /*httpServletResponse.setHeader("Location", "http://192.168.0.104:6001/ExpenseService/expenses");*/
        System.out.println("Groot------------------------------------------------------------------------------------");
        System.out.println("url :::: "+url);
        System.out.println("------------------------------------------------------------------------------------------");
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        return redirectView;
    }
}
