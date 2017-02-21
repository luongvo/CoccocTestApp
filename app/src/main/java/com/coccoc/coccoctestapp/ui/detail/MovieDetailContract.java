package com.coccoc.coccoctestapp.ui.detail;

import com.coccoc.coccoctestapp.models.Movie;
import com.coccoc.coccoctestapp.ui.BaseActivityContract;

/**
 * Created by luongvo on 2/22/17.
 */

public interface MovieDetailContract {

    interface View extends BaseActivityContract.View {

        void initUI(Movie movie);
    }

    interface Presenter extends BaseActivityContract.Presenter {

        void init();
    }

    interface Interactor extends BaseActivityContract.Interactor {
    }
}
