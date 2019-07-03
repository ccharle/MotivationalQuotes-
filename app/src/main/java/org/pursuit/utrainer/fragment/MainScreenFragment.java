package org.pursuit.utrainer.fragment;

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
import org.pursuit.utrainer.controller.MainScreenAdapter;
import org.pursuit.utrainer.viewholder.MainViewHolder;

public class MainScreenFragment extends Fragment {
    private RecyclerView mainScreenRecyclerView;

    public MainScreenFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews(view);


    }


//    public MainScreenFragment newInstance(){
//        MainScreenFragment  mainScreenFragment = new MainScreenFragment();
//        Bundle args = new Bundle();
//
//
//
//
//
//
//    }
    private void setViews(View v){

         mainScreenRecyclerView = v.findViewById(R.id.main_recylcerview);
         setUpRecyclerView();
    }
    private void  setUpRecyclerView(){
        MainScreenAdapter mainScreenAdapter = new MainScreenAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mainScreenRecyclerView.setAdapter(mainScreenAdapter);
        mainScreenRecyclerView.setLayoutManager(linearLayoutManager);






    }
}
