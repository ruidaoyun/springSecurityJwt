package com.belle.springsecurityjwt.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class KnowledgeQuestion {
    private Integer questionId;
    private String questionDescription;
    private List<KnowledgeAnswer> answerList;
}
