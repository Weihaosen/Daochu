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
import comp.cumulus.projectzhou1.adapet.ThelastAda;
import comp.cumulus.projectzhou1.bean.ThelateBean;
import comp.cumulus.projectzhou1.m.Lmimodle;
import comp.cumulus.projectzhou1.m.ThelatestLmimodle;
import comp.cumulus.projectzhou1.p.Lmipre;
import comp.cumulus.projectzhou1.p.ThelatesLmipre;
import comp.cumulus.projectzhou1.v.ThelatestView;


public class ThelatestFragment extends Fragment implements ThelatestView {


    private View view;
    private XRecyclerView mXr;
    private Lmipre mlmipre;
    private ThelastAda mthelastAda;
    private int mid;
    private List<ThelateBean.DataBean.DatasBean> mlist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_thelatest, container, false);
       mid = getActivity().getIntent().getIntExtra("id", 0);
        ThelatesLmipre thelatesLmipre = new ThelatesLmipre(new ThelatestLmimodle(), this);
        thelatesLmipre.getData(mid);
        initView(inflate);
        return inflate;
    }
    private void initView(View inflate) {
        mXr = (XRecyclerView) inflate.findViewById(R.id.xr);
        mXr.setLayoutManager(new LinearLayoutManager(getContext()));
        mlist=new ArrayList<>();
        mthelastAda = new ThelastAda(getContext(),mlist);
        mXr.setAdapter(mthelastAda);
    }


    @Override
    public void setSuee(ThelateBean thelateBean) {
        mlist = thelateBean.getData().getDatas();
        if (thelateBean != null) {
           mthelastAda.setALL(mlist);
        }
    }

    @Override
    public void setError(String error) {
        Log.e("tag", "setError: "+error);
    }
}
