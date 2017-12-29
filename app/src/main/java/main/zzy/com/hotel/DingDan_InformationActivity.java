package main.zzy.com.hotel;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


import butterknife.BindView;
import main.zzy.com.hotel.adapter.section.DingDanInformationSection;
import main.zzy.com.hotel.base.RxBaseActivity;
import main.zzy.com.hotel.entity.Data;
import main.zzy.com.hotel.wiget.sectioned.SectionedRecyclerViewAdapter;


public class DingDan_InformationActivity extends RxBaseActivity {
    private SectionedRecyclerViewAdapter mSectionedRecyclerViewAdapter;
 @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    public int getLayoutId() {
        return R.layout.activity_ding_dan__information;
    }


    @Override
    public void initViews(Bundle savedInstanceState) {
     initRecyclerView();
    }


    @Override
    public void initRecyclerView() {
        mSectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(mSectionedRecyclerViewAdapter);
        mSectionedRecyclerViewAdapter.addSection(new DingDanInformationSection(this, Data.getDingDanInfo()));

    }

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
}
