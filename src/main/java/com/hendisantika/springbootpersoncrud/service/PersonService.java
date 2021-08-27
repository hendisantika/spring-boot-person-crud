package com.hendisantika.springbootpersoncrud.service;

import com.hendisantika.springbootpersoncrud.entity.Person;
import com.hendisantika.springbootpersoncrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-person-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/08/21
 * Time: 06.19
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> list() {
        return (List<Person>) personRepository.findAll();
    }
}
