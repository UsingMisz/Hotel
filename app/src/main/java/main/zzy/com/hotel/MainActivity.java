package main.zzy.com.hotel;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

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
      initQuanXian();
        initRecyclerView();
       // initLocation();
        initBannerView();
        
    }
    List<String> permissionList = new ArrayList<>();
    private void initQuanXian() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this, permissions, 1);
        } else {
            requestLocation();
        }
    }

    private void requestLocation() {
        initLocation();
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
        //分层加载adapter 多层Recyclerview嵌套 s
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须同意所有权限才能够使用本程序", Toast.LENGTH_SHORT).show();
                          //  finish();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                   // finish();
                }
                break;
            default:
        }
    }
}
