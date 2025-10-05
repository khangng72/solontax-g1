package solontax.g1.management.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solontax.g1.management.service.PersonService;

@RestController
@RequestMapping("/v1/person")
@AllArgsConstructor
public class PersonController {
    private PersonService personService;

    @GetMapping
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok("List of person");
    }
}
