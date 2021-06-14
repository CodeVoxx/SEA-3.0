package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;  // Variable personService
	
	@Autowired
	public PersonController(PersonService personService) {  // Construtor PersonController
		super();
		System.out.println("** PersonController instanziert --> " + this.toString());
		System.out.println("** PersonService instanziert --> " + personService.toString());
		this.personService = personService;	// Übergabe personService
	}


	
}
