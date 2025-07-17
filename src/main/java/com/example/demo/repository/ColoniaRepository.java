package com.example.demo.repository;

import com.example.demo.model.Colonia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ColoniaRepository extends JpaRepository<Colonia, String> {
    List<Colonia> findByCp(String cp);
}
