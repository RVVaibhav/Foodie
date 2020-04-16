package com.mica.media.tech.foodie.ui.home;

import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.mica.media.tech.foodie.common.CategoriesRepository;
import com.mica.media.tech.foodie.common.DashBoardController;
import com.mica.media.tech.foodie.common.FragmentSupportBaseObservable;
import com.mica.media.tech.foodie.common.TableCategoriesModel;
import com.mica.media.tech.foodie.pojo.Categories;

import java.util.List;
import java.util.Objects;

public class HomeViewModel extends FragmentSupportBaseObservable {

    public ObservableBoolean isMoreItem;
    public ObservableBoolean isProgress;
    private final Fragment fragment;
    private CategoriesRepository categoriesRepository;
    private DashBoardController controller;
    private static final String TAG = "TripCostViewModel";
    public ObservableList<TableCategoriesModel> modelCategories;
    public GenericAdapter<TableCategoriesModel, CategoriesViewModel> genericAdapter;

    private MutableLiveData<String> mText;

    private GenericAdapter.OnItemClickListner listnerViaRoute = o -> {
       // ((MainActivity) Objects.requireNonNull(getFragment().getContext())).openCityFragment(AppFragmentEnum.CITYFRAGMENT, 0);


    };



    public HomeViewModel(HomeFragment homeFragment, CategoriesRepository categoriesRepository) {
        super(homeFragment);
        this.fragment = homeFragment;
        isProgress = new ObservableBoolean(false);
        this.categoriesRepository = categoriesRepository;
        modelCategories = new ObservableArrayList<>();
        controller = new DashBoardController();
        setViewModel();
        generateRvContent();
    }


    @BindingAdapter(value = {"customCategories"}, requireAll = false)
    public static void designationLocationRecyclerview(RecyclerView recyclerView, GenericAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void generateRvContent() {
        CategoriesViewModel catItem = new CategoriesViewModel();
        catItem.setListener(listnerViaRoute);
        genericAdapter = new GenericAdapter<>(modelCategories,catItem);



    }

    public void setViewModel() {
        isProgress.set(false);
        categoriesRepository.getCategory().observe(getFragment(), tableCategoriesModels -> {
            for (TableCategoriesModel mo : tableCategoriesModels
            ) {
                setBottomSheetModel(mo);

            }
        });
        genericAdapter.notifyDataSetChanged();
//        isItem.set(true);

    }

    private void setBottomSheetModel(TableCategoriesModel mo) {

    }


}