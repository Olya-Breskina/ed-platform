package ru.podgoretskaya.edplatform.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "посещяемость курса")
public class CourseAttendanceDTO {
    @Schema(description = "название курса")
    private String nameCourses;
    @Schema(description = "счетчик просмотров")
    private int counter;
}
