package io.github.adam035.networkdrive.repository;

import io.github.adam035.networkdrive.model.Directory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class DirectoryRepositoryImpl implements DirectoryRepository {

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public Directory save(Directory directory) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(directory);
            transaction.commit();
            return directory;
        } catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public List<Directory> findAll() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("select d from Directory d", Directory.class).getResultList();
        }
    }

    @Override
    public Optional<Directory> findById(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Directory directory = entityManager.find(Directory.class, id);
            return Optional.ofNullable(directory);
        }
    }
}
