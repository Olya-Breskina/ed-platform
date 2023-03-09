package ru.podgoretskaya.edplatform.service;

import org.springframework.web.multipart.MultipartFile;
import ru.podgoretskaya.edplatform.entity.EducationMaterialEntity;

public interface EducationMaterialService {
    void save(MultipartFile file, int lessonsId);

    EducationMaterialEntity findById(int id);
}
