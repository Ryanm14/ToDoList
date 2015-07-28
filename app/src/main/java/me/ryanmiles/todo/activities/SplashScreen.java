package me.ryanmiles.todo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import me.ryanmiles.todolist.R;

public class SplashScreen extends BaseActivity {

    private static final int SLEEP_TIME = 5000;
    private static final String TAG = "SplashScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreen.this, ToDo.class);
                    startActivity(intent);
                    finish();
                    Log.d(TAG, "Finished");
                }
            }
        };
        timer.start();
    }
}
