/**
 * Author: Beau Bouchard
 * Date: 4/4/2013
 * Last Updated: 4/4/2013
 * Description: Used to store each tweet as object which will then be saved into database
 * 
 * 
 *  
 **/
import java.sql.*;

public class tweetscrapeTweet {
	private int tweetID;
	private long twitterID;
	private Date created_at; 
	private String text;

	//User -- from obj class User
	private long userID;
	//User -- from obj class User
	private long userID;
	private String screenName;
	private String userlocationString
	//Geolocation -- from obj class Geolocation
	private boolean geoLocation; //if true, there are lat long
	private double latitude;
	private double longitude;
	//Place -- from obj class Place
	private String placeID;
	private String country;
	private String countryCode;
	private String fullName;
	private String place_lat;
	private String place_long;
	private String streetAddress;
	private String place_url;
	
	public tweetscrapeTweet()
	{
		
	
		
	}
	
	public tweetscrapeTweet(long inc_twitterID, String text)
	{
		
	
		
	}
	
	/**
	 * settweetID
	 * Description - used for setting the tweetID of object
	 * @param inc_tweetID - the ID of the tweet obj inside local database
	 */
	public void settweetID(int inc_tweetID)
	{
		tweetID = inc_tweetID;
	}
	/**
	 * settwitterID
	 * Description - used for setting the twitterID of object
	 * @param inc_twitterID - Incomming ID which maps to twitter's Tweet ID
	 */
	public void settwitterID(long inc_twitterID)
	{
		twitterID = inc_twitterID;
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
	

}
