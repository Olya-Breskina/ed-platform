package ru.podgoretskaya.edplatform.dto.test;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.podgoretskaya.edplatform.enums.AnswerPosition;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private int id;
    private String quastion;
    private List<AnswerDTO> answers;
    @JsonIgnore
    private AnswerPosition carrectAnswers;
}