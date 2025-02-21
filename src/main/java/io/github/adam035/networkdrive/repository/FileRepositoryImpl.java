package io.github.adam035.networkdrive.repository;

import io.github.adam035.networkdrive.model.File;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class FileRepositoryImpl implements FileRepository {

    private final EntityManagerFactory entityManagerFactory;
    @Override
    public File save(File file) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(file);
            transaction.commit();
            return file;
        } catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public List<File> findAll() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("select f from File f", File.class).getResultList();
        }
    }

    @Override
    public Optional<File> findById(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            File file = entityManager.find(File.class, id);
            return Optional.ofNullable(file);
        }
    }
}
