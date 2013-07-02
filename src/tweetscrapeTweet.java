/**
 * Author: Beau Bouchard
 * Date: 2013/04/04
 * Last Updated: 2013/07/01
 * Description: Used to store each tweet as object which will then be saved into database
 * 
 * ts_f_tweet
 * ts_f_user
 * ts_
 *  
 **/
import java.sql.*;
import java.text.SimpleDateFormat;

import twitter4j.*;
import twitter4j.conf.*;

public class tweetscrapeTweet {

   /*
    * 
    * 				`tweetid` ,
				`fk_sessionid` ,
				`fk_twitteruserid` ,
				`created_at` ,
				`captured_at` ,
				`text` ,
				`lat` ,
				`long`
    * */
    
	private int tweetid; //Unique
	private int fk_sessionid; //the id of the scrape
	private int fk_twitteruserid;
	private String created_at;
	private String captured_at; 
	private String text;
	private double lat;
	private double lon; 

	
	//Geolocation -- from obj class Geolocation
	private boolean geoLocation; //if true, there are lat long
   
	
	public tweetscrapeTweet()
	{
		
	
		
	}
	
	public tweetscrapeTweet(int inc_twitterID, String text)
	{
		
	
		
	}
	
	/**
	 * settweetid
	 * Description - used for setting the tweetID of object
	 * @param inc_tweetid - the ID of the tweet obj inside local database
	 */
	public void settweetid(int inc_tweetid)
	{
		tweetid = inc_tweetid;
	}
	
	
	/**
	 * setfk_twitteruserid
	 * Description - used for setting the twitterID of object
	 * @param inc_twitterID - Incomming ID which maps to twitter's Tweet ID
	 */
	public void settwitteruserid(int inc_twitterID)
	{
		fk_sessionid = inc_twitterID;
	}
	
	
	public void setcreated_at(java.util.Date date)
	{
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			 
		
		created_at = timeStamp;
	}
	
	public void setcaptured_at(String inc_value)
	{
		captured_at = inc_value;
	}
	
	/**
	 * settext
	 * Description - used for setting the text, or message of twitter post
	 * @param inc_twitterID - Incomming text from tweet
	 */
	public void settext(String inc_text)
	{
		text = inc_text;
	}
	
	public void setgeo(GeoLocation inc_geo)
	{
		setlat(inc_geo.getLatitude());
		setlon(inc_geo.getLongitude());
	}
	
	/**
	 * setlat
	 * Description - 
	 * @param lat - latitude of best guessed location
	 */
	public void setlat(double inc_lat)
	{
		lat = inc_lat;
		geoLocation = true;
	}
	
	/**
	 * setlon
	 * Description - 
	 * @param lon - longitude of best guessed location
	 */
	public void setlon(double inc_lon)
	{
		lon = inc_lon;
		geoLocation = true;
	}
	
	///GET GET GET 
	
	public int gettweetid()
	{
		return tweetid;
	}
	
	public int getsessionid()
	{
		return fk_sessionid;
	}
	
	public int gettwitteruserid()
	{
		return fk_twitteruserid;
	}
	
	public String gettext()
	{
		return text;
	}
	
	public String getcreated_at()
	{
		return created_at;
	}
	
	
	public String getcaptured_at()
	{
		return captured_at;
	}
	
	public boolean getgeoLocation()
	{
		return geoLocation;
	}
	
	public double getlat()
	{
		return lat;
	}
	public double getlon()
	{
		return lon;
	}

}
