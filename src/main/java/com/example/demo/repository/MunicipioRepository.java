package com.example.demo.repository;

import com.example.demo.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MunicipioRepository extends JpaRepository<Municipio, String> {
    List<Municipio> findByEstado(String estado);
}
