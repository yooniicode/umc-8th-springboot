// StoreCommandService.java
package umc.study.service.StoreService;

import umc.study.api.dto.StoreRequestDto;
import umc.study.api.dto.StoreResponseDto;

public interface StoreCommandService {
    StoreResponseDto createStore(StoreRequestDto requestDto);
}
