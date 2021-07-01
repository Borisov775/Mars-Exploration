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

public class ActivityLander extends AppCompatActivity {
    List<Lander> landerList;
    ImageView ld_spec_image,ld_flag,ld_em,ld_nice;
    TextView ld_name2;
    PDFView pdfView;
    Button ld_web,ld_location,ld_doc,ld_imagesFunction;
    String id;
    MyApplication myApplication=(MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lander2);
        landerList=myApplication.getLanderList();
        ld_spec_image=findViewById(R.id.ld_spec_image);
        ld_web=findViewById(R.id.ld_web);
        ld_location=findViewById(R.id.ld_location);
        ld_doc=findViewById(R.id.ld_doc);
        ld_imagesFunction=findViewById(R.id.ld_imagesFunction);
        ld_name2=findViewById(R.id.ld_name2);
        ld_em=findViewById(R.id.ld_em);


        Intent intent=getIntent();
        intent.getData();
        id= intent.getStringExtra("name");
        for(Lander lander:landerList){
            if(lander.getName().equals(id)){
                Glide.with(ActivityLander.this).load(lander.getImageURL()).into(ld_spec_image);
                Glide.with(ActivityLander.this).load(lander.getEmblem()).into(ld_em);
                ld_web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebPage(lander.getPageURL());
                    }
                });
                ld_location.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebPage(lander.getOrbitDebris());
                    }
                });
                ld_doc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(v.getContext(),PdfActivity.class);
                        intent.putExtra("name",id);
                        startActivity(intent);
                    }
                });
                ld_imagesFunction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebPage(lander.getImagesData());
                    }
                });
                ld_name2.setText(lander.getName());
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

