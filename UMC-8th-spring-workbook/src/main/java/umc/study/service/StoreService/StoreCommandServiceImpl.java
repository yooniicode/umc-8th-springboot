// StoreCommandServiceImpl.java
package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public StoreResponseDTO createStore(StoreRequestDTO requestDto) {
        Region region = regionRepository.findById(requestDto.getRegionId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 지역입니다."));

        Store store = Store.builder()
                .name(requestDto.getName())
                .address(requestDto.getAddress())
                .score(requestDto.getScore())
                .region(region)
                .build();

        Store saved = storeRepository.save(store);

        return StoreResponseDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .address(saved.getAddress())
                .score(saved.getScore())
                .regionName(region.getName())
                .build();
    }
}
