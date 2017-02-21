package com.coccoc.coccoctestapp.ui.detail;

import android.app.Activity;
import android.content.Context;

import com.coccoc.coccoctestapp.models.Movie;
import com.coccoc.coccoctestapp.utils.Constants;

/**
 * Created by luongvo on 2/22/17.
 */

public class MovieDetailPresenter implements MovieDetailContract.Presenter {

    private Context mContext;
    private MovieDetailContract.View mView;
    private MovieDetailContract.Interactor mInteractor;

    private Movie mMovie;

    public MovieDetailPresenter(Context context, MovieDetailContract.View view) {
        mContext = context;
        mView = view;
        mInteractor = new MovieDetailInteractor();
    }

    @Override
    public void init() {
        mMovie = ((Activity) mContext).getIntent().getParcelableExtra(Constants.MOVIE_KEY);
        if (mMovie == null) {
            mView.finishScreen();
            return;
        }

        mView.initUI(mMovie);
    }
}
