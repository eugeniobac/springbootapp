package demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Person;
import demo.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Person> list(HttpServletResponse response) {
	System.out.println("List...");
	return repository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
	System.out.println("Create...");

	try {
	    repository.save(person);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return person;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Person update(@RequestBody Person person) {
	try {
	    System.out.println("Update...");
	    repository.save(person);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return person;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
	try {
	    System.out.println("Delete...");
	    repository.delete(repository.findOne(id));
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public PersonRepository getRepository() {
	return repository;
    }

    public void setRepository(PersonRepository repository) {
	this.repository = repository;
    }

}
