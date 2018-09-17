package com.belle.springsecurityjwt.model.entity;

import lombok.Data;

@Data
public class KnowledgeRecord {
    private Integer recordId;
    private String recordAnswer;
    private Integer recordScore;
}
