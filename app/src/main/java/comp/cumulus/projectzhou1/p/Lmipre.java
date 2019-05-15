package comp.cumulus.projectzhou1.p;

import comp.cumulus.projectzhou1.bean.Mainbean;
import comp.cumulus.projectzhou1.m.Lmimodle;
import comp.cumulus.projectzhou1.v.View;

/**
 * Created by Lenovo on 2019/3/31.
 */

public class Lmipre implements pre,Lmimodle.Finshi {
    Lmimodle lmimodle;
    View view;
    public Lmipre(Lmimodle lmimodle, View view) {
        this.lmimodle = lmimodle;
        this.view = view;
    }


    @Override
    public void getData(String url) {
        if(lmimodle!=null){
            lmimodle.setData(this,url);
        }

    }

    @Override
    public void setSuee(Object o) {
   if(view!=null){
       view.setSuee(o);
   }
    }

    @Override
    public void setError(String error) {
        if(view!=null){
            view.setError(error);
        }
    }
}
