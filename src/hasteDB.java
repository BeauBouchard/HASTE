/**
 * @author Beau Bouchard ( @beaubouchard )
 * Date: 2013/04/04
 * Last Updated: August 12th, 2014
 * <p>
 * Description: Used to access the database in the haste app.
 * 
 * 
 **/

import java.sql.*;

public class hasteDB 
{
	private hasteGUI tsGUI;
	private String prefix				= "ts_"; // Prefix which is used before tables user and database names
	private String databaseName			= "hasteapp"; //tweetscape_essentials 
	private String tweetTableName		= prefix + "tweet"; // 
	private String userTableName		= prefix + "user";
	private String scrapeTableName		= prefix + "scrape"; 
   
   
	
	private String databaseUserName;       // Database username
	private String databasePassword;
	private String databaseAddress = "jdbc:mysql://localhost";	//jdbc:mysql://localhost:3306/hasteapp
	private String databasePort = "3306";
	private String databaseWriterUserName  = prefix + "writer"; // The common username for the inserter. 
	private String databaseReaderUserName  = prefix + "reader"; // Username which will check status of database
   
   private Connection conn; // database connection
	
   public hasteDB()
   {
	   
   }
	
	public hasteDB(hasteGUI inc_tsGUI) 
	{
		tsGUI = new hasteGUI("run");
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
 
      
      String url = databaseAddress+":"+databasePort+"/"+databaseName; //jdbc:mysql://localhost:3306/databasename
      String driver = "com.mysql.jdbc.Driver";
      String userName = "user"; // replace with username of db writer
      String password = "xxx"; // replace xxx with password
      try 
      {
         Class.forName(driver).newInstance();
         conn = DriverManager.getConnection("xxx",userName,password); //jdbc:mysql://localhost:3306/databasename
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
	
   /*
    * insertTweet
    * 
    * inserts/saves the tweet to the database
    * 
    * @param inc_tweetobj A hasteTweet object which contains text, latitude, longitude and other information to be saved to the database
    * @return 
    */
	public String insertTweet( hasteTweet inc_tweetobj)
	{
		String returnvarstring = "started, init";
		hasteTweet tweet = inc_tweetobj;
		
		String tweet_statement = "";
		if(inc_tweetobj.getgeoLocation())
		{
			tweet_statement = "INSERT INTO  `ts_tweet` VALUES" + "(NULL , NULL , NULL,?,?,?,?,?)";
			try{
				PreparedStatement tweet_prest = conn.prepareStatement(tweet_statement);
		        tweet_prest.setString(1, inc_tweetobj.getcreated_at()+"");
		        tweet_prest.setString(2, inc_tweetobj.getcaptured_at()+"");
		        tweet_prest.setString(3, inc_tweetobj.gettext()+"");
		        tweet_prest.setDouble(4, inc_tweetobj.getlat());
		        tweet_prest.setDouble(5, inc_tweetobj.getlon());
		        
		        try{
					tweet_prest.executeUpdate();
				}
				catch( Exception e){
					
					System.out.println(e.getMessage());
				}
		        
			}
			catch( Exception e){
				System.out.println(e.getMessage());
			}
		}
		else
		{
			try{
				tweet_statement = "INSERT INTO  `ts_tweet` VALUES" + "(NULL , NULL , NULL,?,?,?)";
				PreparedStatement tweet_prest = conn.prepareStatement(tweet_statement);
		        tweet_prest.setString(1, inc_tweetobj.getcreated_at()+"");
		        tweet_prest.setString(2, inc_tweetobj.getcaptured_at()+"");
		        tweet_prest.setString(3, inc_tweetobj.gettext()+"");
		        
		        try{
					tweet_prest.executeUpdate();
				}
				catch( Exception e){
					
					System.out.println(e.getMessage());
				}
			}
			catch( Exception e){}
		}
		

		
		return returnvarstring;
		
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
