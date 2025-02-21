package io.github.adam035.networkdrive.controller;

import io.github.adam035.networkdrive.dto.CreateUserRequestDto;
import io.github.adam035.networkdrive.dto.UserDto;
import io.github.adam035.networkdrive.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public UserDto create(@RequestBody CreateUserRequestDto createUserRequestDto) {
        return userService.save(createUserRequestDto);
    }
}
