package com.belle.springsecurityjwt.dao;

import com.belle.springsecurityjwt.model.entity.KnowledgeAnswer;

import java.util.List;

public interface KnowledgeDao {
    List selectAllQuestion();

    KnowledgeAnswer selectTrueQuestionAnswer(Integer questionId);

}
