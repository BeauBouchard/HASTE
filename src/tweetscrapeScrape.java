/**
 * Author: Beau Bouchard
 * Date: 2013/04/04
 * Last Updated: 2013/05/10
 * Description: Each tweet entity will be linked to a scrape
 * 
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
