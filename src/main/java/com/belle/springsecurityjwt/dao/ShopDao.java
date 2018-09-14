package com.belle.springsecurityjwt.dao;


import com.belle.springsecurityjwt.model.entity.Shop;

import java.util.List;

public interface ShopDao {
    List<Shop> selectShopListByUserId(Integer userId);

    List<Shop> selectShopListByShopNameOrShopNumber(String shopName);

    Integer insertIntoLocationImg();
}
