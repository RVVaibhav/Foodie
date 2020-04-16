package com.mica.media.tech.foodie.common;

import com.mica.media.tech.foodie.network.NetworkCall;
import com.mica.media.tech.foodie.network.RetroController;

public class AppConstant {
    public static final String BASE_URL="http://192.168.43.80/annkut_android/";
    public static final String BASE_URL_TRIP_COST="http://tis.nhai.gov.in/";
    public static final String BASE_URL_FUEL_COST = "https://newsrain-petrol-diesel-prices-india-v1.p.rapidapi.com/";


    public static final String PREF_NAME ="Foodie" ;
    public static final String BOOKING_ID ="BOOKING_ID";
    public static final String CART_ITEMS = "CART_ITEMS";
    public static final String ITEM_ID = "ITEM_ID";
    public static final String ITEM_QUANTITY = "ITEM_QUANTITY";
    public static final String ITEM_PRICE = "ITEM_PRICE";
    // public static final String SHOP_ID = "SHOP_ID";
    public static final String ITEM_NAME = "ITEM_NAME";
    public static final String ITEM_PACK_SIZE = "ITEM_PACK_SIZE";
    public static final String ITEM_CATEGORY = "ITEM_CATEGORY";
    public static final String CART_REQUEST ="CART_REQUEST";
    public static final String USER_NAME="USER_NAME";
    public static final String USER_CONTACT  ="USER_CONTACT ";
    public static final String USER_ADDRESS  ="USER_ADDRESS ";
    public static final String CART_DATE  =" CART_DATE ";
    public static final String PAYMENT_MODE  =" PAYMENT_MODE";
    public static final String PRODUCT_COUNT =" PRODUCT_COUNT";
    public static final String CART_AMOUNT ="CART_AMOUNT";
    public static final String IMAGE_ID ="IMAGE_ID";
    public static final String SHOP_NAME ="SHOP_NAME";
    public static final String ORDER_ID = "ORDER_ID";
    public static final String SP_NAME ="Annakut" ;
    public static final String SP_EMPEMAIL = "sp_email";
    public static final String SP_PASSWORD = "sp_password";
    public static final String SP_USER_ID ="sp_user_id";
    public static final String SP_USER_NAME = "sp_user_name";
    public static final String SP_USER_CONTACT = "sp_user_contact";
    public static final String SP_USER_ADDRESS ="sp_user_address";
    public static final String SP_REGISTRATION ="sp_registration_date";
    public static final String APP_DB = "foodieDb";
    public static String isUserLogin="isUserLogin" ;
    public static String isDownloadFirst="isDownloadFirst";


    public static RetroController getController() {
        return NetworkCall.getController();
    }
    public static RetroController getTripCostController() {
        return NetworkCall.getControllerTipCost();
    }

    public static RetroController getFuelCostController(){
        return NetworkCall.getControllerFuelCost();
    }
}
