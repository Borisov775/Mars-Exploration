package com.example.marsexploration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity extends AppCompatActivity {
    PDFView pdfView1;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_activity);
        pdfView1=findViewById(R.id.pdf_activity);
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
        }


    }
}