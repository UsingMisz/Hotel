package main.zzy.com.hotel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.poi.PoiSortType;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;
import main.zzy.com.hotel.base.RxBaseActivity;
import main.zzy.com.hotel.entity.LocationInfo;
import main.zzy.com.hotel.entity.MessageLocationEvent;
import main.zzy.com.hotel.entity.SuggestResultInfo;

public class MapActivity extends RxBaseActivity {
   @BindView(R.id.mTexturemap)
   TextureMapView mmapView;
    private BaiduMap mBaiduMap;
    @BindView(R.id.search_edit)
    AutoCompleteTextView search_edit;
    @BindView(R.id.search_button)
    Button search_button;
    @BindView(R.id.lin7)
    LinearLayout linearLayout;
    private PoiSearch mPoiSearch;
    SuggestionSearch mSuggestionSearch;
      List<SuggestResultInfo> suggList;
    MapView mMapView = null;
    MapStatus mMapStatus;MapStatusUpdate mMapStatusUpdate;
    Marker coverMarker;
    List<Map<String, String>> coverArray = new ArrayList<Map<String, String>>();


    /**
     * 设置布局layout
     *
     * @return
     */
    @Override
    public int getLayoutId() {
        SDKInitializer.initialize(getApplicationContext());
        return R.layout.activity_map;
    }

    /**
     * 初始化views
     *
     * @param savedInstanceState
     */
    @Override
    public void initViews(Bundle savedInstanceState) {

        initMap();
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MapActivity.this,HotelContentActivity.class);
                startActivity(intent);
            }
        });
    }




    private void initMap() {
        //TODO 怎么都不显示list列表
        search_edit.setAdapter(new ArrayAdapter<SuggestResultInfo>(MapActivity.this, android.R.layout.simple_dropdown_item_1line, suggList));
        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        final LocationInfo locationInfo= (LocationInfo) bundle.getSerializable("location");
        //创建地图
        mBaiduMap=mmapView.getMap();
        //poi检索
        // mPoiSearch = PoiSearch.newInstance();
       // mPoiSearch.setOnGetPoiSearchResultListener(poiListener);

          //热词搜索
        mSuggestionSearch = SuggestionSearch.newInstance();
        mSuggestionSearch.setOnGetSuggestionResultListener(listener);


        //定位
        LocationStart(locationInfo);

        
        search_edit.setThreshold(1);
        search_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (suggList!=null){
                        addMarks();
                    }
            }

            private void addMarks() {

                double[][] coordinates = new double[coverArray.size()][2];
                for (int i = 0; i < coverArray.size(); i++) {
                    coordinates[i][0] = Double.parseDouble(coverArray.get(i).get("longitude"));
                    coordinates[i][1] = Double.parseDouble(coverArray.get(i).get("latitude"));
                }
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.marker, null);
                TextView hotel_name = (TextView) view.findViewById(R.id.hotel_name);

                for (int j = 0; j <suggList.size(); j++) {
                    //LatLng lla = new LatLng(coordinates[j][1], coordinates[j][0]);
                    hotel_name.setText(suggList.get(j).getInfo());
                    BitmapDescriptor bd1 = BitmapDescriptorFactory.fromBitmap(getBitmapFromView(view));
                    MarkerOptions ooA = new MarkerOptions().position(suggList.get(j).getPt()).icon(bd1).zIndex(9).draggable(true).title(coverArray.get(j).get("coverid"));
                    coverMarker = (Marker) mBaiduMap.addOverlay(ooA);
                }


            }

            @Override
            public void afterTextChanged(Editable editable)
                {
                   try {
                       mSuggestionSearch.requestSuggestion((new SuggestionSearchOption())
                               .keyword(search_edit.getText().toString())
                               .citylimit(true)
                               .city(locationInfo.getCity()));
                   }catch (Exception e){

                   }
            }
        });



        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(search_edit.getText())) {
                    //获取地点为空
                    /*LatLng center=new LatLng(locationInfo.getLatitude(),locationInfo.getLongitude());
                    mPoiSearch.searchNearby(new PoiNearbySearchOption()
                            .keyword("酒店")
                            .sortType(PoiSortType.distance_from_near_to_far)
                            .location(center)//这个地点要根据地图中央获取
                            .radius((int)locationInfo.getRadius())
                            .pageNum(10));*/
                }
            }
        });

    }

    private Bitmap getBitmapFromView(View view) {
        view.destroyDrawingCache();
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.UNSPECIFIED);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }




    /**
     * suggest提示
     */

    OnGetSuggestionResultListener listener = new OnGetSuggestionResultListener() {
        public void onGetSuggestionResult(SuggestionResult res) {
            if (res == null || res.getAllSuggestions() == null) {
                Log.e("OnGetSuggestion","false");
                return;
                //未找到相关结果

            }
            suggList=new ArrayList<>();
            for (SuggestionResult.SuggestionInfo info : res.getAllSuggestions()) {
                SuggestResultInfo infos=new SuggestResultInfo();
                suggList.clear();
                if (info.key != null) {

                    Log.e("onGetSuggestionResult", info.key + " " + info.city + info.district);
                    infos.setPt(info.pt);
                    //在地图上标注并绘制出来
                    suggList.add(infos);

                }

            }
            //获取在线建议检索结果
        }
    };




    /**
     * 搜索返回值
     */
    OnGetPoiSearchResultListener poiListener = new OnGetPoiSearchResultListener(){

        public void onGetPoiResult(PoiResult result){
            if (result.isHasAddrInfo()){
                Log.e("onGetPoiResult",result.getAllPoi().get(0).name+"??????????");
            }else {
                Toast.makeText(MapActivity.this,"获取不到周边值",Toast.LENGTH_SHORT).show();
            }
            //获取POI检索结果

        }

        public void onGetPoiDetailResult(PoiDetailResult result){
            //获取Place详情页检索结果
            Log.e("onGetPoiDetailResult",result.getName());
        }

        @Override
        public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
            Log.e("onGetPoiIndoorResult",poiIndoorResult.getPoiNum()+"");

        }
    };







    /**
     * 定位
     */
    private void LocationStart(LocationInfo locationInfo) {
        //显示定位
        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
// 构造定位数据
        MyLocationData locData = new MyLocationData.Builder()
                .accuracy(locationInfo.getRadius())
                // 此处设置开发者获取到的方向信息，顺时针0-360
                .direction(100).latitude(locationInfo.getLatitude())
                .longitude(locationInfo.getLongitude()).build();
        //缩放
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.zoomBy(4);
        mBaiduMap.animateMapStatus(mapStatusUpdate);
// 设置定位数据
        mBaiduMap.setMyLocationData(locData);
        //设置定位的图标还有一些信息
        mBaiduMap.setMyLocationConfiguration(new MyLocationConfiguration(
                MyLocationConfiguration.LocationMode.FOLLOWING, true, BitmapDescriptorFactory .fromResource(R.drawable.location),
                0xAAFFFF88, 0xAA00FF00));
    }

    /**
     * 初始化toolbar
     */
    @Override
    public void initToolBar() {

    }

    @Override
    protected void onDestroy() {
        mmapView.onDestroy();
//        mPoiSearch.destroy();
        mSuggestionSearch.destroy();
        //bind.unbind();//TODO 这里关于绑定事件解绑有问题
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        mmapView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mmapView.onPause();
        super.onPause();
    }
}
