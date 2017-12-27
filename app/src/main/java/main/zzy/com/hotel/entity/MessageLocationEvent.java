package main.zzy.com.hotel.entity;

/**
 * @author zzy
 * @fileName MessageLocationEvent
 * @date 2017/12/2415:14
 * @email 747608835@qq.com
 */

public class MessageLocationEvent {
    public LocationInfo getMessage() {
        return message;
    }

    public void setMessage(LocationInfo message) {
        this.message = message;
    }

    private LocationInfo message;
    public MessageLocationEvent(LocationInfo message){
        this.message=message;
    }

}
