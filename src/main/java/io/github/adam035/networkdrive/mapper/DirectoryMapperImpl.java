package io.github.adam035.networkdrive.mapper;

import io.github.adam035.networkdrive.dto.CreateDirectoryRequestDto;
import io.github.adam035.networkdrive.dto.DirectoryDto;
import io.github.adam035.networkdrive.model.Directory;
import io.github.adam035.networkdrive.repository.DirectoryRepository;
import io.github.adam035.networkdrive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class DirectoryMapperImpl implements DirectoryMapper {

    private final UserRepository userRepository;
    private final DirectoryRepository directoryRepository;
    private final UserMapper userMapper;

    @Override
    public DirectoryDto toDto(Directory directory) {
        if (directory == null) {
            return null;
        }
        DirectoryDto directoryDto = new DirectoryDto();
        directoryDto.setId(directory.getId());
        directoryDto.setName(directory.getName());
        directoryDto.setOwner(userMapper.toDto(directory.getOwner()));
        directoryDto.setParent(toDto(directory.getParentDirectory()));
        directoryDto.setCreatedAt(directory.getCreatedAt());
        return directoryDto;
    }

    @Override
    public Directory toModel(CreateDirectoryRequestDto createDirectoryRequestDto) {
        if (createDirectoryRequestDto == null) {
            return null;
        }
        Directory directory = new Directory();
        directory.setName(createDirectoryRequestDto.name());
        directory.setDeleted(false);
        directory.setCreatedAt(LocalDateTime.now());
        directory.setType("DIRECTORY");
        directory.setRoot(createDirectoryRequestDto.parentId() == null);
        directory.setOwner(userRepository.findById(createDirectoryRequestDto.ownerId())
                .orElseThrow(() -> new IllegalArgumentException("Owner not found with ID")));

        if (directory.isRoot()) {
            directory.setParentDirectory(null);
        } else {
            directory.setParentDirectory(directoryRepository.findById(createDirectoryRequestDto.parentId())
                    .orElseThrow(() -> new IllegalArgumentException("Parent directory not found with ID")));
        }
        return directory;
    }
}
