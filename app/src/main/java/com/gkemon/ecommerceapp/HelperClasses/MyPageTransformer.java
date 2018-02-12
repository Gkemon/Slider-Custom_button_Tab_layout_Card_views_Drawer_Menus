package com.gkemon.ecommerceapp.HelperClasses;

import android.support.v4.view.ViewPager;
import android.view.View;



public class MyPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View view, float position) {

        if (position < 0) {
           // ViewHelper.setAlpha(view, position + 1);

        } else if (position < 1) {
            view.setTranslationX(view.getMeasuredWidth() * -position);
        }

    }
}
