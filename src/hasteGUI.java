
/**
 * Author: Beau Bouchard
 * Date: January 21st, 2013
 * Last Updated: 2013/05/06
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

public class hasteGUI extends JFrame implements ActionListener 
{

	// Initializing connection parameters
	private Socket client;
	private Socket server;
	static final int PORT = 8873;
	public ArrayList connections; // public variable for listed connections, remove when server/client is removed
	
	// Initializing Menu Variables for top dropdown.
	//File -
	private JMenuItem clear 	= new JMenuItem("Clear Log",KeyEvent.VK_C); 	
	private JMenuItem savelog 	= new JMenuItem("Save Log to File"); 
	private JMenuItem exit 		= new JMenuItem("Exit",KeyEvent.VK_X); 				//Exit, with x as the mnemonic
	
	//Scrape 
	private JMenuItem dbcreds	= new JMenuItem("Enter Database Credentials");
	private JMenuItem apikeys	= new JMenuItem("Enter API Keys");
	private JMenuItem stop		= new JMenuItem("Stop Scraper",KeyEvent.VK_Z); 		//Clear, with C as the mnemonic
	private JMenuItem start 	= new JMenuItem("Start Scraper",KeyEvent.VK_S); 	//Start, with S as the mnemonic
	
	//Database 
	// Create Database <-- make not work if database is not running, or database already has the tables created
	// 
	
	//Help - 
	private JMenuItem about 	= new JMenuItem("About",KeyEvent.VK_A); 			//About, with A as the mnemonic

	private JPanel bottom;
	private JTextArea txtArea;
	private JTextArea readout = new JTextArea(" "); 

	
	// Property variables
	private boolean running = false; // scraper is currently running?
	private boolean apikey = false;  // if api key is entered
	
	private boolean tablesCreated = false; 
	
	private hasteDB tsDB;
	private hasteEngine tse;
   
  
   
	public hasteGUI()
   {
		try
		{
			tse = new hasteEngine(this);
		}
		catch(Exception tw)
		{
			
		}
      
      try
		{
			tsDB = new hasteDB(this);
		}
		catch(Exception tw)
		{
			
		}
	}
   
	public hasteGUI(String inc_str) 
	{
		
	
	}
	
	public void initializeGUI() {
		

		setTitle("haste -- Scrape twitter the easy way");
		setSize( 800, 600 );
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JMenuBar topmenu = new JMenuBar();
		setJMenuBar(topmenu);
		
		// Top Most Menu Titles
		JMenu file = new JMenu("File"); 				//Menu - File
			file.setMnemonic(KeyEvent.VK_F); 		//Setting the mnemonic character to F
		JMenu scrape = new JMenu("Scrape"); 			//Menu - Database
		JMenu database = new JMenu("Database"); 			//Menu - Database
		JMenu help = new JMenu("Help"); 				//Menu - Help
			help.setMnemonic(KeyEvent.VK_H); 

			
			topmenu.add(file);
				file.add(savelog);
				file.add(clear);
				file.add(exit);
			topmenu.add(scrape);
				scrape.add(dbcreds);
				scrape.add(apikeys);
				scrape.add(start);
				scrape.add(stop);
			topmenu.add(database);
			

				//database.add(Create Tables);
				//database.add(Readout);
			topmenu.add(help);
				help.add(about);
				
			//txtArea.setLineWrap(true);
			txtArea = new JTextArea(16,70);
			//txtArea.setLineWrap(true);
			JScrollPane scrollPane = new JScrollPane(txtArea); 
			
			
			JPanel top = new JPanel();
			JPanel center = new JPanel();
			
			bottom = new JPanel();
			Color color = UIManager.getColor ( "Panel.background" );
			
				top.add( scrollPane );
			add(top, BorderLayout.NORTH);
			readout.setBackground(color);
			top.setBackground(color);
			center.setBackground(color);
			bottom.setBackground(color);
			//.setOpaque(true);
			
			bottom.setLayout(new GridLayout(1,2));
			bottom.add(readout);
			center.setLayout(new GridLayout(2,1));
			add(center, BorderLayout.CENTER);
			add(bottom, BorderLayout.SOUTH);
			
			about.addActionListener(this);
			exit.addActionListener(this);
			clear.addActionListener(this);
			start.addActionListener(this);
			stop.addActionListener(this);
			savelog.addActionListener(this);
			apikeys.addActionListener(this);
			dbcreds.addActionListener(this);
		
			
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
	
	/**
	 * setRunning()
	 * Description: setter for systemproperty variable, tells the GUI scraper is currently running?
	 * @param	incRunning	boolean // scraper is currently running? 1 = yes, 0 = no
	 */
	public void setRunning(boolean incRunning){
		running = incRunning;
	}
	
	public boolean getRunning(){
		return running;
	}
	
	public void start()
	{
		if(!apikey)
		{
			promptAPIkeys();
		}
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
		readout.setText("Thank you for using haste by Beau Bouchard 2013");
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
	
	public void promptDBCreds()
	{
		/*outputText("Prompting user Database Credentials");
		String username = "";
		String password = "";
		String address = "";
		String port = "";
		
		username = promptfor("Please enter Database Username");
		password = promptfor("Please enter Database Password");
		address = promptfor("jdbc:mysql://localhost");
		port = promptfor("Please enter Database Port (ie 3306)");
		
		tsDB.setDatabaseUsername(username);
		tsDB.setDatabasePassword(password);
		tsDB.setDatabaseAddress(address);
		tsDB.setDatabasePort(port);
		*/
		tse.startDatabase();
		
	}
	public void promptAPIkeys()
	{
		outputText("Prompting user for API key");
		String consumerKey = "";
		String consumerSecret = "";
		String authAccessToken = "";
		String authAccessTokenSecret = "";
		
		consumerKey 			= promptfor("Please enter your Consumer Public Key");
		consumerSecret 			= promptfor("Please enter your Consumer Secret Key");
		authAccessToken 		= promptfor("Please enter your Auth Access Token");
		authAccessTokenSecret 	= promptfor("Please enter your Auth Access Secret Token");
		
		tse.setconsumerKey(consumerKey);
		tse.setconsumerSecret(consumerSecret);
		tse.setauthAccessToken(authAccessToken);
		tse.setauthAccessTokenSecret(authAccessTokenSecret);
		displayAPIKey();
		apikey = true; 
		outputText("New API keys entered successfully");
	  }
	
	public void displayAPIKey()
	{
		readout.setText("   Consumer Public Key: \t"		+tse.getconsumerKey() +"\n"
					   +"   Consumer Secret Key: \t"							+tse.getconsumerSecret() +"\n"
					   +"   Auth Access Token: \t"							+tse.getauthAccessToken() +"\n"
					   +"   Auth Access Secret Token: \t"							+tse.getauthAccessTokenSecret()	+"\n\n\n");
	}
	
	public String promptfor(String message)
	{
		String authConsumerKey = JOptionPane.showInputDialog(bottom,message,null);
		return authConsumerKey;
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
			else if(action.equals("Enter Database Credentials")){
				promptDBCreds();
			}
			else if(action.equals("Enter API Keys")){
				promptAPIkeys();
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
