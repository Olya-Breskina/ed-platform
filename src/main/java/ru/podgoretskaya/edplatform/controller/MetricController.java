package ru.podgoretskaya.edplatform.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.podgoretskaya.edplatform.dto.CourseAttendanceDTO;
import ru.podgoretskaya.edplatform.service.MetricServise;


@RestController
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/metric")
@Tag(name = "Статистика", description = "Методы для получения статистики")
public class MetricController {
    private final MetricServise metricServise;

    @GetMapping("/course/{id}")
    @Operation(summary = "посещяемость конкретного курса")
    public ResponseEntity<CourseAttendanceDTO> getCourseMetric(@PathVariable int id) {
        return ResponseEntity.ok(metricServise.getOpenCourseMetric(id));
    }

    @GetMapping("/course")
    @Operation(summary = "общее количество курсов")
    public int getCourseMetric() {
        return metricServise.getNumberOfCourses();
    }

    @GetMapping("/education")
    @Operation(summary = "общее количество статей")
    public int getEducationMetric() {
        return metricServise.getNumberOfEducation();
    }

}
