package main.zzy.com.hotel.entity;

/**
 * @author zzy
 * @fileName DingDanInform
 * @date 2017/12/279:14
 * @email 747608835@qq.com
 */

public class DingDanInform {
    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String State;
    private String price;
}
