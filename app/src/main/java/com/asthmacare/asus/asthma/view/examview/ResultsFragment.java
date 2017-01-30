package com.asthmacare.asus.asthma.view.examview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asthmacare.asus.asthma.R;
import com.asthmacare.asus.asthma.adapters.AllResultsAdapter;
import com.asthmacare.asus.asthma.model.Results.Result;
import com.asthmacare.asus.asthma.presenter.allresultpresenter.AllResultPresenter;

import java.util.ArrayList;


public class ResultsFragment extends Fragment {
    private String id;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_all);



        Bundle bundle = this.getArguments();
        if (bundle != null) {
             id = bundle.getString("id","id");
            Log.d("POIUY",id);
        }



        // AllResultPresenter allResultPresenter = new AllResultPresenter(id,ResultsFragment.this);



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
       // super.onViewCreated(view, savedInstanceState);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(linearLayoutManager);
        AllResultPresenter allResultPresenter = new AllResultPresenter(id,ResultsFragment.this);



    }

    public void showAllResult(ArrayList<Result> allResultResponses) {
        recyclerView.setAdapter(new AllResultsAdapter(this, allResultResponses));
    }
}
