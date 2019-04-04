package org.pursuit.utrainer.model;

public class ProgramsDetail {
    private String description;
    private String workoutName;

    public ProgramsDetail(String description, String workoutName) {
        this.description = description;
        this.workoutName = workoutName;
    }


    public String getDescription() {
        return description;
    }

    public String getWorkoutName() {
        return workoutName;
    }
}
