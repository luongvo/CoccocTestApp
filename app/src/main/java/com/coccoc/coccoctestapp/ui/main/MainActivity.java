package com.coccoc.coccoctestapp.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.coccoc.coccoctestapp.R;
import com.coccoc.coccoctestapp.models.Movie;
import com.coccoc.coccoctestapp.ui.BaseActivity;
import com.coccoc.coccoctestapp.widgets.VerticalSpaceItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by luongvo on 1/20/17.
 */

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.rv_movies)
    RecyclerView rvMovies;
    @BindView(R.id.tv_no_data)
    View tvNoData;

    private MainContract.Presenter mPresenter;
    private MovieAdapter mMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mPresenter = new MainPresenter(this);
        mPresenter.init();
    }

    @Override
    public void initUI(List<Movie> movies) {
        initDataList(movies);
    }

    @Override
    public void refreshDataList(boolean hasData) {
        mMovieAdapter.notifyDataSetChanged();
        tvNoData.setVisibility(hasData ? View.GONE : View.VISIBLE);
    }

    private void initDataList(List<Movie> movies) {
        mMovieAdapter = new MovieAdapter(this, movies);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvMovies.setLayoutManager(linearLayoutManager);
        rvMovies.addItemDecoration(new VerticalSpaceItemDecoration(this));
        rvMovies.setAdapter(mMovieAdapter);
    }
}
