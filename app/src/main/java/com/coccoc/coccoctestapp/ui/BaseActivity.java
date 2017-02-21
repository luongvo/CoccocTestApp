package com.coccoc.coccoctestapp.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.coccoc.coccoctestapp.R;
import com.coccoc.coccoctestapp.utils.FlowUtils;

/**
 * Created by Luong Vo on 1/20/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseActivityContract.View {

    @Override
    public void finishScreen() {
        finish();
    }

    @Override
    public void showLoadingDialog() {
        FlowUtils.getInstance().showLoadingDialog(this);
    }

    @Override
    public void dismissLoadingDialog() {
        FlowUtils.getInstance().dismissLoadingDialog();
    }

    @Override
    public void showFailureDialog(String message) {
        if (TextUtils.isEmpty(message)) {
            message = getString(R.string.something_went_wrong_could_not_get_response);
        }
        FlowUtils.getInstance().showAlert(this, getString(R.string.error), message, null);
    }

    @Override
    public void showServerFailureDialog() {
        showFailureDialog(getString(R.string.can_not_connect_to_server));
    }

    protected void setUpActionBar(String title, boolean isBackVisible) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);

        // set back button
        if (isBackVisible) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
