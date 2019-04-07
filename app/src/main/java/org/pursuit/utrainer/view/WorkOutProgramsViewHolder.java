package org.pursuit.utrainer.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.utrainer.R;
import org.pursuit.utrainer.fragment.WorkOutProgramsFragment;
import org.pursuit.utrainer.model.ProgramsDetail;
import org.pursuit.utrainer.model.WorkoutPrograms;

import java.util.ArrayList;
import java.util.List;

public class WorkOutProgramsViewHolder extends RecyclerView.ViewHolder {
    private TextView workoutsTextView;
    private WorkOutProgramsFragment.OnFragmentInteractionListener onFragmentInteractionListener;


    public WorkOutProgramsViewHolder(@NonNull final View itemView, WorkOutProgramsFragment.OnFragmentInteractionListener onFragmentInteractionListener) {
        super(itemView);
        this.onFragmentInteractionListener = onFragmentInteractionListener;
        setViews();



    }

    private void setViews() {

        workoutsTextView = itemView.findViewById(R.id.workoutprogram_textview);


    }


    public void onBind(WorkoutPrograms workoutPrograms) {
        workoutsTextView.setText(workoutPrograms.getProgramTitle());

        itemView.setOnClickListener(v -> {
            String workOut = workoutsTextView.getText().toString();
            onFragmentInteractionListener.onFragmentInteraction(workOut);


        });



    }



}
