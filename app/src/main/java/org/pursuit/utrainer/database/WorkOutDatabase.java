
package org.pursuit.utrainer;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.support.annotation.NonNull;

import org.pursuit.utrainer.fragment.ProgramDetailsFragment;
import org.pursuit.utrainer.model.ProgramsDetail;
import org.pursuit.utrainer.model.WorkoutPrograms;

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
        void Insert(ProgramsDetail programsDetail);

        @Update
        void update(ProgramsDetail programsDetail);

        @Delete
        void delete(ProgramsDetail programsDetail);

        @Query("SELECT * FROM  workout")
        public List<WorkOutDatabase> getWorkOutName();




    }
}
