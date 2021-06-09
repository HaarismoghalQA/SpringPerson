package com.qa.person.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.person.domain.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

	 // SELECT * from Person where name = '[name]';
    List<Person> findPersonByName(String name); 

    // SELECT * from Person where name = '[name]' and age = [age];
    List<Person> findByNameAndAge(String name, int age); 

    // SELECT * from Person where name = '[name]' and age = [age] LIMIT 1;
    Person findPersonByNameAndAge(String name, int age); 

    // SELECT * from Person where age > [age];
    List<Person> findPersonByAgeGreaterThan(int age); 

    // SELECT * from Person where age < [age];
    List<Person> findPersonByAgeLessThan(int age); 

    // SELECT * from Person where name = '[name]' IS NOT NULL;
    List<Person> findPersonByNameIsNotNull();  

    // SELECT * from Person where name = '[name]' IS NULL;
    List<Person> findPersonByNameIsNull(); 


}
