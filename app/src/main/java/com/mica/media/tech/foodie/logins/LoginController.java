package com.mica.media.tech.foodie.logins;

import android.util.Log;

import com.google.gson.Gson;
import com.mica.media.tech.foodie.common.AppConstant;
import com.mica.media.tech.foodie.common.Prefs;
import com.mica.media.tech.foodie.pojo.MessageResonseModel;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class LoginController {


    public static MessageResonseModel getLoginResponse(String response) throws JSONException {
        return getFlagResponse(response);


    }

    private static MessageResonseModel getFlagResponse(String response) throws JSONException {
        JSONObject object = new JSONObject(response);
        MessageResonseModel model = null;
        if (object.has("flag")) {
            model = new MessageResonseModel();
           // model.setFlag(object.getString("flag"));
            if (object.getString("flag").equalsIgnoreCase("1")) {
                model.setMessage(object.getString("message"));
                model.setFlag(object.getString("flag"));
                model.setRegistrationDate(object.getString("registration_date"));
                model.setUserId(object.getString("user_id"));
                model.setUserAddress(object.getString("user_address"));
                model.setUserName(object.getString("user_name"));
                model.setUserContact(object.getString("user_contact"));
                model.setUserEmail(object.getString("user_email"));
                model.setUserPassword(object.getString("user_password"));
            } else {
                model.setMessage(object.getString("message"));
            }
        }
        Log.d(TAG, "getLocationMaster: " + new Gson().toJson(model));

        return model;

    }

    private static void saveUserProfile(JSONObject jsonObjectUser) {

    }

   /* private static MessageResonseModel getFlagResponse(String response) throws JSONException {
        JSONObject object = new JSONObject(response);
        MessageResonseModel model = null;
        if (object.has("ve")) {
            model = new MessageResonseModel();
            model.setFlag(object.getString("flag"));
            model.setRegistrationDate(object.getString("registration_date"));
            model.setUserId(object.getString("user_id"));
            model.setUserAddress(object.getString("user_address"));
            if (object.getString("flag").equalsIgnoreCase("1")) {
                model.setMessage(object.getString("message"));
            } else {
                model.setMessage(object.getString("message"));
            }

        }

        if (object.has("ve")) {
            JSONObject jsonObject1 = object.getJSONObject("userinformation");
            if(jsonObject1.has("User")){
                JSONObject jsonObjectUser = jsonObject1.getJSONObject("User");
                saveUserProfile(jsonObjectUser);
                if(jsonObjectUser.has("id"))
                    model.setUserId(jsonObjectUser.getString("id"));
                if(jsonObjectUser.has("user_group_id"))
                    Prefs.putInt(AppConstant.APP_USER_TYPE, Integer.parseInt(jsonObjectUser.getString("user_group_id")));



            } }

        Log.d(TAG, "getFlagResponse: "+new Gson().toJson(model));
        return model;
    }*/

    private static final String TAG = "LoginController";
    public LoginController() {

    }

}
