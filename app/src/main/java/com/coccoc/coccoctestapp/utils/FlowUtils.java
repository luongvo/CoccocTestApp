package com.coccoc.coccoctestapp.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.coccoc.coccoctestapp.R;

/**
 * Created by Luong Vo on 1/20/17.
 */

public class FlowUtils {

    private static FlowUtils sInstance;

    private ProgressDialog mProgressDialog;

    private FlowUtils() {
    }

    public static FlowUtils getInstance() {
        if (sInstance == null) {
            sInstance = new FlowUtils();
        }
        return sInstance;
    }

    public void showLoadingDialog(Context context) {
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(context.getString(R.string.loading));
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
    }

    public void dismissLoadingDialog() {
        if (mProgressDialog != null) {
            try {
                mProgressDialog.dismiss();
            } catch (IllegalArgumentException ex) {
                Log.e(getClass().getSimpleName(), "Activity is already finished, no need dismissing dialog");
            }
        }
    }

    public void showAlert(Context context, String title, String message, DialogInterface.OnClickListener onClick) {
        AlertDialog.Builder bld = new AlertDialog.Builder(context);
        bld.setTitle(title);
        bld.setMessage(message);
        bld.setNeutralButton(context.getString(R.string.ok), onClick);
        bld.create().show();
    }
}
