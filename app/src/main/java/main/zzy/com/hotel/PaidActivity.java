package main.zzy.com.hotel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

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
