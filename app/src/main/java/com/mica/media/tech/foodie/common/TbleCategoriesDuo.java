package com.mica.media.tech.foodie.common;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TbleCategoriesDuo {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract long[] insertCategories(TableCategoriesModel... categoriesModels);

    @Query("select * from tbl_categories")
    LiveData<List<TableCategoriesModel>> getCategories();

    @Query("select * from tbl_categories where type_id=(:typeId)")
    LiveData<List<TableCategoriesModel>> getCategoriesByID(int typeId);

    @Update
    void updateServices(TableCategoriesModel categoryUpdate);

    @Query("delete from tbl_categories")
    void clearAll();

    @Query("select * from tbl_categories where type_id in (:ids)")
    LiveData<List<TableCategoriesModel>> getSelectedCategories(List<Integer> ids);
}
