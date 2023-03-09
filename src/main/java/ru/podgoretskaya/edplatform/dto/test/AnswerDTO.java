package ru.podgoretskaya.edplatform.dto.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.podgoretskaya.edplatform.enums.AnswerPosition;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {
    private String answer;
    private AnswerPosition position;
}