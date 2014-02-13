Hazardous Alert System for Twitter Environment (HASTE)
==========

Author: Beau Bouchard (@beaubouchard) 



Usage 
---

# sh bin/run.sh

You will need to include the twitter4j class path into your Java Build Path inorder to run this applciation. 


Description
---
Hazardous Alert System for Twitter Environment, HASTE is a small automated software system to connect twitter social media postings to a real natural hazard warnings issued from National Oceanic and Atmospheric Administration (NOAA). 
This simple GUI programmed in Java (compatable java-7-openjdk-amd64) to access twitter'es streaming API to gather tweets specific to one of the listed Hazard/Disasters:
 * Tornado
 * Hurricane
 * Severe Thunderstorm
 * Flash Flood
 * Flood
 * Winter Storm
 * Special Marine
 * Non Precipitation
 * Tsunami
 * Space Weather

Other custom filters can be added through regular expressions. The saved tweets are stored in a MySql database for later anaysis. 


###UML Diagram###
![Basic Database UML](bin/documentation/media/img/umldiagram0001.png "UML Diagram")


###Architecture Diagram###
![Basic System Architecture](bin/documentation/media/img/architecturev0001.png "Architecture Diagram")

###Demo Screenshot###
![Working Screenshot](http://www.beaubouchard.com/wpblog/wp-content/uploads/2013/05/example-1.png "Example of HASTE running")

