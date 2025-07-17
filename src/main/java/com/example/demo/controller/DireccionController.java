package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import com.example.demo.repository.EstadoRepository;
import com.example.demo.repository.ColoniaRepository;
import com.example.demo.repository.CodigoPostalRepository;
import com.example.demo.repository.LocalidadRepository;
import com.example.demo.repository.MunicipioRepository;

import com.example.demo.model.Estado;
import com.example.demo.model.Municipio;
import com.example.demo.model.Localidad;
import com.example.demo.model.Colonia;
import com.example.demo.model.CodigoPostal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
@Controller
public class DireccionController {

    @Autowired EstadoRepository estadoRepo;
    @Autowired MunicipioRepository municipioRepo;
    @Autowired LocalidadRepository localidadRepo;
    @Autowired CodigoPostalRepository cpRepo;
    @Autowired ColoniaRepository coloniaRepo;

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estados", estadoRepo.findAll());
        return "formulario";
    }

    @GetMapping("/municipios")
    @ResponseBody
    public List<Municipio> municipios(@RequestParam String estadoId) {
        return municipioRepo.findByEstado(estadoId);
    }

    @GetMapping("/localidades")
    @ResponseBody
    public List<Localidad> localidades(@RequestParam String estadoId) {
        return localidadRepo.findByEstado(estadoId);
    }

    @GetMapping("/buscar-cp")
    @ResponseBody
    public ResponseEntity<?> buscarPorCp(@RequestParam String cp) {
        Optional<CodigoPostal> resultado = cpRepo.findByCp(cp);
        if (resultado.isPresent()) {
            CodigoPostal data = resultado.get();
            Map<String, Object> res = new HashMap<>();
            res.put("estadoId", data.getEstado());
            res.put("municipioId", data.getMunicipio());
            res.put("localidadId", data.getLocalidad());
            res.put("colonias", coloniaRepo.findByCp(cp));
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(404).body("Código postal no encontrado");
        }
    }

    @PostMapping("/validar-direccion")
    @ResponseBody
    public ResponseEntity<String> validar(@RequestParam String codigoPostal,
                                          @RequestParam String estadoId,
                                          @RequestParam String municipioId,
                                          @RequestParam String localidadId,
                                          @RequestParam String colonia) {
        Optional<CodigoPostal> cp = cpRepo.findByCp(codigoPostal);
        if (cp.isEmpty()) return ResponseEntity.badRequest().body("Código postal inválido");

        CodigoPostal data = cp.get();
        if (!data.getEstado().equals(estadoId) ||
                !data.getMunicipio().equals(municipioId) ||
                !data.getLocalidad().equals(localidadId)) {
            return ResponseEntity.badRequest().body("Datos inconsistentes con el catálogo");
        }

        boolean coloniaExiste = coloniaRepo.findByCp(codigoPostal)
                .stream().anyMatch(c -> c.getClave().equalsIgnoreCase(colonia));
        if (!coloniaExiste) {
            return ResponseEntity.badRequest().body("Colonia no encontrada");
        }

        return ResponseEntity.ok("Dirección válida");
    }
}
