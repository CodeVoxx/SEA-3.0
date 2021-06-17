// PersonController gibt HTML zurück

package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.service.PersonService;

@Controller  // liefert HTML und kein Json
public class PersonHTMLController {

	private static final String HTMLTEMPLATE = "<!DOCTYPE html> <html lang='de'> "
			+ "<head> <meta charset='utf-8'> <meta name='viewport' content='width=device-width, "
			+ "initial-scale=1.0'> <title>Titel</title> </head> <body>size: %d </body> </html>";

	private PersonService personService; // Variable personService

	@Autowired
	public PersonHTMLController(PersonService personService) { // Construtor PersonController
		super();
		System.out.println("** PersonHTMLController instanziert --> ipse" + this.toString());
		System.out.println("** PersonService instanziert --> " + personService.toString());
		this.personService = personService; // Übergabe personService
	}

	// URL: "http://localhost:8080/size"
	@GetMapping("/size")
	@ResponseBody
	public String getSize() {
		String string5 = String.format(HTMLTEMPLATE, personService.getSize());
		return string5;
	}
	
	// URL:"http://localhost:8080/count"
	@GetMapping("/count")
	public String getCount() {
		String string = "count";
		return string;
	}
	
}
