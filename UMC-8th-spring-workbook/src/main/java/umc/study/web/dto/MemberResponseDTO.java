package umc.study.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO {

        @Schema(description = "회원 ID", example = "1001")
        private Long memberId;

        @Schema(description = "가입 일시", example = "2025-05-23T14:53:21")
        private LocalDateTime createdAt;
    }
}

