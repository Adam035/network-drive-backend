package io.github.adam035.networkdrive.repository;

import io.github.adam035.networkdrive.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(Long id);
}
