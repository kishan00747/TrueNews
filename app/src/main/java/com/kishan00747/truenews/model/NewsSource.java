package com.kishan00747.truenews.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NewsSource implements Parcelable {

    String name;
    String[] links;

    public static final Creator<NewsSource> CREATOR = new Creator<NewsSource>(){

        @Override
        public NewsSource createFromParcel(Parcel parcel) {
            return new NewsSource(parcel);
        }

        @Override
        public NewsSource[] newArray(int size) {
            return new NewsSource[0];
        }
    };


    public NewsSource(Parcel parcel)
    {
        name = parcel.readString();
        parcel.readStringArray(links);

    }

    public NewsSource(String name, String[] links) {
        this.name = name;
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getLinks() {
        return links;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeStringArray(links);
    }
}

