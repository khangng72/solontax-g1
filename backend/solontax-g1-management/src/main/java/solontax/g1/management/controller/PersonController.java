package solontax.g1.management.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solontax.g1.management.dto.PersonDto;
import solontax.g1.management.entity.Person;
import solontax.g1.management.service.PersonService;

@RestController
@RequestMapping("/v1/person")
@AllArgsConstructor
public class PersonController {
    private PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<List<PersonDto>> findAll() {
        List<PersonDto> persons = personService.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/by-tax-number/{taxNumber}")
    public ResponseEntity<PersonDto> findByTaxNumber(@PathVariable("taxNumber") Long taxNumber) throws Exception {
        PersonDto person = personService.findByTaxNumber(taxNumber);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonDto> upsert(@RequestBody Person person) {
        PersonDto savedPerson = personService.upsert(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }
}
