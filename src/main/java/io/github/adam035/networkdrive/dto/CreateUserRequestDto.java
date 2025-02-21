package io.github.adam035.networkdrive.dto;

public record CreateUserRequestDto(
        String username,
        String email,
        String avatarUrl,
        String role
) {
}
