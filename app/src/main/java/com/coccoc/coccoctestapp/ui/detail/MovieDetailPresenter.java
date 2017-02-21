package com.coccoc.coccoctestapp.ui.detail;

/**
 * Created by luongvo on 2/22/17.
 */

public class MovieDetailPresenter implements MovieDetailContract.Presenter {

    private MovieDetailContract.View mView;
    private MovieDetailContract.Interactor mInteractor;

    public MovieDetailPresenter(MovieDetailContract.View view) {
        mView = view;
        mInteractor = new MovieDetailInteractor();
    }

    @Override
    public void init() {
        mView.initUI();
    }
}
