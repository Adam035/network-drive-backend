package io.github.adam035.networkdrive.service;

import io.github.adam035.networkdrive.dto.CreateUserRequestDto;
import io.github.adam035.networkdrive.dto.UserDto;
import io.github.adam035.networkdrive.mapper.UserMapper;
import io.github.adam035.networkdrive.model.User;
import io.github.adam035.networkdrive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto save(CreateUserRequestDto createUserRequestDto) {
        User user = userMapper.toModel(createUserRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }
}
