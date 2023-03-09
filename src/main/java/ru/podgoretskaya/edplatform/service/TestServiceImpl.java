package ru.podgoretskaya.edplatform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.podgoretskaya.edplatform.dto.test.*;
import ru.podgoretskaya.edplatform.entity.CoursesEntity;
import ru.podgoretskaya.edplatform.entity.TestsEntity;
import ru.podgoretskaya.edplatform.enums.AnswerPosition;
import ru.podgoretskaya.edplatform.repository.CoursesRepo;
import ru.podgoretskaya.edplatform.repository.TestsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestServiceImpl implements TestService {
    private final TestsRepo testsRepo;
    private final CoursesRepo coursesRepo;

    @Override
    public void save(MultipartFile file, int courseId, int threshold) {
        try {
            CoursesEntity coursesEntity = coursesRepo.findById(courseId).orElseThrow();
            TestsEntity testsEntity = new TestsEntity();
            testsEntity.setNameFile(file.getOriginalFilename());
            testsEntity.setTypeFile(file.getContentType());
            testsEntity.setData(file.getBytes());
            testsEntity.setThreshold(threshold);
            testsEntity.setCourses(coursesEntity);
            testsRepo.save(testsEntity);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public TestDTO findById(int id) {
        Optional<TestsEntity> file = testsRepo.findById(id);
        List<QuestionDTO> list = new ArrayList<>();
        String cvsSplitBy = ";";
        int count = 1;
        String s = new String(file.get().getData());
        log.info("\n>>>" + file.get().getNameFile());
        for (String line : s.split("\\r\\n")) {
            List<AnswerDTO> answers = new ArrayList<>();//список ответов
            String quastion;
            String[] element = line.split(cvsSplitBy);
            quastion = element[0];
            answers.add(new AnswerDTO(element[1], AnswerPosition.A));
            answers.add(new AnswerDTO(element[2], AnswerPosition.B));
            answers.add(new AnswerDTO(element[3], AnswerPosition.C));
            QuestionDTO questionDTO = new QuestionDTO();//список вопросов
            questionDTO.setId(count++);
            questionDTO.setQuastion(quastion);
            questionDTO.setAnswers(answers);
            questionDTO.setCarrectAnswers(AnswerPosition.getByPosition(Integer.parseInt(element[4].trim())));
            list.add(questionDTO);
        }
        return new TestDTO(1L, "name", list);
    }

    @Override
    public DTO answer(UserAnswerDTO userAnswerDTO, int id) {
        TestDTO test = findById(id);
        if (test.getQuestions().size() != userAnswerDTO.getAnswers().size()) {
        }
        int count = (int) test.getQuestions().stream().filter(q -> q.getCarrectAnswers().equals(userAnswerDTO.getAnswers().get(q.getId()))).count();// кол-во правельныхответов
        int countQuestion = test.getQuestions().size();//кол-во вопросов
        return new DTO(countQuestion, count);
    }
}
