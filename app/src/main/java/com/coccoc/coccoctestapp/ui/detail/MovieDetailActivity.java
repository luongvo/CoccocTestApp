package com.coccoc.coccoctestapp.ui.detail;

import android.os.Bundle;
import android.view.MenuItem;

import com.coccoc.coccoctestapp.R;
import com.coccoc.coccoctestapp.ui.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by luongvo on 2/22/17.
 */

public class MovieDetailActivity extends BaseActivity implements MovieDetailContract.View {

    private MovieDetailContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        mPresenter = new MovieDetailPresenter(this);
        mPresenter.init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

    @Override
    public void initUI() {
        setUpActionBar("MovieDetailActivity", true);
    }
}
