package comp.cumulus.projectzhou1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import comp.cumulus.projectzhou1.R;
import comp.cumulus.projectzhou1.adapet.Mainadapet;
import comp.cumulus.projectzhou1.bean.Mainbean;
import comp.cumulus.projectzhou1.fragemnt.ThelatestFragment;
import comp.cumulus.projectzhou1.m.Lmimodle;
import comp.cumulus.projectzhou1.p.Lmipre;
import comp.cumulus.projectzhou1.v.View;

public class MainActivity extends AppCompatActivity implements View{

    private Toolbar mTo;
    private XRecyclerView mXr;
    private String TAG=""+MainActivity.class.getName();
    private Mainadapet mmainadapet;
    private Lmipre mlmipre;
    private List<Mainbean.DataBean> mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mlmipre = new Lmipre(new Lmimodle(), this);
        iniData();
        setContentView(R.layout.activity_main);
        initView();
    }

    private void iniData() {
        mlmipre.getData("project/tree/json");
    }

    private void initView() {
        mTo = (Toolbar) findViewById(R.id.to);
        mXr = (XRecyclerView) findViewById(R.id.xr);
        mTo.setTitle("");
        setSupportActionBar(mTo);
        mlist=new ArrayList<>();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mXr.setLayoutManager(staggeredGridLayoutManager);
        mmainadapet = new Mainadapet(this, mlist);
        mXr.setAdapter(mmainadapet);
        mmainadapet.setOnItemClickListener(new Mainadapet.OnItemClickListener() {
            @Override
            public void OnItemClick(android.view.View v, int position) {
                Intent intent = new Intent(MainActivity.this, FigureActivity.class);
                intent.putExtra("id",mlist.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void setSuee(Object o) {
        Log.i(TAG, "setSuee: "+o);
        String data = (String) o;
        Gson gson = new Gson();
        Mainbean mainbean = gson.fromJson(data, Mainbean.class);
        mlist = mainbean.getData();
        if(mainbean!=null){
          mmainadapet.setALL(mlist);
        }
    }

    @Override
    public void setError(String error) {
        Log.i(TAG, "setSuee: "+error);
    }
}
