/**
 * Author: Beau Bouchard
 * Date: 2013/04/04
 * Last Updated: 2014/01/23
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
	
	/**
    * setcreated_at
    * Description - set created_at with a timestamp. this is used as the time tweet was created on twitter
    * @param date - Incomming date to be used for the created_at Timestamp, 
    */
	public void setcreated_at(java.util.Date date)
	{
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			 
		
		created_at = timeStamp;
	}
	
   /**
    * setcaptured_at
    * Description - sets capture time, a string is used to keep the captured at time, this is computed when tweet is accepted, and stored as a string
    * @param inc_value - the incomming captured timestamp, stored in a string
    */
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
	
   /**
    * setgeo
    * Description - used for setting lat and lon of the tweets location. 
    * @param inc_geo - Incomming geolocation object, which is broken down into the latitude and longitude points of the tweets location. 
    */
	public void setgeo(GeoLocation inc_geo)
	{
		setlat(inc_geo.getLatitude());
		setlon(inc_geo.getLongitude());
      geoLocation = true;
	}
	
	/**
	 * setlat
	 * Description - used for setting the latitude of the best guessed location for the tweet
	 * @param lat - decimal degree format latitude of best guessed location
	 */
	public void setlat(double inc_lat)
	{
		lat = inc_lat;
		geoLocation = true;
	}
	
	/**
	 * setlon
	 * Description -  used for setting the longitude of the best guessed location for the tweet 
	 * @param lon - decimal degree format longitude of best guessed location
	 */
	public void setlon(double inc_lon)
	{
		lon = inc_lon;
		geoLocation = true;
	}
	
	///GET GET GET 
   
	/**
    * gettweetid
    * Description - used for getting  tweetid,
    * @return tweetid - the ID of the tweet in the local database
    *
    */
	public int gettweetid()
	{
		return tweetid;
	}
   
	/**
    * getsessionid
    * Description - used for getting  fk_sessionid,  a foreignkey and also  the id of the session, or collection of tweets this tweet belongs to in the local database
    * @return fk_sessionid - the id of the session, or collection of tweets this tweet belongs to in the local database
    *
    */
	public int getsessionid()
	{
		return fk_sessionid;
	}
   
	/**
    * gettwitteruserid
    * Description - used for getting  fk_twitteruserid, a foreignkey and also the ID of the twitter user's username in the local database
    * @return gettwitteruserid - the ID of the twitter user's username in the local database
    *
    */
	public int gettwitteruserid()
	{
		return fk_twitteruserid;
	}
	
	/**
    * gettext
    * Description - used for getting the text, or message of twitter post
    * @return text - a string which stores the message of twitter post
    *
    */
	public String gettext()
	{
		return text;
	}
	
	/**
    * getcreated_at
    * Description - used for getting created_at, the time which the tweet was created and saved to twitter
    * @return created_at - a string which represents the time which the tweet was created and saved to twitter
    *
    */
	public String getcreated_at()
	{
		return created_at;
	}
	
	/**
    * getcaptured_at
    * Description - used for getting captured_at, the time which the tweetscrape application saved the tweet from twitter
    * @return captured_at - a string which represents the time which the tweetscrape application saved the tweet from twitter
    *
    */
	public String getcaptured_at()
	{
		return captured_at;
	}
   
	/**
    * getgeoLocation
    * Description - returns a  geolocation object, which is broken down into the latitude and longitude points of the tweets location.
    * @return geoLocation -  geolocation object, which is broken down into the latitude and longitude points of the tweets location.
    */
	public boolean getgeoLocation()
	{
		return geoLocation;
	}
	
   /**
    * getlat
    * Description - returns decimal degree format latitude of best guessed location
    * @return lat - decimal degree format latitude of best guessed location
    */
	public double getlat()
	{
		return lat;
	}
   
   /**
    * getlon
    * Description - returns a decimal degree format longitude of best guessed location for tweet
    * @return lon - decimal degree format longitude of best guessed location
    */
	public double getlon()
	{
		return lon;
	}

}
