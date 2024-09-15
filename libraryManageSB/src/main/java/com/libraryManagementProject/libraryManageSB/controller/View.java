package com.libraryManagementProject.libraryManageSB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View {
    @RequestMapping("/view")
    public String view(){
        return "view";
    }
}
