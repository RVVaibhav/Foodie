package com.mica.media.tech.foodie;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.mica.media.tech.foodie.common.AppConstant;
import com.mica.media.tech.foodie.common.CategoriesRepository;
import com.mica.media.tech.foodie.common.DashBoardController;
import com.mica.media.tech.foodie.common.MyApplication;
import com.mica.media.tech.foodie.common.Prefs;
import com.mica.media.tech.foodie.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends BaseActivity {

    private NavigationView navigationView;
    private ActivityMainBinding binding;
    private MainViewModel model;
    private BottomNavigationView botttomNavigation;
    private CategoriesRepository categoriesRepository;
    private DashBoardController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
       // botttomNavigation = findViewById(R.id.nav_view);
        controller = new DashBoardController();
        initView();
        setUpNavigationController();
        createInstanceRepository();
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

    }

    private void createInstanceRepository() {
        categoriesRepository = new CategoriesRepository(MyApplication.getInstance());

    }

    private void setUpNavigationController() {
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
       // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(botttomNavigation, navController);
    }

    private void initView() {
        model = new MainViewModel(this);
        binding.setViewModel(model);
        findViewByIds();
        isUserSV();

    }

    private void isUserSV() {
        if (!Prefs.getBoolean(AppConstant.isUserLogin, false) || TextUtils.isEmpty(Prefs.getString(AppConstant.SP_USER_ID))) {
            startACActivity();

        }else{
           // getLocationSelected();
        }
        //setupNavigationItem();
    }

    private void startACActivity() {
        this.finish();
        startActivity(new Intent(this, ComActivity.class));
    }

    private void findViewByIds() {
        botttomNavigation = findViewById(R.id.nav_view);
       // navigationView.setNavigationItemSelectedListener(navigationItemSelectedListner);
        botttomNavigation.setOnNavigationItemSelectedListener(bottomNavigationItemSelectedListner);
    }



}
