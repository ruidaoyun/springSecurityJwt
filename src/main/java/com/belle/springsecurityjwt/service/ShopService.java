package com.belle.springsecurityjwt.service;


import com.belle.springsecurityjwt.model.entity.Shop;

import java.util.List;
import java.util.Map;

public interface ShopService {
    List<Shop> selectShopListByUserId(Integer userId);

    List<Shop> selectShopListByShopName(String shopName);

    String fileUpload(Map map);
}
