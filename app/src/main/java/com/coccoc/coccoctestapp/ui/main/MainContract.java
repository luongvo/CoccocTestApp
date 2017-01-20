package com.coccoc.coccoctestapp.ui.main;

import android.support.annotation.NonNull;

import com.coccoc.coccoctestapp.services.OnAPIListener;
import com.coccoc.coccoctestapp.ui.BaseContract;

/**
 * Created by Luong Vo on 1/20/17.
 */

public interface MainContract {

    interface View extends BaseContract.View {
    }

    interface Presenter extends BaseContract.Presenter {
        void init();
    }

    interface Interactor extends BaseContract.Interactor {
        void getMovies(@NonNull OnAPIListener listener);
    }
}
