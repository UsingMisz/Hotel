package main.zzy.com.hotel.wiget.map;

import android.util.Log;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import main.zzy.com.hotel.entity.LocationInfo;
import main.zzy.com.hotel.entity.MessageLocationEvent;

/**
 * @author zzy
 * @fileName MyLocationListerner
 * @date 2017/12/2413:03
 * @email 747608835@qq.com
 */

public class MyLocationListerner extends BDAbstractLocationListener {

    @Override
    public void onReceiveLocation(BDLocation location) {
        //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
        //以下只列举部分获取地址相关的结果信息
        //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
        //获取的是异步信息
        String addr = location.getAddrStr();    //获取详细地址信息
        String country = location.getCountry();    //获取国家
        String province = location.getProvince();    //获取省份
        String city = location.getCity();    //获取城市
        String district = location.getDistrict();    //获取区县
        String street = location.getStreet();    //获取街道信息
        double latitude = location.getLatitude();    //获取纬度信息
        double longitude = location.getLongitude();    //获取经度信息
        float radius=location.getRadius();
        //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
        LocationInfo locationInfo=new LocationInfo();
        locationInfo.setAddr(addr);
        locationInfo.setCountry(country);
        locationInfo.setProvince(province);
        locationInfo.setCity(city);
        locationInfo.setDistrict(district);
        locationInfo.setRadius(radius);
        locationInfo.setStreet(street);
        locationInfo.setLatitude(latitude);
        locationInfo.setLongitude(longitude);
        List<Poi>poiList=location.getPoiList();
        locationInfo.setPoiList(poiList);
        //
       EventBus.getDefault().post(new MessageLocationEvent(locationInfo));

    }


}