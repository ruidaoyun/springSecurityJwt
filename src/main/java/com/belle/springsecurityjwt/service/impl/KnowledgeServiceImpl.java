package com.belle.springsecurityjwt.service.impl;

import com.belle.springsecurityjwt.dao.KnowledgeDao;
import com.belle.springsecurityjwt.model.entity.KnowledgeAnswer;
import com.belle.springsecurityjwt.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private KnowledgeDao knowledgeDao;
    @Override
    public List getAllQuestion() {
        return knowledgeDao.selectAllQuestion ();
    }

    @Override
    public KnowledgeAnswer selectTrueQuestionAnswer(Integer questionId) {
        return selectTrueQuestionAnswer (questionId);
    }
}
