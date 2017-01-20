package com.coccoc.coccoctestapp;

import android.os.Bundle;

public class MainActivity extends BaseActivity implements MainActivityView {

    private MainActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainActivityPresenterImpl(this);
        mPresenter.onInit();
    }
}
