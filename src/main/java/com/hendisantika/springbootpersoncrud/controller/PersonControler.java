package com.hendisantika.springbootpersoncrud.controller;

import com.hendisantika.springbootpersoncrud.entity.Person;
import com.hendisantika.springbootpersoncrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-person-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/08/21
 * Time: 06.26
 */
@Controller
@RequestMapping("/persons")
public class PersonControler {
    @Autowired
    private PersonService personService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("persons", personService.list());
        return "index";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("person", personService.findById(id));
        return "form";
    }

    @GetMapping("/new")
    public String new(
    Model model)

    {
        model.addAttribute("person", new Person());
        return "form";
    }

}
