package com.panwarjagdev.covidtracker;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Covid> covid;
    Context context;

    public Adapter(ArrayList<Covid> covid, Context context) {
        this.covid = covid;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mainactivityrow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String distname=covid.get(position).getDist();
        holder.dist.setText(distname);
        holder.recovered.setText("Recovered: "+covid.get(position).getRecovered());
        holder.deceased.setText("Deceased: "+covid.get(position).getDeceased());
        holder.active.setText("Active: "+covid.get(position).getActive());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(context,DataActivity.class);
                in.putExtra("distname",distname);
                context.startActivity(in);
            }
        });


    }

    @Override
    public int getItemCount() {
        return covid.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView dist;
        public TextView active;
        public TextView recovered;
        public TextView deceased;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dist=(TextView) itemView.findViewById(R.id.state);
            active=(TextView) itemView.findViewById(R.id.total);
            recovered=(TextView) itemView.findViewById(R.id.recovered);
            deceased=(TextView) itemView.findViewById(R.id.deceased);
        }
    }
}
