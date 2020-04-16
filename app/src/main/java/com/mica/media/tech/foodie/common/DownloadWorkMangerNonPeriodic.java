package com.mica.media.tech.foodie.common;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class DownloadWorkMangerNonPeriodic  extends Worker {
    private  CategoriesRepository categoriesRepository;
    private  Context context;
    private  DashBoardController controller;
    private ObservableList<Disposable> compositeDisposable;
    private static final String TAG = "DownloadWorkMangerNonPe";
    public DownloadWorkMangerNonPeriodic(@NonNull Context appContext, @NonNull WorkerParameters workerParams) {
        super(appContext, workerParams);
        this.context=appContext;
        compositeDisposable = new ObservableArrayList<>();
        controller = new DashBoardController();
        categoriesRepository = new CategoriesRepository(MyApplication.getInstance());
      //  tollInformationRepository = new TollInformationRepository(MyApplication.getInstance());
    }

    @NonNull
    @Override
    public Result doWork() {
        downloadCategory();
        return Result.success();
    }

    private void downloadCategory() {
        Observable<ResponseBody> observable = AppConstant.getController().getCategory();
        Disposable disposable = observable.flatMap((Function<ResponseBody, Observable<HashMap<String, Boolean>>>) responseBody -> {
            String res = responseBody.string();
            return Observable.just(controller.getCategory(res));
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::showError);
        compositeDisposable.add(disposable);
    }

    private void showError(Throwable t) {
        System.out.println(t.getMessage());
       // Toast.makeText(context,  t.getMessage(), Toast.LENGTH_SHORT).show();
        t.printStackTrace();
    }

    private void onSuccess(HashMap<String, Boolean> stringBooleanHashMap) {
        if (stringBooleanHashMap != null) {
            Prefs.putBoolean(AppConstant.isDownloadFirst, true);
        }

    }


}
