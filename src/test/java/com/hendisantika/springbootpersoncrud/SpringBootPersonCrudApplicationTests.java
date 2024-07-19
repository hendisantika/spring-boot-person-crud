package com.hendisantika.springbootpersoncrud;

import com.hendisantika.springbootpersoncrud.entity.Person;
import com.hendisantika.springbootpersoncrud.repository.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class SpringBootPersonCrudApplicationTests {
	@Container
	private static final MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.4.0");
	@Autowired
	private PersonRepository personRepository;

	@DynamicPropertySource
	public static void dbProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
		registry.add("spring.datasource.username", mySQLContainer::getUsername);
		registry.add("spring.datasource.password", mySQLContainer::getPassword);
	}

	@Test
	void contextLoads() {
		Person person1 = new Person(1, "Monkey D. Luffy", "+6281321411500");
		Person person2 = new Person(2, "Roronoa Zoro", "+6281321411501");
		Person person3 = new Person(3, "Nami", "+6281321411502");

		personRepository.saveAll(List.of(person1, person2, person3));

		Iterable<Person> people = personRepository.findAll();
		Assertions.assertThat(people).hasSize(3);
	}

}
