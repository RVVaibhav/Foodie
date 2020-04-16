package com.mica.media.tech.foodie.network;

import android.util.Log;

import com.mica.media.tech.foodie.common.AppConstant;

public class NetworkCall {

    private static final String TAG = "NetworkCall";

    private static RetroController controller;
    private static boolean isTripCost= false;

    private NetworkCall(NetworkBuilder networkBuilder) {
        controller = Retro.getInstance().getController(networkBuilder.token);

    }





    public static RetroController getController() {
        return controller;
    }

    public static RetroController getControllerTipCost() {
        return    Retro.getInstance().geControllerForTripCost( AppConstant.BASE_URL_TRIP_COST);

    }

    public static RetroController getControllerFuelCost() {
        return Retro.getInstance().getControllerFuelCost( AppConstant.BASE_URL_FUEL_COST);
    }

    public static final class NetworkBuilder {
        String token;


        public NetworkBuilder setHeader() {
//            token = Prefs.getString(AppConstant.TOKEN, "-1") + " " + MyApplication.getInstance().getAppToken();
            Log.d(TAG, "setHeader: " + token);
            return this;
        }

        public NetworkCall build() {
            return new NetworkCall(this);
        }
    }
}
