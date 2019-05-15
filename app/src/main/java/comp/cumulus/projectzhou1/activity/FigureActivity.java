package comp.cumulus.projectzhou1.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import comp.cumulus.projectzhou1.R;
import comp.cumulus.projectzhou1.adapet.FigureAdapet;
import comp.cumulus.projectzhou1.fragemnt.RecommendedFragment;
import comp.cumulus.projectzhou1.fragemnt.ThelatestFragment;

public class FigureActivity extends AppCompatActivity {

    private TabLayout mTa;
    private ViewPager mVi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figure);
        initView();
    }

    private void initView() {
        mTa = (TabLayout) findViewById(R.id.ta);
        mVi = (ViewPager) findViewById(R.id.vi);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ThelatestFragment());
        fragments.add(new RecommendedFragment());
        ArrayList<String> list = new ArrayList<>();
        list.add("最新");
        list.add("推荐");
        FigureAdapet figureAdapet = new FigureAdapet(getSupportFragmentManager(), fragments, list);
        mVi.setAdapter(figureAdapet);
        mTa.setupWithViewPager(mVi);
    }
}
