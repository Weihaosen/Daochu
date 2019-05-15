package comp.cumulus.projectzhou1.adapet;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import comp.cumulus.projectzhou1.activity.MainActivity;
import comp.cumulus.projectzhou1.R;
import comp.cumulus.projectzhou1.bean.Mainbean;

/**
 * Created by Lenovo on 2019/3/31.
 */

public class Mainadapet extends RecyclerView.Adapter {
    private final MainActivity mCon;
    private final List<Mainbean.DataBean> mlist;
    private List<Mainbean.DataBean> ALL;
    private OnItemClickListener mListener;

    public Mainadapet(MainActivity mainActivity, List<Mainbean.DataBean> mlist) {

        this.mCon = mainActivity;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mCon).inflate(R.layout.mainlayout, null, false);
        return new H(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
    H h = (H) holder;
    h.mbiao.setText(mlist.get(position).getName());
    h.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mListener!=null){
                mListener.OnItemClick(v,position);
            }
        }
    });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setALL(List<Mainbean.DataBean> ALL) {
        this.mlist.addAll(ALL);
        notifyDataSetChanged();
    }
    class H extends RecyclerView.ViewHolder {

        private final TextView mbiao;

        public H(View itemView) {
            super(itemView);
            mbiao = itemView.findViewById(R.id.biao);
        }
    }
      public interface OnItemClickListener
               {
                   void OnItemClick(View v,int position );
               }
               public void setOnItemClickListener(OnItemClickListener listener)
               {
                   this.mListener=listener;
               }
}
