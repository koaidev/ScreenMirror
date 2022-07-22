package com.bangbangcoding.screenmirror.easybrowser.entity.bo;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

public class TabInfo implements Parcelable {
    private String tag;
    private String title;
    private Uri uri;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (tag == null || obj == null) {
            return false;
        }
        if (obj instanceof TabInfo) {
            TabInfo target = (TabInfo) obj;
            return tag.equals(target.tag);
        } else {
            return false;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tag);
        dest.writeString(this.title);
        dest.writeParcelable(this.uri, flags);
    }

    public TabInfo() {
    }

    public static TabInfo create(String tag, String title) {
        TabInfo tabInfo = new TabInfo();
        tabInfo.tag = tag;
        tabInfo.title = title;
        return tabInfo;
    }

    public static TabInfo create(String tag, String title, Uri uri) {
        TabInfo tabInfo = new TabInfo();
        tabInfo.tag = tag;
        tabInfo.title = title;
        tabInfo.uri = uri;
        return tabInfo;
    }

    protected TabInfo(Parcel in) {
        this.tag = in.readString();
        this.title = in.readString();
        this.uri = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<TabInfo> CREATOR = new Creator<TabInfo>() {
        @Override
        public TabInfo createFromParcel(Parcel source) {
            return new TabInfo(source);
        }

        @Override
        public TabInfo[] newArray(int size) {
            return new TabInfo[size];
        }
    };
}