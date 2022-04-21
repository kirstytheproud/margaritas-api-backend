package com.example.margaritasapibackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MargaritaRepository extends JpaRepository <Margarita, Integer> {
}
