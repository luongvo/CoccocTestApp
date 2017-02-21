package com.coccoc.coccoctestapp.ui.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.MenuItem;

import com.coccoc.coccoctestapp.R;
import com.coccoc.coccoctestapp.databinding.ActivityDetailBinding;
import com.coccoc.coccoctestapp.models.Movie;
import com.coccoc.coccoctestapp.ui.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by luongvo on 2/22/17.
 */

public class MovieDetailActivity extends BaseActivity implements MovieDetailContract.View {

    private ActivityDetailBinding mBinding;
    private MovieDetailContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        mPresenter = new MovieDetailPresenter(this, this);
        mPresenter.init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finishScreen();
        }
        return true;
    }

    @Override
    public void initUI(Movie movie) {
        setUpActionBar(movie.getName(), true);

        mBinding.setMovie(movie);
    }
}
