package io.github.adam035.networkdrive.service;

import io.github.adam035.networkdrive.dto.CreateFileRequestDto;
import io.github.adam035.networkdrive.dto.FileDto;

import java.util.List;

public interface FileService {
    FileDto save(CreateFileRequestDto createFileRequestDto);
    List<FileDto> findAll();
}
