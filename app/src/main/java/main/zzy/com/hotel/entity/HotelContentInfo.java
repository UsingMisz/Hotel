package main.zzy.com.hotel.entity;

/**
 * @author zzy
 * @fileName HotelContentInfo
 * @date 2017/12/2522:17
 * @email 747608835@qq.com
 */

public class HotelContentInfo {
    private int imageId;
    private String houseName;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getDianping() {
        return dianping;
    }

    public void setDianping(String dianping) {
        this.dianping = dianping;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String size;
    private String bed;
    private String dianping;
    private String price;
}
