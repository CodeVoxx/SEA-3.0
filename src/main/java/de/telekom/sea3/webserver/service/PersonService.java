package de.telekom.sea3.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.telekom.sea3.webserver.repo.PersonRepository;
import de.telekom.sea3.webserver.model.*;

@Service
public class PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		System.out.println("PersonService instanziert: " + this.toString());
		System.out.println("PersonRepository: " + personRepository.toString());
		this.personRepository = personRepository;
	}

	public int getSize() {
		return personRepository.getSize();
	}

	
	public Personen getAllPersons() {
		return new Personen(personRepository.getAll());
	}

	public Person get(int id) {
		
		return new Person("Max","Mustermann","Herr");
	}

	public Person add(Person person) {
		personRepository.add(person);
		System.out.println("Person wurde angelegt!");
		return person;
	}

	public Person del(String id) {
		personRepository.del(id);
		System.out.println("Person wurde gelöscht!");
		return null;
	}
}
