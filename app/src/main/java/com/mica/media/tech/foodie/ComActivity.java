package com.mica.media.tech.foodie;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mica.media.tech.foodie.databinding.ActivityComBinding;

public class ComActivity extends AppCompatActivity {

    private ActivityComBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_com);
        setupComActivityViewModel();
    }

    private void setupComActivityViewModel() {
        ComViewModel model = new ComViewModel();
        binding.setComViewmodel(model);
    }
}
