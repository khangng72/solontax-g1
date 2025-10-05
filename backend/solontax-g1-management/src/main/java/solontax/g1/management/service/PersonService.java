package solontax.g1.management.service;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import solontax.g1.management.dto.PersonDto;
import solontax.g1.management.entity.Person;
import solontax.g1.management.repository.PersonRepository;

@Service
@AllArgsConstructor
public class PersonService {
    private PersonRepository personRepository;
    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    private PersonDto toDto(Person person) {
        Long age = person.getBirthDate () != null ?
                (long) (LocalDate.now().getYear() - person.getBirthDate().getYear()):null;

        return PersonDto.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .age(age)
                .taxNumber(person.getTaxNumber())
                .build();
    }

    public List<PersonDto> findAll() {
        log.info("Find all persons");
        List<Person> persons = personRepository.findAll();
        return persons.stream().map(this::toDto).toList();
    }

    public PersonDto upsert(Person person) {
        Person savedPerson = personRepository.save(person);
        return toDto(savedPerson);
    }
}
