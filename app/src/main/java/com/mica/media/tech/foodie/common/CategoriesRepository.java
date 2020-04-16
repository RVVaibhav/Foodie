package com.mica.media.tech.foodie.common;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.google.gson.Gson;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class CategoriesRepository extends AndroidViewModel {
    private TbleCategoriesDuo dao;

    public CategoriesRepository(MyApplication application) {
        super(application);
        AppDatabase database= AppDatabase.getDatabase(application);
        dao=database.getCategoriesRepository();

    }

    public void insert(List<TableCategoriesModel> categoriesModels){
        Observable.fromIterable(categoriesModels)
                .flatMap(category -> Observable.just(saveCategory(category)))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void insert(TableCategoriesModel notifications){
        Observable.just(notifications)
                .flatMap(category -> Observable.just(saveCategory(category)))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private Long saveCategory(TableCategoriesModel notifcation) {

      //  Timber.d("saveCategory: " + new Gson().toJson(dao.getCategoriesByID(notifcation.getType_id())));
        if(dao.getCategoriesByID(notifcation.getType_id())==null)
        {
            System.out.println("dgdsgsdgg");
            return dao.insertCategories(notifcation)[0];
        }
        return 0L;
    }

    public void clearAll(){
        dao.clearAll();
    }

    public LiveData<List<TableCategoriesModel>> getCategory() {
        return dao.getCategories();
    }


    public LiveData<List<TableCategoriesModel>> getSelectedCategory(List<Integer> ids){
        return   dao.getSelectedCategories(ids);
    }

    public LiveData<List<TableCategoriesModel>> getSelectedCat(int ids){
        return   dao.getCategoriesByID(ids);
    }

}
