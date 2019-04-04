package org.pursuit.utrainer.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.pursuit.utrainer.model.WorkoutPrograms;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm, List<WorkoutPrograms> workoutProgramsList) {
        super(fm);
        this.workoutProgramsList = workoutProgramsList;
    }

    private List<WorkoutPrograms> workoutProgramsList;



    @Override
    public Fragment getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
