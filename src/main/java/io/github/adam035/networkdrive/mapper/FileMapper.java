package io.github.adam035.networkdrive.mapper;

import io.github.adam035.networkdrive.dto.CreateFileRequestDto;
import io.github.adam035.networkdrive.dto.FileDto;
import io.github.adam035.networkdrive.model.File;

public interface FileMapper {
    FileDto toDto(File file);
    File toModel(CreateFileRequestDto createFileRequestDto);
}
