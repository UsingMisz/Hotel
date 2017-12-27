package main.zzy.com.hotel.adapter.section;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.zzy.com.hotel.R;
import main.zzy.com.hotel.entity.ZhiFuChooseInfo;
import main.zzy.com.hotel.wiget.sectioned.StatelessSection;

/**
 * @author zzy
 * @fileName ShouYin_Content_Sectoin
 * @date 2017/12/2614:34
 * @email 747608835@qq.com
 */

public class ShouYin_Content_Sectoin extends StatelessSection{
 private Context context;
    private List<ZhiFuChooseInfo> list;


    public ShouYin_Content_Sectoin(Context context,List<ZhiFuChooseInfo> list) {
        super(R.layout.activity_shouyin_header_section, R.layout.activity_shouyin_footer_section, R.layout.activity_shouyin_item_section);
        this.context=context;
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
        return new ShouYin_Content_Sectoin.ItemViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new ShouYin_Content_Sectoin.HeaderViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder getFooterViewHolder(View view) {
      return   new ShouYin_Content_Sectoin.FooterViewHolder(view);
    }

    @Override
    public void onBindFooterViewHolder(RecyclerView.ViewHolder holder) {
        FooterViewHolder FootViewHolder= (FooterViewHolder) holder;
        FootViewHolder.paid_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
          ItemViewHolder itemViewHolder= (ItemViewHolder) holder;
        itemViewHolder.imageView.setImageResource(list.get(position).getImage());
        itemViewHolder.text.setText(list.get(position).getText());
        itemViewHolder.text1.setText(list.get(position).getText1());
    }

static class FooterViewHolder extends RecyclerView.ViewHolder{
      @BindView(R.id.hotel_paid_button)
    Button paid_button;
    public FooterViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.shouyin_zhifu_image)
        ImageView imageView;
        @BindView(R.id.shouyin_zhifu_text)
        TextView text;
        @BindView(R.id.shouyin_zhifu_text1)
                TextView text1;
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


}
