package main.zzy.com.hotel.entity;

import com.baidu.mapapi.model.LatLng;

/**
 * @author zzy
 * @fileName SuggestResultInfo
 * @date 2017/12/2419:52
 * @email 747608835@qq.com
 */

public class SuggestResultInfo {
  private String info;

  public LatLng getPt() {
    return pt;
  }

  public void setPt(LatLng pt) {
    this.pt = pt;
  }

  private LatLng pt;
  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}
