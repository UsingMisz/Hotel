package main.zzy.com.hotel;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.flyco.tablayout.SlidingTabLayout;

import butterknife.BindView;
import main.zzy.com.hotel.adapter.DingDanPagerAdapter;
import main.zzy.com.hotel.base.RxBaseActivity;

public class Hotel_DingDanActivity extends RxBaseActivity {
@BindView(R.id.mToolbar)
    Toolbar toolbar;
    @BindView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTab;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @Override
    public int getLayoutId() {
        return R.layout.activity_hotel__ding_dan;
    }

    /**
     * 初始化views
     *
     * @param savedInstanceState
     */
    @Override
    public void initViews(Bundle savedInstanceState) {

        initViewPager();
    }

    /**
     * 初始化toolbar
     */
    @Override
    public void initToolBar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }
    private void initViewPager() {
        DingDanPagerAdapter mHomeAdapter = new DingDanPagerAdapter(getSupportFragmentManager(), getApplicationContext());
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(mHomeAdapter);
        mSlidingTab.setViewPager(mViewPager);
        mViewPager.setCurrentItem(1);
    }
}
