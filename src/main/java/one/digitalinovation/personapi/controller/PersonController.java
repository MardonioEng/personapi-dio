package one.digitalinovation.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinovation.personapi.entity.Person;
import one.digitalinovation.personapi.repository.PersonRepository;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	private PersonRepository personRepository;

	@Autowired
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@PostMapping
	public ResponseEntity<Person> insertPerson(@RequestBody Person person) {
		System.out.println(person);
		try {
			person = personRepository.save(person);
			return ResponseEntity.status(HttpStatus.CREATED).body(person);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().build();
		}

	}

}
