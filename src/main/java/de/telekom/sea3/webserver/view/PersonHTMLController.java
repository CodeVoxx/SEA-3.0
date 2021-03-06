// PersonController gibt HTML zurück

package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.service.PersonService;

@Controller  // liefert HTML und kein Json
public class PersonHTMLController {

	private static final String HTMLTEMPLATE = "<!DOCTYPE html> <html lang='de'> "
			+ "<head> <meta charset='utf-8'> <meta name='viewport' content='width=device-width, "
			+ "initial-scale=1.0'> <title>Titel</title> </head> <body><h1>size: %d </h1></body> </html>";

	private PersonService personService; // Variable personService

	@Autowired
	public PersonHTMLController(PersonService personService) { // Construtor PersonController
		super();
		System.out.println("** PersonHTMLController instanziert --> ipse" + this.toString());
		System.out.println("** PersonService instanziert --> " + personService.toString());
		this.personService = personService; // Übergabe personService
	}

	// URL: "http://localhost:8222/size"
	@GetMapping("/size")
	@ResponseBody   // sagt dem Spring Framework, dass die Antwort in den Body gepackt werden soll und nicht über das Template
	public String getSize() {
		String string5 = String.format(HTMLTEMPLATE, personService.getSize());
		return string5;
	}
	
	// URL:"http://localhost:8222/count"
		@GetMapping("/count")   // kein @ResponseBody, da es sonst den Weg über das Template verhindert.
		public String getCount(Model model, 
				@RequestParam(value = "name",   // Aufruf mit "http://localhost:8080/count/?name=Gerd" 
						required = false, 
						defaultValue = "World") 
						String name
		) {
//			String string = "Hallo";
			model.addAttribute("cou", name); // cou Platzhalter in der HTML Seite
			return "count";
		}
		
		
		// URL:"http://localhost:8222/size2"
		@GetMapping("/size2")  // kein @ResponseBody, da es sonst den Weg über das Template verhindert.
		public String getSize2(Model model) {
			model.addAttribute("size3", personService.getSize());
			return "size";
		}
		
		// URL:"http://localhost:8222/personen"
		@GetMapping("/personen")  // kein @ResponseBody, da es sonst den Weg über das Template verhindert.
		public String getPersonen(Model model) {
			Personen personen = personService.getAllPersons();
			model.addAttribute("personenList", personen.getPersonen());
			return "personen";
		}
	}
