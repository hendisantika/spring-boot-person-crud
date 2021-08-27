package com.hendisantika.springbootpersoncrud.service;

import com.hendisantika.springbootpersoncrud.entity.Person;
import com.hendisantika.springbootpersoncrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Person> findById(int id) {
        return personRepository.findById(id);
    }

    public int save(Person p) {
        int res = 0;
        Person per = personRepository.save(p);
        if (!per.equals(null)) {
            res = 1;
        }
        return res;
    }
}
