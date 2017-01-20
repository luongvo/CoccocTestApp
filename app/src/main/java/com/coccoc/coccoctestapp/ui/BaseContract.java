package com.coccoc.coccoctestapp.ui;

/**
 * Created by Luong Vo on 1/20/17.
 */

public interface BaseContract {

    interface View {
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
