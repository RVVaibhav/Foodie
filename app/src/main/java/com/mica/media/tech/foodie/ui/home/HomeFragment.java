package com.mica.media.tech.foodie.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mica.media.tech.foodie.R;
import com.mica.media.tech.foodie.ServiceEventModel;
import com.mica.media.tech.foodie.common.CategoriesRepository;
import com.mica.media.tech.foodie.common.MyApplication;
import com.mica.media.tech.foodie.databinding.FragmentHomeBinding;
import com.mica.media.tech.foodie.pojo.Categories;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class HomeFragment extends Fragment {

    private HomeViewModel model;
    private FragmentHomeBinding binding;
    private CategoriesRepository categoriesRepository;
    ServiceEventModel serviceEventModel ;
    private static final String TAG = "HomeFragment";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceEventModel = new ServiceEventModel();
       // EventBus.getDefault().register(this);
        categoriesRepository = new CategoriesRepository(MyApplication.getInstance());
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        setUpViewModel();
        return binding.getRoot();

    }

    private void setUpViewModel() {
        model = new HomeViewModel(this,categoriesRepository);
        binding.setViewModel(model);
       /* checkKYC();
        checkCities();
        setuptaglocationAdapter(model);*/
    }


}
