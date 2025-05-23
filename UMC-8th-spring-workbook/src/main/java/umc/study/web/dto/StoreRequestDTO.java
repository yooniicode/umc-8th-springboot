// StoreRequestDto.java
package umc.study.web.dto;

import lombok.Getter;

@Getter
public class StoreRequestDTO {
    private Long regionId;
    private String name;
    private String address;
    private Float score;
}
