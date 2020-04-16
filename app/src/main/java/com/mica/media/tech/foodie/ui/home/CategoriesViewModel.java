package com.mica.media.tech.foodie.ui.home;

import android.view.View;

import androidx.databinding.BaseObservable;

import com.mica.media.tech.foodie.R;
import com.mica.media.tech.foodie.common.TableCategoriesModel;


public class CategoriesViewModel extends BaseObservable implements ViewModel<TableCategoriesModel> {
    private GenericAdapter.OnItemClickListner listner;


    public CategoriesViewModel() {
    }

    @Override
    public int layoutId() {
        return R.layout.item_rv_category;
    }

    @Override
    public void setModel(TableCategoriesModel categoriesModel) {

    }

    public void setListener(GenericAdapter.OnItemClickListner listner) {
        this.listner = listner;
    }

    public void onClicked(View view, TableCategoriesModel model, int position) {
        if(listner!=null)
            listner.onItemClicked(model);

    }
}
