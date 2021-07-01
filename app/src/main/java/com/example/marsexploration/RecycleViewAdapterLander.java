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

public class RecycleViewAdapterLander extends RecyclerView.Adapter<RecycleViewAdapterLander.MyViewHolder2>{
    List<Lander> landerList;
    Context context;
    public RecycleViewAdapterLander(List<Lander> landerList,Context context){
        this.landerList=landerList;
        this.context=context;
    }
    @NonNull

    @Override
    public RecycleViewAdapterLander.MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_one_list_of_added_elements3,parent,false);
        RecycleViewAdapterLander.MyViewHolder2 holder=new RecycleViewAdapterLander.MyViewHolder2(view);
        return holder;
    }




    public void onBindViewHolder(@NonNull RecycleViewAdapterLander.MyViewHolder2 holder, int position) {
        holder.ld_name.setText(landerList.get(position).getName());
        holder.ld_operator.setText(landerList.get(position).getOperator());
        holder.ld_duration.setText(landerList.get(position).getDurationOfMission());
        holder.ld_mode.setText(landerList.get(position).getMode());
        holder.ld_dateOfArriving.setText(landerList.get(position).getDateOfArriving());
        Glide.with(this.context).load(landerList.get(position).getImageURL()).override(600,400).into(holder.ld_image);
        Glide.with(this.context).load(landerList.get(position).getFlag()).into(holder.ld_flag);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,ActivityLander.class);
                intent.putExtra("name",landerList.get(position).getName());
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return landerList.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        ImageView ld_image;
        ImageView ld_flag;
        TextView ld_name;
        TextView ld_dateOfArriving;
        TextView ld_mode;
        TextView ld_duration;
        TextView ld_operator;
        ConstraintLayout constraintLayout;

        public MyViewHolder2(@NonNull  View itemView) {
            super(itemView);
            ld_image= itemView.findViewById(R.id.ld_image);
            ld_flag=itemView.findViewById(R.id.ld_flag);
            ld_name=itemView.findViewById(R.id.ld_name);
            ld_dateOfArriving=itemView.findViewById(R.id.ld_DateOfLanding);
            ld_mode=itemView.findViewById(R.id.ld_mode);
            ld_duration=itemView.findViewById(R.id.ld_duration);
            ld_operator=itemView.findViewById(R.id.ld_operator);
            constraintLayout=itemView.findViewById(R.id.LanderLayout);
        }
    }
}
