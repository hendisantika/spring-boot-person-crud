package com.hendisantika.springbootpersoncrud.controller;

import com.hendisantika.springbootpersoncrud.entity.Person;
import com.hendisantika.springbootpersoncrud.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

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
    public String addNewPerson(Model model) {
        model.addAttribute("person", new Person());
        return "form";
    }

    @PostMapping
    public String save(@Valid Person p) {
        int id = personService.save(p);
        if (id == 0) {
            return "form";
        }
        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id) {
        personService.delete(id);
        return "redirect:/persons";
    }

}
