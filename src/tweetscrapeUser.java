/**
 * Author: Beau Bouchard
 * Date: 2013/04/04
 * Last Updated: 2014/01/23
 * Description: 
 * 
 *       ts_tweets, the main tweet object will have a many to one relationship with this (ts_twitteruser) many tweets which are all mapped to the same username. 
 *    It should be noted that there is a userDescription or the twitter user's bio, this is recorded once when the detector first times the first tweet from 
 *    a user not yet in the database thus creating a new entry. If the Bio changes, the changes will not be recorded at this time.  
 *  
 **/
import java.sql.*;

public class tweetscrapeUser {

	//User -- from obj class User
	private long userID;
   //private int uniqueTwitterID;
   private String screenName;
   private String userDescription;
   
   //ts_twitteruser
   //twitter_id
   //twitter_username
   //twitter_bio
   
   

}
