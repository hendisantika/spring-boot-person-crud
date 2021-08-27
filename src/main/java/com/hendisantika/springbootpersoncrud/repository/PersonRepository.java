package com.hendisantika.springbootpersoncrud.repository;

import com.hendisantika.springbootpersoncrud.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-person-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/08/21
 * Time: 06.18
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
