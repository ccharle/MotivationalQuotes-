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
import org.pursuit.utrainer.controller.ProgramDetailsAdapter;
import org.pursuit.utrainer.model.ProgramsDetail;

import java.util.ArrayList;
import java.util.List;


public class ProgramDetailsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private RecyclerView getWorkOutRecyclerView;
    private ProgramDetailsAdapter programDetailsAdapter;
    private WorkOutProgramsFragment.OnFragmentInteractionListener myListener;
    private OnProgramFragmentInteractionListener mListener;
    private List<ProgramsDetail> programsDetailList = new ArrayList<>();
    private String repsDetail = String.valueOf(R.string.reps);

    public ProgramDetailsFragment() {
        // Required empty public constructor
    }


    public static ProgramDetailsFragment newInstance() {
        ProgramDetailsFragment fragment = new ProgramDetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        ProgramsDetail programsDetail = new ProgramsDetail(repsDetail, "Barbell");
        programsDetailList.add(programsDetail);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.program_details_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews(view);
        setUpRecyclerView();
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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

    }
}
