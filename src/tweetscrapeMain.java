/**
 * Author: Beau Bouchard ( @beauboucahrd )
 * Date: 2013/04/04
 * Last Updated: 2014/01/23
 * Description: Main class for the tweetscape app. 
 * 
 * This file is part of tweetscape. It is dependant on one or more other codebases, 
 * such as Twitter4J by @yusuke
 * 
 * tweetscape is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * tweetscape is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with tweetscape.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Also check out my personal website at <http://www.beaubouchard.com/tweetscape/>.
 * 
 * If you have questions about the usage of this application, or its upkeep, you can contact me personally and ask me about it: beau@beaubouchard.com or @beaubouchard.
 * 
 * 
 * Description of tweetscape: tweetscape is a simple GUI programmed in Java (compatable java-7-openjdk-amd64) 
 * to access twitter's Rest API for simple scraping. The tweetscrape will load tweet information into a postgres database
 *  
 */

import twitter4j.*;

public class tweetscrapeMain
{
	public static void main(String [] args )
	{
		//tweetscrapeDB tsDB = new tweetscrapeDB();  // connection to the database 
		tweetscrapeGUI tsGUI = new tweetscrapeGUI(); // passing the database to newly created GUI
		tsGUI.initializeGUI(); // initialize 
	}
}// end of main class
