package ru.podgoretskaya.edplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.podgoretskaya.edplatform.entity.LessonsEntity;

import java.util.List;


public interface LessonsRepo extends JpaRepository<LessonsEntity, Integer> {
    List<LessonsEntity> findAllByCourses(int courses);
}
