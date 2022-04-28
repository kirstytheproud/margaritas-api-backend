package com.example.margaritasapibackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@CrossOrigin
//@RestController
public class MargaritaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MargaritaApplication.class, args);

	}
}
