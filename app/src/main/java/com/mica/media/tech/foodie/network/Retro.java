package com.mica.media.tech.foodie.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mica.media.tech.foodie.common.AppConstant;
import com.mica.media.tech.foodie.common.MyApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro {

    private static final String TAG = "Retro";

    static Retro retrofitObj;

    public static Retro getInstance() {
        if (retrofitObj == null) {
            retrofitObj = new Retro();
        }
        return retrofitObj;

    }


    private Interceptor getHeader(final String header){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .header("Authorization", header); // <-- this is the important line

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
    }




    public RetroController getController(String header) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES);
        if (MyApplication.getInstance().isLoggingNeeded)
            builder.addInterceptor(interceptor);
        builder.readTimeout(5, TimeUnit.MINUTES);
        if(header!=null)
            builder.addInterceptor(getHeader(header));

        OkHttpClient client = builder.build();
        Gson gson = new GsonBuilder().setLenient().serializeNulls().create();

        Retrofit retrofit;
        Log.d(TAG, "getController: "+ AppConstant.BASE_URL);
        retrofit = new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit.create(RetroController.class);
    }


    public RetroController geControllerForTripCost(String baseUrl) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES);
        if (MyApplication.getInstance().isLoggingNeeded)
            builder.addInterceptor(interceptor);
        builder.readTimeout(5, TimeUnit.MINUTES);
//        if(header!=null)
//            builder.addInterceptor(getHeader(header));

        OkHttpClient client = builder.build();
        Gson gson = new GsonBuilder().setLenient().serializeNulls().create();

        Retrofit retrofit;
        Log.d(TAG, "geControllerForTripCost: "+ baseUrl);
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit.create(RetroController.class);
    }


    public RetroController getControllerFuelCost(String baseUrl) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES);
        if (MyApplication.getInstance().isLoggingNeeded)
            builder.addInterceptor(interceptor);
        builder.readTimeout(5, TimeUnit.MINUTES);
//        if(header!=null)
//        .addHeader("x-rapidapi-host", "newsrain-petrol-diesel-prices-india-v1.p.rapidapi.com")
//                .addHeader("x-rapidapi-key", "79323463d0msh8f22b0d5c55988cp119a01jsn27945d25d47b")
//            builder.addInterceptor(getHeaderFuel());

        OkHttpClient client = builder.build();
        Gson gson = new GsonBuilder().setLenient().serializeNulls().create();

        Retrofit retrofit;
        Log.d(TAG, "geControllerForTripCost: "+ baseUrl);
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit.create(RetroController.class);
    }

    private Interceptor getHeaderFuel() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .header("x-rapidapi-host", "newsrain-petrol-diesel-prices-india-v1.p.rapidapi.com")
                        .header("x-rapidapi-key", "79323463d0msh8f22b0d5c55988cp119a01jsn27945d25d47b"); // <-- this is the important line

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
    }
}
