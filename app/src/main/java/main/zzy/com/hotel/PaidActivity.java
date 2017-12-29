package main.zzy.com.hotel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import main.zzy.com.hotel.adapter.section.Hotel_Paid_Section;
import main.zzy.com.hotel.base.RxBaseActivity;
import main.zzy.com.hotel.wiget.sectioned.SectionedRecyclerViewAdapter;

/**
 * @author zzy
 * @fileName PaidActivity
 * @date 2017/12/269:41
 * @email 747608835@qq.com
 */

public class PaidActivity extends RxBaseActivity {
    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.paid_recycler)
    RecyclerView mRecyclerView;
    private SectionedRecyclerViewAdapter mSectionedRecyclerViewAdapter;
    /**
     * 设置布局layout
     *
     * @return
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_paid;
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
        toolbar_title.setText("休闲酒店");
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
        mSectionedRecyclerViewAdapter=new SectionedRecyclerViewAdapter();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mSectionedRecyclerViewAdapter);
        mSectionedRecyclerViewAdapter.addSection(new Hotel_Paid_Section(this));
    }

    public static void launch(Activity activity, int position) {
        Intent mIntent = new Intent(activity, PaidActivity.class);
        activity.startActivity(mIntent);
    }

}
