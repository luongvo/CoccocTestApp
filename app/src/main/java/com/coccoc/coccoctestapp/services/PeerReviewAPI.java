package com.coccoc.coccoctestapp.services;

import com.coccoc.coccoctestapp.services.dto.MovieListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by luongvo on 1/19/17.
 */

public interface PeerReviewAPI {

    @GET("movie/list")
    Call<MovieListResponse> getMovieList();
}
