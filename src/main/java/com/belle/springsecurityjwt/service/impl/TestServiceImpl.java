package com.belle.springsecurityjwt.service.impl;

import com.belle.springsecurityjwt.dao.TestDao;
import com.belle.springsecurityjwt.model.entity.Test;
import com.belle.springsecurityjwt.service.TestService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> selectAllTest() {
        return testDao.selectAllTest ();
    }

    @Override
    public File exportExcel() {
        List<HashMap<String, Object>> userList=testDao.selectAllUser ();

        //创建一个webbook，对应一个excel文件
        HSSFWorkbook sheets=new HSSFWorkbook ();
        //创建一个sheet
        HSSFSheet sheet=sheets.createSheet ("用户表");
        //创建第0行
        HSSFRow row1=sheet.createRow (0);
        //0行0列 第一个单元格
        HSSFCellStyle style=sheets.createCellStyle ();
        style.setAlignment (HorizontalAlignment.CENTER);
        HSSFCell cell1=row1.createCell (0);
        cell1.setCellValue ("编号");
        cell1.setCellStyle (style);
        HSSFCell cell2=row1.createCell (1);
        cell2.setCellValue ("姓名");
        cell2.setCellStyle (style);

        for (int i=1; i <= userList.size (); i++) {
            HashMap<String, Object> map=userList.get (i - 1);
            HSSFRow row=sheet.createRow (i);
            HSSFCell cell3=row.createCell (0);
            cell3.setCellValue (map.get ("user_id").toString ());
            cell3.setCellStyle (style);
            HSSFCell cell4=row.createCell (1);
            cell4.setCellValue (map.get ("user_name").toString ());
            cell4.setCellStyle (style);
        }

        try {
            File excel = new File("user.xls" );
            FileOutputStream fout = new FileOutputStream(excel);
            sheets.write(fout);
            sheets.close();
            fout.close();
            return excel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Void importExcel() {
        return null;
    }
}
