package uz.mardonkhodjaev.exchangeregisterapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mardonkhodjaev.exchangeregisterapp.exception.PersonNotFoundException;
import uz.mardonkhodjaev.exchangeregisterapp.model.Person;
import uz.mardonkhodjaev.exchangeregisterapp.service.PersonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person response = personService.create(person);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable UUID id) {
        this.personService.delete(id);
    }

    @GetMapping("/")
    public ResponseEntity<?> findAllPeople() {
        List<Person> response = personService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable UUID id) {
        try {
            Person person = personService.findById(id);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (PersonNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
