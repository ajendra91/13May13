package com.example.RequestParamPathVariable;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AppController {

    @RequestMapping("/")
    public String demo(){
        return String.format("<html><body><h1>Welcome to home page</h1><p>small text</p></body></html>");
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        return "welcome"+name;
    }


    @RequestMapping("/hello2/{name}")
    public String hello2(@PathVariable String name){
        return "welcome"+name;
    }


    @RequestMapping("/hello3")
    public String hello3(String name){
        return "welcome"+name;
    }


    @RequestMapping("/hello4")
    public String hello4(HttpServletRequest req){
        String name=req.getParameter("name");
        return "welcome"+name;
    }

    @RequestMapping("/hello5/{name2}")
    public String hello5(@RequestParam String name,@PathVariable String name2){
        return "welcome"+name+name2;
    }

}
