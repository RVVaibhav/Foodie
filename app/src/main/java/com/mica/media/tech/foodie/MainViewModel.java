package com.mica.media.tech.foodie;

import android.content.Context;

import androidx.databinding.BaseObservable;

public class MainViewModel extends BaseObservable {
    Context context;
    public MainViewModel(Context context) {
        this.context = context;
    }
}
