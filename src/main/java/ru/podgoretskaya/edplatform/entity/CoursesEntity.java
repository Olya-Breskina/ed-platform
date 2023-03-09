package ru.podgoretskaya.edplatform.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Courses")
@Schema(description = "курсы")
public class CoursesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id урока")
    private int id;
    @Column(nullable = false)
    @Schema(description = "название курса")
    private String nameCourses;
    @Schema(description = "тип курса")
    private String coursesType;
    @Schema(description = "описание курса")
    private String descriptionCourses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courses")
    @Schema(description = "список всех уроков курса")
    private List<LessonsEntity> lessons;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courses")
    @Schema(description = "список всех тестов курса")
    private List<TestsEntity> test;
}
