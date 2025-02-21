package io.github.adam035.networkdrive.repository;

import io.github.adam035.networkdrive.model.Directory;

import java.util.List;
import java.util.Optional;

public interface DirectoryRepository {
    Directory save(Directory directory);
    List<Directory> findAll();
    Optional<Directory> findById(Long id);
}
