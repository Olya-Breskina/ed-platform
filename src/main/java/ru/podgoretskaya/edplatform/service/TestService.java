package ru.podgoretskaya.edplatform.service;

import org.springframework.web.multipart.MultipartFile;
import ru.podgoretskaya.edplatform.dto.test.DTO;
import ru.podgoretskaya.edplatform.dto.test.TestDTO;
import ru.podgoretskaya.edplatform.dto.test.UserAnswerDTO;

public interface TestService {
    void save(MultipartFile file, int courseId, int threshold);

    TestDTO findById(int id);

    DTO answer(UserAnswerDTO userAnswerDTO, int id);
}
