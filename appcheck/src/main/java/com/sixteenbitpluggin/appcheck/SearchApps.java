package com.sixteenbitpluggin.appcheck;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.List;

public class SearchApps {

    private Context context;
    private static SearchApps instance;
    private Activity activity;

    public SearchApps(){
        this.instance = this;
    }

    public static SearchApps instance() {
        if(instance == null) {
            instance = new SearchApps();
        }
        return instance;
    }
    public void setContext(Context context){
        this.context = context;
        this.activity = (Activity)context;
    }

    public boolean appInstalledOrNot(String APP_NAME) {
        PackageManager pm = activity.getPackageManager();
        try {
            pm.getPackageInfo(APP_NAME, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e)
        {
            Log.e("16BitAppCheck", "appInstalledOrNot: " + e );
        }
        return false;
    }

    public String Legal(String APP_NAME){
        PackageManager pm = activity.getPackageManager();
        if(appInstalledOrNot(APP_NAME))
        {
            String installer = pm.getInstallerPackageName(APP_NAME);
            return installer;
        }
        return "Err: App not installed";
    }
}
