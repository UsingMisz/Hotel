package main.zzy.com.hotel;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import main.zzy.com.hotel.adapter.section.DingDanThreeInformationSection;
import main.zzy.com.hotel.base.RxLazyFragment;
import main.zzy.com.hotel.entity.Data;
import main.zzy.com.hotel.wiget.sectioned.SectionedRecyclerViewAdapter;

/**
 * @author zzy
 * @fileName DingDanThreeFragment
 * @date 2017/12/2616:55
 * @email 747608835@qq.com
 */
//三个月内
public class DingDanThreeFragment extends RxLazyFragment{
     @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    private SectionedRecyclerViewAdapter mSectionedRecyclerViewAdapter;
    public static DingDanThreeFragment newIntance() {
        return new DingDanThreeFragment();
    }
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_dingdan_three;
    }

    @Override
    protected void initRecyclerView() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        mSectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mSectionedRecyclerViewAdapter);
        mSectionedRecyclerViewAdapter.addSection(new DingDanThreeInformationSection(Data.getThreeInfo()));
    }

    /**
     * 初始化views
     *
     * @param state
     */
    @Override
    public void finishCreateView(Bundle state) {
       initRecyclerView();
    }
}
