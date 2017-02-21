package com.coccoc.coccoctestapp.ui;

/**
 * Created by Luong Vo on 1/20/17.
 */

public interface BaseActivityContract {

    interface View {

        void finishScreen();

        void showLoadingDialog();

        void dismissLoadingDialog();

        void showFailureDialog(String message);

        void showServerFailureDialog();
    }

    interface Presenter {
    }

    interface Interactor {
    }
}
