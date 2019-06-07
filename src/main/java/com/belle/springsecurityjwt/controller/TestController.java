package com.belle.springsecurityjwt.controller;

import com.belle.springsecurityjwt.model.dto.ResultUtil;
import com.belle.springsecurityjwt.model.entity.Test;
import com.belle.springsecurityjwt.service.TestService;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("test")
    public List<Test> tests(){
        return testService.selectAllTest ();
    }

    @RequestMapping("json_test")
    public ResultUtil jsonTest(){
        return new ResultUtil (0,"","");
    }

    @RequestMapping("json_test2")
    public ResultUtil jsonTest2(){
        return new ResultUtil (0,null,testService.selectAllTest ());
    }

    @RequestMapping("export_excel")
    public ResultUtil exportExcel(HttpServletResponse response){
        File excel = testService.exportExcel ();
        response.setContentType("application/excel;charset=utf=-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + excel.getName());
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", -1);
        ServletOutputStream servletOutputStream =null;
        try {
            servletOutputStream=response.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(excel);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int size = 0;
            byte[] b = new byte[4096];
            while ((size = bufferedInputStream.read(b)) != -1) {
                servletOutputStream.write(b, 0, size);
            }
            servletOutputStream.flush();
            servletOutputStream.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace ();
        }

        return null;
    }

    @PostMapping("import_excel")
    public ResultUtil importExcel(@RequestParam("file")CommonsMultipartFile file){
        System.out.println (file.getOriginalFilename ());
        System.out.println ("hello");
        return null;
    }

    @GetMapping("easyui_data")
    public HashMap<String,Object> easyUiData(){
        HashMap<String, Object> map=new HashMap<> ();
        ArrayList<HashMap> list=new ArrayList<> ();
        for (int i=0; i <15 ; i++) {
            HashMap<String, Object> map1=new HashMap<> ();
            map1.put ("city","城市"+i);
            map1.put ("assoType","类型"+i);
            map1.put ("timeOut",i);
            map1.put ("overDue",i);
            map1.put ("solving",i);
            map1.put ("unsolve",i);
            map1.put ("solved",i);
            map1.put ("isDone",i);
            list.add (map1);
        }
        map.put ("total",list.size ());
        map.put ("rows",list);
        return map;
    }


}
