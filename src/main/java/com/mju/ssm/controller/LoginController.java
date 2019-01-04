package com.mju.ssm.controller;

import com.mju.ssm.entity.Person;
import com.mju.ssm.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/LoginController")
public class LoginController {

    @Resource
    private PersonService personService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Person person, HttpSession session){
        Person loginPerson = this.personService.validatePersonInfo(person);
        if(null!=loginPerson){
            session.setAttribute("loginPerson",loginPerson);
            return "redirect:/PersonController/list";
        }else{
            return "login";
        }
    }

}
