package com.development.beshoy.taskcardview.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;


import com.development.beshoy.taskcardview.BuildConfig;

import java.util.Random;

/**
 * Created by bisho on 07-Sep-17.
 */

public class AppUtils {
    private static Random random;
    public static final String FIRST_LAUNCH_KEY = "FLK";
    private static final String LOG_TAG = "debugqr";

    private AppUtils() {
    }

    public static void showToast(Context context, int stringId) {
        Toast.makeText(context, stringId, Toast.LENGTH_LONG).show();
    }

    public static int getRandom(int end) {
        if (random == null)
            random = new Random();
        return random.nextInt(end);
    }



    public static boolean checkIfHasNetwork(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static void makeLog(String log) {
        if (BuildConfig.DEBUG)
            Log.d(LOG_TAG, log);
    }
}
