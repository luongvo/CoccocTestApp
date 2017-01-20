package com.coccoc.coccoctestapp.services.dto;

import com.coccoc.coccoctestapp.models.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by luongvo on 1/19/17.
 */

public class MovieListResponse {

    @SerializedName("data")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
}
