package ru.podgoretskaya.edplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.podgoretskaya.edplatform.entity.CoursesEntity;


public interface CoursesRepo extends JpaRepository<CoursesEntity, Integer> {

}
