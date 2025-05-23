// StoreResponseDto.java
package umc.study.web.dto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreResponseDTO {
    private Long id;
    private String name;
    private String address;
    private Float score;
    private String regionName;
}
