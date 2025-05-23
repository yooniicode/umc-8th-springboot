// StoreCommandServiceImpl.java
package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.api.dto.StoreRequestDto;
import umc.study.api.dto.StoreResponseDto;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public StoreResponseDto createStore(StoreRequestDto requestDto) {
        Region region = regionRepository.findById(requestDto.getRegionId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 지역입니다."));

        Store store = Store.builder()
                .name(requestDto.getName())
                .address(requestDto.getAddress())
                .score(requestDto.getScore())
                .region(region)
                .build();

        Store saved = storeRepository.save(store);

        return StoreResponseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .address(saved.getAddress())
                .score(saved.getScore())
                .regionName(region.getName())
                .build();
    }
}
