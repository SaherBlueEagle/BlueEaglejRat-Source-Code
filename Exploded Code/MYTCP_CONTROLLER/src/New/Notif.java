package New;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Notif {
	private  JFrame form ;
 

	private  String Exe_Split = "fxf0x4x4x0fxf";
	private  String Exe_Ending = "c2x2824x828200x0c";
	private  String Jar_Split = "fxf0x4x4x0fxf";
	private  String Jar_Ending = "c2x2824x828200x0c";
	private  String sock = "";
	private  String ID = "";
	private  String OS = "";
    private  String title = "";
    private  String dev_type = "";
    private  String other_data="";
    private  String Lang="";
 
	
	
	
	public Notif(String ip,String str1, String str3 , String str4 , String str5, String str6) throws InterruptedException{
		this.sock = ip;
		this.ID = str1;
		this.OS = str3; //str2  is the ip
		this.Lang = str4;
		this.dev_type = str5;
		this.other_data = str6;
		this.Do_frame();
		   int widthx =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			 int heightx = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		 for (int i = 0 ; i < 200;i++){
			 Thread.sleep(5);
			form.setLocation(form.getLocation().x, heightx-i);
			 form.validate();
		 }
		int TIME_VISIBLE = 5000;
		 new Timer(TIME_VISIBLE, new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		         Master.Remove_Form_Notif(sock);
		         form.dispose();
		        }
		      }).start();
		
	}
	public void Set_sock(String ip){
		sock = ip;
	}
	public String Get_sock(){
		return sock ;
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
	 private  ArrayList<String> SplitString_D(String s,String Delimeter){
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
	 private  String convertSize(float iSize)
	 {
	   if (iSize <= 0.0F) {
	     return "0";
	   }
	   
	   String[] units = { "Bytes", "KB", "MB", "GB", "TB" };
	   int digitGroups = (int)(Math.log10(iSize) / Math.log10(1024.0D));
	   
	   return new java.text.DecimalFormat("#,##0.#")
	     .format(iSize / Math.pow(1024.0D, digitGroups)) + 
	     " " + units[digitGroups];
	 }
	public  void Perform_data(String Received){
		 form.setTitle("File Manager For : " + sock);
		 form.repaint();
		 String YY = "";
		 String xx = "|||";
		 YY = xx.charAt(0)+ "" +xx.charAt(1);
		//  System.out.println("here          " + Received );
			if (Received.isEmpty()==false){
				 
					Received = Received.replace("c2x2824x828200x0c", YY);
					
					  switch (SplitString(Received).get(0)){
					  
					  case "drive":
						  
						  break;
						  
					 
					  }
					
				 
					
				
			}
				
		
	}
	public  void Do_frame(){
		 form = new JFrame();
		 form.setName("File Manager For : " + sock);
		 form.setTitle("File Manager For : " + sock);
		 title = "File Manager For : " + sock;
		 form.setResizable(false);
		  
		 int widthx =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		 int heightx = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	 
		
		 
		 
		
		 form.setLayout(null);
		 Font font = new Font("Microsoft Sans Serif", Font.PLAIN, 12);
		 form.setFont(font); 
	 
			
			DefaultTableModel model = new DefaultTableModel(){

     	         @Override
     	         public boolean isCellEditable(int row, int column) {
     	             //Only the third column
     	             return false;
     	         }
     	    	public Class<?> getColumnClass(int column) {
     	           switch(column) {
     	               
     	               case 0: return ImageIcon.class;
     	               default: return Object.class;
     	           	}
     	   				}
			};

			
		  
			
			ImageIcon icon=new ImageIcon("Drive.png");
		    Object[] columnNames = {"^.^","Drive / File / Folder", "Type / Ext.", "Size"}; 

		 
	        model.setColumnIdentifiers(columnNames);
	       
			
	        form.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			    	    //on closing event
			            Master.Remove_Form_Notif(sock);
			    	 	form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			          
			    }
			}); 
			
			
		   FontUIResource fontx = new FontUIResource("Verdana", Font.BOLD, 13);
		  
		//	 form.add(btnNext);
			// form.add(Dir);
		         
		
		//	 form.setBounds((widthx -300),(heightx -200), 300, 150);
			
		   form.setBounds((widthx -300),(heightx), 300, 150);
		        JPanel Buttons = new JPanel();
		        Buttons.setSize(form.getSize());
		        Buttons.setBackground(Color.DARK_GRAY);
		        Buttons.setLayout(null);
		        JLabel id = new JLabel("ID : " + ID);
		        id.setBounds(5,1, Buttons.getWidth(), 50);
		        id.setFont(fontx);
		        id.setForeground(Color.WHITE);
		        Buttons.add(id);
		        JLabel ip = new JLabel("IP : " + sock);
		        ip.setBounds(5,20, Buttons.getWidth(), 50);
		        ip.setFont(fontx);
		        ip.setForeground(Color.WHITE);
		        Buttons.add(ip);
		        JLabel OSl = new JLabel("Operating System : " + OS );
		        OSl.setBounds(5,40, Buttons.getWidth(), 50);
		        OSl.setFont(fontx);
		        OSl.setForeground(Color.WHITE);
		        Buttons.add(OSl);
		        JLabel CNM = new JLabel("Language / Country : " + Lang );
		        CNM.setBounds(5,60, Buttons.getWidth(), 50);
		        CNM.setFont(fontx);
		        CNM.setForeground(Color.WHITE);
		        Buttons.add(CNM);
		        JLabel usr = new JLabel("Device : " + dev_type );
		        usr.setBounds(5,83, Buttons.getWidth(), 50);
		        usr.setFont(fontx);
		        usr.setForeground(Color.WHITE);
		        Buttons.add(usr);
		        JLabel oth = new JLabel("Device : " + other_data );
		        oth.setBounds(5,102, Buttons.getWidth(), 50);
		        oth.setFont(fontx);
		        oth.setForeground(Color.YELLOW);
		        Buttons.add(oth);
				 form.validate();
				 form.add(Buttons);
				 form.setResizable(false);
				 form.setUndecorated(true);
				 form.setAlwaysOnTop(true);
				 form.setBackground(Color.DARK_GRAY);
				 
				 form.repaint();
			// form.add(sp);
			 form.validate();
			// form.getContentPane().setBackground(Color.DARK_GRAY);
			 form.setVisible(true);
		
	}
	
	
 
	
	
	
}

