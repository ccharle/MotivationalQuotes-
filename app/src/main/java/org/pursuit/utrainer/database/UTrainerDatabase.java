package org.pursuit.utrainer.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import org.pursuit.utrainer.model.WorkoutPrograms;

@Database(entities = {WorkOutDatabase.class}, version = 1, exportSchema = false)

public abstract class UTrainerDatabase extends RoomDatabase {

    private static UTrainerDatabase uTrainerDatabaseInstance;

    public static UTrainerDatabase getInstance(Context context) {
        if (uTrainerDatabaseInstance == null) {
            uTrainerDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    UTrainerDatabase.class,
                    "UtrainerDatabase")
                    .build();


        }
        return uTrainerDatabaseInstance;


    }

    public static void destroyInstance() {
        uTrainerDatabaseInstance = null;
    }


    public abstract WorkOutDatabase.WorkoutDAO WorkoutPostDAO();


    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
