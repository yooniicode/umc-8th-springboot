package umc.study.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto {

        @Schema(description = "회원 이름", example = "이윤지")
        @NotBlank(message = "이름은 공백일 수 없습니다.")
        private String name;

        @Schema(description = "성별 (0: 남자, 1: 여자)", example = "1")
        @NotNull(message = "성별을 입력해야 합니다.")
        private Integer gender;

        @Schema(description = "출생년도 (YYYY)", example = "2004")
        @NotNull(message = "출생년도를 입력해야 합니다.")
        private Integer birthYear;

        @Schema(description = "출생월 (MM)", example = "3")
        @NotNull(message = "출생월을 입력해야 합니다.")
        private Integer birthMonth;

        @Schema(description = "출생일 (DD)", example = "29")
        @NotNull(message = "출생일을 입력해야 합니다.")
        private Integer birthDay;

        @Schema(description = "주소 (5~12자)", example = "서울시 마포구")
        @Size(min = 5, max = 12, message = "주소는 5자 이상, 12자 이하로 입력해야 합니다.")
        private String address;

        @Schema(description = "상세 주소 (5~12자)", example = "합정동 123-45")
        @Size(min = 5, max = 12, message = "상세주소는 5자 이상, 12자 이하로 입력해야 합니다.")
        private String specAddress;

        @Schema(description = "선호 카테고리 ID 리스트 (최소 1개 이상)", example = "[1, 3, 5]")
        @ExistCategories
        private List<Long> preferCategory;
    }
}
