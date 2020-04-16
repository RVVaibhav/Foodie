package com.mica.media.tech.foodie;

import androidx.lifecycle.MutableLiveData;

public class ServiceEventModel {

    public MutableLiveData<Boolean> getIsTripCost() {
        return isTripCost;
    }

    public void setIsTripCost(Boolean isTripCost) {
        this.isTripCost.setValue( isTripCost);
    }

    public MutableLiveData<Boolean> getIsTollCost() {
        return isTollCost;
    }

    public void setIsTollCost(MutableLiveData<Boolean> isTollCost) {
        this.isTollCost = isTollCost;
    }

    public MutableLiveData<Boolean> isTripCost= new MutableLiveData<>();
    public MutableLiveData<Boolean> isTollCost= new MutableLiveData<>();



    public void setIsTripCost(MutableLiveData<Boolean> isTripCost) {
        this.isTripCost = isTripCost;
    }







    public ServiceEventModel() {

    }

}
