package ru.podgoretskaya.edplatform.service;

import ru.podgoretskaya.edplatform.dto.CoursesDTO;
import ru.podgoretskaya.edplatform.dto.CoursesResponseDTO;

import java.util.List;

public interface CoursesService {
    void saveCoursInDB(CoursesDTO model);

    List<CoursesDTO> getCoursFromDB();

    CoursesResponseDTO chooseCourseFromDB(int id);
}

