package com.hendisantika.springbootpersoncrud.controller;

import com.hendisantika.springbootpersoncrud.entity.Person;
import com.hendisantika.springbootpersoncrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-person-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/08/21
 * Time: 12.06
 */
@Controller
@RequestMapping
public class IndexController {
    @Autowired
    private PersonService personService;

    @GetMapping("/test1")
    public String list(Model model) {
        model.addAttribute("persons", personService.list());
        return "test1";
    }

    @GetMapping("/test1/add")
    public String addNewPerson(Model model) {
        model.addAttribute("person", new Person());
        return "add";
    }
}
