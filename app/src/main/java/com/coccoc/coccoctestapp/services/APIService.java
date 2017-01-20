package com.coccoc.coccoctestapp.services;

import com.coccoc.coccoctestapp.services.dto.MovieListResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by Luong Vo on 1/19/17.
 */

public class APIService {

    private static APIService sInstance;

    private PeerReviewAPI mService;

    public static APIService getInstance() {
        if (sInstance == null) {
            synchronized (APIService.class) {
                if (sInstance == null) {
                    sInstance = new APIService();
                }
            }
        }

        return sInstance;
    }

    private APIService() {
        Retrofit retrofit = ServiceGenerator.createService();
        mService = retrofit.create(PeerReviewAPI.class);
    }

    /**
     * Call this to get movie list data
     *
     * @param callback callback which will be triggered when receiving response message
     */
    public void getMovies(Callback<MovieListResponse> callback) {
        Call<MovieListResponse> call = mService.getMovieList();
        call.enqueue(callback);
    }
}
