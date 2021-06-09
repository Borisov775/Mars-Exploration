package com.example.marsexploration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;


import java.util.List;

public class Activity2 extends AppCompatActivity {
    List<Rover> roverLists;
    ImageView rv_spec_image;
    PDFView pdfView;
    Button rv_web,rv_location,rv_doc;
    String id;
    MyApplication myApplication=(MyApplication) this.getApplication();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        roverLists=myApplication.getRoverList();
        rv_spec_image=findViewById(R.id.rv_spec_image);
        rv_web=findViewById(R.id.rv_web);
        rv_location=findViewById(R.id.rv_location);
        rv_doc=findViewById(R.id.rv_doc);
        pdfView=findViewById(R.id.pdf_viewer);

        pdfView.fromAsset("Press-Kit Pathfinder.pdf").load();

        Intent intent=getIntent();
        intent.getData();
        id= intent.getStringExtra("name");
        for(Rover rover:roverLists){
            if(rover.getName().equals(id)){
                Glide.with(Activity2.this).load(rover.getImageURL()).into(rv_spec_image);
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
