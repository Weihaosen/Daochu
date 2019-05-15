package comp.cumulus.projectzhou1.p;

import comp.cumulus.projectzhou1.bean.ThelateBean;
import comp.cumulus.projectzhou1.m.ThelatestLmimodle;
import comp.cumulus.projectzhou1.v.ThelatestView;

/**
 * Created by Lenovo on 2019/3/31.
 */

public class ThelatesLmipre implements Thelatestpre,ThelatestLmimodle.Finshi {
    ThelatestLmimodle thelatestLmimodle;

    ThelatestView view;
    public ThelatesLmipre(ThelatestLmimodle thelatestLmimodle, ThelatestView view) {
        this.thelatestLmimodle = thelatestLmimodle;
        this.view = view;
    }

    @Override
    public void getData(int page) {
        if(thelatestLmimodle!=null){
            thelatestLmimodle.setData(this,page);
        }
    }

    @Override
    public void setSuee(ThelateBean thelateBean) {
    if(view!=null){
        view.setSuee(thelateBean);
    }
    }

    @Override
    public void setError(String error) {
        if(view!=null){
            view.setError(error);
        }
    }
}
