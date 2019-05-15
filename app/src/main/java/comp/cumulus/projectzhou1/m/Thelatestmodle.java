package comp.cumulus.projectzhou1.m;

import comp.cumulus.projectzhou1.bean.ThelateBean;

/**
 * Created by Lenovo on 2019/3/31.
 */

public interface Thelatestmodle  {
    public interface Finshi{
        void setSuee(ThelateBean thelateBean);
        void setError(String error);
    }
    void setData(Finshi finshi,int page);
}
