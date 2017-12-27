package main.zzy.com.hotel.adapter.section;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.zzy.com.hotel.PaidActivity;
import main.zzy.com.hotel.R;
import main.zzy.com.hotel.entity.HotelContentInfo;
import main.zzy.com.hotel.wiget.sectioned.StatelessSection;

/**
 * @author zzy
 * @fileName Hotel_Content_Section
 * @date 2017/12/2523:22
 * @email 747608835@qq.com
 */

public class Hotel_Content_Section extends StatelessSection {
     private List<HotelContentInfo> list;
   private Context context;

    public Hotel_Content_Section(List<HotelContentInfo> list,Context context) {
        super(R.layout.activity_hotel_content_empty_header, R.layout.activity_hotel_content_footer_section, R.layout.activity_hotel_content_section);
        this.list=list;
        this.context=context;
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
        return new ItemViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new Hotel_Content_Section.HeaderViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder getFooterViewHolder(View view) {
        return new Hotel_Content_Section.FooterViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder itemholder, final int position) {
      ItemViewHolder holder= (ItemViewHolder) itemholder;
        HotelContentInfo info=list.get(position);
        holder.image.setImageResource(info.getImageId());
        holder.houseName.setText(info.getHouseName());
        holder.houseSize.setText(info.getSize());
        holder.houseBed.setText(info.getBed());
        holder.dianping.setText(info.getDianping());
        holder.price.setText(info.getPrice());
        //跳转 这里就没有传值 TODO 传值到另外一个activity
        //思路 :把position传出去 到下一个adapter的时候写一个专门负责监听的adapter 或者监听回调
          holder.lin.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  PaidActivity.launch((Activity) context,position);
              }
          });

    }



    static class ItemViewHolder extends RecyclerView.ViewHolder {
        //绑定item
        @BindView(R.id.hotel_content_image)
        ImageView image;
        @BindView(R.id.hotel_content_name)
        TextView houseName;
        @BindView(R.id.hotel_content_size)
        TextView houseSize;
        @BindView(R.id.hotel_content_bed)
        TextView houseBed;
        @BindView(R.id.hotel_content_dianping)
        TextView dianping;
        @BindView(R.id.hotel_content_price)
        TextView price;
        @BindView(R.id.hotel_content_lin)
        LinearLayout lin;
        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        //绑定头 为空没数据

        HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    static class FooterViewHolder extends RecyclerView.ViewHolder {
        //绑定尾 专门处理订单订完数据
        //TODO 怎么画订完到布局中

        FooterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
