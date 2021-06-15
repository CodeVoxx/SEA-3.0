// Gibt Json Code zurück
package de.telekom.sea3.webserver.view;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.model.Size;
import de.telekom.sea3.webserver.service.PersonService;

@RestController
public class PersonRestController {

	private PersonService personService; // Variable personService

	@Autowired
	public PersonRestController(PersonService personService) { // Construtor PersonController
		super();
		this.personService = personService; // Übergabe personService
	}

	/** @see URL: <a href="http://localhost:8080/allpersons">Das ist eine URL</a>
	 * */
	@GetMapping("/json/persons/all")
	public Personen getAllPersons() {
		Personen personen = personService.getAllPerson();
		return personen;
	}
	
	@GetMapping("/json/persons/size")
	public Size getSize() {
		return new Size(personService.getSize());
	}
}
