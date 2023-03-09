package ru.podgoretskaya.edplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Material")
public class EducationMaterialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    @JsonIgnore
    @ToString.Exclude
    private LessonsEntity lessons;//уникальный идентификатор урока

    @Column(nullable = false)
    private String nameFile;// название файла
    @Column(nullable = false)
    private String typeFile;// формат файла
    private String url;// путь до файла, интернет ресурса
    @Lob
    @ToString.Exclude
    private byte[] data;//файл как массив байт


}