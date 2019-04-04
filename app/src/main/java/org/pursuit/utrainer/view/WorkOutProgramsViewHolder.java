package org.pursuit.utrainer.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.utrainer.R;

public class workOutProgramsViewHolder extends RecyclerView.ViewHolder {
    private TextView displayWorkoutProgram;
    private ImageView workOutIcon;

    public workOutProgramsViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    private void setViews() {

        displayWorkoutProgram = itemView.findViewById(R.id.workouts_textview);
        workOutIcon = itemView.findViewById(R.id.workout_icons);


    }
}
