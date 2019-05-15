package comp.cumulus.projectzhou1.m;

import android.util.Log;

import com.google.gson.Gson;

import comp.cumulus.projectzhou1.api.Iserver;
import comp.cumulus.projectzhou1.bean.Mainbean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Lenovo on 2019/3/31.
 */

public class Lmimodle implements modle {
    @Override
    public void setData(final Finshi finshi,String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Iserver.url)
                .addConverterFactory(ScalarsConverterFactory.create())// 数据类型
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Iserver myServer = retrofit.create(Iserver.class);
        Observable<String> data = myServer.getData(url);
        data.subscribeOn(Schedulers.io())  //被观察者在子线程
                .observeOn(AndroidSchedulers.mainThread())  //观察者在主线程中执行
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String value) {
                        Log.i("whs", "showVerify: " + value);
                        finshi.setSuee(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("whs", "onError: " + e.getMessage());
                        finshi.setError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
