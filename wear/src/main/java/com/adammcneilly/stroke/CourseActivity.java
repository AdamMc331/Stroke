package com.adammcneilly.stroke;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WearableListView;

import com.adammcneilly.util.models.Course;
import com.adammcneilly.util.models.HoleBase;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        CourseAdapter courseAdapter = new CourseAdapter(getTestCourses());

        WearableListView wearableListView = (WearableListView) findViewById(R.id.course_list_view);
        wearableListView.setAdapter(courseAdapter);
    }

    private List<Course> getTestCourses() {
        List<Course> courses = new ArrayList<>();

        courses.add(new Course("Maple Lane East", HoleBase.getTestHoles(9, 3)));
        courses.add(new Course("Maple Lane West", HoleBase.getTestHoles(9, 3)));
        courses.add(new Course("Maple Lane North", HoleBase.getTestHoles(9, 3)));

        return courses;
    }
}
