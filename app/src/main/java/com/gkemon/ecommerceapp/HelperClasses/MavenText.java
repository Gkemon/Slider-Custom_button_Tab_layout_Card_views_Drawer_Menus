package com.gkemon.ecommerceapp.HelperClasses;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import java.util.Locale;


public class MavenText extends AppCompatTextView {
    public MavenText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MavenText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MavenText(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), String.format(Locale.US, "fonts/%s", "MavenPro-Regular.ttf"));
        setTypeface(tf ,1);

    }
}
