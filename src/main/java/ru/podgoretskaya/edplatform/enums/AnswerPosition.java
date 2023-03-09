package ru.podgoretskaya.edplatform.enums;
import lombok.Getter;

import java.util.Arrays;
@Getter
public enum AnswerPosition {
    A(1),B(2),C(3);
    private final int position;

    AnswerPosition(int position) {
        this.position = position;
    }
    public static AnswerPosition getByPosition(int position){
        return Arrays.stream(values()).filter(v->v.getPosition()==position).findFirst().orElseThrow();
    }
}
