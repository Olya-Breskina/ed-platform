package ru.podgoretskaya.edplatform.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "материал")
public class MaterialResponseDTO {
    private int id;
    private String name;
}
