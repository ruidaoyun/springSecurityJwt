package com.belle.springsecurityjwt.service;

import com.belle.springsecurityjwt.model.entity.Test;

import java.io.File;
import java.util.List;

public interface TestService {
    List<Test> selectAllTest();

    File exportExcel();

    Void importExcel();
}
