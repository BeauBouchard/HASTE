/**
 * @author Beau Bouchard ( @beaubouchard )
 * Date: 2013/04/04
 * Last Updated: August 12th, 2014
 * <p>
 * Description: 
 * 
 *       ts_tweets, the main tweet object will have a many to one relationship with this (ts_twitteruser) many tweets which are all mapped to the same username. 
 *    It should be noted that there is a userDescription or the twitter user's bio, this is recorded once when the detector first times the first tweet from 
 *    a user not yet in the database thus creating a new entry. If the Bio changes, the changes will not be recorded at this time.  
 *  
 **/
import java.sql.*;

public class hasteUser {

	//User -- from obj class User
	private int userID;
   //private int uniqueTwitterID;
   private String screenName;
   private String userDescription;
   
   //ts_twitteruser
   //twitter_id
   //twitter_username
   //uniqueTwitterID
   //twitter_bio
   	
	public hasteUser()
	{
		
	
		
	}
	
	public hasteUser(int inc_userID, String inc_screenName)
	{
		
	
		
	}
   
   	
	/**
	 * setuserID
	 * Description - used for setting the userID of object
	 * @param inc_userID - the ID of the user obj inside local database
	 */
	public void setuserID(int inc_userID)
	{
		userID = inc_userID;
	}
   
   /**
	 * setscreenName
	 * Description - used for setting the screenName of object
	 * @param inc_screenName - Incomming String of the twitter user's username
	 */
	public void setscreenName(String inc_screenName)
	{
		screenName = inc_screenName;
	}
   /**
    * setuserDescription
    * Description - used for setting the userDescription of object, userDescription will be the twitter bio of user's profile at first tweet
    * @param inc_userDescription - Incomming string of the twitter user's bio
    */
   public void setuserDescription(String inc_userDescription)
   {
      userDescription = inc_userDescription;
   }
   
   
   
   
   
   /**
	 * getuserID
	 * Description - used for getting  the userID of object
	 * @return userID - the ID of the user obj inside local database
	 */
   public int getuserID()
   {
      return userID;
   }
   
   /**
	 * getscreenName
	 * Description - used for setting the screenName of object
	 * @return screenName - String of the twitter user's username
	 */
   public String getscreenName()
   {
      return screenName;
   }
   
   /**
    * getuserDescription
    * Description - userDescription will be the twitter bio of user's profile at first tweet
    * @return userDescription - string of the twitter user's bio
    */
   public String getuserDescription()
   {
      return userDescription;
   }
}
