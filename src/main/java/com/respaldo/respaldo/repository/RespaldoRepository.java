package com.respaldo.respaldo.repository;

import com.respaldo.respaldo.model.Respaldo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class RespaldoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Respaldo> findAll() {
        return entityManager.createQuery("from Respaldo", Respaldo.class).getResultList();
    }

    public Optional<Respaldo> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Respaldo.class, id));
    }

    public Respaldo save(Respaldo entity) {
        if (entity.getIdRespaldo() == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

    public void deleteById(Integer id) {
        Optional<Respaldo> respaldoOptional = findById(id);
        respaldoOptional.ifPresent(entityManager::remove);
    }

    // Puedes añadir más métodos personalizados aquí
}