package io.github.adam035.networkdrive.service;

import io.github.adam035.networkdrive.dto.CreateUserRequestDto;
import io.github.adam035.networkdrive.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(CreateUserRequestDto createUserRequestDto);
    List<UserDto> findAll();
}
