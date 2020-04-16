package com.mica.media.tech.foodie.common;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "TBL_CATEGORIES")

public class TableCategoriesModel extends BaseObservable implements Parcelable {

    @PrimaryKey(autoGenerate = false)
    @SerializedName("type_id")
    @Expose
    public int type_id;
    @ColumnInfo(name = "type_name")
    @SerializedName("type_name")
    @Expose
    public String type_name;
    @ColumnInfo(name="type_description")
    @SerializedName("type_description")
    @Expose
    public String type_description;

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getType_description() {
        return type_description;
    }

    public void setType_description(String type_description) {
        this.type_description = type_description;
    }

    public static Creator<TableCategoriesModel> getCREATOR() {
        return CREATOR;
    }

    public TableCategoriesModel() {
    }

    protected TableCategoriesModel(Parcel in) {
        type_id = in.readInt();
        type_name = in.readString();
        type_description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(type_id);
        dest.writeString(type_name);
        dest.writeString(type_description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TableCategoriesModel> CREATOR = new Creator<TableCategoriesModel>() {
        @Override
        public TableCategoriesModel createFromParcel(Parcel in) {
            return new TableCategoriesModel(in);
        }

        @Override
        public TableCategoriesModel[] newArray(int size) {
            return new TableCategoriesModel[size];
        }
    };
}
