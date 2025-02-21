package io.github.adam035.networkdrive.dto;

import io.github.adam035.networkdrive.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileDto {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private String md5;
    private String sha1;
    private String sha256;
    private long size;
    private UserDto owner;
}
