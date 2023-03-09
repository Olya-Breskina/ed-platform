package ru.podgoretskaya.edplatform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.podgoretskaya.edplatform.dto.CourseAttendanceDTO;
import ru.podgoretskaya.edplatform.entity.CoursesEntity;
import ru.podgoretskaya.edplatform.entity.EducationMaterialEntity;
import ru.podgoretskaya.edplatform.repository.CoursesRepo;
import ru.podgoretskaya.edplatform.repository.EducationMaterialRepo;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Component
@RequiredArgsConstructor
@Slf4j
public class MetricServiseImpl implements MetricServise {
    private final CoursesRepo coursesRepo;
    private final EducationMaterialRepo educationMaterialRepo;

    private final ConcurrentHashMap<Integer, Integer> courseMetric = new ConcurrentHashMap<>();

    @Override
    public void openCourseMetric(int courseId) {
        if (!courseMetric.containsKey(courseId)) {
            courseMetric.put(courseId, 0);
        }
        Integer integer = courseMetric.get(courseId);
        integer++;
        courseMetric.put(courseId, integer);
    }

    @Override
    public CourseAttendanceDTO getOpenCourseMetric(int courseId) {
        CourseAttendanceDTO courseAttendanceDTO = new CourseAttendanceDTO();
        if (!courseMetric.containsKey(courseId)) {
            courseMetric.put(courseId, 0);
        }
        CoursesEntity coursesEntity = coursesRepo.findById(courseId).orElseThrow();
        courseAttendanceDTO.setNameCourses(coursesEntity.getNameCourses());
        courseAttendanceDTO.setCounter(courseMetric.get(courseId));
        return courseAttendanceDTO;
    }

    @Override
    public int getNumberOfCourses()//количество курсов
    {
        List<CoursesEntity> all = coursesRepo.findAll();
        System.out.println(all.size());
        return all.size();
    }

    @Override
    public int getNumberOfEducation()//количество уч.материалов
    {
        List<EducationMaterialEntity> all = educationMaterialRepo.findAll();
        System.out.println(all.size());
        return all.size();
    }
}
