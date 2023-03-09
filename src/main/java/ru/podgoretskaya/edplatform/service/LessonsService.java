package ru.podgoretskaya.edplatform.service;

import ru.podgoretskaya.edplatform.dto.LessonsDTO;

public interface LessonsService {
    void saveLessonsInDB(LessonsDTO model);

    LessonsDTO chooseLessonsFromDB(int id);
}
