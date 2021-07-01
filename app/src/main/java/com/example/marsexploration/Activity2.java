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

public class Activity2 extends AppCompatActivity {
    List<Rover> roverLists;
    ImageView rv_spec_image,rv_flag,rv_em;
    TextView rv_name;
    PDFView pdfView;
    Button rv_web,rv_location,rv_doc,rv_imagesFunction;
    String id;
    MyApplication myApplication=(MyApplication) this.getApplication();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        roverLists=myApplication.getRoverList();
        rv_spec_image=findViewById(R.id.ld_spec_image);
        rv_web=findViewById(R.id.rv_web);
        rv_location=findViewById(R.id.rv_location);
        rv_doc=findViewById(R.id.rv_doc);
        rv_imagesFunction=findViewById(R.id.rv_imagesFunction);
        rv_flag=findViewById(R.id.rv_flag);
        rv_name=findViewById(R.id.ld_name2);
        rv_em=findViewById(R.id.ld_em);
        //pdfView.fromAsset("Mars Exploration Rover Press Kit.pdf").load();

        Intent intent=getIntent();
        intent.getData();
        id= intent.getStringExtra("name");
        for(Rover rover:roverLists){
            if(rover.getName().equals(id)){
                Glide.with(Activity2.this).load(rover.getImageURL()).into(rv_spec_image);
                Glide.with(Activity2.this).load(rover.getEmblem()).into(rv_em);
                rv_web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebPage(rover.getPageURL());
                    }
                });
                rv_location.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebPage(rover.getCurrentLocation());
                    }
                });
                rv_doc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(v.getContext(),PdfActivity.class);
                        intent.putExtra("name",id);
                        startActivity(intent);
                    }
                });
                rv_imagesFunction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebPage(rover.getImagesData());
                    }
                });
                rv_name.setText(rover.getName());
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
