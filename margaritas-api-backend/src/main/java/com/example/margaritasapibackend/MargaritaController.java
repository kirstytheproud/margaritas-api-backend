package com.example.margaritasapibackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
public class MargaritaController {

    //making a repository makes it link up to the database
    @Autowired
    MargaritaRepository repository;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the wonderful world of frozen margaritas!";
    }

    @GetMapping("/margaritas")
    public ResponseEntity<List<Margarita>> getMargaritas() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping("/margarita")
    public ResponseEntity<String> createMargarita(@RequestBody Margarita margarita) {
        repository.save(margarita);
        return ResponseEntity.status(HttpStatus.CREATED).body("Margarita added");
    }

    @DeleteMapping("/margarita/{id}")
    public ResponseEntity<String> deleteMargarita(@PathVariable int id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Greeting with id of: " + id + " was deleted");
        } catch (
                EmptyResultDataAccessException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Greeting with the id of :" + id + "doesn't exist, can't delete!");
        }
    }

        // Get a random flavour
    @GetMapping("/margarita/random")
    public ResponseEntity<Margarita> getRandomMargarita() {
        List<Margarita> margaritas = repository.findAll();
        Random random = new Random();
        int randomArrayIndex = random.nextInt(margaritas.size());

        return ResponseEntity.status(HttpStatus.FOUND).body(margaritas.get(randomArrayIndex));
    }

}

