package org.pursuit.utrainer.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.utrainer.R;
import org.pursuit.utrainer.fragment.ProgramDetailsFragment;
import org.pursuit.utrainer.fragment.WorkOutProgramsFragment;
import org.pursuit.utrainer.model.ProgramsDetail;
import org.pursuit.utrainer.view.ProgramDetailsViewHolder;
import org.pursuit.utrainer.view.WorkOutProgramsViewHolder;

import java.util.List;

public class ProgramDetailsAdapter extends RecyclerView.Adapter<ProgramDetailsViewHolder> {
    private List<ProgramsDetail> programsDetailList;

    public ProgramDetailsAdapter(List<ProgramsDetail> programsDetailList) {
        this.programsDetailList = programsDetailList;
    }

    @NonNull
    @Override
    public ProgramDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.programs_detail_itemview, viewGroup, false);
        return new ProgramDetailsViewHolder(childView);
    }


    @Override
    public void onBindViewHolder(@NonNull ProgramDetailsViewHolder programDetailsViewHolder, int i) {

    }


    @Override
    public int getItemCount() {
        return programsDetailList.size();
    }
}
