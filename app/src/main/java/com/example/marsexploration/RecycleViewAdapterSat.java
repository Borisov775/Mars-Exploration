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

public class RecycleViewAdapterSat extends RecyclerView.Adapter<RecycleViewAdapterSat.MyViewHolder2> {
    List<Satellite> satelliteList;
    Context context;
    public RecycleViewAdapterSat(List<Satellite> satelliteList, Context context){

        this.satelliteList=satelliteList;
        this.context=context;
    }


    @NonNull

    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_one_list_of_added_elements2,parent,false);
        MyViewHolder2 holder=new MyViewHolder2(view);
        return holder;
    }




    public void onBindViewHolder(@NonNull  MyViewHolder2 holder, int position) {
        holder.st_name.setText(satelliteList.get(position).getName());
        holder.st_operator.setText(satelliteList.get(position).getOperator());
        holder.st_duration.setText(satelliteList.get(position).getDurationOfMission());
        holder.st_mode.setText(satelliteList.get(position).getMode());
        holder.st_dateOfArriving.setText(satelliteList.get(position).getDateOfLanding());
        Glide.with(this.context).load(satelliteList.get(position).getImageURL()).override(600,400).into(holder.st_image);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,Activity2.class);
                intent.putExtra("name",satelliteList.get(position).getName());
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return satelliteList.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        ImageView st_image;
        TextView st_name;
        TextView st_dateOfArriving;
        TextView st_mode;
        TextView st_duration;
        TextView st_operator;
        ConstraintLayout constraintLayout;

        public MyViewHolder2(@NonNull  View itemView) {
            super(itemView);
            st_image= itemView.findViewById(R.id.st_image);
            st_name=itemView.findViewById(R.id.st_name);
            st_dateOfArriving=itemView.findViewById(R.id.st_DateOfLanding);
            st_mode=itemView.findViewById(R.id.st_mode);
            st_duration=itemView.findViewById(R.id.st_duration);
            st_operator=itemView.findViewById(R.id.st_operator);
            constraintLayout=itemView.findViewById(R.id.SatelliteLayout);
        }
    }

}
