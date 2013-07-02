/**
 * Author: Beau Bouchard
 * Date: 4/2/2013
 * Last Updated: 7/1/2013
 * Description: Used to access the database in the tweetscrape app.
 * 
 * 
 *  
 **/

import java.sql.*;

public class tweetscrapeDB 
{
	private tweetscrapeGUI tsGUI;
	private String prefix				= "ts_"; // Prefix which is used before tables user and database names
	private String databaseName			= "tweetscrapeapp"; //tweetscape_essentials 
	private String tweetTableName		= prefix + "tweet"; // 
	private String userTableName		= prefix + "user";
	private String scrapeTableName		= prefix + "scrape"; 
   
   
	
	private String databaseUserName;       // Database username
	private String databasePassword;
	private String databaseAddress = "jdbc:mysql://localhost";	//jdbc:mysql://localhost:3306/tweetscrapeapp
	private String databasePort = "3306";
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
	
	public void setDatabaseUsername(String inc_string)
	{
		databaseUserName = inc_string;
	
	}
	
	public void setDatabasePassword(String inc_string)
	{
		databasePassword = inc_string;
	}
	
	public void setDatabaseAddress(String inc_string)
	{
		databaseAddress = inc_string;
	}
	
	public void setDatabasePort(String inc_string)
	{
		databasePort = inc_string;
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
   
   public void startDatabase()
   {
	    startConnection();
	    
	   
   }
   private void startConnection()
   {
 
      //jdbc:mysql://localhost:3306/tweetscrapeapp
      String url = databaseAddress+":"+databasePort+"/"+databaseName;
      String driver = "com.mysql.jdbc.Driver";
      String userName = "root";
      String password = "lol like i am putting that here :P";
      try 
      {
         Class.forName(driver).newInstance();
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tweetscrapeapp",userName,password);
         System.out.println("Connected to the database");
      } 
      catch (SQLException qe) {
   		System.out.println("Connection Failed! Check output console");
   		qe.printStackTrace();
   		
	   }
      catch (Exception e) 
      {
         System.out.println("NO CONNECTION  "+ e.getMessage());
         e.printStackTrace();
      }
      
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
   
	   //ZyRDvcZ4AWAGGNW4
   String creationQuery = "";
   }
	
	public void insertTweet( tweetscrapeTweet inc_tweetobj)
	{
		tweetscrapeTweet tweet = inc_tweetobj;
		PreparedStatement tweet_prest = null;
		String tweet_statement = "";
		if(inc_tweetobj.getgeoLocation())
		{
			tweet_statement = "INSERT INTO  `ts_tweet` VALUES" + "(NULL , NULL , NULL,?,?,?,?,?)";
			try{
		        tweet_prest = conn.prepareStatement(tweet_statement);
		        tweet_prest.setString(1, inc_tweetobj.getcreated_at()+"");
		        tweet_prest.setString(2, inc_tweetobj.getcaptured_at()+"");
		        tweet_prest.setString(3, inc_tweetobj.gettext()+"");
		        tweet_prest.setDouble(4, inc_tweetobj.getlat());
		        tweet_prest.setDouble(5, inc_tweetobj.getlon());
		        
			}
			catch( Exception e){}
		}
		else
		{
			try{
				tweet_statement = "INSERT INTO  `ts_tweet` VALUES" + "(NULL , NULL , NULL,?,?,?)";
		        tweet_prest = conn.prepareStatement(tweet_statement);
		        tweet_prest.setString(1, inc_tweetobj.getcreated_at()+"");
		        tweet_prest.setString(2, inc_tweetobj.getcaptured_at()+"");
		        tweet_prest.setString(3, inc_tweetobj.gettext()+"");
			}
			catch( Exception e){}
		}
		

		try{
			tweet_prest.executeUpdate();
		}
		catch( Exception e){
			
			System.out.println(e.getMessage());
		}
      
		
		/* (

				)
				VALUES (
				NULL , NULL , NULL ,  '2013-07-01 16:29:43',  '2013-07-01 16:29:43',  'tornado here, lol check this tyweet out, demo tweet do not use #demo',  '40.7619',  '-73.9763'
				);*/
	}
	
	public boolean tablesCreated()
	{
		//check to see if the tables exist
		boolean checkresult = false;
		
		return checkresult; 
	}
	
}
