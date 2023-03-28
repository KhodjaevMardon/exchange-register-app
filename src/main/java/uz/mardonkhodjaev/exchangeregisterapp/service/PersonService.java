package uz.mardonkhodjaev.exchangeregisterapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.mardonkhodjaev.exchangeregisterapp.exception.PersonNotFoundException;
import uz.mardonkhodjaev.exchangeregisterapp.model.Person;
import uz.mardonkhodjaev.exchangeregisterapp.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(Person person) {
        if (person.getId() == null) {
            person.setId(UUID.randomUUID());
        }
        return repository.save(person);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Person findByName(String name) throws PersonNotFoundException{
        Optional<Person> found = repository.findByName(name);
        if (found.isPresent()) {
            return found.get();
        } else {
            throw new PersonNotFoundException();
        }
    }

    public Person findByPassportNum(String passportNum) throws PersonNotFoundException{
        Optional<Person> found = repository.findByPassportNum(passportNum);
        if (found.isPresent()) {
            return found.get();
        } else {
            throw new PersonNotFoundException();
        }
    }

    public Person findById(UUID id) throws PersonNotFoundException{
        Optional<Person> found = repository.findById(id);
        if (found.isPresent()) {
            return found.get();
        } else {
            throw new PersonNotFoundException();
        }
    }
}
