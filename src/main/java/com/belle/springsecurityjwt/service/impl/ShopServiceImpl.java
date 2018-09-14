package com.belle.springsecurityjwt.service.impl;

import com.belle.springsecurityjwt.dao.ShopDao;
import com.belle.springsecurityjwt.model.dto.JSONResult;
import com.belle.springsecurityjwt.model.entity.PositionImg;
import com.belle.springsecurityjwt.model.entity.Shop;
import com.belle.springsecurityjwt.service.PositionImgService;
import com.belle.springsecurityjwt.service.ShopService;
import com.belle.springsecurityjwt.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private PositionImgService positionImgService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public List<Shop> selectShopListByUserId(Integer userId) {
        return shopDao.selectShopListByUserId (userId);
    }

    @Override
    public List<Shop> selectShopListByShopName(String shopName) {
            shopName="%"+shopName+"%";
        return shopDao.selectShopListByShopNameOrShopNumber (shopName);
    }

    @Override
    public String fileUpload(Map map) {
        ArrayList<Map<String,Object>> list=(ArrayList<Map<String, Object>>) map.get ("List");
        if (list==null){
            return JSONResult.fillResultString (1,"数据为空",null);
        }
        for (int i=0; i < list.size (); i++) {
            HashMap hashMap =(HashMap<String,Object>) list.get (i);
            try {
                uploadBaseArray (hashMap.get ("beforeImgBase64"),map.get ("shopId"),hashMap.get ("positionId"),0);
                uploadBaseArray (hashMap.get ("afterImgBase64"),map.get ("shopId"),hashMap.get ("positionId"),1);
            } catch (Exception e) {
                e.printStackTrace ();
                return JSONResult.fillResultString (1,e.getMessage (),null);
            }
        }
        return JSONResult.fillResultString (0,"上传失败",null);
    }

    public void uploadBaseArray(Object strObj, Object shopIdObj, Object positionIdObj, Object statusObj) throws Exception {
        try {
            if (strObj==null||"".equals (strObj)){
                throw new Exception ("图片不能为空！");
            }
            ArrayList<String> strList = (ArrayList<String>) strObj;
            System.out.println (strList+"  "+strList.size ());
            Integer shopId = (Integer)shopIdObj;
            Integer positionId = (Integer)positionIdObj;
            Integer status = (Integer)statusObj;
            for (int i=0; i < strList.size (); i++) {
                String base64=strList.get (i);
                String suffixName=base64.substring (base64.indexOf ("/") + 1, base64.indexOf (";"));
                UUID uuid=UUID.randomUUID ();
                //Path path=Paths.get (new File ("").getAbsolutePath ()+"/"+UPLOAD_FOLDER +"/");
                Path path=Paths.get ("E:/static/img/");
                //如果没有files文件夹，则创建
                if (!Files.isWritable (path)) {
                    Files.createDirectories (path);
                }
                System.out.println (path.toString ());
                ImageUtil.decodeBase64ToImage (base64,path.toString (),uuid+"."+suffixName);
                String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/image/"+uuid+"."+suffixName;
                PositionImg img=new PositionImg ();
                img.setPositionId (positionId);
                img.setStatus (status);
                img.setShopId (shopId);
                img.setImgPath (url);
                positionImgService.insertIntoPositionImgDao (img);
            }
        }catch (Exception e){
            e.printStackTrace ();
            throw new Exception ("上传失败！！");
        }
    }


}
