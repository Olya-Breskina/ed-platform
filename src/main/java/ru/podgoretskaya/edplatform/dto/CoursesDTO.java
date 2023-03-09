package ru.podgoretskaya.edplatform.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "курс")
public class CoursesDTO {
    @Schema(description = "порядковый номер курса")
    private int id;
    @Schema(description = "название курса")
    private String nameCourses;
    @Schema(description = "направление курса: ИТ, психология, искуство и т.д.")
    private String coursesType;
    @Schema(description = "описание курса")
    private String descriptionCourses;
}
