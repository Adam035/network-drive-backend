package io.github.adam035.networkdrive.repository;

import io.github.adam035.networkdrive.model.File;

import java.util.List;
import java.util.Optional;

public interface FileRepository {
    File save(File file);
    List<File> findAll();
    Optional<File> findById(Long id);
}
