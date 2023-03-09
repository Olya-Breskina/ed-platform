package ru.podgoretskaya.edplatform.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.podgoretskaya.edplatform.dto.CoursesDTO;
import ru.podgoretskaya.edplatform.dto.CoursesResponseDTO;
import ru.podgoretskaya.edplatform.dto.TestResponseDTO;
import ru.podgoretskaya.edplatform.entity.CoursesEntity;
import ru.podgoretskaya.edplatform.entity.TestsEntity;


import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CoursesMapper {
    private final LessonsMapper lessonsMapper;

    public CoursesResponseDTO mapCoursesEntityToDTO(CoursesEntity coursesEntity) {
        CoursesResponseDTO coursesDTO = new CoursesResponseDTO();
        coursesDTO.setId(coursesEntity.getId());
        coursesDTO.setCoursesType(coursesEntity.getCoursesType());
        coursesDTO.setDescriptionCourses(coursesEntity.getDescriptionCourses());
        coursesDTO.setNameCourses(coursesEntity.getNameCourses());
        coursesDTO.setLessons(coursesEntity.getLessons().stream().map(dto -> lessonsMapper.mapLessonsEntityToDTO(dto)).collect(Collectors.toList()));
        coursesDTO.setTest((coursesEntity.getTest().stream().map(dto -> creatTestDTO(dto)).collect(Collectors.toList())));
        return coursesDTO;
    }

    public CoursesEntity mapCoursesDTOToEntity(CoursesDTO coursesDTO) {
        CoursesEntity coursesEntity = new CoursesEntity();
        coursesEntity.setCoursesType(coursesDTO.getCoursesType());
        coursesEntity.setDescriptionCourses(coursesDTO.getDescriptionCourses());
        coursesEntity.setNameCourses(coursesDTO.getNameCourses());
        coursesEntity.setId(coursesDTO.getId());
        return coursesEntity;
    }

    private TestResponseDTO creatTestDTO(TestsEntity testsEntity) {
        TestResponseDTO testResponseDTO = new TestResponseDTO();
        testResponseDTO.setId(testsEntity.getId());
        testResponseDTO.setName(testsEntity.getNameFile());
        return testResponseDTO;
    }
}
