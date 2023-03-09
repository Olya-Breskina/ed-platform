package ru.podgoretskaya.edplatform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.podgoretskaya.edplatform.entity.EducationMaterialEntity;
import ru.podgoretskaya.edplatform.entity.LessonsEntity;
import ru.podgoretskaya.edplatform.repository.EducationMaterialRepo;
import ru.podgoretskaya.edplatform.repository.LessonsRepo;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EducationMaterialServiceImpl implements EducationMaterialService {
    private final EducationMaterialRepo educationMaterialRepo;
    private final LessonsRepo lessonsRepo;


    @Override
    public void save(MultipartFile file, int lessonsId) {
        try {

            LessonsEntity lessonsEntity = lessonsRepo.findById(lessonsId).orElseThrow();
            EducationMaterialEntity educationMaterial = new EducationMaterialEntity();
            educationMaterial.setNameFile(file.getOriginalFilename());
            educationMaterial.setTypeFile(file.getContentType());
            educationMaterial.setData(file.getBytes());
            educationMaterial.setLessons(lessonsEntity);
            educationMaterialRepo.save(educationMaterial);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public EducationMaterialEntity findById(int id) {//вернет материал
        Optional<EducationMaterialEntity> file = educationMaterialRepo.findById(id);
        return file.orElseThrow();
    }
}