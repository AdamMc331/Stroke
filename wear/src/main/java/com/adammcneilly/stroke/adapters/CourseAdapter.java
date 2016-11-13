package com.adammcneilly.stroke.adapters;

import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adammcneilly.stroke.R;
import com.adammcneilly.stroke.views.WearableListItem;
import com.adammcneilly.util.models.Course;

import java.util.List;

/**
 * Helps display a list of courses on the watch.
 *
 * Created by adam.mcneilly on 11/13/16.
 */
public class CourseAdapter extends WearableListView.Adapter {
    private List<Course> courses;

    public CourseAdapter(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CourseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_wearable, parent, false));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
        ((CourseViewHolder) holder).bindCourse(courses.get(position));
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class CourseViewHolder extends WearableListView.ViewHolder {
        private WearableListItem listItem;

        public CourseViewHolder(View view) {
            super(view);

            listItem = (WearableListItem) view;
        }

        public void bindCourse(Course course) {
            listItem.setText(course.getName());
        }
    }
}
