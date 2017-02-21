package com.coccoc.coccoctestapp.models;

import android.databinding.BindingAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.Date;

/**
 * Created by luongvo on 1/19/17.
 */

public class Movie implements Parcelable {
    private String name;
    private String thumbnail;
    @SerializedName("release_date")
    private Date releaseDate;
    private String category;
    @SerializedName("movie_trailer")
    private String movieTrailer;
    @SerializedName("rating_icon")
    private String ratingIcon;
    @SerializedName("movie_endtime")
    private int movieEndtime;

    protected Movie(Parcel in) {
        name = in.readString();
        thumbnail = in.readString();
        releaseDate = new Date(in.readLong());
        category = in.readString();
        movieTrailer = in.readString();
        ratingIcon = in.readString();
        movieEndtime = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(thumbnail);
        parcel.writeLong(releaseDate.getTime());
        parcel.writeString(category);
        parcel.writeString(movieTrailer);
        parcel.writeString(ratingIcon);
        parcel.writeInt(movieEndtime);
    }

    public String getName() {
        return name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getCategory() {
        return category;
    }

    public String getMovieTrailer() {
        return movieTrailer;
    }

    public String getRatingIcon() {
        return ratingIcon;
    }

    public int getMovieEndtime() {
        return movieEndtime;
    }

    @BindingAdapter({"bind:thumbnail"})
    public static void loadThumbnail(ImageView view, String thumbnail) {
        Picasso.with(view.getContext())
                .load(thumbnail)
                .into(view);
    }
}
