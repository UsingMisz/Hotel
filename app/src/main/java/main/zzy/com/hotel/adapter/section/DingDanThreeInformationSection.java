package main.zzy.com.hotel.adapter.section;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.zzy.com.hotel.R;
import main.zzy.com.hotel.entity.Hotel_three_info;
import main.zzy.com.hotel.wiget.sectioned.StatelessSection;

/**
 * @author zzy
 * @fileName DingDanThreeInformationSection
 * @date 2017/12/2620:44
 * @email 747608835@qq.com
 */

public class DingDanThreeInformationSection extends StatelessSection {
 private  List<Hotel_three_info> list;
    public DingDanThreeInformationSection(List<Hotel_three_info> list) {
        super(R.layout.activity_dingdan_three_information_section);
        this.list=list;
    }

    /**
     * Return the total of items of this Section
     *
     * @return total of items of this Section
     */
    @Override
    public int getContentItemsTotal() {
        return list.size();
    }

    /**
     * Return the ViewHolder for a single Item of this Section
     *
     * @param view View inflated by resource returned by getItemResourceId
     * @return ViewHolder for the Item of this Section
     */
    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new DingDanThreeInformationSection.ItemViewHolder(view);
    }

    /**
     * Bind the data to the ViewHolder for an Item of this Section
     *
     * @param holder   ViewHolder for the Item of this Section
     * @param position position of the item in the Section, not in the RecyclerView
     */
    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder= (ItemViewHolder) holder;
        itemViewHolder.name.setText(list.get(position).getName());
        itemViewHolder.time.setText(list.get(position).getTime());
        itemViewHolder.lastTime.setText(list.get(position).getLast_time());
        itemViewHolder.price.setText(list.get(position).getPrice());
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.hotel_name)
        TextView name;
        @BindView(R.id.hotel_time)
        TextView time;
        @BindView(R.id.hotel_last_time)
        TextView lastTime;
        @BindView(R.id.hotel_price)
        TextView price;
        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
