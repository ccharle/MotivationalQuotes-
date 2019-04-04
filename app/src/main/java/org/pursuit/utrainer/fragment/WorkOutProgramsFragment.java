package org.pursuit.utrainer.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.utrainer.R;
import org.pursuit.utrainer.controller.WorkOutProgramsAdapter;
import org.pursuit.utrainer.model.WorkoutPrograms;

import java.util.ArrayList;
import java.util.List;


public class ProgramsFragment extends Fragment {
    private RecyclerView workOutRecyclerView;


    private static final String PROGRAM_NAME_PARAM = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String programName;
    private String mParam2;

    private RecyclerView getWorkOutRecyclerView;
    private WorkOutProgramsAdapter workOutProgramsAdapter;
    private List<WorkoutPrograms> workoutProgramsList = new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    public static ProgramsFragment newInstance(String workoutName) {
        ProgramsFragment fragment = new ProgramsFragment();
        Bundle args = new Bundle();
        args.putString(PROGRAM_NAME_PARAM, workoutName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            programName = getArguments().getString(PROGRAM_NAME_PARAM);
            mParam2 = getArguments().getString(ARG_PARAM2);*/
        WorkoutPrograms PHAT = new WorkoutPrograms("P.H.A.T");
        workoutProgramsList.add(PHAT);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_programs_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews(view);
        setUpRecyclerView();


    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }


    {

    }

    private void setUpRecyclerView() {

        workOutProgramsAdapter = new WorkOutProgramsAdapter(workoutProgramsList, mListener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        getWorkOutRecyclerView.setLayoutManager(layoutManager);
        getWorkOutRecyclerView.setAdapter(workOutProgramsAdapter);


    }



    private void setViews(View v) {
        getWorkOutRecyclerView = v.findViewById(R.id.workout_program_recylerview);

    }
    private void preLoadedPrograms() {
        WorkoutPrograms PHAT = new WorkoutPrograms("P.H.A.T");
        workoutProgramsList.add(PHAT);


    }

}
