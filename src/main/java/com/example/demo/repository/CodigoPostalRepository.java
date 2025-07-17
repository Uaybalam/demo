package com.example.demo.repository;

import com.example.demo.model.CodigoPostal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CodigoPostalRepository extends JpaRepository<CodigoPostal, String> {
    Optional<CodigoPostal> findByCp(String cp);
}
