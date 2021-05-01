package com.albae69.lifecycleactivity.utils;

import android.content.Context;
import android.widget.Toast;

public class Utils {

    //show toast
    public static void showToast(Context c, String message) {
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show();
    }


}
