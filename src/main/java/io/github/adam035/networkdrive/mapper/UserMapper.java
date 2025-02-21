package io.github.adam035.networkdrive.mapper;

import io.github.adam035.networkdrive.dto.CreateUserRequestDto;
import io.github.adam035.networkdrive.dto.UserDto;
import io.github.adam035.networkdrive.model.User;

public interface UserMapper {
    UserDto toDto(User user);
    User toModel(CreateUserRequestDto createUserRequestDto);
}
