package io.github.adam035.networkdrive.service;

import io.github.adam035.networkdrive.dto.CreateFileRequestDto;
import io.github.adam035.networkdrive.dto.FileDto;
import io.github.adam035.networkdrive.mapper.FileMapper;
import io.github.adam035.networkdrive.model.File;
import io.github.adam035.networkdrive.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final FileMapper fileMapper;

    @Override
    public FileDto save(CreateFileRequestDto createFileRequestDto) {
        File file = fileMapper.toModel(createFileRequestDto);
        File savedFile = fileRepository.save(file);
        return fileMapper.toDto(savedFile);
    }

    @Override
    public List<FileDto> findAll() {
        return fileRepository.findAll().stream()
                .map(fileMapper::toDto)
                .toList();
    }
}
