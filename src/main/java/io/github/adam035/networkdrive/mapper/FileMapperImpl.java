package io.github.adam035.networkdrive.mapper;

import io.github.adam035.networkdrive.dto.CreateFileRequestDto;
import io.github.adam035.networkdrive.dto.FileDto;
import io.github.adam035.networkdrive.model.File;
import io.github.adam035.networkdrive.repository.DirectoryRepository;
import io.github.adam035.networkdrive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class FileMapperImpl implements FileMapper {

    private final UserRepository userRepository;
    private final DirectoryRepository directoryRepository;
    private final UserMapper userMapper;

    @Override
    public FileDto toDto(File file) {
        if (file == null) {
            return null;
        }
        FileDto fileDto = new FileDto();
        fileDto.setId(file.getId());
        fileDto.setName(file.getName());
        fileDto.setCreatedAt(file.getCreatedAt());
        fileDto.setMd5(file.getMd5());
        fileDto.setSha1(file.getSha1());
        fileDto.setSha256(file.getSha256());
        fileDto.setSize(file.getSize());
        fileDto.setOwner(userMapper.toDto(file.getOwner()));
        return fileDto;
    }

    @Override
    public File toModel(CreateFileRequestDto createFileRequestDto) {
        if (createFileRequestDto == null) {
            return null;
        }
        File file = new File();
        file.setName(createFileRequestDto.name());
        file.setType("FILE");
        file.setOwner(userRepository.findById(createFileRequestDto.ownerId())
                .orElse(null));

        if (createFileRequestDto.directoryId() != null) {
            file.setParentDirectory(directoryRepository
                    .findById(createFileRequestDto.directoryId())
                    .orElse(null));
        }
        file.setDeleted(false);
        file.setCreatedAt(LocalDateTime.now());
        file.setPath("path");
        file.setMd5("MD5");
        file.setSha1("SHA-1");
        file.setSha256("SHA-256");
        file.setSize(1);
        return file;
    }
}
