package com.qa.person.rest;

//import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.person.domain.Person;
import com.qa.person.services.PersonService;

@RestController
public class PersonController {

	//private List<Person> people = new ArrayList<>();
	private PersonService service;

    public PersonController(PersonService service) {
        super();
        this.service = service;
        
    }

    @PostMapping("/create")
    public Person addPerson(@RequestBody Person person) {
        return this.service.addPerson(person);
    }

    @GetMapping("/getAll")
    public List<Person> getAllPeople() {
        return this.service.getAllPeople();
    }

    @PutMapping("/update")
    public Person updatePerson(@PathParam("id") long id, @RequestBody Person person) {
    	return this.service.updatePerson(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public boolean removePerson(@PathVariable long id) {
        // Remove Person and return it
    	return this.service.removePerson(id);
    }
    
    

}