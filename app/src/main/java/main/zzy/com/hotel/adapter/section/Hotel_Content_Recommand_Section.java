package main.zzy.com.hotel.adapter.section;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
import main.zzy.com.hotel.R;
import main.zzy.com.hotel.wiget.sectioned.StatelessSection;

/**
 * @author zzy
 * @fileName Hotel_Content_Recommand_Section
 * @date 2017/12/2523:00
 * @email 747608835@qq.com
 */

public class Hotel_Content_Recommand_Section extends StatelessSection {

    public Hotel_Content_Recommand_Section() {
        super(R.layout.activity_hotel_recommend_section, R.layout.activity_home_item_empty);
    }


    @Override
    public int getContentItemsTotal() {
        return 3;
    }

    /**
     * Return the ViewHolder for a single Item of this Section
     *
     * @param view View inflated by resource returned by getItemResourceId
     * @return ViewHolder for the Item of this Section
     */
    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new Hotel_Content_Recommand_Section.EmptyViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new Hotel_Content_Recommand_Section.ItemViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
       //绑定代码写在这里
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    static class EmptyViewHolder extends RecyclerView.ViewHolder {
        EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
    static class ItemViewHolder extends RecyclerView.ViewHolder {
       //绑定item

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
