package main.zzy.com.hotel.adapter.section;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import main.zzy.com.hotel.R;
import main.zzy.com.hotel.ShouYinActivity;
import main.zzy.com.hotel.entity.DingDanInform;
import main.zzy.com.hotel.wiget.sectioned.StatelessSection;

/**
 * @author zzy
 * @fileName DingDanInformationSection
 * @date 2017/12/279:11
 * @email 747608835@qq.com
 */

public class DingDanInformationSection extends StatelessSection {
List<DingDanInform>list;
    Context context;
    public DingDanInformationSection(Context context, List<DingDanInform> list) {
        super(R.layout.activity_dingdan_inform_header_section, R.layout.activity_dingdan_inform_footer_section, R.layout.activity_dingdan_inform_item_section);
        this.list=list;
        this.context=context;
    }


    @Override
    public int getContentItemsTotal() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder getFooterViewHolder(View view) {
        return new DingDanInformationSection.FooterHolder(view);

    }

    @Override
    public void onBindFooterViewHolder(RecyclerView.ViewHolder holder) {
       FooterHolder footerHolder= (FooterHolder) holder;
        footerHolder.paid_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ShouYinActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new DingDanInformationSection.HeaderHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
      return new DingDanInformationSection.ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        HeaderHolder headerHolder= (HeaderHolder) holder;
        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("提交订单",1);
        StepBean stepBean1 = new StepBean("酒店确认",1);
        StepBean stepBean2 = new StepBean("入住",0);
        StepBean stepBean3 = new StepBean("离店",-1);

        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);
        stepsBeanList.add(stepBean3);

        headerHolder.step_view0
                .setTextSize(12)
                .setStepViewTexts(stepsBeanList)//总步骤
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(context, R.color.colorPrimary))//设置StepsViewIndicator完成线的颜色
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(context, R.color.grey))//设置StepsViewIndicator未完成线的颜色
                .setStepViewComplectedTextColor(ContextCompat.getColor(context, R.color.colorPrimary))//设置StepsView text完成线的颜色
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(context, R.color.black))//设置StepsView text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(context, R.mipmap.ic_launcher_round))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(context, R.drawable.default_icon))//设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(context, R.drawable.attention));//设置StepsViewIndicator AttentionIcon


    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
    static class HeaderHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.step_view0)
        HorizontalStepView step_view0;
        public HeaderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    static class FooterHolder extends RecyclerView.ViewHolder{
       @BindView(R.id.paid_money)
       Button paid_money;
        public FooterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
