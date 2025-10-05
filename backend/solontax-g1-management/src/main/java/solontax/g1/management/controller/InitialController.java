package solontax.g1.management.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController {

    @GetMapping
    public ResponseEntity<String> getInitial() {
        return ResponseEntity.ok("Welcome to the SolonTax G1 Management API");
    }
}
