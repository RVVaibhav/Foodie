package com.mica.media.tech.foodie.ui.home;

public class EventBottomSheet {

    public   int id;
    public   String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public EventBottomSheet(int id, String value, String type) {

        this.id = id;
        this.value = value;
        this.type = type;
    }
}
