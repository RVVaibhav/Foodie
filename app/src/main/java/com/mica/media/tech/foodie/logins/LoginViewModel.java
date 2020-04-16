package com.mica.media.tech.foodie.logins;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableBoolean;

import com.mica.media.tech.foodie.MainActivity;
import com.mica.media.tech.foodie.UtilSnackbar;
import com.mica.media.tech.foodie.common.AppConstant;
import com.mica.media.tech.foodie.common.Prefs;
import com.mica.media.tech.foodie.pojo.MessageResonseModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class LoginViewModel extends BaseObservable {

    public ObservableBoolean isProgress;
    private Observable<ResponseBody> responseBodyObservable;
    public LoginModel model;


    public  LoginViewModel() {
        isProgress = new ObservableBoolean(false);
        model = new LoginModel();
        /*model.setUserName("8087890011");
        model.setPassword("123456");*/
    }

    public void onSignUpClicked(View view){
        if(view.getContext()!=null){

            ((LoginsActivity)view.getContext()).callRegistration();
        }
    }

    public void onLoginClicked(View view, LoginModel model) {
//        {"msg":"Login Success","flag":"1","userinformation"
//            :{"User":{"id":"39","user_group_id":"4","username":"9511891383","city":"Nagpur","subscribtion_year":"","type_of_company":"","tinnumber":"123456","pancardnumber":"NOT_AVAILABL","adharcardnumber":"123456789012","flatno":"575","bulging":"575, Gittikhadan, Boriyapura, Nagpur, Maharashtra 440002, India","road":"575, Gittikhadan, Boriyapura, Nagpur, Maharashtra 440002, India","area":"575, Gittikhadan, Boriyapura, Nagpur, Maharashtra 440002, India","pincode":"440002","email":"iwner@gmail.com","first_name":"company name",
//                "last_name":"xyz","otp_verified":"1"},"Statemaster":{"name":null},"LoginToken":[]}}


//
        if (model.isValid()) {
            isProgress.set(true);
            responseBodyObservable = AppConstant.getController().getLogin(model.getUserName(), model.getPassword());
            responseBodyObservable.subscribeOn(Schedulers.io())
                    .map(responseBody -> LoginController.getLoginResponse(responseBody.string()))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<MessageResonseModel>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(MessageResonseModel messageResonseModel) {
                         isProgress.set(false);
                         if (messageResonseModel.getFlag().equalsIgnoreCase("1")) {
                             showSnackbar(messageResonseModel.getMessage(), view);
                             Prefs.putBoolean(AppConstant.isUserLogin, true);
                             Prefs.putString(AppConstant.SP_USER_ID, messageResonseModel.getUserId());
                             ((LoginsActivity) view.getContext()).finish();
                             view.getContext().startActivity(new Intent(view.getContext(), MainActivity.class));
                         } else {
                             showSnackbar(messageResonseModel.getMessage(), view);
                         }
                     }

                     @Override
                     public void onError(Throwable e) {
                         isProgress.set(false);
                         e.printStackTrace();
                         showSnackbar(e.getMessage(), view);
                     }

                     @Override
                     public void onComplete() {

                     }
                 });



        }else{
            showSnackbar("vgdsgdsg", view);
        }


    }
    private void showSnackbar(String message, View view) {
        UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(view, message, () -> {
        });
    }

    @BindingAdapter({"error"})
    public static void setError(EditText layout, String err) {
        layout.setError(err);
    }

}
