package com.mica.media.tech.foodie;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class UtilSnackbar {
    /************************************ ShowSnackbar with message, KeepItDisplayedOnScreen for few seconds*****************************/
    public static void showSnakbarRedColor(View rootView, String mMessage) {
        Snackbar.make(rootView, mMessage, Snackbar.LENGTH_LONG)
                .setAction("OK", null)
                .show();
    }

    /************************************ ShowSnackbar with message, KeepItDisplayedOnScreen*****************************/
    public static void showSnakbarTypeTwo(View rootView, String mMessage) {

        Snackbar.make(rootView, mMessage, Snackbar.LENGTH_SHORT)
                .setAction("Action", null)
                .show();

    }

    /************************************ ShowSnackbar without message, KeepItDisplayedOnScreen, OnClickOfOk restrat the activity*****************************/
    public static void showSnakbarTypeThree(View rootView, final OnSnackbarActionClickListener listener) {

        Snackbar
                .make(rootView, "No Internet Connectivity", Snackbar.LENGTH_INDEFINITE)
                .setAction("Try Again", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onRetryClicked();
                    }
                })
                .setActionTextColor(Color.CYAN)
                .setCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
                    }

                    @Override
                    public void onShown(Snackbar snackbar) {
                        super.onShown(snackbar);
                    }
                })
                .show();

    }



    /************************************ ShowSnackbar without message, KeepItDisplayedOnScreen, OnClickOfOk restrat the activity*****************************/
    public static void showSnakbarTypeFail(View rootView, String message, final OnSnackbarActionClickListener listener) {

        Snackbar
                .make(rootView, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("Try Again", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onRetryClicked();
                    }
                })
                .setActionTextColor(Color.CYAN)
                .setCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
                    }

                    @Override
                    public void onShown(Snackbar snackbar) {
                        super.onShown(snackbar);
                    }
                })
                .show();

    }
    /************************************ ShowSnackbar without message, KeepItDisplayedOnScreen, OnClickOfOk restrat the activity*****************************/
    public static void showSnakbarTypeSuccessForCallPresnter(View rootView, String message, final OnSnackbarActionClickListener listener) {

        Snackbar
                .make(rootView, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onRetryClicked();
                    }
                })
                .setActionTextColor(Color.CYAN)
                .setCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
                    }

                    @Override
                    public void onShown(Snackbar snackbar) {
                        super.onShown(snackbar);
                    }
                })
                .show();

    }


    /************************************ ShowSnackbar with message, KeepItDisplayedOnScreen, OnClickOfOk restrat the activity*****************************/
    public static void showSnakbarTypeFour(View rootView, final Activity activity, String mMessage) {

        Snackbar
                .make(rootView, mMessage, Snackbar.LENGTH_INDEFINITE)
                .setAction("TryAgain", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = activity.getIntent();
                        activity.finish();
                        activity.startActivity(intent);
                    }
                })
                .setActionTextColor(Color.CYAN)
                .setCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
                    }

                    @Override
                    public void onShown(Snackbar snackbar) {
                        super.onShown(snackbar);
                    }
                })
                .show();

    }


    public interface OnSnackbarActionClickListener{
        void onRetryClicked();
    }
}
