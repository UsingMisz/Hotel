package main.zzy.com.hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import main.zzy.com.hotel.adapter.section.ShouYin_Content_Sectoin;
import main.zzy.com.hotel.base.RxBaseActivity;
import main.zzy.com.hotel.entity.Data;
import main.zzy.com.hotel.wiget.sectioned.SectionedRecyclerViewAdapter;

public class ShouYinActivity extends RxBaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
@BindView(R.id.shouyin_recyclerView)
    RecyclerView mRecyclerView;

    private SectionedRecyclerViewAdapter mSectionedRecyclerViewAdapter;
    /**
     * 设置布局layout
     *
     * @return
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_shou_yin;
    }

    /**
     * 初始化views
     *
     * @param savedInstanceState
     */
    @Override
    public void initViews(Bundle savedInstanceState) {
        initRecyclerView();
    }

    /**
     * 初始化toolbar
     */
    @Override
    public void initToolBar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initRecyclerView() {
        mSectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mSectionedRecyclerViewAdapter);
        mSectionedRecyclerViewAdapter.addSection(new ShouYin_Content_Sectoin(this, Data.getZhiFuInfo()));

    }
}
