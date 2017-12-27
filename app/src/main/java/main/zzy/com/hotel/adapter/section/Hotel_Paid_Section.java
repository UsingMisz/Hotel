package main.zzy.com.hotel.adapter.section;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.zzy.com.hotel.DingDan_InformationActivity;
import main.zzy.com.hotel.R;
import main.zzy.com.hotel.ShouYinActivity;
import main.zzy.com.hotel.wiget.sectioned.StatelessSection;

/**
 * @author zzy
 * @fileName Hotel_Paid_Section
 * @date 2017/12/2610:33
 * @email 747608835@qq.com
 */

public class Hotel_Paid_Section extends StatelessSection {
private Context context;
    public Hotel_Paid_Section(Context context) {
        super(R.layout.activity_hotel_paid_header_section, R.layout.activity_hotel_paid_item_section);
        this.context=context;
    }


    @Override
    public int getContentItemsTotal() {
        return 1;
    }


    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new Hotel_Paid_Section.ItemHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new Hotel_Paid_Section.HeaderHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {

    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
       ItemHolder mHolder= (ItemHolder) holder;
        mHolder.paid_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         Intent intent=new Intent(context, DingDan_InformationActivity.class);
                context.startActivity(intent);
            }
        });
    }

    static class HeaderHolder extends RecyclerView.ViewHolder{

        public HeaderHolder(View itemView) {
            super(itemView);
        }
    }
    static  class ItemHolder extends RecyclerView.ViewHolder{
         @BindView(R.id.hotel_paid_button)
        Button paid_button;
        public ItemHolder(View itemView) {
            super(itemView);
             ButterKnife.bind(this, itemView);

        }

    }

}
