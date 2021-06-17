package com.example.marsexploration;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplicationSat extends Application {
    public static List<Satellite> satelliteList=new ArrayList<Satellite>();
    public MyApplicationSat(){
        fillSatList();
    }
    private void fillSatList(){
        Satellite s1=new Satellite("Mars2","1971","https://upload.wikimedia.org/wikipedia/commons/1/13/Mars3_iki.jpg","inactive","269 days","Lavochkin");
        Satellite s2=new Satellite("Mars3","1971","https://upload.wikimedia.org/wikipedia/commons/1/13/Mars3_iki.jpg","inactive","264","Lavochkin");
        satelliteList.addAll(Arrays.asList(new Satellite[]{s1,s2}));
    }
    public static List<Satellite> getSatelliteList() {
        return satelliteList;
    }

    public static void setSatelliteList(List<Satellite> satelliteList) {
        MyApplicationSat.satelliteList = satelliteList;
    }
}
