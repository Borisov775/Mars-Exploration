package com.example.marsexploration;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.List;

import static com.example.marsexploration.R.id.RoverImage;
import static com.example.marsexploration.R.id.SatellitesImage;
import static com.example.marsexploration.R.id.satellite;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
    ImageView rv_image;
    TextClock rv_time;
    TextView time,rv_utc;
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
                                updateTextView1();
                                updateTextView2();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    //do nothing
                }
            }
        };

        t.start();
        time=findViewById(R.id.rv_mars_live);
        rv_utc=findViewById(R.id.rv_utc);
        roverList=myApplication.getRoverList();
        rv_image=findViewById(RoverImage);
        Glide.with(MainActivity.this).load("https://www.universetoday.com/wp-content/uploads/2012/01/PIA15277_3rovers-hi_D2011_1215_D511_br2.jpg").into(rv_image);
        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);
        //use a linear layout manager
        layoutManager=new LinearLayoutManager(this);//I've created one
        recyclerView.setLayoutManager(layoutManager);

        //specify an adapter
        mAdapter=new RecyclerViewAdapter(roverList,MainActivity.this);
        recyclerView.setAdapter(mAdapter);
    }

    private void updateTextView1() {

        time.setText(MTC.CalculatingMTC(MTC.Msd()));
    }
    private void updateTextView2(){
        rv_utc.setText(MTC.TimeManager());

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



