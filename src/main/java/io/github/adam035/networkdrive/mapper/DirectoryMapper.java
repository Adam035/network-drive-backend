package io.github.adam035.networkdrive.mapper;

import io.github.adam035.networkdrive.dto.CreateDirectoryRequestDto;
import io.github.adam035.networkdrive.dto.DirectoryDto;
import io.github.adam035.networkdrive.model.Directory;

public interface DirectoryMapper {
    DirectoryDto toDto(Directory directory);
    Directory toModel(CreateDirectoryRequestDto createDirectoryRequestDto);
}
