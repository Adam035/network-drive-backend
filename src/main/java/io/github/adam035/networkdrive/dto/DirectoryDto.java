package io.github.adam035.networkdrive.dto;

import io.github.adam035.networkdrive.model.Directory;
import io.github.adam035.networkdrive.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DirectoryDto {
    private Long id;
    private String name;
    private UserDto owner;
    private DirectoryDto parent;
    private LocalDateTime createdAt;
}
