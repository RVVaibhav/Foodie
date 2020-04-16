package com.mica.media.tech.foodie;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public abstract class BaseActivity extends AppCompatActivity {

   // private BottomSheetFragment bottomSheetFragment;
    public NavController navController;
    private static final String TAG = "HBaseActivity";

    public BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationItemSelectedListner = this::getBottomNavigationItemSelected;

    private boolean getBottomNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                navController.navigate(R.id.navigation_home);
                break;

            case R.id.navigation_dashboard:
                navController.navigate(R.id.navigation_dashboard);
                break;

            case R.id.navigation_notifications:
                navController.navigate(R.id.navigation_notifications);

                break;
        }

        return true;
    }




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
