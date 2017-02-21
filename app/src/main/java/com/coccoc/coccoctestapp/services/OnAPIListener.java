package com.coccoc.coccoctestapp.services;

import retrofit2.Response;

/**
 * Created by Luong Vo on 1/20/17.
 */

public interface OnAPIListener<T> {

    void onSuccess(Response<T> response);

    void onFailure(String message);

    void onServerFailure();
}
