package main.zzy.com.hotel;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import butterknife.BindView;
import main.zzy.com.hotel.adapter.section.DingDanInformationSection;
import main.zzy.com.hotel.base.RxBaseActivity;
import main.zzy.com.hotel.entity.Data;
import main.zzy.com.hotel.wiget.sectioned.SectionedRecyclerViewAdapter;


public class DingDan_InformationActivity extends RxBaseActivity {
    private SectionedRecyclerViewAdapter mSectionedRecyclerViewAdapter;
 @BindView(R.id.recycler)
    RecyclerView recycler;
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

    }
}
