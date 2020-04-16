package com.mica.media.tech.foodie.ui.home;

interface ViewModel<T> {
    int layoutId();
    void setModel(T t);
}
