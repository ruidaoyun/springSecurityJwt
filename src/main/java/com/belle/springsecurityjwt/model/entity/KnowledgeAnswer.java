package com.belle.springsecurityjwt.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KnowledgeAnswer {
    private Integer questionId;
    private Integer answerId;
    private String answerName;
    private String answerDescription;
    private Integer isTrue;
}
