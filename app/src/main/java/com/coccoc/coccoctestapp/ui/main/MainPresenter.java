package com.coccoc.coccoctestapp.ui.main;

import com.coccoc.coccoctestapp.models.Movie;
import com.coccoc.coccoctestapp.services.OnAPIListener;
import com.coccoc.coccoctestapp.services.dto.MovieListResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;


/**
 * Created by Luong Vo on 1/20/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private MainContract.Interactor mInteractor;

    private List<Movie> movies;

    public MainPresenter(MainContract.View view) {
        mView = view;
        mInteractor = new MainInteractor();
    }

    @Override
    public void init() {
        movies = new ArrayList<>();
        mView.initUI(movies);

        mView.showLoadingDialog();
        callGetMoviesAPI();
    }

    @Override
    public void handleRefresh() {
        callGetMoviesAPI();
    }

    private void callGetMoviesAPI() {
        mInteractor.getMovies(new OnAPIListener<MovieListResponse>() {
            @Override
            public void onSuccess(Response<MovieListResponse> response) {
                if (mView == null) return;
                mView.finishRefresh();
                mView.dismissLoadingDialog();

                List<Movie> result = response.body().getMovies();

                movies.clear();
                movies.addAll(result);

                mView.refreshDataList(!movies.isEmpty());
            }

            @Override
            public void onFailure(String message) {
                if (mView == null) return;
                mView.finishRefresh();
                mView.dismissLoadingDialog();
                mView.showFailureDialog(message);
            }

            @Override
            public void onServerFailure() {
                if (mView == null) return;
                mView.finishRefresh();
                mView.dismissLoadingDialog();
                mView.showServerFailureDialog();
            }
        });
    }
}
