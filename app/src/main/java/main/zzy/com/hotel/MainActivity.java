package main.zzy.com.hotel;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;

import main.zzy.com.hotel.adapter.section.MainActivity_Home_Section;
import main.zzy.com.hotel.adapter.section.MainActivity_Home_item_Section;
import main.zzy.com.hotel.base.RxBaseActivity;
import main.zzy.com.hotel.entity.Constants;
import main.zzy.com.hotel.entity.MessageLocationEvent;
import main.zzy.com.hotel.wiget.banner.BannerEntity;
import main.zzy.com.hotel.wiget.banner.BannerView;
import main.zzy.com.hotel.wiget.map.MyLocationListerner;
import main.zzy.com.hotel.wiget.sectioned.SectionedRecyclerViewAdapter;

public class MainActivity extends RxBaseActivity {
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    private SectionedRecyclerViewAdapter mSectionedRecyclerViewAdapter;
    public LocationClient mLocationClient = null;
    private MyLocationListerner myListener = new MyLocationListerner();

    /**
     * 设置布局layout
     *
     * @return
     */
    @Override
    public int getLayoutId() {

        return R.layout.activity_main;
    }

    /**
     * 初始化views
     *
     * @param savedInstanceState
     */

    @Override
    public void initViews(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        initRecyclerView();
        initLocation();
        initBannerView();

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onMessage(MessageLocationEvent event) {
        mSectionedRecyclerViewAdapter.addSection(new MainActivity_Home_item_Section(this, event.getMessage()));
        Log.e("addr","有问题");
    }


    //初始化bannerView
    private void initBannerView() {
        List<BannerEntity> list=new ArrayList<>();
        for (int i=0;i<3;i++) {
            BannerEntity entity = new BannerEntity(Constants.BINNER_VALUE);
            list.add(entity);
        }
        //分层加载adapter 多层Recyclerview嵌套 这里有点秀
        mSectionedRecyclerViewAdapter.addSection(new MainActivity_Home_Section(list));
    }


    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
    private void initLocation() {

        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setCoorType("bd09ll");
        option.setOpenGps(true);
        option.setIsNeedAddress(true);
        option.setWifiCacheTimeOut(5*60*1000);
        //可选，是否需要地址信息，默认为不需要，即参数为false
        //如果开发者需要获得当前点的地址信息，此处必须为true
        mLocationClient.setLocOption(option);
        mLocationClient.start();//启动服务
    }
    /**
     * 初始化toolbar
     */
    @Override
    public void initToolBar() {

    }

    @Override
    public void initRecyclerView() {
        mSectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mSectionedRecyclerViewAdapter);
    }
}
