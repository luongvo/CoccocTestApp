package com.coccoc.coccoctestapp;

import android.util.Log;

import com.coccoc.coccoctestapp.models.Movie;
import com.coccoc.coccoctestapp.services.OnAPIListener;
import com.coccoc.coccoctestapp.services.dto.MovieListResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;


/**
 * Created by Luong Vo on 1/20/17.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private MainActivityView mView;
    private MainActivityInteractor mInteractor;

    private List<Movie> movies;

    public MainActivityPresenterImpl(MainActivityView view) {
        mView = view;
        mInteractor = new MainActivityInteractorImpl();
    }

    @Override
    public void onInit() {
        movies = new ArrayList<>();
        callGetMoviesAPI();
    }

    private void callGetMoviesAPI() {
        mInteractor.getMovies(new OnAPIListener<MovieListResponse>() {
            @Override
            public void onSuccess(Response<MovieListResponse> response) {
                if (mView == null) return;
                mView.dismissLoadingDialog();

                movies.clear();
                movies.addAll(response.body().getMovies());

                Log.i("==", movies.size() + "_");
            }

            @Override
            public void onFailure(String message) {
                if (mView == null) return;
                mView.dismissLoadingDialog();
                mView.showFailureDialog(message);
            }

            @Override
            public void onServerFailure() {
                if (mView == null) return;
                mView.dismissLoadingDialog();
                mView.showServerFailureDialog();
            }
        });
    }
}
