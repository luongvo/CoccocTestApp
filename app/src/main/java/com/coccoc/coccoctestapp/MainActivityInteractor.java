package com.coccoc.coccoctestapp;

import android.support.annotation.NonNull;

import com.coccoc.coccoctestapp.services.OnAPIListener;

/**
 * Created by Luong Vo on 1/20/17.
 */

public interface MainActivityInteractor {
    void getMovies(@NonNull OnAPIListener listener);
}
