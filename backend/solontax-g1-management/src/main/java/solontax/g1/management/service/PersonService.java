package solontax.g1.management.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import solontax.g1.management.entity.Person;
import solontax.g1.management.repository.PersonRepository;

@Service
@AllArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
