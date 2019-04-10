package org.pursuit.utrainer.view;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.pursuit.utrainer.R;
import org.pursuit.utrainer.database.UTrainerDatabase;
import org.pursuit.utrainer.database.UTrainerDatabase_Impl;
import org.pursuit.utrainer.database.WorkOutDatabase;
import org.pursuit.utrainer.model.ProgramsDetail;

public class ProgramDetailsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView workoutNameTextView, workOutDetailTextview, firstSetTextView, weightSetTextView, thirdSetTextView;
    private Button increaseButton, decreasebutton;
    private int counter = 50;

    public ProgramDetailsViewHolder(@NonNull View itemView) {
        super(itemView);
        setViews();

    }

    public void onBindWorkout(ProgramsDetail programsDetail) {
        workoutNameTextView.setText(programsDetail.getWorkoutName());
        workOutDetailTextview.setText(programsDetail.getDescription());
        weightSetTextView.setText(String.valueOf(counter));


    }

    public void setViews() {

        workoutNameTextView = itemView.findViewById(R.id.workout_name_textview);
        workOutDetailTextview = itemView.findViewById(R.id.workout_detail_textview);
        weightSetTextView = itemView.findViewById(R.id.weight_textview);
        increaseButton = itemView.findViewById(R.id.increase_weight_button);
        increaseButton.setOnClickListener(this::onClick);
        decreasebutton = itemView.findViewById(R.id.decrease_weight_button);
        decreasebutton.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.increase_weight_button: {
                counter++;
                weightSetTextView.setText(String.valueOf(counter));

                break;
            }
            case R.id.decrease_weight_button: {
                counter--;
                weightSetTextView.setText(String.valueOf(counter));
                break;

            }

        }
    }

}
