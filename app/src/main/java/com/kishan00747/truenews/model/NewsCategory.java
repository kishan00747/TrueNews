package com.kishan00747.truenews.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NewsCategory implements Parcelable {

    String name;
    String link;

    public static final Parcelable.Creator<NewsCategory> CREATOR = new Parcelable.Creator<NewsCategory>(){

        @Override
        public NewsCategory createFromParcel(Parcel parcel) {
            return new NewsCategory(parcel);
        }

        @Override
        public NewsCategory[] newArray(int size) {
            return new NewsCategory[0];
        }
    };


    public NewsCategory(Parcel parcel)
    {
        name = parcel.readString();
        link = parcel.readString();

    }

    public NewsCategory(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLinks(String links) {
        this.link = link;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(link);
    }
}

