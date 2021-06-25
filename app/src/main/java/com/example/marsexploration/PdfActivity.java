package com.example.marsexploration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity extends AppCompatActivity {
    PDFView pdfView1;
    Button notes;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_activity);
        pdfView1=findViewById(R.id.pdf_activity);
        notes=findViewById(R.id.note_activity);
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),Notes.class);
                startActivity(intent);
            }
        });
        Intent intent=getIntent();
        intent.getData();
        id= intent.getStringExtra("name");
        switch (id){
            case "Sojourner(mis.Pathfinder)":
                pdfView1.fromAsset("Press-Kit Pathfinder.pdf")
                        .load();
                break;
            case "Spirit":
            case "Opportunity":
                pdfView1.fromAsset("Mars Exploration Rover Press Kit.pdf")
                        .load();
                break;
            case "Curiosity":
                pdfView1.fromAsset("MSLLanding Press Kit.pdf")
                        .load();
                break;
            case "Perseverance":
                pdfView1.fromAsset("Perseverance Press KIt.pdf")
                        .load();
                break;
            case "Tianwen-1":
                pdfView1.fromAsset("Tianwen1 Press Kit.pdf")
                        .load();
                break;
            case "Mars 2":
            case "Mars 3":
                pdfView1.fromAsset("SovietExp.pdf")
                        .load();
                break;
            case "Mariner 9":
                pdfView1.fromAsset("MarinerDoc.pdf")
                        .load();
                break;
            case "Viking(1,2)":
                pdfView1.fromAsset("19760019036.pdf")
                        .load();
                break;
            case "Mars Global Surveyor":
                pdfView1.fromAsset("mgsarriv.pdf")
                        .load();
                break;
            case "2001 Mars Odyssey":
                pdfView1.fromAsset("odysseyarrival1.pdf")
                        .load();
            case "Mars Express":
                pdfView1.fromAsset("SCHMIDT2.pdf")
                        .load();
            case "Mars Reconnaissance Orbiter":
                pdfView1.fromAsset("mro-arrival.pdf")
                        .load();
            case "MAVEN":
                pdfView1.fromAsset("MAVEN.pdf")
                        .load();
            case "ExoMars 2016 Mission":
                pdfView1.fromAsset("ExoM26.pdf")
                        .load();
        }
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),Notes.class);
                startActivity(intent);
            }
        });



    }
}