package com.coccoc.coccoctestapp;

/**
 * Created by Luong Vo on 1/20/17.
 */

public interface BaseActivityView {
    void showLoadingDialog();

    void dismissLoadingDialog();

    void showFailureDialog(String message);

    void showServerFailureDialog();
}
