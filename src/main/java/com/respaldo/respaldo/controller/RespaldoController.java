package com.respaldo.respaldo.controller;

import com.respaldo.respaldo.model.Respaldo;
import com.respaldo.respaldo.service.RespaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/api/respaldos")
public class RespaldoController {

    @Autowired
    private RespaldoService respaldoService;

    @GetMapping
    public ResponseEntity<List<Respaldo>> obtenerTodosLosRespaldos() {
        return new ResponseEntity<>(respaldoService.getAllRespaldo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respaldo> obtenerRespaldoPorId(@PathVariable Integer id) {
        Optional<Respaldo> respaldo = respaldoService.getRespaldoById(id);
        return respaldo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Respaldo> crearRespaldo(@RequestBody Respaldo respaldo) {
        Respaldo nuevoRespaldo = respaldoService.crearRespaldo(respaldo);
        return new ResponseEntity<>(nuevoRespaldo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRespaldo(@PathVariable Integer id) {
        respaldoService.eliminarRespaldo(id);
        Map<String, String> response = Map.of("message", "Respaldo eliminado");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}") // Añade este método
    public ResponseEntity<Respaldo> actualizarRespaldo(@PathVariable Integer id, @RequestBody Respaldo respaldoActualizado) {
        Respaldo respaldo = respaldoService.actualizarRespaldo(id, respaldoActualizado);
        if (respaldo != null) {
            return new ResponseEntity<>(respaldo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}