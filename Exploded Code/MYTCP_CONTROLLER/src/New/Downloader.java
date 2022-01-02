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

public class Downloader {
	private  JFrame form ;
  
	private  String sock = "";
    private String Filename = "";
    private String full_progress = "";
	private String fname = "";
	
	
	public Downloader(String ip,String str1, String str2,String tr4) throws InterruptedException{
		this.sock = ip;
	    this.Filename = str1;
	    this.full_progress = str2;
		this.fname = tr4;
	}
	public void SetDownloader(String ip,String str1, String str2) throws InterruptedException{
		this.sock = ip;
	    this.Filename = str1;
	    this.full_progress = str2;
		 prog.setMaximum(Integer.parseInt(full_progress));
		 message.setText("... Working");
		 message.repaint();
	}
	public void SetDownloader_W(String ip,String str1) throws InterruptedException{
		this.sock = ip;
	    this.Filename = str1;
	   if (str1.contains("Error")){
		   filelocation.setText(str1);
		   filelocation.repaint();
		   message.setText("Cannot Download File");
		   message.repaint();
		}else{
			 message.setText("... Working");
			 message.repaint();
		   filelocation.setText(str1);
		   filelocation.repaint();
	   }
	   form.repaint();
		 
	}
	public void Set_sock(String ip){
		sock = ip;
	}
	public String Get_sock(){
		return sock ;
	}
	public String Get_fname(){
		return fname ;
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
     private JProgressBar prog;
     private  JLabel id;
     private  JLabel message;
     private  JLabel filelocation;
	 private int counprog=0;
	 public void On_Finish(String Filepath,String b){
		 message.setText("");
		 message.repaint();
		 form.repaint();
		 filelocation.setText("");
		 filelocation.repaint();
		 prog.setValue(0);
		 id.setText("Progress : ");
		 id.repaint();
		 prog.setMaximum(0);
		 prog.repaint();
		 form.repaint();
		 counprog = 0;
		
		 
	 }
	public void set_chunk_counter(int x){
		counprog = x;
	}
	public  void Perform_data(){
		 form.setTitle("File Downloader For : " + sock);
		 form.setVisible(true);
		 form.repaint();
		 form.repaint();
		 String YY = "";
		 String xx = "|||";
		 YY = xx.charAt(0)+ "" +xx.charAt(1);
		 if (prog!=null){
			 if (counprog<=prog.getMaximum()){
				 try{
					
					 prog.setValue(counprog);
					 double ratio = (double)prog.getValue()/prog.getMaximum();
					 ratio = ratio * 100;
					 id.setText(("Progress : " + ratio ) + " %");
					 id.repaint();
					 prog.repaint();
					 form.repaint();
					 counprog +=1;
				 }catch(Exception x){
					 
				 }
			 }else{
				 counprog = 0;
				 prog.setValue(counprog);
				 double ratio = (double)prog.getValue()/prog.getMaximum();
				 ratio = ratio * 100;
				 id.setText(("Progress : " + ratio )+ " %");
				 
				 id.repaint();
				 prog.repaint();
				 form.repaint();
			 }
		 }
	
				
		
	}
	public  void Do_frame(){
		 form = new JFrame();
		 form.setName("File Manager For : " + sock);
		 form.setTitle("File Manager For : " + sock);
		 
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
			    	
			    	
			    	 if (JOptionPane.showConfirmDialog(form, 
					            "Are you sure you want to close File Downloader From :  "+ sock +" window?", "Close Window?", 
					            JOptionPane.YES_NO_OPTION,
					            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			    		   Master.Remove_Form_Open_Downloaders(sock,fname);
				    	 	form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					        } else{
					        	form.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					        }
			         
			          
			    }
			}); 
			
			
		   FontUIResource fontx = new FontUIResource("Verdana", Font.BOLD, 13);
		  
		//	 form.add(btnNext);
			// form.add(Dir);
		         
		
		//	 form.setBounds((widthx -300),(heightx -200), 300, 150);
		   form.setBounds((widthx -500)/2,( heightx -150)/2, 500, 150);
		  
		        JPanel Buttons = new JPanel();
		        Buttons.setSize(form.getSize());
		        Buttons.setBackground(Color.DARK_GRAY);
		        Buttons.setLayout(null);
		        
		        id = new JLabel("Progress : " );
		        id.setBounds(9,18, Buttons.getWidth(), 22);
		        id.setFont(fontx);
		        id.setForeground(Color.BLACK);
		        Buttons.add(id);
		        
		        prog = new JProgressBar();
		        prog.setBounds(5,19, Buttons.getWidth() - 30, 22);
		        prog.setFont(fontx);
		        prog.setMaximum(Integer.parseInt(full_progress));
		        Buttons.add(prog);
		        
		        
		        message = new JLabel("Status : Downloading Commanded" );
		        message.setBounds(5,35, Buttons.getWidth(), 25);
		        message.setFont(fontx);
		        message.setForeground(Color.WHITE);
		        Buttons.add(message);
		        
		             
		        filelocation = new JLabel(Filename);
		        filelocation.setBounds(5,50, Buttons.getWidth(), 50);
		        filelocation.setFont(fontx);
		        filelocation.setForeground(Color.WHITE);
		        Buttons.add(filelocation);
		        
		        
				 form.validate();
				 form.add(Buttons);
				 form.setResizable(false);
				  
				 form.setAlwaysOnTop(true);
				 form.setBackground(Color.DARK_GRAY);
				 
				 form.repaint();
			// form.add(sp);
			 form.validate();
			// form.getContentPane().setBackground(Color.DARK_GRAY);
			 form.setVisible(true);
		
	}
	
	
 
	
	
	
}

