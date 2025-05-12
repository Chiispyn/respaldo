package com.respaldo.respaldo.repository;

import com.respaldo.respaldo.model.Respaldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RespaldoRepository extends JpaRepository<Respaldo, Integer> {
    List<Respaldo> findAll();

    Optional<Respaldo> findById(Integer id);

    @SuppressWarnings("unchecked")
    Respaldo save(Respaldo respaldo);

    void deleteById(Integer id);
}