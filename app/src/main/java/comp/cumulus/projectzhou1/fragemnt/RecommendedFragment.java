package comp.cumulus.projectzhou1.fragemnt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import comp.cumulus.projectzhou1.R;
import comp.cumulus.projectzhou1.adapet.Recommendadapet;
import comp.cumulus.projectzhou1.bean.RecommendadBean;
import comp.cumulus.projectzhou1.m.Lmimodle;
import comp.cumulus.projectzhou1.p.Lmipre;

public class RecommendedFragment extends Fragment implements comp.cumulus.projectzhou1.v.View{


    private static final String TAG = RecommendedFragment.class.getName();
    private View view;
    private XRecyclerView mXr;
    private List<RecommendadBean.DataBean.DatasBean> mlist;
    private Recommendadapet mrecommendadapet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_recommended, container, false);
        Lmipre lmipre = new Lmipre(new Lmimodle(), this);
        lmipre.getData("article/list/0/json");
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mXr = (XRecyclerView) inflate.findViewById(R.id.xr);
        mlist=new ArrayList<>();
        mXr.setLayoutManager(new LinearLayoutManager(getContext()));
        mrecommendadapet = new Recommendadapet(getContext(), mlist);
        mXr.setAdapter(mrecommendadapet);

    }

    @Override
    public void setSuee(Object o) {
        Log.e(TAG, "setSuee: "+o );
        String data= (String) o;
        Gson gson = new Gson();
        RecommendadBean recommendadBean = gson.fromJson(data, RecommendadBean.class);
        mlist = recommendadBean.getData().getDatas();
        if (recommendadBean!=null&&recommendadBean.getData()!=null&&recommendadBean.getData().getDatas()!=null&&recommendadBean.getData().getDatas().size()>0){
            mrecommendadapet.setALL(mlist);
        }
    }

    @Override
    public void setError(String error) {

    }
}
