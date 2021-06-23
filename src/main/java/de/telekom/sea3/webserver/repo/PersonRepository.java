package de.telekom.sea3.webserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.telekom.sea3.webserver.model.Person;

@Repository // Implementierung der Klasse uebernimmt Spring
public interface PersonRepository extends CrudRepository<Person,Long>{

}
