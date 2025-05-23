package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @Operation(summary = "가게 등록", description = "특정 지역에 새 가게를 등록합니다.")
    @ApiResponse(responseCode = "200", description = "가게 등록 성공",
            content = @Content(schema = @Schema(implementation = StoreResponseDTO.class)))
    @PostMapping("/stores")
    public ResponseEntity<StoreResponseDTO> addStore(@Valid @RequestBody StoreRequestDTO requestDto) {
        StoreResponseDTO response = storeCommandService.createStore(requestDto);
        return ResponseEntity.ok(response);
    }

}
