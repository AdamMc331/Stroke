package com.adammcneilly.stroke;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //TODO: Set this up to configure instead of just wait.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startCourseActivity();
            }
        }, 2000);
    }

    private void startCourseActivity() {
        Intent courseActivity = new Intent(this, CourseActivity.class);
        startActivity(courseActivity);
    }
}
