package ru.podgoretskaya.edplatform.dto.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.podgoretskaya.edplatform.enums.AnswerPosition;


import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAnswerDTO {
    private Long testId;
    private Map<Integer, AnswerPosition> answers;// id и позиция ответа

}