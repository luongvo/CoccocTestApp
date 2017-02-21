package com.coccoc.coccoctestapp.ui.main;

import android.support.annotation.NonNull;

import com.coccoc.coccoctestapp.models.Movie;
import com.coccoc.coccoctestapp.services.OnAPIListener;
import com.coccoc.coccoctestapp.ui.BaseActivityContract;

import java.util.List;

/**
 * Created by Luong Vo on 1/20/17.
 */

public interface MainContract {

    interface View extends BaseActivityContract.View {
        void initUI(List<Movie> movies);

        void refreshDataList(boolean hasData);
    }

    interface Presenter extends BaseActivityContract.Presenter {
        void init();
    }

    interface Interactor extends BaseActivityContract.Interactor {
        void getMovies(@NonNull OnAPIListener listener);
    }
}
