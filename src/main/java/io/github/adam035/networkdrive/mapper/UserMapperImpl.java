package io.github.adam035.networkdrive.mapper;

import io.github.adam035.networkdrive.dto.CreateUserRequestDto;
import io.github.adam035.networkdrive.dto.UserDto;
import io.github.adam035.networkdrive.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setAvatarUrl(user.getAvatarUrl());
        userDto.setRole(user.getRole());
        return userDto;
    }

    @Override
    public User toModel(CreateUserRequestDto createUserRequestDto) {
        if (createUserRequestDto == null) {
            return null;
        }
        User user = new User();
        user.setUsername(createUserRequestDto.username());
        user.setEmail(createUserRequestDto.email());
        user.setFidoCredentials("FIDO");
        user.setDeleted(false);
        user.setCreatedAt(LocalDateTime.now());
        user.setAvatarUrl(createUserRequestDto.avatarUrl());
        user.setRole(createUserRequestDto.role());
        user.setFiles(List.of());
        return user;
    }
}
