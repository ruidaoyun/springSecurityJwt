package com.belle.springsecurityjwt.controller;

import com.belle.springsecurityjwt.model.entity.KnowledgeAnswer;
import com.belle.springsecurityjwt.model.entity.KnowledgeQuestion;
import com.belle.springsecurityjwt.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KnowledgeController {
    @Autowired
    private KnowledgeService knowledgeService;

    @GetMapping("/question")
    public List<KnowledgeQuestion> getAllQuestion(){
        return knowledgeService.getAllQuestion ();
    }

    /*@PostMapping("/test")
    public String test(@RequestBody RecordDTO[] records){
        for (int i=0; i < records.length; i++) {
            RecordDTO record=records[i];
        }
    }*/
    @GetMapping("/ture")
    public KnowledgeAnswer getQuestion(Integer questionId){
        return knowledgeService.selectTrueQuestionAnswer (questionId);
    }
}
