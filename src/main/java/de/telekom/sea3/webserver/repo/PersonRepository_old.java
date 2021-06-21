package de.telekom.sea3.webserver.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import de.telekom.sea3.webserver.model.Person;

@Repository // erzeugt new PersonRepository
public class PersonRepository_old {

	private List<Person> personen = new ArrayList<Person>();

	public PersonRepository_old() {
		super();
		System.out.println("PersonRepository instanziert: " + this.toString());

	}

	public int getSize() {
		return personen.size();
	}

	public boolean add(Person person) {
		return personen.add(person);
	}

	public List<Person> getAll() {
		return personen;
	}

	public boolean del(String id) {
		for (int i = 0; i < personen.size(); i++) {
			Person person = personen.get(i);
			if (person.getId().equals(id)) {
				personen.remove(i);
				return true;
			}
		}
		return false;
	}

}