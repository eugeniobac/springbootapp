package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Person;


public interface PersonRepository extends JpaRepository<Person, Integer> {

}
