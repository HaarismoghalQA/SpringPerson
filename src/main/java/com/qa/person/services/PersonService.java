package com.qa.person.services;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.person.domain.Person;
import com.qa.person.repo.PersonRepo;


@Service
public class PersonService {
	
	 private PersonRepo repo; 

	    public PersonService(PersonRepo repo) {
	        super();
	        this.repo = repo;
	    }

    

    public Person addPerson(Person person) {
        return this.repo.save(person);
    }

    public List<Person> getAllPeople() {
        return this.repo.findAll();
    }

    public Person updatePerson(Long id, Person newPerson) {
        Optional<Person> existingOptional = this.repo.findById(id);
        Person existing = existingOptional.get();

        existing.setAge(newPerson.getAge());
        existing.setName(newPerson.getName());

        return this.repo.save(existing);
    }

    public boolean removePerson(Long id) {
        // removes the entity
        this.repo.deleteById(id);
        // checks to see if it still exists
        boolean exists = this.repo.existsById(id);
        // returns true if entity no longer exists
        return !exists;
    }
    
    

  

}
