package uz.mardonkhodjaev.exchangeregisterapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mardonkhodjaev.exchangeregisterapp.model.Person;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
    Optional<Person> findByName(String name);

    Optional<Person> findByPassportNum(String passportNum);
}
