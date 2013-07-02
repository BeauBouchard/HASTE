/**
 * Author: Beau Bouchard
 * Date: 4/4/2013
 * Last Updated: 7/1/2013
 * Description:  tweetscrapeEngine  - Class which will utilize Twitter4J 
 * Twitter4J from http://twitter4j.org/en/index.html Copyright 2007 Yusuke Yamamoto
 * 
 * 
 **/


import twitter4j.*;
import twitter4j.conf.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class tweetscrapeEngine 
{
	private tweetscrapeGUI tsGUI;
	private tweetscrapeDB tsDB;

	private String currentFilter = ".*?(tornado|twister).*";
	private String consumerKey = "";
	private String consumerSecret = "";
	private String authAccessToken = "";
	private String authAccessTokenSecret = "";
	//filter object?
	//demo filter "^.*\b(tornado|twister|hail)\b.*$"
	//.*?(tornado|twister|hail).*
	
	private Pattern pattern;
	private Matcher matcher;
	private boolean filterisset = false;
	private boolean keysareset = false;
	
	public tweetscrapeEngine()
	{
		
	
	}
	
	public tweetscrapeEngine(tweetscrapeGUI inc_tsGUI) throws TwitterException
	{
		tsGUI = new tweetscrapeGUI("run");
		tsGUI = inc_tsGUI;
		
		 try
			{
				tsDB = new tweetscrapeDB(tsGUI);
			}
			catch(Exception tw)
			{
				
			}
		
	}
	
	/* Mutators/setters */ 
	public void setFilter(String inc_filtervalue){
		currentFilter = inc_filtervalue;
	}
	
	public void setconsumerKey(String inc_value)
	{
		consumerKey = inc_value;
	}
	public void setconsumerSecret(String inc_value)
	{
		consumerSecret = inc_value;
	}
	public void setauthAccessToken(String inc_value)
	{
		authAccessToken = inc_value;
	}
	public void setauthAccessTokenSecret(String inc_value)
	{
		authAccessTokenSecret = inc_value;
	}
	
	public void setKeysareset(boolean inc_value)
	{
		keysareset = inc_value;
	}
	
	public void setFilterisset(boolean inc_value)
	{
		filterisset = inc_value;
	}
	
	/* Accessors/getters */ 
	public String getFilter()
	{
		return currentFilter;
	}
	
	public String getconsumerKey()
	{
		return consumerKey;
	}
	
	public String getconsumerSecret()
	{
		return consumerSecret;
	}
	
	public String getauthAccessToken()
	{
		return authAccessToken;
	}
	
	public String getauthAccessTokenSecret()
	{
		return authAccessTokenSecret;
	}
	
	public boolean getKeysareset()
	{
		return keysareset;
	}
	
	public boolean getFilterisset()
	{
		return filterisset;
	}
	
	
	public ConfigurationBuilder getConfig()
	{
		ConfigurationBuilder configBuild = new ConfigurationBuilder();
		configBuild.setDebugEnabled(true)
		  .setOAuthConsumerKey(getconsumerKey())
		  .setOAuthConsumerSecret(getconsumerSecret())
		  .setOAuthAccessToken(getauthAccessToken())
		  .setOAuthAccessTokenSecret(getauthAccessTokenSecret());
		return configBuild;
	}
	
	public void configureFilter()
	{
		if(!filterisset)
		{
			tsGUI.outputText("Setting up Filter");
			pattern = Pattern.compile(getFilter(), Pattern.CASE_INSENSITIVE);
			filterisset = true;
			tsGUI.outputText("New REGEX filter: " + getFilter() );
		}
		else {
			//filter already set, now resetting filter
			filterisset = true;
		}
		
	}
	

	
		
	public boolean filterTweet(Status status)
	{
		boolean passfail = false;
		String p = getFilter();
		String message = status.getText();
		//passfail 
		if(filterisset)
		{
			matcher = pattern.matcher(message);
			passfail = matcher.matches();
			//System.out.println("match");
		}
		else if(!filterisset)
		{
			//filter not set
			System.out.println("Filter is not set");
		}
		else
		{
			//error
		}
		
		return passfail;
	}
	
	public void startDatabase()
	{
		
		tsDB.startDatabase();
	}
	
	/**
	 * returns a string which is formated as yyyy-MM-dd HH:mm:ss
	 * @return timeStamp - a string of the date and time, formated as yyyy-MM-dd HH:mm:ss
	 */
	public String getTimeStamp()
	{
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		return timeStamp; 
	}
	
	public void saveStatus(Status status)
	{
		tweetscrapeTweet tstobj = new tweetscrapeTweet();
		tstobj.settext(status.getText());
		tstobj.setcreated_at(status.getCreatedAt());
		tstobj.setcaptured_at(getTimeStamp());
		if(status.getGeoLocation() != null) {tstobj.setgeo(status.getGeoLocation());}
		
		tsDB.insertTweet(tstobj);
		
		
		//save to new tweet object?
	}
	
	public void startStreamSearch()
	{
		if(!filterisset)
		{
			configureFilter();
		}
		tsGUI.outputText("Engine online");
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb = getConfig();
		
		//TwitterFactory tf = new TwitterFactory(cb.build());
		//Twitter twitter = tf.getInstance();
		
	       TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
	        StatusListener listener = new StatusListener() {
	            @Override
	            public void onStatus(Status status) {
	            	//
	            	 if(filterTweet(status))
	            	 { 
	            		 
	            		 tsGUI.outputText(status.getText() + " - " + "@" + status.getUser().getScreenName()  );
	            		// System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
	            		 saveStatus(status);
	            	 }
	            	 else{
	            		// System.out.print("nope");
	            	 }
	            }

	            @Override
	            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
	                //System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
	            }

	            @Override
	            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
	               // System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
	            }

	            @Override
	            public void onScrubGeo(long userId, long upToStatusId) {
	                //System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
	            }

	            @Override
	            public void onStallWarning(StallWarning warning) {
	                System.out.println("Got stall warning:" + warning);
	            }

	            @Override
	            public void onException(Exception ex) {
	                //ex.printStackTrace();
	            }
	    };
	    

        twitterStream.addListener(listener);
        // sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
        twitterStream.sample();
	}

}
