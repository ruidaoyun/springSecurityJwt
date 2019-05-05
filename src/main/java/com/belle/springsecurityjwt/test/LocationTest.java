package com.belle.springsecurityjwt.test;

import com.belle.springsecurityjwt.utils.LocationUtils;
import java.lang.Math;
import java.text.DecimalFormat;

public class LocationTest {
    public static void main(String[] args) {
       /* System.out.println (LocationUtils.getDistance (31, 32, 33, 34));
        System.out.println (Distance (32,31,34,33));*/
        //System.out.println (LocationUtils.getDistance (32, 31, 34, 33));
        //System.out.println (new DecimalFormat ("0").format (10000.1245 / 1000));
        System.out.println (Integer.parseInt (new DecimalFormat ("0").format (10000.1245 / 1000)));
    }

    /// <summary>
    /// 计算两点位置的距离，返回两点的距离，单位：公里或千米
    /// 该公式为GOOGLE提供，误差小于0.2米
    /// </summary>
    /// <param name="lat1">第一点纬度</param>
    /// <param name="lng1">第一点经度</param>
    /// <param name="lat2">第二点纬度</param>
    /// <param name="lng2">第二点经度</param>
    /// <returns>返回两点的距离，单位：公里或千米</returns>
    public static double GetDistance(double lat1, double lng1, double lat2, double lng2)
    {
        //地球半径，单位米
        double EARTH_RADIUS = 6378137;
        double radLat1 = Rad(lat1);
        double radLng1 = Rad(lng1);
        double radLat2 = Rad(lat2);
        double radLng2 = Rad(lng2);
        double a = radLat1 - radLat2;
        double b = radLng1 - radLng2;
        double result = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2))) * EARTH_RADIUS;
        return result / 1000;
    }

    /**根据经纬度计算距离
     *
     * @param long1  	第一经度
     * @param lat1  	第一维度
     * @param long2	第二经度
     * @param lat2		第二维度
     * @return		单位：米
     */
    public static double Distance(double long1, double lat1, double long2,
                           double lat2) {
        double a, b, R;
        R = 6378137; // 地球半径
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        a = lat1 - lat2;
        b = (long1 - long2) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2
                * R
                * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
                * Math.cos(lat2) * sb2 * sb2));
        return d;
    }

    /// <summary>
    /// 经纬度转化成弧度
    /// </summary>
    /// <param name="d"></param>
    /// <returns></returns>
    private static double Rad(double d)
    {
        return (double)d * Math.PI / 180d;
    }
}
