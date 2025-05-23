package umc.study.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class StoreRequestDTO {

    @Schema(description = "소속 지역 ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "지역 ID는 필수입니다.")
    private Long regionId;

    @Schema(description = "가게 이름", example = "윤지카페", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "가게 이름은 공백일 수 없습니다.")
    private String name;

    @Schema(description = "가게 주소", example = "서울시 마포구 합정동 123-45", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "가게 주소는 공백일 수 없습니다.")
    private String address;

    @Schema(description = "가게 평점 (0.0 ~ 5.0)", example = "4.5", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "가게 평점은 필수입니다.")
    @DecimalMin(value = "0.0", inclusive = true, message = "평점은 0 이상이어야 합니다.")
    @DecimalMax(value = "5.0", inclusive = true, message = "평점은 5 이하이어야 합니다.")
    private Float score;
}
