package com.example.marsexploration;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.marsexploration.R.id.RoverImage;
import static com.example.marsexploration.R.id.time;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
    ImageView rv_image;
    TextClock rv_time;
    TextView time;
    private static final String TAG="MARSExploration App";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    MyApplication myApplication= (MyApplication) this.getApplication();
    static List<Rover>roverList;
    MTC mtc=new MTC();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateTextView();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    //
                }
            }
        };

        t.start();
        time=findViewById(R.id.rv_mars_live);
        roverList=myApplication.getRoverList();
        rv_image=findViewById(RoverImage);
        Glide.with(MainActivity.this).load("https://www.universetoday.com/wp-content/uploads/2012/01/PIA15277_3rovers-hi_D2011_1215_D511_br2.jpg").into(rv_image);
        System.out.println(roverList.size());
        Log.d(TAG,"onCreate"+roverList.toString());
        Toast.makeText(this,"Rovers count "+roverList.size(),Toast.LENGTH_SHORT).show();
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setNestedScrollingEnabled(true);
        layoutManager=new LinearLayoutManager(this);//I've created one
        recyclerView.setLayoutManager(layoutManager);

        mAdapter=new RecyclerViewAdapter(roverList,MainActivity.this);
        recyclerView.setAdapter(mAdapter);
    }

    private void updateTextView() {
        time.setText(MTC.CalculatingMTC(MTC.Msd()));
    }

}



