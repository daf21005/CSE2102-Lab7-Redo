package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.example.demo.model.questions.QuestionTrueFalse;

public class QuestionTrueFalseTest {

    @Test
    public void testGettersAndSetters() {
        QuestionTrueFalse q = new QuestionTrueFalse("Is this a test?", true);
        assertEquals("Is this a test?", q.getQuestion());
        assertTrue(q.getAnswer());

        q.setQuestion("Changed?");
        q.setAnswer(false);
        assertEquals("Changed?", q.getQuestion());
        assertFalse(q.getAnswer());
    }

}
