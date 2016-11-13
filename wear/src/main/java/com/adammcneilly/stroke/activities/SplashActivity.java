package com.adammcneilly.stroke.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.adammcneilly.stroke.R;
import com.adammcneilly.stroke.activities.CourseActivity;

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
