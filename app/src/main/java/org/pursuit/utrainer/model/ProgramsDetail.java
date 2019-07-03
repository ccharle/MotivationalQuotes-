package org.pursuit.utrainer.model;

public class ProgramsDetail {
    private String description;
    private String workoutName;
    private Integer currentWeight;


    public ProgramsDetail(String description, String workoutName, Integer currentWeight) {
        this.description = description;
        this.workoutName = workoutName;
        this.currentWeight = currentWeight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }




}


