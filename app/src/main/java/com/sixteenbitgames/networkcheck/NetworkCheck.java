package com.sixteenbitgames.networkcheck;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkCheck {

    private Context context;
    private static NetworkCheck instance;
    private Activity activity;
    private ConnectivityManager connectivityManager;

    public NetworkCheck(){
        this.instance = this;
    }

    public static NetworkCheck instance() {
        if(instance == null) {
            instance = new NetworkCheck();
        }
        return instance;
    }

    public boolean CheckWifi(){
        if(connectivityManager == null)
            connectivityManager = (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        return (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED);
    }
    public boolean CheckMobile(){
        if(connectivityManager == null)
            connectivityManager = (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        return (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED);
    }

    public boolean CheckInternet(){
        return (CheckMobile() || CheckWifi());
    }

}
