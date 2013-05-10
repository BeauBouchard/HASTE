tweetscrape
==========

Author: Beau Bouchard (@beaubouchard) 



Licence
---
tweetscape is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
tweetscape is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with tweetscape.  If not, see <http://www.gnu.org/licenses/>.
Also check out my personal website at <http://www.beaubouchard.com/tweetscape/>.
If you have questions about the usage of this application, or its upkeep, you can contact me personally and ask me about it: beau@beaubouchard.com or @beaubouchard.

Usage 
---


You will need to include the twitter4j class path into your Java Build Path inorder to run this applciation. 


Description
---
Tweetscrape is a small automated software system to connect twitter social media postings to a real natural hazard warnings issued from National Oceanic and Atmospheric Administration (NOAA). 
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

![Working Screenshot](http://www.beaubouchard.com/wpblog/wp-content/uploads/2013/05/example-1.png "Example of tweetscrape running")

