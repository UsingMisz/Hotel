package main.zzy.com.hotel.adapter.section;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.zzy.com.hotel.Hotel_DingDanActivity;
import main.zzy.com.hotel.MainActivity;
import main.zzy.com.hotel.MapActivity;
import main.zzy.com.hotel.R;
import main.zzy.com.hotel.entity.LocationInfo;
import main.zzy.com.hotel.entity.MessageLocationEvent;
import main.zzy.com.hotel.wiget.banner.BannerView;
import main.zzy.com.hotel.wiget.map.MyLocationListerner;
import main.zzy.com.hotel.wiget.sectioned.StatelessSection;

/**
 * @author zzy
 * @fileName MainActivity_Home_item_Section
 * @date 2017/12/2322:38
 * @email 747608835@qq.com
 */

public class MainActivity_Home_item_Section extends StatelessSection {
private Context context;


    private LocationInfo info;
    /**
     * Create a Section object with loading/failed states but no header and footer
     *
     * @param
     */
    public MainActivity_Home_item_Section(Context context,LocationInfo info) {
        super(R.layout.activity_home_item_section,R.layout.activity_home_item_empty);
        this.info=info;
        this.context=context;
    }

    /**
     * Return the total of items of this Section
     *
     * @return total of items of this Section
     */
    @Override
    public int getContentItemsTotal() {
        return 1;
    }

    /**
     * Return the ViewHolder for a single Item of this Section
     *
     * @param view View inflated by resource returned by getItemResourceId
     * @return ViewHolder for the Item of this Section
     */
    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {

        return new MainActivity_Home_item_Section.EmptyViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new MainActivity_Home_item_Section.ItemViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {

        ItemViewHolder viewHolder= (ItemViewHolder) holder;
        if (info!=null) {
            viewHolder.road_text.setText(info.getStreet());//没有值..?
        }
        viewHolder.search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 传入定位的值
                Intent intent =new Intent(context, MapActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("location",info);
                 intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
            viewHolder.dingdan_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, Hotel_DingDanActivity.class);
                    context.startActivity(intent);
                }
            });
    }





    /**
     * Bind the data to the ViewHolder for an Item of this Section
     *
     * @param holder   ViewHolder for the Item of this Section
     * @param position position of the item in the Section, not in the RecyclerView
     */
    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
    }



    static class EmptyViewHolder extends RecyclerView.ViewHolder {
        EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }
    static class ItemViewHolder extends RecyclerView.ViewHolder {
       @BindView(R.id.dest_road_text)
       TextView road_text;
        @BindView(R.id.dest_text)
                TextView dest_text;
        @BindView(R.id.search_button)
        Button search_button;
        @BindView(R.id.dingdan_button)
                Button dingdan_button;

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
