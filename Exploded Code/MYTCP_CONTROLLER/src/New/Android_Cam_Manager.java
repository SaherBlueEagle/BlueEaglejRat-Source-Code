package New;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class Android_Cam_Manager {
	private  JFrame form ;
	private    JScrollPane sp;
    private  JPopupMenu popupMenu;
    private JLabel screen;
  	private  String Exe_Split = "fxf0x4x4x0fxf";
  	private  String Exe_Ending = "c2x2824x828200x0c";
  	private  String Jar_Split = "fxf0x4x4x0fxf";
  	private  String Jar_Ending = "c2x2824x828200x0c";
  	private  String sock = "";
    private  String title = "";
    private  JPanel Buttons;
    private JSplitPane split;
  	private  JComboBox<String> cam_devices = new JComboBox<String>();;
  	private int Start=0;
  	private  JButton btnNext ;
	private Checkbox keep_capture = new Checkbox("Continue Capture");  
    private boolean loop_capture = false;
    public ArrayList<String> camlist = new ArrayList<String>();
    public Android_Cam_Manager(String ip){
    	this.sock = ip;
 
		 
    }
    public JFrame get_form(){
    	return form;
    }
    public void Set_sock(String ip){
		sock = ip;
	}
	public String Get_sock(){
		return sock ;
	}
	public void command(){
		
		  sock = title.replace("Remote Cam Manager For : "  , "");
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
									if(loop_capture==true){
										try{
											
											double x_ratio = 1.0;//(double) this.Width_t / screen.getWidth();
											double y_ratio = 2.0;//(double) this.Height_t / screen.getHeight();
											int form_x = screen.getMousePosition().x ;
											 double tar_x = (double)form_x * x_ratio;//screen.getMousePosition().x * x_ratio;
											 double tar_y = (double) screen.getMousePosition().y * y_ratio;
										//	 cam_devices.setText("Client Screen Size : Width :- "+" Height :- "  + "\n" + "Mouse Control Enabled" + "\n" + "Request : Refresh Screen");
										  
											  Master.Send_Data("$" + Exe_Split + (int)tar_x  + Exe_Split + (int)tar_y + Exe_Split + Exe_Ending,sock,false);
											
										}catch(Exception ex){
											System.out.println("ex"+"\n" + ex.getMessage());
										}
										
										}else{
											// cam_devices.setText("Client Screen Size : Width :- "+" Height :- "  + "\n" + "Mouse Control Disabled" + "\n" + "Request : Refresh Screen");
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
	private ArrayList<String> SplitString(String received) {
		// TODO Auto-generated method stub
		return null;
	}
	public  void Do_frame(){
	if(form==null){
		 form = new JFrame();
		
		    form.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			     
			    	 if (JOptionPane.showConfirmDialog(form, 
			            "Are you sure you want to close Remote Cam Manager "+ sock +" window?", "Close Window?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			    		   Master.Remove_Form_CamManager_Android(sock);
			        } 
			    }
			}); 
			
			
	}
	 keep_capture = new Checkbox("Continue Capture");  	
		 form.setName("Remote Cam Manager For : " + sock);
		 form.setTitle("Remote Cam Manager For : " + sock);
		 title = "Remote Cam Manager For : "+ sock;
		 form.setResizable(false);
		  
		 int widthx =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		 int heightx = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	 
		 form.setBounds((widthx -500)/2,( heightx -430)/2, 500, 430);
		 
		 
		 Font font = new Font("Microsoft Sans Serif", Font.PLAIN, 12);
		
	
		 keep_capture.addItemListener(new ItemListener() {  
		     	@Override
		          public void itemStateChanged(ItemEvent e) {               
		           if( e.getStateChange() ==1){
		         	  loop_capture = true;
		           }else{
		         	  loop_capture = false;
		         	 
		           }
		           
		          }

					 
		       });  
		     
		     keep_capture.setFont(font);
		     keep_capture.setForeground(Color.WHITE);
		
		 
		 	
		 	   
		 	
		 	
		 btnNext = new JButton("Refresh Drives");
		 cam_devices = new JComboBox<String>();
		
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//do here some stuff
					//System.out.println(sock);
					if(Start ==1){
						Start = 0;
						Master.Send_Data("camera_manager_capture" + Exe_Split + sp.getWidth()  + Exe_Split+ sp.getHeight()  + Exe_Split + "0" + Exe_Split + "100"+ Exe_Ending,sock,true);
						btnNext.setText("Refresh Drives");
						btnNext.repaint();
						form.validate();
						return;
					}else{
						Start = 0;
						
						btnNext.setText("Start Capture");
						btnNext.repaint();
						form.validate();
					}
					
				}
			});
			btnNext.setBounds(5, 55, 170, 23);
			 cam_devices.setBounds(5, 5, 200, 20);
			 	keep_capture.setBounds(5, 30, 200, 23);
	        btnNext.setFont(font);
			cam_devices.setFont(font);
			cam_devices.setEditable(false);
			 for (String camStr : camlist){
				 cam_devices.addItem(camStr.replace("cam_split", ":"));
				 cam_devices.updateUI();
				 cam_devices.repaint();
			 }
		   FontUIResource fontx = new FontUIResource("Verdana", Font.PLAIN, 13);
	
		   		screen = new JLabel();
		   		screen.setBounds(5, 100, 485, 290); 
		        sp = new JScrollPane(screen); 
		       
		        sp.setBounds(5, 100, 485, 290); 
		        form.setLayout(new BorderLayout());
		        Buttons = new JPanel();
		        Buttons.setSize(50, 50);
		        Buttons.setBackground(Color.DARK_GRAY);
		        Buttons.setLayout(null);
		        Buttons.add(btnNext);
		        Buttons.add(cam_devices);
		      Buttons.add(keep_capture);
		      Buttons.updateUI();
		      Buttons.repaint();
				

				    split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp,Buttons );
				   
				    split.setDividerSize(10);//line thickness
				    split.setDividerLocation(300);
				    split.setOneTouchExpandable(true);
				 
				    form.addComponentListener(new ComponentAdapter() {
				        public void componentResized(ComponentEvent componentEvent) {
				        	split.setDividerLocation(300);
				         
				        	screen.setSize((form.getWidth() - (form.getWidth()/4)), 200);
				        	Buttons.repaint();
				         
				        	split.validate();
				        	split.repaint();
				        }
				    });
				    
				    
				    
				    split.setDividerLocation(300);
			         
		        	screen.setSize((form.getWidth() - (form.getWidth()/4)), 200);
		        	Buttons.repaint();
		         
		        	split.validate();
		        	split.repaint();
				 form.validate();
				 form.setResizable(true);
				    form.add(split, BorderLayout.CENTER);
				    split.repaint();
		        form.repaint();
	 
			 form.setVisible(true);
			
	}
	
	 
 
}
