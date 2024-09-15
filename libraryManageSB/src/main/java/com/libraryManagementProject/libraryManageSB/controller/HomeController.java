package com.libraryManagementProject.libraryManageSB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping("/home")
    public String homepage(){
        return "index";
    }
}
