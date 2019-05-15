package comp.cumulus.projectzhou1.adapet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import comp.cumulus.projectzhou1.R;
import comp.cumulus.projectzhou1.activity.MainActivity;
import comp.cumulus.projectzhou1.bean.Mainbean;
import comp.cumulus.projectzhou1.bean.RecommendadBean;

/**
 * Created by Lenovo on 2019/3/31.
 */

public class Recommendadapet extends RecyclerView.Adapter {

    private final Context mCon;
    private final List<RecommendadBean.DataBean.DatasBean> mlist;

    public Recommendadapet(Context mainActivity, List<RecommendadBean.DataBean.DatasBean> mlist) {


        this.mCon = mainActivity;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mCon).inflate(R.layout.recommend_layout, null, false);
        return new H(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
    H h = (H) holder;
    h.mname.setText(mlist.get(position).getChapterName());
    h.mbiao.setText(mlist.get(position).getTitle());
        Glide.with(mCon).load(mlist.get(position).getEnvelopePic()).load(R.mipmap.ic_launcher).into(h.mtu);
        Glide.with(mCon).load(mlist.get(position).getLink()).load(R.mipmap.ic_launcher).into(h.mimg);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setALL(List<RecommendadBean.DataBean.DatasBean> ALL) {
        this.mlist.addAll(ALL) ;
        notifyDataSetChanged();
    }

    class H extends RecyclerView.ViewHolder {

        private final TextView mbiao;
        private final ImageView mimg;
        private final TextView mname;
        private final ImageView mtu;

        public H(View itemView) {
            super(itemView);
            mbiao = itemView.findViewById(R.id.biao);
            mimg = itemView.findViewById(R.id.img);
            mname = itemView.findViewById(R.id.name);
            mtu = itemView.findViewById(R.id.tu);
        }
    }

}
