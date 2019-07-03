
package org.pursuit.utrainer.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "workout")

public class WorkOutDatabase {
    private String exerciseName;
    private Integer weight;
    private Integer lastCompleted;
    @PrimaryKey
    @NonNull
    private String workOutName;

    public String getExerciseName() {
        return exerciseName;
    }

    public void setLastCompleted(Integer lastCompleted) {
        this.lastCompleted = lastCompleted;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setWorkOutName(@NonNull String workOutName) {
        this.workOutName = workOutName;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getLastCompleted() {
        return lastCompleted;
    }

    @NonNull
    public String getWorkOutName() {
        return workOutName;
    }

    @Dao
    public interface WorkoutDAO {

        @Insert
        void Insert(WorkOutDatabase workOutDatabase);

        @Update
        void update(WorkOutDatabase workOutDatabase);

        @Delete
        void delete(WorkOutDatabase workOutDatabase);

        @Query("SELECT * FROM  workout")
        List<WorkOutDatabase> getWorkOutName();


    }
}
