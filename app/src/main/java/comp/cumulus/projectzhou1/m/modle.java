package comp.cumulus.projectzhou1.m;

import comp.cumulus.projectzhou1.bean.Mainbean;

/**
 * Created by Lenovo on 2019/3/31.
 */

public interface modle {
    public interface Finshi{
        void setSuee(Object o);
        void  setError(String error);
    }
    void setData(Finshi finshi,String url);
}
