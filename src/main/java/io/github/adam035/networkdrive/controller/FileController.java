package io.github.adam035.networkdrive.controller;

import io.github.adam035.networkdrive.dto.CreateFileRequestDto;
import io.github.adam035.networkdrive.dto.FileDto;
import io.github.adam035.networkdrive.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/files")
public class FileController {

    private final FileService fileService;

    @GetMapping
    public List<FileDto> findAll() {
        return fileService.findAll();
    }

    @PostMapping
    public FileDto save(@RequestBody CreateFileRequestDto createFileRequestDto) {
        return fileService.save(createFileRequestDto);
    }
}
