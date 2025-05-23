package umc.study.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(description = "가게 등록 응답 DTO")
public class StoreResponseDTO {

    @Schema(description = "가게 ID", example = "1001")
    private Long id;

    @Schema(description = "가게 이름", example = "윤지카페")
    private String name;

    @Schema(description = "가게 주소", example = "서울시 마포구 합정동 123-45")
    private String address;

    @Schema(description = "가게 평점", example = "4.5")
    private Float score;

    @Schema(description = "지역 이름", example = "홍대")
    private String regionName;
}
