/**
 * Author: Beau Bouchard
 * Date: 4/4/2013
 * Last Updated: 4/4/2013
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
	//used for testing
	public tweetscrapeEngine()
	{
		
	
	}
	public tweetscrapeEngine(tweetscrapeGUI inc_tsGUI) throws TwitterException
	{
		tsGUI = new tweetscrapeGUI();
		tsGUI = inc_tsGUI;
		
	}

	public ConfigurationBuilder getConfig()
	{
		ConfigurationBuilder configBuild = new ConfigurationBuilder();
		configBuild.setDebugEnabled(true)
		  .setOAuthConsumerKey("xxx")//Consumer key	xxx
		  .setOAuthConsumerSecret("xxx")//Consumer secret	xxx
		  .setOAuthAccessToken("xxx")//Access token
		  .setOAuthAccessTokenSecret("xxx");//Access token secret	
		return configBuild;
	}
	
	public String getFilter()
	{
		String pattern = ".*dog.*";  //##testing##
		return pattern;
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
