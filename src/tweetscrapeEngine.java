/**
 * Author: Beau Bouchard
 * Date: 2013/04/04
 * Last Updated: 2013/05/01
 * Description:  tweetscrapeEngine  - Class which will utilize Twitter4J 
 * Twitter4J from http://twitter4j.org/en/index.html Copyright 2007 Yusuke Yamamoto
 * 
 * 
 **/


import twitter4j.*;
import twitter4j.conf.*;

import java.util.*;


public class tweetscrapeEngine 
{
	private tweetscrapeGUI tsGUI;
	

	private String currentFilter = "";
	private String consumerKey = "";
	private String consumerSecret = "";
	private String authAccessToken = "";
	private String authAccessTokenSecret = "";

	
	public tweetscrapeEngine()
	{
		
	
	}
	
	public tweetscrapeEngine(tweetscrapeGUI inc_tsGUI) throws TwitterException
	{
		tsGUI = new tweetscrapeGUI("run");
		tsGUI = inc_tsGUI;
		
	}
	

	
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
	

	
		
	public boolean filterTweet(Status status)
	{
		boolean passfail = false;
		String p = getFilter();
		String message = status.getText();
		passfail = message.matches(getFilter());
		return passfail;
	}
	
	public void saveStatus(Status status)
	{
		tsGUI.outputText("@" + status.getUser().getScreenName() + " - " + status.getText());
		System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
	}
	
	public void startStreamSearch()
	{
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
	            		 saveStatus(status);
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
	                //System.out.println("Got stall warning:" + warning);
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
