package com.respaldo.respaldo.controller;

import com.respaldo.respaldo.model.Respaldo;
import com.respaldo.respaldo.service.RespaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/respaldos")
public class RespaldoController {

    private final RespaldoService respaldoService;

    @Autowired
    public RespaldoController(RespaldoService respaldoService) {
        this.respaldoService = respaldoService;
    }

    @GetMapping
    public ResponseEntity<List<Respaldo>> getAllRespaldos() {
        return ResponseEntity.ok(respaldoService.getAllRespaldo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respaldo> getRespaldoById(@PathVariable Integer id) {
        Optional<Respaldo> respaldo = respaldoService.getRespaldoById(id);
        return respaldo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Respaldo> crearRespaldo(@RequestBody Respaldo respaldo) {
        Respaldo nuevoRespaldo = respaldoService.crearRespaldo(respaldo);
        return new ResponseEntity<>(nuevoRespaldo, HttpStatus.CREATED);
    }

    @PostMapping("/restaurar/{id}")
    public ResponseEntity<Void> restaurarRespaldo(
            @PathVariable Integer id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaHoraVersion) {
        respaldoService.restaurarVersion(id, fechaHoraVersion);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRespaldo(@PathVariable Integer id) {
        respaldoService.eliminarRespaldo(id);
        return ResponseEntity.noContent().build();
    }
}