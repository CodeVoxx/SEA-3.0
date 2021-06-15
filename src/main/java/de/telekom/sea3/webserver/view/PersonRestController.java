package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonRestController {

	private PersonService personService; // Variable personService

	@Autowired
	public PersonRestController(PersonService personService) { // Construtor PersonController
		super();
		this.personService = personService; // Übergabe personService
	}

	// URL: "http://localhost:8080/allpersons"
	@GetMapping("/allpersons")
	@ResponseBody  //sagt Spring Framework dass die Antwort in den Body gepack werden soll
	public String getAllPersons() {
		Personen personen = personService.getAllPerson();
		personen.toJson();
		String string1 ="{\n"
				+ "	\"personen\": [\n"
				+ "		{\n"
				+ "			\"vorname\": \"Paul\",\n"
				+ "			\"nachname\": \"Paulsen\",\n"
				+ "			\"anrede\": \"Herr\"\n"
				+ "		},\n"
				+ "		{\n"
				+ "			\"vorname\": \"Paul\",\n"
				+ "			\"nachname\": \"Paulsen\",\n"
				+ "			\"anrede\": \"Herr\"\n"
				+ "		},\n"
				+ "		{\n"
				+ "			\"vorname\": \"Paul\",\n"
				+ "			\"nachname\": \"Paulsen\",\n"
				+ "			\"anrede\": \"Herr\"\n"
				+ "		}\n"
				+ "	]\n"
				+ "}";
		return string1;

	}
}
