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
import android.widget.TextView;

import org.pursuit.utrainer.R;
import org.pursuit.utrainer.controller.ProgramDetailsAdapter;
import org.pursuit.utrainer.model.ProgramsDetail;
import org.pursuit.utrainer.view.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class DisplayWorkOutFragment extends Fragment {

    private static final String WORKOUT_PARAM = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView workoutNameTextView, workOutDetailTextview, firstSetTextView, weightTextView, thirdSetTextView;

    private String getWorkoutParam;
    private String mParam2;
    private RecyclerView getWorkOutRecyclerView;
    private ProgramDetailsAdapter programDetailsAdapter;
    private WorkOutProgramsFragment.OnFragmentInteractionListener myListener;
    private OnProgramFragmentInteractionListener mListener;
    private List<ProgramsDetail> programsDetailList = new ArrayList<>();
    private String workoutDescription;


    public DisplayWorkOutFragment() {
        // Required empty public constructor
    }


    public static DisplayWorkOutFragment newInstance(String workout) {
        DisplayWorkOutFragment fragment = new DisplayWorkOutFragment();
        Bundle args = new Bundle();
        args.putString(WORKOUT_PARAM, workout);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            getWorkoutParam = getArguments().getString(WORKOUT_PARAM);

            switch (getWorkoutParam) {

                case "P.H.A.T": {
                    getPHAT();
                    break;

                }
                case "P.H.U.L": {

                    getPHUL();
                    break;
                }


            }
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.workout_db_fraglayout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews(view);
        setUpRecyclerView();
    }


   /* public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction();
        }
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        workoutDescription = getActivity().getResources().getString(R.string.reps);
        if (context instanceof OnProgramFragmentInteractionListener) {
            mListener = (OnProgramFragmentInteractionListener) context;

        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnProgramFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnProgramFragmentInteractionListener {
        void onFragmentInteraction();
    }

    private void setUpRecyclerView() {

        programDetailsAdapter = new ProgramDetailsAdapter(programsDetailList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        getWorkOutRecyclerView.setLayoutManager(layoutManager);
        getWorkOutRecyclerView.setAdapter(programDetailsAdapter);


    }


    private void setViews(View v) {
        getWorkOutRecyclerView = v.findViewById(R.id.program_details_recylerview);
        workoutNameTextView = v.findViewById(R.id.workout_name_textview);
        workOutDetailTextview = v.findViewById(R.id.workout_detail_textview);
        weightTextView = v.findViewById(R.id.weight_textview);

    }

    public void getPHAT() {
        ProgramsDetail programsDetail = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.barbell_row), 5);
        ProgramsDetail programsDetail2 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.pull_up), 5);
        ProgramsDetail programsDetail3 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.seated_cable_row), 5);
        ProgramsDetail programsDetail4 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.flat_dumbell_press), 5);
        ProgramsDetail programsDetail5 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.dips), 5);
        ProgramsDetail programsDetail6 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.seated_dumbell_shoulder_press), 5);
        ProgramsDetail programsDetail7 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.barbell_curl), 5);
        ProgramsDetail programsDetail8 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.skullcrushers), 5);
        programsDetailList.add(programsDetail);
        programsDetailList.add(programsDetail2);
        programsDetailList.add(programsDetail3);
        programsDetailList.add(programsDetail4);
        programsDetailList.add(programsDetail5);
        programsDetailList.add(programsDetail6);
        programsDetailList.add(programsDetail7);
        programsDetailList.add(programsDetail8);
    }

    public void getPHUL() {
        ProgramsDetail programsDetail = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.barbell_bench_press), 5);
        ProgramsDetail programsDetail2 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.flat_dumbell_press), 5);
        ProgramsDetail programsDetail3 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.bent_over_row), 5);
        ProgramsDetail programsDetail4 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.lat_pulldown), 5);
        ProgramsDetail programsDetail5 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.overhead_press), 5);
        ProgramsDetail programsDetail6 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.barbell_curl), 5);
        ProgramsDetail programsDetail7 = new ProgramsDetail(workoutDescription, getActivity().getResources().getString(R.string.skullcrushers), 5);
        programsDetailList.add(programsDetail);
        programsDetailList.add(programsDetail2);
        programsDetailList.add(programsDetail3);
        programsDetailList.add(programsDetail4);
        programsDetailList.add(programsDetail5);
        programsDetailList.add(programsDetail6);
        programsDetailList.add(programsDetail7);


    }

}
