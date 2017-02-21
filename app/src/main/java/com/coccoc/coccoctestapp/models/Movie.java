package com.coccoc.coccoctestapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by luongvo on 1/19/17.
 */

public class Movie {
    private String name;
    private String thumbnail;
    @SerializedName("release_date")
    private Date releaseDate;

    public String getName() {
        return name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
}
