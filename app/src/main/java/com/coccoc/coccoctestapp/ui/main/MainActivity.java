package com.coccoc.coccoctestapp.ui.main;

import android.os.Bundle;

import com.coccoc.coccoctestapp.R;
import com.coccoc.coccoctestapp.ui.BaseActivity;

public class MainActivity extends BaseActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);
        mPresenter.init();
    }
}
