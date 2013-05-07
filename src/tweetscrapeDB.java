/**
 * Author: Beau Bouchard
 * Date: 2013/04/02
 * Last Updated: 2013/05/06
 * Description: Used to access the database in the tweetscrape app.
 * 
 * 
 *  
 **/

import java.sql.*;

public class tweetscrapeDB 
{
   private tweetscrapeGUI tsGUI;
   private String prefix                  = "ts_"; // Prefix which is used before tables user and database names
	private String databaseName            = prefix + "storage"; //tweetscape_essentials 
	private String tweetTableName          = prefix + "tweet"; // 
   private String userTableName           = prefix + "user";
   private String scrapeTableName         = prefix + "scrape"; 
	
	private int Port = 3306; 
	private String databaseUserName;       // Database username
	private String databaseWriterUserName  = prefix + "writer"; // The common username for the inserter. 
	private String databaseReaderUserName  = prefix + "reader"; // Username which will check status of database
   
   private Connection conn; // database connection
	
   public tweetscrapeDB()
   {
	   
   }
	
	public tweetscrapeDB(tweetscrapeGUI inc_tsGUI) 
	{
		tsGUI = new tweetscrapeGUI("run");
		tsGUI = inc_tsGUI;
		
	
	}
	
   //prompt database Credentials 
   public boolean promptdbcreds()
   {
   
	   
	   return false;
   }
   
	public void createTables()
	{
		
	}
   
   //Create Tweet Database Table


   public void executeQuery()
   {

   }
   
   private Connection startConnection()
   {
      Connection conn = null;
      String url = "jdbc:mysql://localhost:3306/";
      String driver = "com.mysql.jdbc.Driver";
      String userName = "root";
      String password = "password";
      try 
      {
         Class.forName(driver).newInstance();
         conn = DriverManager.getConnection(url+databaseName,userName,password);
         System.out.println("Connected to the database");
         
         
         
      } 
      catch (SQLException qe) {
   		System.out.println("Connection Failed! Check output console");
   		qe.printStackTrace();
   		
	   }
      catch (Exception e) 
      {
         System.out.println("NO CONNECTION ");
      }
      
      return conn;
   }
   
   private void endConnection(Connection inc_conn)
   {
      try 
      {
         inc_conn.close();
         System.out.println("Disconnected from database");
      } 
      catch (SQLException qe) 
      {
         System.out.println("Connection Failed! Check output console");
         qe.printStackTrace();
      }
      catch (Exception e) 
      {
         System.out.println("NO CONNECTION ");
      }
   }

 
   public void createTweetDBT()
   {
   
   String creationQuery = "CREATE TABLE IF NOT EXISTS `"+tweetTableName+"` (" +
   		"`tweetid` int(11) NOT NULL AUTO_INCREMENT," +
   		"`scrapeid` int(11) NOT NULL," +
   		"`twitterid` int(11) NOT NULL," +
   		"`created_at` datetime NOT NULL," +
   		"`captured_at` datetime NOT NULL," +
   		"`text` varchar(160) NOT NULL," + 
   		"`geolocation` int(11) NOT NULL," +
   		"`latlong` point DEFAULT NULL," +
   		"`placeid` int(11) DEFAULT NULL," +
   		"`country` int(11) DEFAULT NULL," +
   		"`countryCode` int(11) DEFAULT NULL," +
   		"`fullname` int(11) DEFAULT NULL," +
   		"`place_lat` int(11) DEFAULT NULL," +
   		"`place_long` int(11) DEFAULT NULL," +
   		"`streetaddress` int(11) DEFAULT NULL," +
   		"`place_url` int(11) DEFAULT NULL," +
   		"`userlocationtext` int(11) DEFAULT NULL," +
   		"PRIMARY KEY (`tweetid`)" +
   		") ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;";
   }
   
   public void createUserDBT()
   {
   	
   
   }
	
	public void insertTweet()
	{
		
	}
	
	public boolean tablesCreated()
	{
		//check to see if the tables exist
		boolean checkresult = false;
		
		return checkresult; 
	}
	
}
