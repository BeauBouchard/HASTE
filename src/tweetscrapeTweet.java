/**
 * Author: Beau Bouchard
 * Date: 2013/04/04
 * Last Updated: 2013/05/01
 * Description: Used to store each tweet as object which will then be saved into database
 * 
 * ts_f_tweet
 * ts_f_user
 * ts_
 *  
 **/
import java.sql.*;

public class tweetscrapeTweet {

   //
	private int tweetID; //Unique
	private int scrapeID; //the id of the scrape
	private long twitterID;
	private Date created_at;
	private Date captured_at; 
	private String text;

	
	//Geolocation -- from obj class Geolocation
	private boolean geoLocation; //if true, there are lat long
	private double latitude;
	private double longitude;
   
   
	//Place -- from obj class Place (as places change we will only have the place information stored with the tweet.)
	private String placeID;
	private String country;
	private String countryCode;
	private String fullName;
	private double place_lat;
	private double place_long;
	private String streetAddress;
	private String place_url;
   //User's Account's location infromation at time of tweet
   private String userLocationText;
	
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
