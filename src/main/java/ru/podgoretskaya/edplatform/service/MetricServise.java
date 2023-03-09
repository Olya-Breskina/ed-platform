package ru.podgoretskaya.edplatform.service;

import ru.podgoretskaya.edplatform.dto.CourseAttendanceDTO;

public interface MetricServise {
    void openCourseMetric(int courseId);

    CourseAttendanceDTO getOpenCourseMetric(int courseId);

    int getNumberOfCourses();

    int getNumberOfEducation();
}
