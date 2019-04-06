package org.pursuit.utrainer.view;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.utrainer.R;
import org.pursuit.utrainer.database.UTrainerDatabase;
import org.pursuit.utrainer.database.UTrainerDatabase_Impl;
import org.pursuit.utrainer.database.WorkOutDatabase;
import org.pursuit.utrainer.model.ProgramsDetail;

public class WorkOutDatabaseViewHolder extends RecyclerView.ViewHolder {
    private TextView workoutNameTextView, workOutDetailTextview, firstSetTextView, secondSetTextView, thirdSetTextView;


    public WorkOutDatabaseViewHolder(@NonNull View itemView) {
        super(itemView);
        setViews();

    }

    public void onBindWorkout(ProgramsDetail programsDetail) {
        workoutNameTextView.setText(programsDetail.getWorkoutName());
        workOutDetailTextview.setText(programsDetail.getDescription());

    }

    public void setViews() {

        workoutNameTextView = itemView.findViewById(R.id.workout_name_textview);
        workOutDetailTextview = itemView.findViewById(R.id.workout_detail_textview);

    }
}
