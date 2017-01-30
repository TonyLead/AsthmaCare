package com.asthmacare.asus.asthma.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asthmacare.asus.asthma.R;
import com.asthmacare.asus.asthma.model.Results.Result;
import com.asthmacare.asus.asthma.view.examview.examview.ExamFragment;

import java.util.ArrayList;

/**
 * Created by Tony on 13.01.2017.
 */

public class LastResultsAdapter extends RecyclerView.Adapter<LastResultsAdapter.ViewHolder> {

    private ArrayList<Result> results;
    private ExamFragment examFragment;
    private CardView v;

    public LastResultsAdapter(ExamFragment mExamFragment, ArrayList<Result> mResults) {
        this.examFragment = mExamFragment;
        this.results = mResults;
    }


    @Override
    public LastResultsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_result,parent,false);
        return new LastResultsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String date = results.get(position).getDate();
        String percent = results.get(position).getPercent();
        String cathegory =  results.get(position).getCathegory();
        if(results.get(position).getCathegory().equals("красный")){
            cathegory = "Красная";
            v.setCardBackgroundColor(Color.rgb(229,28,35));
        }else if(results.get(position).getCathegory().equals("зелёный")){
            cathegory = "Зеленая";
            v.setCardBackgroundColor(Color.rgb(10,126,7));
        } else if(results.get(position).getCathegory().equals("желтый")){
            cathegory = "Желтая";
            v.setCardBackgroundColor(Color.rgb(255,215,64));
        }


        holder.percentTextView.setText("Значение: " + percent);
        holder.cathegoryTextView.setText("Зона: " + cathegory);
        holder.dateTextView.setText(date);
    }


    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dateTextView;
        public TextView percentTextView;
        public TextView cathegoryTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            dateTextView = (TextView) itemView.findViewById(R.id.time_tv);
            percentTextView = (TextView) itemView.findViewById(R.id.percent_tv);
            cathegoryTextView = (TextView) itemView.findViewById(R.id.cathegory_tv);
        }
    }
}