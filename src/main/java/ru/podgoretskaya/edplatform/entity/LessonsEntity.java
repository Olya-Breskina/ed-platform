package ru.podgoretskaya.edplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Lessons")
@Schema(description = "урок")
public class LessonsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "идентификатор")
    private int id;//уникальный идентификатор урока

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courses_id")
    @JsonIgnore
    @ToString.Exclude
    private CoursesEntity courses;

    @Column(nullable = false)
    @Schema(description = "название урока")
    private String nameLessons;
    @Schema(description = "описание урока")
    private String descriptionLessons;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lessons")
    @Schema(description = "список учебных материалов")
    @ToString.Exclude
    private List<EducationMaterialEntity> educationMaterials;
}
