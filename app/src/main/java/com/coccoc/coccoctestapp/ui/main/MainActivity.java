package com.coccoc.coccoctestapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.coccoc.coccoctestapp.R;
import com.coccoc.coccoctestapp.models.Movie;
import com.coccoc.coccoctestapp.ui.BaseActivity;
import com.coccoc.coccoctestapp.ui.detail.MovieDetailActivity;
import com.coccoc.coccoctestapp.utils.Constants;
import com.coccoc.coccoctestapp.widgets.recyclerview.ItemClickSupport;
import com.coccoc.coccoctestapp.widgets.recyclerview.VerticalSpaceItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by luongvo on 1/20/17.
 */

public class MainActivity extends BaseActivity
        implements MainContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.swipe_container)
    SwipeRefreshLayout srLayout;
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
        srLayout.setColorSchemeResources(R.color.colorAccent);
        srLayout.setOnRefreshListener(this);

        initDataList(movies);
    }

    @Override
    public void refreshDataList(boolean hasData) {
        mMovieAdapter.notifyDataSetChanged();
        tvNoData.setVisibility(hasData ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onRefresh() {
        mPresenter.handleRefresh();
    }

    @Override
    public void finishRefresh() {
        if (srLayout != null) {
            srLayout.setRefreshing(false);
        }
    }

    @Override
    public void navigateToDetailScreen(Movie movie) {
        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra(Constants.MOVIE_KEY, movie);
        startActivity(intent);
    }

    private void initDataList(List<Movie> movies) {
        mMovieAdapter = new MovieAdapter(movies);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvMovies.setLayoutManager(linearLayoutManager);
        rvMovies.addItemDecoration(new VerticalSpaceItemDecoration(this));
        rvMovies.setAdapter(mMovieAdapter);

        // add OnItemClick into RecyclerView
        ItemClickSupport.addTo(rvMovies).setOnItemClickListener(
                (recyclerView, position, v) -> mPresenter.handleMovieListItemClicked(position));
    }
}
