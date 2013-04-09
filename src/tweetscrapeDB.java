/**
 * Author: Beau Bouchard
 * Date: 4/2/2013
 * Last Updated: 4/4/2013
 * Description: Used to access the database in the tweetscrape app.
 * 
 * 
 *  
 **/



public class tweetscrapeDB 
{
	private String databaseName; //
	private String tweetTableName; // tweetscape_
	private String prefix = "ts_"; // Prefix which is used before tables user and database names
	private int Port = 3306; 
	private String databaseUserName; // Database username root
	private String databaseWriterUserName = "writer"; // The common username for the inserter. 
	private String databaseReaderUserName = "reader"; // Username which will check status of database
	
	
	
	public tweetscrapeDB() 
	{
		
	}
	
	public void createTables()
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