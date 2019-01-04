package com.mju.ssm.controller;

import com.mju.ssm.entity.Person;
import com.mju.ssm.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping(value = "/PersonController")
public class PersonController {

    @Resource
    private PersonService personService;

    @RequestMapping("/list")
    public String list(Model model,Integer pageNum){
        Integer num = 1;
        if(null!=pageNum){
            num = pageNum;
        }
        Integer pageSize =2;
        model.addAttribute("pageInfo",this.personService.findWithPageInfo(num,pageSize));
        return "list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        System.out.println(id);
        this.personService.deleteByPrimaryKey(id);
        return "redirect:/PersonController/list";
    }

}
