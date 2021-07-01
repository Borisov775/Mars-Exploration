package com.example.marsexploration;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
@RequiresApi(api = Build.VERSION_CODES.O)
public class LanderActivity extends AppCompatActivity {
    ImageView ld_image;
    TextView ld_time,ld_utc;
    private static final String TAG="MARSExploration App";
    private RecyclerView recyclerView3;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManagerSat;

    MyApplication myApplication= (MyApplication) this.getApplication();

    private static List<Lander> landerList;
    MTC mtc=new MTC();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lander);
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
        landerList=myApplication.getLanderList();
        ld_time=findViewById(R.id.ld_mtcText);
        ld_utc=findViewById(R.id.ld_utcText);
        ld_image=findViewById(R.id.LanderImage);
        Glide.with(LanderActivity.this).load("https://mars.nasa.gov/system/content_pages/main_images/383_phoenix-lander.jpg").into(ld_image);
        recyclerView3=findViewById(R.id.recyclerViewLd);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setNestedScrollingEnabled(true);
        LinearLayoutManager layoutManagerLd = new LinearLayoutManager(this);//I've created one
        recyclerView3.setLayoutManager(layoutManagerLd);
        mAdapter=new RecycleViewAdapterLander (landerList,LanderActivity.this);
        recyclerView3.setAdapter(mAdapter);
    }

    private void updateTextView1() {

        ld_time.setText(MTC.CalculatingMTC(MTC.Msd()));
    }
    private void updateTextView2(){
        ld_utc.setText(MTC.TimeManager());

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
                Intent intent3=new Intent(getApplicationContext(),LanderActivity.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
