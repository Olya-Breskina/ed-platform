package ru.podgoretskaya.edplatform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.podgoretskaya.edplatform.dto.CoursesDTO;
import ru.podgoretskaya.edplatform.dto.CoursesResponseDTO;
import ru.podgoretskaya.edplatform.entity.CoursesEntity;
import ru.podgoretskaya.edplatform.mapper.CoursesMapper;
import ru.podgoretskaya.edplatform.repository.CoursesRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoursesServiceImpl implements CoursesService {
    private final CoursesMapper coursesMapper;
    private final CoursesRepo coursesRepo;

    @Override
    public void saveCoursInDB(CoursesDTO model) {
        log.info("\n>>> сохраниение  курсов " + model.toString() + ">>>\n");
        try {
            coursesRepo.save(coursesMapper.mapCoursesDTOToEntity(model));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<CoursesDTO> getCoursFromDB() {
        List<CoursesEntity> all = coursesRepo.findAll();
        return all.stream()
                .map(dto -> new CoursesDTO(dto.getId(), dto.getNameCourses(), dto.getCoursesType(), dto.getDescriptionCourses()))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public CoursesResponseDTO chooseCourseFromDB(int id) { //CoursesEntity
        CoursesEntity coursesEntity = coursesRepo.findById(id).orElseThrow();
        return coursesMapper.mapCoursesEntityToDTO(coursesEntity); // return  coursesRepo.findById(id).orElseThrow();

    }
}
