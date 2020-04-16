package com.mica.media.tech.foodie;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.databinding.BaseObservable;

import com.mica.media.tech.foodie.logins.LoginsActivity;
import com.mica.media.tech.foodie.signup.SignUpActivity;

public class ComViewModel extends BaseObservable {
    Context context;

    public ComViewModel() {
    }

    public void onLoginClicked(View view) {
        ((ComActivity) view.getContext()).finish();
        view.getContext().startActivity(new Intent(view.getContext(), LoginsActivity.class));

    }

    public void onSignUpClicked(View view) {

        ((ComActivity) view.getContext()).finish();
        view.getContext().startActivity(new Intent(view.getContext(), SignUpActivity.class));
        

    }

}
