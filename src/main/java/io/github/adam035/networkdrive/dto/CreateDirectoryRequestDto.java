package io.github.adam035.networkdrive.dto;

public record CreateDirectoryRequestDto(
        String name,
        Long ownerId,
        Long parentId
) {
}
