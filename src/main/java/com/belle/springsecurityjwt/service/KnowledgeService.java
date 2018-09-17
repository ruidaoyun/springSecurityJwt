package com.belle.springsecurityjwt.service;

import com.belle.springsecurityjwt.model.entity.KnowledgeAnswer;

import java.util.List;

public interface KnowledgeService {
    List getAllQuestion();

    KnowledgeAnswer selectTrueQuestionAnswer(Integer questionId);
}
