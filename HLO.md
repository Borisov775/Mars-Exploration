# MARSExploration 

 Developers:

1. George Borisov
<h2>High-Level Overview</h2>
The main goal of this app is to provide detailed information of all missions have ever taken to Mars,
 it might use like a reference book for engineers and operators who's currently working for Mars mission, it will give the capability to track all spacecraft on Mars Map, see the documentation of each spacecraft, and make some notes referring to each spacecraft.  This app is a prototype of a smart reference book and assistant in common. Moreover,
it will give people the feeling of pride for human genius. And it will provide to be part of a big team of explorers which aims are simple - explore and find the answers.

<h2>Functional Details</h2>
Main window consists of:
<ul>
    <li>1. Toggle Bar - switch between types of spacecraft(probe,lander,rover,satellite)</li>
    <li>2. Main Layout Activity(RecycleView)</li>
    <li>3. Additional Data(MTC time, UTC time and etc)</li>
</ul>
<br>
Each item(spacecraft)in RecycleView will consist the following functions(buttons):
-<br> TRAVERSE MAP - explore the Mars' map to see the landing site(or current position on orbit).
-<br>VISIT THE SITE - expanding the site of a mission
-<br> DOCUMENTATION- expanding the press kit for a mission
-<br> IMAGES - Photos reffering to a mission
-<br> NOTE- make a note if you need to
<h2>Development</h2>
App is written on Java with using Gradle tools.The application platform is Android. Also there is connection to some API's, for example -Glide(for better working with Photo or Video),for better experience instead of using ListView I use the RecycleView, some interesting functions like MTC clock are also written in Java. All data will be stored in Global variables.
!During the development I may add more functions.
