package com.mica.media.tech.foodie.common;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DashBoardController {

    private static final String CATEGORY = "CATEGORY";


    private static final String TAG = "DashBoardController";

    private HashMap<String, Boolean> booleanHashMap = new HashMap<>();


    public DashBoardController() {

    }



    public HashMap<String, Boolean> getCategory(String response) throws JSONException {
        boolean isDownload = false;
        if (response != null && !TextUtils.isEmpty(response)) {
            JSONArray object = new JSONArray(response);
            CategoriesRepository categoriesRepository = new CategoriesRepository(MyApplication.getInstance());
            categoriesRepository.clearAll();
            for (int i = 0; i < object.length(); i++) {
                JSONObject jCity = object.getJSONObject(i);
                Log.d(TAG, "getStateList: " + new Gson().toJson(jCity));
                isDownload = storeCategory(jCity, categoriesRepository, isDownload);
//                getLocationMaster(jCity);
            }

        }


        booleanHashMap.put(CATEGORY, isDownload);
        return booleanHashMap;

    }


    private boolean storeCategory(JSONObject category, CategoriesRepository categoriesRepository, boolean isDownload) throws JSONException {
        categoriesRepository.insert(getCategoryS(category));
        isDownload = true;
        return isDownload;

    }

    private TableCategoriesModel getCategoryS(JSONObject category) throws JSONException {
        TableCategoriesModel model = new TableCategoriesModel();
        if (category.has("res")) {
            JSONObject jsonObject = category.getJSONObject("res");
            if (jsonObject.has("type_id"))
                model.setType_id(Integer.parseInt(jsonObject.getString("type_id")));
            if (jsonObject.has("type_name"))
                model.setType_name(jsonObject.getString("type_name"));
            if (jsonObject.has("type_description"))
                model.setType_description(jsonObject.getString("type_description"));
        }

        return model;
    }
}
