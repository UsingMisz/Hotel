package main.zzy.com.hotel.entity;

/**
 * @author zzy
 * @fileName Hotel_three_info
 * @date 2017/12/2620:46
 * @email 747608835@qq.com
 */

public class Hotel_three_info {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }

    private String time;
    private String price;
    private String last_time;
}
