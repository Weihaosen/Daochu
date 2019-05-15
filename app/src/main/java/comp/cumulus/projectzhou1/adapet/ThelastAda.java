package comp.cumulus.projectzhou1.adapet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import comp.cumulus.projectzhou1.R;
import comp.cumulus.projectzhou1.bean.ThelateBean;

/**
 * Created by Lenovo on 2019/3/31.
 */

public class ThelastAda extends RecyclerView.Adapter {
    private final Context mCon;
    private final List<ThelateBean.DataBean.DatasBean> mlist;

    public ThelastAda(Context context, List<ThelateBean.DataBean.DatasBean> mlist) {

        this.mCon = context;
        this.mlist = mlist;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    if(viewType==0){
        View inflate = LayoutInflater.from(mCon).inflate(R.layout.thelaonelayout, null, false);
        return new H1(inflate);
    }else{
        View inflate = LayoutInflater.from(mCon).inflate(R.layout.thelatwolayout, null, false);
        return new H2(inflate);
    }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType==0){
            int mposition = position;
             H1  h1= (H1) holder;
             h1.mbiao.setText(mlist.get(mposition).getEnvelopePic());
             RoundedCorners roundedCorners = new RoundedCorners(20);
                     //圆形
                     RequestOptions circleCropTransform =  RequestOptions.circleCropTransform();
                     //圆角
                     RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);
                     Glide.with(mCon).load(mlist.get(position).getEnvelopePic()).apply(circleCropTransform).into(h1.mtu);
             h1.mname.setText(mlist.get(mposition).getPublishTime()+"");

        }else{
            H2 h2= (H2) holder;
            h2.mbiao.setText(mlist.get(position).getDesc());
            h2.mname.setText(mlist.get(position).getLink());
          Glide.with(mCon).load(mlist.get(position).getEnvelopePic()).into(h2.mimg);
          Glide.with(mCon).load(mlist.get(position).getEnvelopePic()).into(h2.mtu);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if(position %2==0){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();

    }

    public void setALL(List<ThelateBean.DataBean.DatasBean> ALL) {
        this.mlist.addAll(ALL);
        notifyDataSetChanged();
    }

    class H1 extends RecyclerView.ViewHolder {

        private final TextView mbiao;
        private final ImageView mtu;
        private final TextView mname;

        public H1(View itemView) {
            super(itemView);
            mbiao = itemView.findViewById(R.id.biao);
            mtu = itemView.findViewById(R.id.tu);
            mname = itemView.findViewById(R.id.name);
        }
    }
    class H2 extends RecyclerView.ViewHolder {
        private final TextView mbiao;
        private final ImageView mtu;
        private final TextView mname;
        private final ImageView mimg;

        public H2(View itemView) {
            super(itemView);
            mbiao = itemView.findViewById(R.id.biao);
            mtu = itemView.findViewById(R.id.tu);
            mname = itemView.findViewById(R.id.name);
            mimg = itemView.findViewById(R.id.img);
        }
    }
}
