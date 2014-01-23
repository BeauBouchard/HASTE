/**
 * Author: Beau Bouchard ( @beauboucahrd )
 * Date: 2013/04/04
 * Last Updated: 2014/01/23
 * Description: 
 
 *          Each tweet entity will be linked to a scrape, a scrape is a time frame in which the tweetscrape application is 
 *    recording tweets using a specific filter, the searchREGEX is that regular expression filter. 
 * 
 *  
 **/
import java.util.*;
import java.text.SimpleDateFormat;

public class tweetscrapeScrape {
	private int scrapeID;
	private Date start_at; 
	private Date stop_at; 
	private String searchREGEX;
	private int filterID;
	
	public tweetscrapeScrape()
	{
	}
	
	public tweetscrapeScrape(int inc_scrapeID, Date inc_start)
	{
		scrapeID = inc_scrapeID;
		start_at = inc_start; 
	}
	
   
   /**
    * setscrapeID
    * Description - used to set the unique ID of the scrape object, for refference in the local database
    * @param inc_scrapeID - the incomming scrapeID to be set
    */
    public void setscrapeID(int inc_scrapeID)
    {
      scrapeID = inc_scrapeID;
    }
    
    /**
     * setStart
     * Description - used to set the start_at value, the time in which the scrape was started.
     * @param inc_start_at -  the incomming start_at value 
     */
	public void setStart(Date inc_start)
	{
		start_at = inc_start;
	}
	
	public void setStop(Date inc_stop)
	{
		stop_at = inc_stop;
	}
	
	public void setsearchREGEX(String inc_searchREGEX)
	{
		searchREGEX = inc_searchREGEX;
	}
	
	public Date getStart()
	{
		return start_at;
	}
	
	public String getStarttoString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String start = sdf.format(start_at);
		
		return start;
	}	
	
	public Date getStop()
	{
		return stop_at;
	}
	
	public String getStoptoString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String stop = sdf.format(stop_at);
		
		return stop;
	}
	
	public String getsearchREGEX()
	{
		return searchREGEX;
	}

}
