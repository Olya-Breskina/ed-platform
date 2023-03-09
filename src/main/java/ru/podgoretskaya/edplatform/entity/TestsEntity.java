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
@Table(name = "Tests")
public class TestsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;//уникальный идентификатор теста

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courses_id")
    @JsonIgnore
    @ToString.Exclude
    private CoursesEntity courses;//уникальный идентификатор урока
    @Column(nullable = false)
    private String nameFile;// название файла
    @Column(nullable = false)
    private String typeFile;// формат файла
    @Column(nullable = false)
    private int threshold;//количество правильных ответов для зачета по курсу
    @Lob
    @ToString.Exclude
    @JsonIgnore
    private byte[] data;//файл как массив байт

}
