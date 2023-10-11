package com.sixteenbitgames.androidtouch;

import android.app.Activity;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class AndroidTouch
{
    private String tag = "Android Touch Error";
    private Context context;
    private static AndroidTouch instance;
    private Activity activity;
    float[] vector2 = new float[2];
    float fingerSize = -1;

    public AndroidTouch(){
        this.instance = this;
    }

    public static AndroidTouch instance() {
        if(instance == null) {
            instance = new AndroidTouch();
        }
        return instance;
    }

    public void setContext(Context context){
        this.context = context;
        this.activity = (Activity)context;

        final View currentView = activity.getCurrentFocus();
        currentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                int index = event.getPointerCount();
                vector2[0] = event.getX(0);
                vector2[1] = event.getY(0);
                fingerSize = event.getSize(0);
                Log.d(tag,"Num Fingers = "+index + " Finger Size = " + fingerSize);

                return true;
            }
        });
    }

    public float[] GetTouchPosition(int fingerId)
    {
        return vector2;
    }

    public float GetTouchSize(int fingerId)
    {
        return fingerSize;
    }
}
