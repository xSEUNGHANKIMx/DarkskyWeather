package com.seankim.darkskyweather.Utils;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TouchListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View v, MotionEvent event)  {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            v.animate().scaleX(1.025f).scaleY(1.025f).setDuration(300).start();
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
        }else if(event.getAction() == MotionEvent.ACTION_CANCEL){
            v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
        }
        return true;
    }
}
