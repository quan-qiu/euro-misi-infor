package com.euromisi.infordatainterface.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorld {

    @GetMapping("/welcome")
    private String welcome(Model model){
        model.addAttribute("username","qiuquan");
        return "index";
    }

    @GetMapping("/")
    private String index(Model model){


        return "index";
    }
}
