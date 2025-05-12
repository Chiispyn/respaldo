package com.respaldo.respaldo.service.impl;

import com.respaldo.respaldo.model.Respaldo;
import com.respaldo.respaldo.repository.RespaldoRepository;
import com.respaldo.respaldo.service.RespaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RespaldoServiceImpl implements RespaldoService {

    private final RespaldoRepository respaldoRepository;

    @Autowired
    public RespaldoServiceImpl(RespaldoRepository respaldoRepository) {
        this.respaldoRepository = respaldoRepository;
    }

    @Override
    public List<Respaldo> getAllRespaldo() {
        return respaldoRepository.findAll();
    }

    @Override
    public Optional<Respaldo> getRespaldoById(Integer id) {
        return respaldoRepository.findById(id);
    }

    @Override
    public Respaldo crearRespaldo(Respaldo respaldo) {
        respaldo.setFechaHora(LocalDateTime.now());
        return respaldoRepository.save(respaldo);
    }

    @Override
    public void restaurarVersion(Integer idRespaldo, LocalDateTime fechaHoraVersion) {
        // Aquí iría la lógica para restaurar a la versión con la fecha y hora especificada
        // Podrías necesitar buscar el respaldo por ID y luego el archivo correspondiente a la fechaHoraVersion
        System.out.println("Restaurando respaldo con ID: " + idRespaldo + ", a la versión de: " + fechaHoraVersion);
        // Por ahora, solo imprimimos un mensaje
    }

    @Override
    public void eliminarRespaldo(Integer idRespaldo) {
        respaldoRepository.deleteById(idRespaldo);
    }
}