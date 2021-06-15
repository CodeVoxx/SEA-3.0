package de.telekom.sea3.webserver.repo;

import org.springframework.stereotype.Repository;

@Repository // erzeugt neue Persoenrepository
public class PersonRepository {

	public PersonRepository() {
		super();
		System.out.println("** PersonService instanziert --> " + this.toString());
	}

	public int getSize() {
		return 0;
	}
}