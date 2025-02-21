package io.github.adam035.networkdrive.service;

import io.github.adam035.networkdrive.dto.CreateDirectoryRequestDto;
import io.github.adam035.networkdrive.dto.DirectoryDto;
import io.github.adam035.networkdrive.mapper.DirectoryMapper;
import io.github.adam035.networkdrive.model.Directory;
import io.github.adam035.networkdrive.repository.DirectoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DirectoryServiceImpl implements DirectoryService {

    private final DirectoryRepository directoryRepository;
    private final DirectoryMapper directoryMapper;

    @Override
    public DirectoryDto save(CreateDirectoryRequestDto createDirectoryRequestDto) {
        Directory directory = directoryMapper.toModel(createDirectoryRequestDto);
        Directory savedDirectory  = directoryRepository.save(directory);
        return directoryMapper.toDto(savedDirectory);
    }

    @Override
    public List<DirectoryDto> findAll() {
        return directoryRepository.findAll().stream()
                .map(directoryMapper::toDto)
                .toList();
    }
}
