package com.coccoc.coccoctestapp.widgets.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.coccoc.coccoctestapp.R;

/**
 * @author Luong
 */

public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int mVerticalSpaceHeight;
    private boolean mIsBottomSeperator = false;

    public VerticalSpaceItemDecoration(Context context) {
        mVerticalSpaceHeight = context.getResources().
                getDimensionPixelSize(R.dimen.separator_size);
    }

    public VerticalSpaceItemDecoration(Context context, boolean isBottomSeperator) {
        mVerticalSpaceHeight = context.getResources().
                getDimensionPixelSize(R.dimen.separator_size);
        mIsBottomSeperator = isBottomSeperator;
    }

    public VerticalSpaceItemDecoration(int verticalSpaceHeight) {
        mVerticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        // it includes the top divider
        if (!mIsBottomSeperator) {
            outRect.top = mVerticalSpaceHeight;
        } else {
            outRect.bottom = mVerticalSpaceHeight;
        }
    }
}
