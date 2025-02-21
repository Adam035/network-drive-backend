package io.github.adam035.networkdrive.dto;

public record CreateFileRequestDto (
    String name,
    Long ownerId,
    Long directoryId
) {
}
