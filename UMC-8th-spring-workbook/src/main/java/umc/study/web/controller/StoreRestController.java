package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.api.dto.StoreRequestDto;
import umc.study.api.dto.StoreResponseDto;
import umc.study.service.StoreService.StoreCommandService;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping
    public ResponseEntity<StoreResponseDto> addStore(@RequestBody StoreRequestDto requestDto) {
        StoreResponseDto response = storeCommandService.createStore(requestDto);
        return ResponseEntity.ok(response);
    }
}
