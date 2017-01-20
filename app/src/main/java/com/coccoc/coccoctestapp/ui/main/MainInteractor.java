package com.coccoc.coccoctestapp.ui.main;

import android.support.annotation.NonNull;

import com.coccoc.coccoctestapp.services.APIService;
import com.coccoc.coccoctestapp.services.OnAPIListener;
import com.coccoc.coccoctestapp.services.dto.MovieListResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Luong Vo on 1/20/17.
 */

public class MainInteractor implements MainContract.Interactor {

    @Override
    public void getMovies(@NonNull final OnAPIListener listener) {
        APIService.getInstance().getMovies(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(Call<MovieListResponse> call, Response<MovieListResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response);
                } else {
                    // TODO: check error response object here to get error message
                    listener.onFailure(null);
                }
            }

            @Override
            public void onFailure(Call<MovieListResponse> call, Throwable t) {
                listener.onServerFailure();
            }
        });
    }
}
