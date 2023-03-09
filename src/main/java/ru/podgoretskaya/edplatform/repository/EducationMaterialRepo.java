package ru.podgoretskaya.edplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.podgoretskaya.edplatform.entity.EducationMaterialEntity;


import java.util.List;

public interface EducationMaterialRepo extends JpaRepository<EducationMaterialEntity, Integer> {
    List<EducationMaterialEntity> findAllByLessons(int id);
}
