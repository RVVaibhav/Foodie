package com.mica.media.tech.foodie.common;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {TableCategoriesModel.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                INSTANCE = Room
                        .databaseBuilder(context.getApplicationContext(), AppDatabase.class, AppConstant.APP_DB)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }

        return INSTANCE;
    }

    public abstract TbleCategoriesDuo getCategoriesRepository();

}
