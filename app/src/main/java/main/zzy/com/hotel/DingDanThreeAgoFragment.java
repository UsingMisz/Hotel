package main.zzy.com.hotel;

import android.os.Bundle;

import main.zzy.com.hotel.base.RxLazyFragment;

/**
 * @author zzy
 * @fileName DingDanThreeAgoFragment
 * @date 2017/12/2616:54
 * @email 747608835@qq.com
 */
//三个月前
public class DingDanThreeAgoFragment  extends RxLazyFragment{

    public static DingDanThreeAgoFragment newIntance() {
        return new DingDanThreeAgoFragment();
    }
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_dingdan_three_ago;
    }

    /**
     * 初始化views
     *
     * @param state
     */
    @Override
    public void finishCreateView(Bundle state) {

    }
}
