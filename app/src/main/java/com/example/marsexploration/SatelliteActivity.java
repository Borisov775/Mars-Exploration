package com.example.marsexploration;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RequiresApi(api = Build.VERSION_CODES.O)
public class SatelliteActivity extends AppCompatActivity {
    ImageView st_image;
    TextView st_time,st_utc;
    private static final String TAG="MARSExploration App";
    private RecyclerView recyclerView2;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManagerSat;

    MyApplication myApplication= (MyApplication) this.getApplication();

    private static List<Satellite> satelliteList;

    MTC mtc=new MTC();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //satelliteList.addAll(Arrays.asList(new Satellite("Mars 2","1971","https://upload.wikimedia.org/wikipedia/commons/1/13/Mars3_iki.jpg","inactive","269 days","Lavochkin"),
        //        new Satellite("Mars 3","1971","https://upload.wikimedia.org/wikipedia/commons/1/13/Mars3_iki.jpg","inactive","264","Lavochkin")));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satellite2);
        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {

                            public void run() {
                                updateTextView1();
                                updateTextView2();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    //
                }
            }
        };
        t.start();
        satelliteList=myApplication.getSatelliteList();
        st_time=findViewById(R.id.st_mtcText);
        st_utc=findViewById(R.id.st_utcText);
        st_image=findViewById(R.id.SatellitesImage);
        Glide.with(SatelliteActivity.this).load("https://mars.nasa.gov/system/content_pages/main_images/366_mro20100917_PIA05490_modest.jpg").into(st_image);
        //Log.d(TAG,"onCreate"+satelliteList.toString());
        //Toast.makeText(this,"Satellites count "+satelliteList.size(),Toast.LENGTH_SHORT).show();
        recyclerView2=findViewById(R.id.recyclerViewSat);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setNestedScrollingEnabled(true);
        layoutManagerSat=new LinearLayoutManager(this);//I've created one
        recyclerView2.setLayoutManager(layoutManagerSat);
        mAdapter=new RecycleViewAdapterSat (satelliteList,SatelliteActivity.this);
        recyclerView2.setAdapter(mAdapter);
    }

    private void updateTextView1() {
        st_time.setText(MTC.CalculatingMTC(MTC.Msd()));
    }
    private void updateTextView2(){
        st_utc.setText(MTC.TimeManager());

    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Rover's section selected",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                Toast.makeText(this,"Satellites's section selected",Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(getApplicationContext(),SatelliteActivity.class);
                startActivity(intent2);
                return true;
            case R.id.item3:
                Toast.makeText(this,"Lander's section selected",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}