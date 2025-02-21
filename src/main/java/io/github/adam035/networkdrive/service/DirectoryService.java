package io.github.adam035.networkdrive.service;

import io.github.adam035.networkdrive.dto.CreateDirectoryRequestDto;
import io.github.adam035.networkdrive.dto.DirectoryDto;

import java.util.List;

public interface DirectoryService {
    DirectoryDto save(CreateDirectoryRequestDto createDirectoryRequestDto);
    List<DirectoryDto> findAll();
}
