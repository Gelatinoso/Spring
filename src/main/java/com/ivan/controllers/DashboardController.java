package com.ivan.controllers;

import com.ivan.utils.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    Environment environment;

    @GetMapping(Router.DASH_BOARD)
    public String goIndex(){
        System.out.println(environment.getProperty("service_name"));
        return "dashboard";
    }
}
