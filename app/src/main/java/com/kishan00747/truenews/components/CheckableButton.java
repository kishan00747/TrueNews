package com.kishan00747.truenews.components;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import android.widget.Checkable;

public class CheckableButton extends AppCompatButton implements Checkable {

    private static final int[] CheckedStateSet = { android.R.attr.state_checked };

    private boolean mChecked = false;

    public CheckableButton(Context context) {
        super(context);
    }

    public CheckableButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckableButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void setChecked(boolean checked) {
        mChecked = checked;
        refreshDrawableState();
    }

    @Override
    public void toggle() {
        mChecked = !mChecked;
        refreshDrawableState();
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CheckedStateSet);
        }
        return drawableState;
    }


    @Override
    public boolean performClick() {
        toggle();
        return super.performClick();
    }
}