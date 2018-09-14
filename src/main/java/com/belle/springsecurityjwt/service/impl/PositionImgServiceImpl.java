package com.belle.springsecurityjwt.service.impl;

import com.belle.springsecurityjwt.dao.PositionImgDao;
import com.belle.springsecurityjwt.model.entity.PositionImg;
import com.belle.springsecurityjwt.service.PositionImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionImgServiceImpl implements PositionImgService {
    @Autowired
    private PositionImgDao positionImgDao;

    @Override
    public Integer insertIntoPositionImgDao(PositionImg positionImg) {
        return positionImgDao.insertIntoPositionImgDao (positionImg);
    }
}
