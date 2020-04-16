package com.mica.media.tech.foodie.logins;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mica.media.tech.foodie.R;
import com.mica.media.tech.foodie.databinding.ActivityLoginBinding;

public class LoginsActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        setupLoginViewModel();
    }

    private void setupLoginViewModel() {
        LoginViewModel model = new LoginViewModel();
        binding.setLoginViewModel(model);
    }

    public void callRegistration() {
        startActivity(new Intent(this, RegistrationActivity.class));

    }
}
