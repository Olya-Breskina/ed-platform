package ru.podgoretskaya.edplatform.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "урок")
public class LessonsDTO {
    @Schema(description = "id курса")
    private int id;
    @Schema(description = "название урока")
    private String nameLessons;
    @Schema(description = "описание урока")
    private String descriptionLessons;
    private List<MaterialResponseDTO> educationMaterialName;
}
