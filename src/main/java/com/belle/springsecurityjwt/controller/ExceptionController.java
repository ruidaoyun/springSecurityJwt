package com.belle.springsecurityjwt.controller;

import com.belle.springsecurityjwt.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
    @RequestMapping("hello")
    public void hello(@ModelAttribute("author")String author, ModelMap modelMap){
        System.out.println ("author1 "+modelMap.get ("author"));
        System.out.println ("author2 "+author);
        throw new MyException ("100","hello world");
    }

    @GetMapping("world")
    public void world(){
        throw new MyException ("101","hello siri");
    }

    @PostMapping("world")
    public void helloWorld(){
        throw new MyException ("102","小爱同学");
    }
}
