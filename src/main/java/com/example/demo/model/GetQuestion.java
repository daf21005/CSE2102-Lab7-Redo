package com.example.demo.model;

import com.example.demo.model.*;
import com.example.demo.model.questions.*;

public class GetQuestion {
    private static ArrayQuestionsTrueFalse arrayListQuestionsTF = new ArrayQuestionsTrueFalse();

    public GetQuestion() { }

    /**
     * Default next question (index 0) kept for compatibility.
     */
    public com.example.demo.model.questions.QuestionTrueFalse nextQuestion() {
        return arrayListQuestionsTF.nextQuestion(0);
    }

    /**
     * Return the question at the provided index (wraps by total questions).
     */
    public com.example.demo.model.questions.QuestionTrueFalse nextQuestion(int i) {
        return arrayListQuestionsTF.nextQuestion(i);
    }

}