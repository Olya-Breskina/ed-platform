package ru.podgoretskaya.edplatform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Activities")
public class ActivitiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private UsersEntity userId;
    @OneToOne
    private TestsEntity testId;
    @ManyToOne
    private CoursesEntity courseId;
    private int testRresult;
    private boolean isCompleted;
}
