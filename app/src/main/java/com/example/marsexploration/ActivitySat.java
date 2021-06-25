package com.example.marsexploration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;

import java.util.List;

public class ActivitySat extends AppCompatActivity {
    List<Satellite> satelliteList;
    ImageView st_spec_image,st_flag,st_em;
    TextView st_name2;
    PDFView pdfView;
    Button st_web,st_location,st_doc,st_imagesFunction;
    String id;
    MyApplication myApplication=(MyApplication) this.getApplication();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sat);
        satelliteList=myApplication.getSatelliteList();
        st_spec_image=findViewById(R.id.st_spec_image);
        st_web=findViewById(R.id.st_web);
        st_location=findViewById(R.id.st_location);
        st_doc=findViewById(R.id.st_doc);
        st_imagesFunction=findViewById(R.id.st_imagesFunction);
        st_flag=findViewById(R.id.st_flag);
        st_name2=findViewById(R.id.st_name2);
        st_em=findViewById(R.id.st_em);


        Intent intent=getIntent();
        intent.getData();
        id= intent.getStringExtra("name");
        for(Satellite satellite:satelliteList){
            if(satellite.getName().equals(id)){
                Glide.with(ActivitySat.this).load(satellite.getImageURL()).into(st_spec_image);
                Glide.with(ActivitySat.this).load(satellite.getEmblem()).into(st_em);
                st_web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebPage(satellite.getPageURL());
                    }
                });
                st_location.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebPage(satellite.getCurrentLocation());
                    }
                });
                st_doc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(v.getContext(),PdfActivity.class);
                        intent.putExtra("name",id);
                        startActivity(intent);
                    }
                });
                st_imagesFunction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       openWebPage(satellite.getImagesData());
                    }
                });
                st_name2.setText(satellite.getName());
            }
        }

    }
    private void openWebPage(String url){
        Uri webpage= Uri.parse(url);
        Intent intent =new Intent(Intent.ACTION_VIEW,webpage);
        startActivity(intent);
        startActivity(intent);
    }
}