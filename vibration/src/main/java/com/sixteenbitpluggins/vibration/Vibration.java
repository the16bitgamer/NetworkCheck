package com.sixteenbitpluggins.vibration;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class Vibration {

    private Context context;
    private static Vibration instance;
    private Activity activity;
    private ConnectivityManager connectivityManager;

    public static Vibration instance() {
        if(instance == null) {
            instance = new Vibration();
        }
        return instance;
    }
    public void setContext(Context context){
        this.context = context;
        this.activity = (Activity)context;
    }

    public void Vibrate(int TIME){
        Vibrator v = (Vibrator) activity.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(TIME, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(TIME);
        }
    }
}
