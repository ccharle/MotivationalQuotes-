package org.pursuit.utrainer.model;

public class ProgramsDetail {
    private String description;
    private String workoutName;
    private Integer firstSet;
    private Integer secondSet;
    private Integer thirdSet;
    private Integer fourthSet;
    private Integer fifthSet;
    private Integer sixthSet;
    private Integer currentWeight;

    public ProgramsDetail(String description, String workoutName, Integer firstSet, Integer secondSet, Integer thirdSet, Integer fourthSet, Integer fifthSet, Integer sixthSet, Integer currentWeight) {
        this.description = description;
        this.workoutName = workoutName;
        this.firstSet = firstSet;
        this.secondSet = secondSet;
        this.thirdSet = thirdSet;
        this.fourthSet = fourthSet;
        this.fifthSet = fifthSet;
        this.sixthSet = sixthSet;
        this.currentWeight = currentWeight;
    }

    public ProgramsDetail(String description, String workoutName, Integer firstSet, Integer secondSet, Integer thirdSet, Integer fourthSet, Integer fifthSet, Integer currentWeight) {
        this.description = description;
        this.workoutName = workoutName;
        this.firstSet = firstSet;
        this.secondSet = secondSet;
        this.thirdSet = thirdSet;
        this.fourthSet = fourthSet;
        this.fifthSet = fifthSet;
        this.currentWeight = currentWeight;

    }

    public ProgramsDetail(String description, String workoutName, Integer firstSet, Integer secondSet, Integer thirdSet, Integer fourthSet, Integer currentWeight) {
        this.description = description;
        this.workoutName = workoutName;
        this.firstSet = firstSet;
        this.secondSet = secondSet;
        this.thirdSet = thirdSet;
        this.fourthSet = fourthSet;
        this.currentWeight = currentWeight;

    }

    public ProgramsDetail(String description, String workoutName, Integer firstSet, Integer secondSet, Integer thirdSet, Integer currentWeight) {
        this.description = description;
        this.workoutName = workoutName;
        this.firstSet = firstSet;
        this.secondSet = secondSet;
        this.thirdSet = thirdSet;
        this.currentWeight = currentWeight;

    }

    public ProgramsDetail(String description, String workoutName, Integer firstSet, Integer secondSet, Integer currentWeight) {
        this.description = description;
        this.workoutName = workoutName;
        this.firstSet = firstSet;
        this.secondSet = secondSet;
        this.currentWeight = currentWeight;

    }

    public ProgramsDetail(String description, String workoutName, Integer firstSet, Integer currentWeight) {
        this.description = description;
        this.workoutName = workoutName;
        this.firstSet = firstSet;
        this.currentWeight = currentWeight;
    }

    public ProgramsDetail(String description, String workoutName, Integer currentWeight) {
        this.description = description;
        this.workoutName = workoutName;
        this.currentWeight = currentWeight;

    }

    public String getDescription() {
        return description;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public Integer getFirstSet() {
        return firstSet;
    }

    public Integer getSecondSet() {
        return secondSet;
    }

    public Integer getThirdSet() {
        return thirdSet;
    }

    public Integer getFourthSet() {
        return fourthSet;
    }

    public Integer getFifthSet() {
        return fifthSet;
    }

    public Integer getSixthSet() {
        return sixthSet;
    }

    public void setFirstSet(Integer firstSet) {
        this.firstSet = firstSet;
    }

    public void setSecondSet(Integer secondSet) {
        this.secondSet = secondSet;
    }

    public void setThirdSet(Integer thirdSet) {
        this.thirdSet = thirdSet;
    }

    public void setFourthSet(Integer fourthSet) {
        this.fourthSet = fourthSet;
    }

    public void setFifthSet(Integer fifthSet) {
        this.fifthSet = fifthSet;
    }

    public void setSixthSet(Integer sixthSet) {
        this.sixthSet = sixthSet;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }
}
