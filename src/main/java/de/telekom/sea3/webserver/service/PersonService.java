package de.telekom.sea3.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.repo.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository; // Variabe personRepository
	
	@Autowired
	public PersonService(PersonRepository personRepository) {  // Constructor
		super();
		System.out.println("** PersonService instanziert  --> " + this.toString());
		System.out.println("** PersonRepository  --> " + personRepository.toString());
		this.personRepository = personRepository; // Übergabeparameter
	}

	public int getSize() {
		return personRepository.getSize();
		
		}
	public Personen getAllPerson() {
		return new Personen();
		
	}
	
	
}
