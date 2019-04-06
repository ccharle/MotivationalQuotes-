
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
    private String workOutName;
    private String workOutDescription;
    @PrimaryKey
    @NonNull
    private String bodyWorked;

    public String getWorkOutName() {
        return workOutName;
    }

    public void setWorkOutName(String workOutName) {
        this.workOutName = workOutName;
    }

    public void setWorkOutDescription(String workOutDescription) {
        this.workOutDescription = workOutDescription;
    }

    public void setBodyWorked(@NonNull String bodyWorked) {
        this.bodyWorked = bodyWorked;
    }

    public String getWorkOutDescription() {
        return workOutDescription;
    }

    @NonNull
    public String getBodyWorked() {
        return bodyWorked;
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
        public List<WorkOutDatabase> getWorkOutName();


    }
}
