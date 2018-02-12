package com.gkemon.ecommerceapp.CustomView;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Gk emon on 2/11/2018.
 */

public class CustomCardsForItem extends CardView {
    Context context;

    public CustomCardsForItem(Context context) {
        super(context);
    }
    public CustomCardsForItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCardsForItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int width, int height) {

        super.onMeasure(width, width);
    }


}
