package io.github.adam035.networkdrive.controller;

import io.github.adam035.networkdrive.dto.CreateDirectoryRequestDto;
import io.github.adam035.networkdrive.dto.DirectoryDto;
import io.github.adam035.networkdrive.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/directories")
public class DirectoryController {

    private final DirectoryService directoryService;

    @GetMapping
    List<DirectoryDto> findAll() {
        return directoryService.findAll();
    }

    @PostMapping
    DirectoryDto save(@RequestBody CreateDirectoryRequestDto createDirectoryRequestDto) {
        return directoryService.save(createDirectoryRequestDto);
    }
}
