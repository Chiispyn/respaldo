package com.respaldo.respaldo.service;

import com.respaldo.respaldo.model.Respaldo;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RespaldoService {
    List<Respaldo> getAllRespaldo();
    Optional<Respaldo> getRespaldoById(Integer id);
    Respaldo crearRespaldo(Respaldo respaldo);
    void restaurarVersion(Integer idRespaldo, LocalDateTime fechaHoraVersion);
    void eliminarRespaldo(Integer idRespaldo);
}