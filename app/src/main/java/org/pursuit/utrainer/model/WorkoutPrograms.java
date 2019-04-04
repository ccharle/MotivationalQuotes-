package org.pursuit.utrainer.model;

public class WorkoutPrograms {
    private String programTitle;
    private String workoutDescription;

    public String getProgramTitle() {
        return programTitle;
    }

    public String getWorkoutDescription() {
        return workoutDescription;
    }

    public WorkoutPrograms(String programTitle) {
        this.programTitle = programTitle;
        this.workoutDescription = workoutDescription;
    }
}
