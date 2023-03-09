package ru.podgoretskaya.edplatform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.podgoretskaya.edplatform.dto.LessonsDTO;
import ru.podgoretskaya.edplatform.entity.CoursesEntity;
import ru.podgoretskaya.edplatform.entity.LessonsEntity;
import ru.podgoretskaya.edplatform.mapper.LessonsMapper;
import ru.podgoretskaya.edplatform.repository.CoursesRepo;
import ru.podgoretskaya.edplatform.repository.EducationMaterialRepo;
import ru.podgoretskaya.edplatform.repository.LessonsRepo;

@Service
@RequiredArgsConstructor
@Slf4j
public class LessonsServiceImpl implements LessonsService {
    private final LessonsRepo lessonsRepo;
    private final LessonsMapper lessonsMapper;
    private final EducationMaterialRepo educationMaterialRepo;
    private final CoursesRepo coursesRepo;

    @Override
    public void saveLessonsInDB(LessonsDTO model) {
        log.info("\n>>> сохраниение  курсов " + model.toString() + ">>>\n");
        try {
            CoursesEntity coursesEntity = coursesRepo.findById(model.getId()).orElseThrow();
            LessonsEntity lessonsEntity = lessonsMapper.mapLessonsDTOToEntity(model);
            lessonsEntity.setCourses(coursesEntity);
            lessonsRepo.save(lessonsEntity);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    @Transactional
    public LessonsDTO chooseLessonsFromDB(int id) {
        LessonsEntity lessonsEntity = lessonsRepo.findById(id).orElseThrow();
        LessonsDTO lessonsDTO = lessonsMapper.mapLessonsEntityToDTO(lessonsEntity);
        return lessonsDTO;
    }
}
