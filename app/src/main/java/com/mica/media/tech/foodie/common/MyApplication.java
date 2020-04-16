package com.mica.media.tech.foodie.common;

import android.app.Application;


import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.facebook.stetho.Stetho;
import com.mica.media.tech.foodie.network.NetworkCall;
import com.mica.media.tech.foodie.network.RetroController;

public class MyApplication extends Application {


    private static String TAG = "MyApplication";
    private static final String PREF_NAME = AppConstant.PREF_NAME;
    private static MyApplication mInstance;
    public boolean isLoggingNeeded = true;

    private PeriodicWorkRequest request;
    private OneTimeWorkRequest requestWork;
   /* private PeriodicWorkRequest request;
    private OneTimeWorkRequest requestWork;*/


    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    private String hashKey;


    public static MyApplication getInstance() {
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
       // Fabric.with(this, new Crashlytics());
//        Fabric.with(this, new Crashlytics());
        mInstance = this;
        mInstance.initPref();
//        mInstance.initLeakCanary();
        Stetho.initializeWithDefaults(this);
        AppSignatureHelper appSignatureHashHelper = new AppSignatureHelper(this);
        setHashKey(appSignatureHashHelper.getAppSignatures().get(0));
        mInstance.initNetworkCall();
        /* mInstance.initPicassoLog();*/
       // mInstance.initTimberLog();
        //   setUpWorkManager();
          setUpWorkManagerNoPeriodic();

    }

    private void setUpWorkManagerNoPeriodic() {
        Constraints constraints = new Constraints.Builder()
                .setRequiresDeviceIdle(false)
                .build();
        requestWork = new OneTimeWorkRequest.Builder(DownloadWorkMangerNonPeriodic.class)
                .setConstraints(constraints)
                .build();



        enquequeWorkManagerNoPeriodic();
    }

   /* private void initTimberLog() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());

        }
    }*/


    private void initLeakCanary() {

    }

   /* private void initPicassoLog() {
        Picasso.get().setLoggingEnabled(true);
    }*/


    public RetroController initNetworkCall() {
        new NetworkCall.NetworkBuilder().build();
        return NetworkCall.getController();
    }


    private void initPref() {
        new Prefs.Builder()
                .setContext(this)
                .setMode(MODE_PRIVATE)
                .setPrefsName(PREF_NAME)
                .setUseDefaultSharedPreference(false)
                .build();
    }

    /*public RegistrationServerModel getUserRegistrationModel() {
        return null;
    }
*/

    /*private void setUpWorkManagerNoPeriodic() {

        Constraints constraints = new Constraints.Builder()
                .setRequiresDeviceIdle(false)
                .build();
        requestWork = new OneTimeWorkRequest.Builder(DownloadWorkMangerNonPeriodic.class)
                .setConstraints(constraints)
                .build();


        enquequeWorkManagerNoPeriodic();

    }*/

    private void enquequeWorkManagerNoPeriodic() {
        if (request != null)
            WorkManager.getInstance().enqueue(request);
        if (!Prefs.getBoolean(AppConstant.isDownloadFirst, false)) {
            if (requestWork != null)
                WorkManager.getInstance().enqueue(requestWork);
        }
    }


   /* private void setUpWorkManager() {

//        Data dataBreath = new Data.Builder()
//                .putString(AppConstant.isBreath, AppConstant.isBreath)
//                .build();
        Constraints constraints = new Constraints.Builder()
                .setRequiresDeviceIdle(false)
                .build();

        request = new PeriodicWorkRequest.Builder(DownloadWorkManger.class, 1, TimeUnit.DAYS)
                .setConstraints(constraints)
                .build();
    }*/


    /*public RegistrationServerModel getUserRegistrationModel() {

        return new Gson().fromJson(Prefs.getString(AppConstant.USER_PROFILE), RegistrationServerModel.class);

    }*/


}