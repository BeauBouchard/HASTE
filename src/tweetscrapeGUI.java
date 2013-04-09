
/**
 * Author: Beau Bouchard
 * Date: January 21st, 2013
 * Last Updated: 4/4/2013
 * Description: GUI class for the tweetscape app. 
 * 
 * 
 *  
 */



import java.io.*;
import java.net.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Color.*;

public class tweetscrapeGUI extends JFrame implements ActionListener 
{
	


  
	// Initializing connection parameters
	private Socket client;
	private Socket server;
	static final int PORT = 8873;
	public ArrayList connections; // public variable for listed connections, remove when server/client is removed
	
	// Initializing Menu Variables for top dropdown.
	private JMenuItem exit 		= new JMenuItem("Exit",KeyEvent.VK_X); 				//Exit, with x as the mnemonic
	private JMenuItem about 	= new JMenuItem("About",KeyEvent.VK_A); 			//About, with A as the mnemonic
	private JMenuItem stop		= new JMenuItem("Stop Scraper",KeyEvent.VK_Z); 		//Clear, with C as the mnemonic
	private JMenuItem start 	= new JMenuItem("Start Scraper",KeyEvent.VK_S); 	//Start, with S as the mnemonic
	private JMenuItem clear 	= new JMenuItem("Clear Log",KeyEvent.VK_C); 	
	private JMenuItem savelog 	= new JMenuItem("Save Log to File"); 
	private JTextArea txtArea;
	private JLabel readout = new JLabel(" "); 
	private JButton color;
	
	// Property variables
	private boolean running = false; // scraper is currently running?
	private boolean tablesCreated = false; 
	
	private tweetscrapeDB tsDB;
	private tweetscrapeEngine tse;
	public tweetscrapeGUI() {

	}
	public tweetscrapeGUI(tweetscrapeDB inc_tsDB) {
		tsDB = new tweetscrapeDB();
		tsDB = inc_tsDB;
		try
		{
			tse = new tweetscrapeEngine(this);
		}
		catch(Exception tw)
		{
			
		}
	}
	public tweetscrapeGUI(tweetscrapeDB inc_tsDB,tweetscrapeEngine  inc_tse) {
		
		tsDB = new tweetscrapeDB();
		tsDB = inc_tsDB;
		tse = new tweetscrapeEngine();
		tse = inc_tse;
	}
	
	public void initializeGUI() {
		

		setTitle("tweetscrape -- Scrape twitter the easy way");
		setSize( 500, 300 );
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JMenuBar topmenu = new JMenuBar();
		setJMenuBar(topmenu);
		
		// Top Most Menu Titles
		JMenu file = new JMenu("File"); 				//Menu - File
			file.setMnemonic(KeyEvent.VK_F); 		//Setting the mnemonic character to F
		JMenu database = new JMenu("Database"); 			//Menu - Database
		JMenu help = new JMenu("Help"); 				//Menu - Help
			help.setMnemonic(KeyEvent.VK_H); 

			
			topmenu.add(file);
				file.add(start);
				file.add(stop);
				file.add(savelog);
				file.add(clear);
				file.add(exit);
			topmenu.add(database);
				//database.add(Create Tables);
				//database.add(Readout);
			topmenu.add(help);
				help.add(about);


		
			
			//txtArea.setLineWrap(true);
			txtArea = new JTextArea(9,42);
			txtArea.setLineWrap(true);
			JPanel window = new JPanel();
			window.add( txtArea );
			add(window, BorderLayout.NORTH);
		
			
			JPanel bottom = new JPanel();
			JPanel center = new JPanel();
			
			center.add(readout);
			
			center.setLayout(new GridLayout(2,1));
			
			
			add(center, BorderLayout.CENTER);
			add(bottom, BorderLayout.SOUTH);
			
			about.addActionListener(this);
			exit.addActionListener(this);
			clear.addActionListener(this);
			start.addActionListener(this);
			stop.addActionListener(this);
			savelog.addActionListener(this);
			
			setDefaultCloseOperation( DO_NOTHING_ON_CLOSE );
			setVisible( true );
			
	}
	
	/**
	 * outputText()
	 * Description: for appending text to the main output text area
	 * @param incomingText - text to be appended to text area
	 * @return boolean - used to determine if text meets criteria
	 */
	public boolean outputText(String incomingText)
	{
		txtArea.append("["+getTimeStamp()+"] "+ incomingText +"\n");
		System.out.println("["+getTimeStamp()+"] "+ incomingText +"\n");//##testing##
		return true;
	}
	
	public void setRunning(boolean incRunning){
		running = incRunning;
	}
	
	public void start()
	{
			if(getRunning())
			{
				outputText("Scraper is already running...");
			}
			else{
				setRunning(true);
				try
				{
					tse.startStreamSearch();
				}
				catch(Exception e)
				{
					outputText("startStreamSearch Has encountered an Error" + e.getMessage());
				}
				outputText("Starting scrape at: " + getTimeStamp());
				//start scraping of twitter
			}
	}
	
	public void stop()
	{
		if(!getRunning())
		{
			outputText("Scraper is not running yet...");
		}
		else{
			setRunning(false);
			outputText("Stopping the Scraper at: " + getTimeStamp());
			//stop scraping of twitter
		}
	}
	
	
	public boolean getRunning(){
		return running;
	}
	
	public void exit()
	{
		if(running) {
			outputText("Currently the scraper is running, please turn it off to exit.");
		}
		else {
			System.exit(0);
		}
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
	
	/**
	 * Creates a little about readout in the textarea
	 */
	public void about()
	{
		readout.setText("Thank you for using Tweetscrape by Beau Bouchard 2013");
		outputText("");
	}
	/**
	 * Clears output from main readout text area
	 */
	public void clear()
	{
		readout.setText("");
		txtArea.setText("");
	}
	
	public void checkTables()
	{
		tablesCreated = tsDB.tablesCreated();
	}
	
	// Top menu / button actions
	public void actionPerformed(ActionEvent ea)
	{
		String action = ea.getActionCommand();
		
		//System.out.println(action);
			if(action.equals("Exit")){
				exit();
			}
			else if(action.equals("About")){
				about();
			}
			else if(action.equals("Start Scraper")){
				start();
			}
			else if(action.equals("Stop Scraper")){
				stop();
			}
			else if(action.equals("Clear Log"))
			{
				clear();
			}		
	}
	 
}
