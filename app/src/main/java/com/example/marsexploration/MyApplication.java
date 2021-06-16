package com.example.marsexploration;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {
    public static List<Rover> roverList= new ArrayList<Rover>();
    public MyApplication(){
        fillRoverList();
    }
    private void fillRoverList(){
        Rover p1=new Rover("Sojourner(mis.Pathfinder)","1997","https://upload.wikimedia.org/wikipedia/commons/3/3a/Sojourner_on_Mars_PIA01122.jpg","inactive","85 days","NASA","https://mars.nasa.gov/MPF/index0.html",
                "https://trek.nasa.gov/mars/#v=0.1&x=-33.23796738688808&y=19.07996832584193&z=12&p=urn%3Aogc%3Adef%3Acrs%3AEPSG%3A%3A104905&d=&l=sojourner_hirise_mosaic%2Ctrue%2C1&locale=&b=mars&e=-33.317017449500426%2C19.017998569917808%2C-33.158917324275734%2C19.14193808176605&sfz=&w=","https://mars.nasa.gov/internal_resources/816/");
        Rover p2=new Rover("Spirit","2004","https://mars.nasa.gov/layout/mer/images/mars-exploration-rover.png","inactive","5 years 3 months 27 days","NASA","https://mars.nasa.gov/mars-exploration/missions/mars-exploration-rovers/","https://mars.nasa.gov/mer/mission/tm-spirit/images/MERA_Sol2555_1_br2.jpg",
                "https://trek.nasa.gov/mars/#v=0.1&x=175.52113447674097&y=-14.588121902048371&z=13&p=urn%3Aogc%3Adef%3Acrs%3AEPSG%3A%3A104905&d=&l=sojourner_hirise_mosaic%2Ctrue%2C1&l=spirit_hirise_mosaic%2Ctrue%2C1&locale=&b=mars&e=175.45521650922058%2C-14.619106780010432%2C175.58705244426136%2C-14.55713702408631&sfz=&w=");
        Rover p3=new Rover("Opportunity","2004","https://www.extremetech.com/wp-content/uploads/2016/01/Opportunity.jpg","inactive","15 years","NASA","https://mars.nasa.gov/mars-exploration/missions/mars-exploration-rovers/",
                "https://trek.nasa.gov/mars/#v=0.1&x=-5.322704344903439&y=-2.162648267684025&z=10&p=urn%3Aogc%3Adef%3Acrs%3AEPSG%3A%3A104905&d=&l=sojourner_hirise_mosaic%2Ctrue%2C1&l=spirit_hirise_mosaic%2Ctrue%2C1&l=opportunity_hirise_mosaic%2Ctrue%2C1&locale=&b=mars&e=-5.8500480850665975%2C-2.4105272913805096%2C-4.795360604740281%2C-1.9147692439875401&sfz=&w=","rfr");
        Rover p4=new Rover("Curiosity","2012","https://mars.nasa.gov/internal_resources/585","still operating","till present","NASA","https://mars.nasa.gov/mars-exploration/missions/mars-science-laboratory/",
                "https://mars.nasa.gov/maps/location/?mission=MSL&site=NOW&mapLon=137.45853420929052&mapLat=-4.643076522855421&mapZoom=12&globeLon=137.3978687&globeLat=-4.663687049999997&globeZoom=13&globeCamera=0,-1.4693679385278594e-32,0,0,1,0&panePercents=0,100,0&on=Current Position$1.00,Waypoints$1.00,Surface View$1.00,Rover Path$1.00,Labels$1.00,Basemap$1.00,Gale Crater Map$1.00","rfr");
        Rover p5=new Rover("Perseverance","2021","https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/Mars_2020_Rover_-_Artist%27s_Concept.png/1280px-Mars_2020_Rover_-_Artist%27s_Concept.png","still operating","till present","NASA","https://mars.nasa.gov/mars2020/spacecraft/rover/wheels/",
                "https://mars.nasa.gov/maps/location/?mission=M20&site=NOW&mapLon=77.45121001411464&mapLat=18.455185829239323&mapZoom=14&globeLon=77.42958068847659&globeLat=18.463327291058505&globeZoom=12&globeCamera=0,-4882.8125,0,0,1,0&panePercents=0,100,0&on=Current Position$1.00,Waypoints$1.00,Surface View$1.00,Landing Ellipse$1.00,Rover Path$1.00,Helicopter Flight Zone$1.00,Labels$1.00,Basemap$1.00,North East Syrtis Base Map$1.00&selected=Current Position,18.444160200000056,77.45221898000005&viewerImg=0","rfr");
        Rover p6=new Rover("Tianwen-1","2021","https://www.spacerobotics.eu/wp-content/uploads/2020/04/spacerobotics.eu_mars_martian_china_chinese_rover_9.png","still operating","till present","CNSA","https://en.wikipedia.org/wiki/Tianwen-1",
                "https://trek.nasa.gov/mars/#v=0.1&x=117.62753845757979&y=46.96638105244731&z=8&p=urn%3Aogc%3Adef%3Acrs%3AEPSG%3A%3A104905&d=&locale=&b=mars&e=115.51816349692716%2C45.974864957661374%2C119.73691341823242%2C47.95789714723325&sfz=&w=","rfr");
        roverList.addAll(Arrays.asList(new Rover[]{p1,p2,p3,p4,p5,p6}));
    }

    public static List<Rover> getRoverList() { return roverList;}

    public void setRoverList(List<Rover> roverList){

        MyApplication.roverList = roverList;
    }
}
