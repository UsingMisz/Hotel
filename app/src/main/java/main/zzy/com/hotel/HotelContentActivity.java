package main.zzy.com.hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;

import main.zzy.com.hotel.adapter.section.Hotel_Content_Recommand_Section;
import main.zzy.com.hotel.adapter.section.Hotel_Content_Section;
import main.zzy.com.hotel.base.RxBaseActivity;
import main.zzy.com.hotel.entity.Data;
import main.zzy.com.hotel.wiget.sectioned.SectionedRecyclerViewAdapter;

public class HotelContentActivity extends RxBaseActivity {
@BindView(R.id.mToobar)
    Toolbar mToobar;
    @BindView(R.id.hotel_recycler)
    RecyclerView mRecyclerView;

    private SectionedRecyclerViewAdapter mSectionedRecyclerViewAdapter;

    /**
     * 设置布局layout
     *
     * @return
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_hotel_content;
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

        setSupportActionBar(mToobar);
    }

    @Override
    public void initRecyclerView() {

        mSectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();
          LinearLayoutManager manager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
       /* GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 3);
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mSectionedRecyclerViewAdapter.getSectionItemViewType(position)) {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 3;
                    default:
                        return 1;
                }
            }
        });*/
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(true);
        //mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setAdapter(mSectionedRecyclerViewAdapter);
         //分层加载
        mSectionedRecyclerViewAdapter.addSection(new Hotel_Content_Recommand_Section());
        mSectionedRecyclerViewAdapter.addSection(new Hotel_Content_Section(Data.getHouseContentData(),this));
       // RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(manager);
        super.initRecyclerView();
    }
}
