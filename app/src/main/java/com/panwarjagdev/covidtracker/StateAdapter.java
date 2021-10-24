package com.panwarjagdev.covidtracker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {
    private ArrayList<StateList> states;
    private Context context;

    public  StateAdapter(Context context,ArrayList<StateList> states){
        this.context=context;
        this.states=states;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statelviserow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       String curstate = states.get(position).getStates();
        holder.state.setText(curstate);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(context,statevise.class);
                in.putExtra("name",curstate);
                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView state;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            state=(TextView) itemView.findViewById(R.id.text1);


        }}
}
