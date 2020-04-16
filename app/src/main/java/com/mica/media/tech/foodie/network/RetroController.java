package com.mica.media.tech.foodie.network;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroController {

    @GET("user_login.php")
    Observable<ResponseBody> getLogin(@Query("email") String userName,
                                      @Query("password") String password);

    @GET("categaries.php")
    Observable<ResponseBody> getCategory();
}
