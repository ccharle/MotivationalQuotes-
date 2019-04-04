package org.pursuit.utrainer.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.utrainer.R;
import org.pursuit.utrainer.fragment.ProgramDetailsFragment;
import org.pursuit.utrainer.fragment.WorkOutProgramsFragment;
import org.pursuit.utrainer.model.WorkoutPrograms;
import org.pursuit.utrainer.view.WorkOutProgramsViewHolder;

import java.util.List;

public class WorkOutProgramsAdapter extends RecyclerView.Adapter<WorkOutProgramsViewHolder> {

    private List<WorkoutPrograms> workoutProgramsList;
    private WorkOutProgramsFragment.OnFragmentInteractionListener onFragmentInteractionListener;
;

    public WorkOutProgramsAdapter(List<WorkoutPrograms> workoutProgramsList, WorkOutProgramsFragment.OnFragmentInteractionListener onFragmentInteractionListener) {
        this.workoutProgramsList = workoutProgramsList;
        this.onFragmentInteractionListener = onFragmentInteractionListener; ;
    }

    @NonNull
    @Override

    public WorkOutProgramsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.workoutprogram_itemview, viewGroup, false);
        return new WorkOutProgramsViewHolder(childView,onFragmentInteractionListener);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkOutProgramsViewHolder workOutProgramsViewHolder, int i) {
        WorkoutPrograms workoutPrograms = workoutProgramsList.get(i);
        workOutProgramsViewHolder.onBind(workoutPrograms);

    }

    @Override
    public int getItemCount() {
        return workoutProgramsList.size();
    }


}
