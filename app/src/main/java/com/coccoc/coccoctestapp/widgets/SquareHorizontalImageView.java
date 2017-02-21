package com.coccoc.coccoctestapp.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @author Luong
 */

public class SquareHorizontalImageView extends ImageView {

    public SquareHorizontalImageView(Context context) {
        super(context);
    }

    public SquareHorizontalImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareHorizontalImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
