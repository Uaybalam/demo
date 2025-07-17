package com.example.demo.repository;

import com.example.demo.model.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LocalidadRepository extends JpaRepository<Localidad, String> {
    List<Localidad> findByEstado(String estado);
}