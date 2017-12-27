package main.zzy.com.hotel.entity;

import java.util.ArrayList;
import java.util.List;

import main.zzy.com.hotel.R;

/**
 * @author zzy
 * @fileName Data
 * @date 2017/12/2522:26
 * @email 747608835@qq.com
 */


public class Data {
    /**
     * 模拟酒店数据
     */
    public static List<HotelContentInfo> getHouseContentData(){
        List<HotelContentInfo>list=new ArrayList<>();
        for (int i=0;i<3;i++){
            HotelContentInfo info=new HotelContentInfo();
            info.setImageId(R.mipmap.ic_launcher_round);
              info.setDianping("4");
             info.setBed("大床");
            info.setHouseName("豪华单人房");
            info.setPrice("310");
            info.setSize("30m");
      list.add(info);
        }
        return list;
    }
    /**
     * 模拟支付信息
     */

    public static  List<ZhiFuChooseInfo>getZhiFuInfo(){
        List<ZhiFuChooseInfo>list=new ArrayList<>();

            ZhiFuChooseInfo info=new ZhiFuChooseInfo();
           info.setImage(R.mipmap.ic_launcher);
            info.setText("微信支付");
        info.setText1("使用微信支付,安全快捷");
            list.add(info);
        ZhiFuChooseInfo info1=new ZhiFuChooseInfo();
        info1.setImage(R.mipmap.ic_launcher);
        info1.setText("支付宝支付");
        info1.setText1("支付宝用户使用");
        list.add(info1);
return list;
    }

    public static  List<Hotel_three_info>getThreeInfo(){
        List<Hotel_three_info>list=new ArrayList<>();

        Hotel_three_info info=new Hotel_three_info();
       info.setName("佛山南海华美达酒店");
        info.setTime("2017-01-14");
        info.setLast_time("2017-01-15");
        info.setPrice("478");
        list.add(info);

        return list;
    }
    public static List<DingDanInform>getDingDanInfo(){
        List<DingDanInform>list=new ArrayList<>();
        DingDanInform info=new DingDanInform();
        info.setState("待支付");
        info.setPrice("478");
        list.add(info);
        return list;
    }
}
