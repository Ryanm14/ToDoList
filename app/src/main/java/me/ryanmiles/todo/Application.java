package me.ryanmiles.todo;

import android.util.Log;

public class Application extends android.app.Application {
    private static final String TAG = Application.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }
}
