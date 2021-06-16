package com.example.marsexploration;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;

public class MTC {
    @RequiresApi(api = Build.VERSION_CODES.O)
    strictfp public static double Msd(){
        BigDecimal UnixEpoch = new BigDecimal(Instant.now().toEpochMilli());

        //JdUt-convert milliseconds to Julian Date
        double JdUt=2440587.5+(UnixEpoch.doubleValue()/8.64E7);

        //JdTt-Julian Date , Actually 37+32.184 is Terrestrial Time
        double JdTt=JdUt+(37+32.184)/86400;

        double t2000=JdTt-2451545.0;

        //msd(mars sol day) -is running count of sols since 29,1873
        double msd=(((t2000-4.5)/1.027491252)+44796.0-0.00096);
        return msd;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String TimeManager(){
        OffsetDateTime now=OffsetDateTime.now();
        String Hh=String.valueOf(now.getHour());
        String Mm=String.valueOf(now.getMinute());
        String Ss=String.valueOf(now.getSecond());
        if(now.getHour()<10){
            Hh="0"+Hh;
        }
        else if(now.getSecond()<10){
            Ss="0"+Ss;
        }
        else if(now.getMinute()<10){
            Mm="0"+Mm;
        }
        return Hh + ":" + Mm + ":" + Ss;

    }
    strictfp public static String CalculatingMTC(double msd){
        double f_h =msd%1;
        Double hh=Math.floor(24*f_h);
        double f_m=(24*f_h)%1;
        Double mm=Math.floor(60*f_m);
        Double ss=60*((60*f_m)%1);
        int ss1=ss.intValue();
        String Hh=String.valueOf(hh.intValue());
        String Mm=String.valueOf(mm.intValue());
        String Ss=String.valueOf(ss.intValue());
        if(hh.intValue()<10){
            Hh="0"+Hh;
        }
        else if(ss.intValue()<10){
            Ss="0"+Ss;
        }
        else if(mm.intValue()<10){
            Mm="0"+Mm;
        }
        return Hh + ":" + Mm + ":" + Ss;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    strictfp public String MtcTime(){
        return CalculatingMTC(Msd());
    }

}
