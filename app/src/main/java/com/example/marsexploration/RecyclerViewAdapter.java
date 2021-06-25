package com.example.marsexploration;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Objects;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    List<Rover>roverList;
    Context context;

    public RecyclerViewAdapter(List<Rover> roverList, Context context) {
        this.roverList = roverList;
        this.context = context;
    }

    public RecyclerViewAdapter(List<Rover> roverList) {

    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_one_list_of_added_elements,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.ed_name.setText(roverList.get(position).getName());
        holder.ed_operator.setText(roverList.get(position).getOperator());
        holder.ed_duration.setText(roverList.get(position).getDurationOfMission());
        holder.ed_mode.setText(roverList.get(position).getMode());
        holder.ed_dateOfLanding.setText(roverList.get(position).getDateOfLanding());
        Glide.with(this.context).load(roverList.get(position).getImageURL()).override(600,400).into(holder.ed_rv_image);
        Glide.with(this.context).load(roverList.get(position).getFlag()).into(holder.rv_flag);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,Activity2.class);
                intent.putExtra("name",roverList.get(position).getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return roverList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ed_rv_image;
        ImageView rv_flag;
        TextView ed_name;
        TextView ed_dateOfLanding;
        TextView ed_mode;
        TextView ed_duration;
        TextView ed_operator;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            ed_rv_image= itemView.findViewById(R.id.ed_rv_image);
            rv_flag=itemView.findViewById(R.id.rv_flag);
            ed_name=itemView.findViewById(R.id.ed_name);
            ed_dateOfLanding=itemView.findViewById(R.id.ed_DateOfLanding);
            ed_mode=itemView.findViewById(R.id.ed_mode);
            ed_duration=itemView.findViewById(R.id.ed_duration);
            ed_operator=itemView.findViewById(R.id.ed_operator);
            constraintLayout=itemView.findViewById(R.id.oneLineRoverLayout);
        }
    }


}
