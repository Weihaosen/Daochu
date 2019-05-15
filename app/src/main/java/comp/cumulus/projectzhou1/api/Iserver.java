package comp.cumulus.projectzhou1.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Lenovo on 2019/3/31.
 */

public interface Iserver {
    String url="http://www.wanandroid.com/";
    @GET()
    Observable<String> getData(@Url String url);

    @GET("project/list/1/json?")
    Observable<String>getData2(@Query("mid") int mid);
}
