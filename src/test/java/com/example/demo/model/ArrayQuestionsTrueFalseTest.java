package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.example.demo.model.questions.ArrayQuestionsTrueFalse;
import com.example.demo.model.questions.QuestionTrueFalse;

public class ArrayQuestionsTrueFalseTest {

    @Test
    public void testNextQuestionAndWrap() {
        ArrayQuestionsTrueFalse arr = new ArrayQuestionsTrueFalse();

        QuestionTrueFalse q0 = arr.nextQuestion(0);
        assertEquals("The earth is the 3rd planet from its star", q0.getQuestion());

        QuestionTrueFalse q1 = arr.nextQuestion(1);
        assertEquals("The earth and mars have the same atmosphere", q1.getQuestion());

        QuestionTrueFalse q2 = arr.nextQuestion(2);
        assertEquals("Saturn in the largest planet", q2.getQuestion());

        QuestionTrueFalse q3 = arr.nextQuestion(3);
        assertEquals("Jupiter in the largest planet", q3.getQuestion());

        // wrap-around: index 4 should return same as index 0
        QuestionTrueFalse q4 = arr.nextQuestion(4);
        assertEquals(q0.getQuestion(), q4.getQuestion());
    }

}
