package main.zzy.com.hotel.adapter.section;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.zzy.com.hotel.R;
import main.zzy.com.hotel.wiget.banner.BannerEntity;
import main.zzy.com.hotel.wiget.banner.BannerView;
import main.zzy.com.hotel.wiget.sectioned.StatelessSection;

/**
 * @author zzy
 * @fileName MainActivity_Home_Section
 * @date 2017/12/2317:15
 * @email 747608835@qq.com
 */

public class MainActivity_Home_Section extends StatelessSection {
    private List<BannerEntity> banners;

    public MainActivity_Home_Section(List<BannerEntity> banners) {
        super(R.layout.binner_view, R.layout.layout_home_binner_empty);
        this.banners = banners;
    }


    @Override
    public int getContentItemsTotal() {
        return 1;
    }


    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new EmptyViewHolder(view);
    }


    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new BannerViewHolder(view);
    }


    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
        bannerViewHolder.mBannerView.delayTime(5).build(banners);
    }


    static class EmptyViewHolder extends RecyclerView.ViewHolder {
        EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.MainActivity_BinnerView)
        BannerView mBannerView;

        BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
