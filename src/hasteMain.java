/**
 * Author: Beau Bouchard ( @beauboucahrd )
 * Date: 2013/04/04
 * Last Updated: August 12th, 2014
 * Description: Main class for the haste app. 
 * 
 * This file is part of haste. It is dependent on one or more other codebases, such as Twitter4J by @yusuke
 * 
 * haste is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * haste is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with haste.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Also check out my personal website at <http://www.beaubouchard.com/>.
 * 
 * If you have questions about the usage of this application, or its upkeep, you can contact me personally and ask me about it: beau@beaubouchard.com or @beaubouchard.
 * 
 * 
 * Description of haste: haste is a simple GUI programmed in Java (compatable java-7-openjdk-amd64) 
 * to access twitter's Rest API for simple scraping. The haste will load tweet information into a postgres database
 *  
 */

import twitter4j.*;

public class hasteMain
{
	public static void main(String [] args )
	{
		//hasteDB tsDB = new hasteDB();  // connection to the database 
		hasteGUI tsGUI = new hasteGUI(); // passing the database to newly created GUI
		tsGUI.initializeGUI(); // initialize 
	}
}// end of main class
