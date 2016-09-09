package faulhaber;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter; 

public class Main {

	private JFrame frame;
	List<String> lis = new ArrayList<String>();
	Vector<String> vec = new Vector<String>();
	JLabel lblNewLabel_1 = new JLabel("无轨迹");
	
	private JPanel panel = new JPanel();
	   int margleft =20;
	    int margtop =20;
	    int vgap =40;
	    int hgap =60;
	    int hgap1 = 100;
	   
	    
	    JPanel jpanelconfig = new JPanel();
	    String portname="COM3";
	    String botelv="9600";
	    String guixing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
//					全屏
//					  GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();  
//				        GraphicsDevice gd = ge.getDefaultScreenDevice();  
//				        gd.setFullScreenWindow(window.frame);  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("焊接工艺实验软件");
		
		//Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();   
		
		frame.setBounds(100, 100, 1080, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("文件");
		menuBar.add(menu);
		
		JMenuItem mntmDaad = new JMenuItem("DAAD文件读入");
		menu.add(mntmDaad);
		
		JMenuItem mntmguiji = new JMenuItem("轨迹文件读入");
		mntmguiji.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter( "CSV FIles", "csv"); 
				jfc.setFileFilter(filter); 
				int returnVal = jfc.showOpenDialog(frame);
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{ 
					
					
					System.out.println("You chose to open this file: " + jfc.getSelectedFile().getName());	
				 try {
					
					BufferedReader buf = new BufferedReader(new FileReader(jfc.getSelectedFile()));
					String readLine = ""; 
					 while ((readLine = buf.readLine()) != null)                     //读取文件内容！！！！！！！！！ 
				      { 
				       lis.add(readLine);
				      }					
					
					  for (int i = 0; i <lis.size(); i++) {
						   System.out.println(lis.get(i));
						  }
					  
					   lblNewLabel_1.setText(jfc.getSelectedFile().getName());
					  
				 } catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					lblNewLabel_1.setText("无轨迹");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					lblNewLabel_1.setText("无轨迹");
				} 
				}
				else
				{
					 lblNewLabel_1.setText("无轨迹");
				}
				
			}
			
			
			
		});
		menu.add(mntmguiji);
		
		
		
		JMenuItem menuItem = new JMenuItem("退出");
		menu.add(menuItem);
		
		JMenu mnNewMenu = new JMenu("操作");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("启动");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame.getContentPane().add(panel);
				panel.setBounds(0, 0, 1500, 800);
				panel.setVisible(true);
				frame.setVisible(true);
				jpanelconfig.setVisible(false);
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		
		
		JMenu mnNewMenu_1 = new JMenu("设置");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("预设参数");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				
				panel.setVisible(false);
				jpanelconfig= new JPanel();
				frame.getContentPane().add(jpanelconfig);
				jpanelconfig.setBounds(0, 0, 800, 600);
				jpanelconfig.setLayout(null);
		        				
			 
				
				JLabel lblDd = new JLabel("轨型:");
				lblDd.setBounds(margleft, margtop, 50, 30);
				jpanelconfig.add(lblDd);
				
				String[] item = {"60","70","45"};
				JComboBox<String> comboBox = new JComboBox<String>(item);
				comboBox.setBounds(margleft+hgap1, margtop, 100, 30);
				jpanelconfig.add(comboBox);
				comboBox.setSelectedIndex(0);
				
				JLabel label = new JLabel("焊缝底宽:");
				label.setBounds(margleft, margtop+vgap, 80, 30);
				jpanelconfig.add(label);
				
				JLabel label_1 = new JLabel("焊缝顶宽:");
				label_1.setBounds(margleft, margtop+2*vgap, 80, 30);
				jpanelconfig.add(label_1);
				
				JLabel label_2 = new JLabel("焊丝曲率半径:");
				label_2.setBounds(margleft, margtop+3*vgap, 100, 30);
				jpanelconfig.add(label_2);
				
				JLabel label_3 = new JLabel("环境温度:");
				label_3.setBounds(margleft, margtop+4*vgap, 80, 30);
				jpanelconfig.add(label_3);
				
				JTextField textField = new JTextField();
				textField.setBounds(margleft+hgap1, margtop+vgap, 100, 30);
				jpanelconfig.add(textField);
				textField.setColumns(10);
				textField.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e) {
						int keyChar = e.getKeyChar();				
						if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
							
						}else{
							e.consume(); //关键，屏蔽掉非法输入
						}
					}
				});
				
				
				JTextField textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(margleft+hgap1, margtop+vgap*2, 100, 30);
				jpanelconfig.add(textField_1);
				textField_1.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e) {
						int keyChar = e.getKeyChar();				
						if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
							
						}else{
							e.consume(); //关键，屏蔽掉非法输入
						}
					}
				});
				
				JTextField textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(margleft+hgap1, margtop+vgap*3, 100, 30);
				jpanelconfig.add(textField_2);
				textField_2.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e) {
						int keyChar = e.getKeyChar();				
						if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
							
						}else{
							e.consume(); //关键，屏蔽掉非法输入
						}
					}
				});
				
				JTextField textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(margleft+hgap1, margtop+vgap*4, 100, 30);
				jpanelconfig.add(textField_3);
				textField_3.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e) {
						int keyChar = e.getKeyChar();				
						if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
							
						}else{
							e.consume(); //关键，屏蔽掉非法输入
						}
					}
				});
				
				JButton button = new JButton("取消");
				button.setBounds(margleft, margtop+vgap*5, 80, 30);
				jpanelconfig.add(button);
				button.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		               
		            	
		            	jpanelconfig.setVisible(false);
		            	
		            }
		        });
				
				JButton button_1 = new JButton("确认");
				button_1.setBounds(margleft+hgap1+20, margtop+vgap*5, 80, 30);
				jpanelconfig.add(button_1);
				button_1.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	jpanelconfig.setVisible(false);
		            }
		        });
				
			  
				jpanelconfig.setVisible(true);
				frame.setVisible(true);

				
				
			}
		});
		
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		
		
		JMenuItem menuItem_1 = new JMenuItem("帮助");
		mnNewMenu_1.add(menuItem_1);
		
		
		frame.getContentPane().setLayout(null);
	
		
		panel = new JPanel();			
		panel.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
	      panel_1.setLayout(null);
	      
	    
	  
	  
	  
	    JLabel label_1 = new JLabel("\u8BBE\u7F6E:");	    
	    JLabel label_2 = new JLabel("轨底:");
	    JTextField tf_1 = new JTextField();
	    tf_1.setColumns(10);
	    
	    JLabel label_3 = new JLabel("三角区:");
	    JTextField tf_2 = new JTextField();
	    tf_2.setColumns(10);
	    
	    
	    JLabel label_4 = new JLabel("轨腰:");
	    JTextField tf_3 = new JTextField();
	    tf_3.setColumns(10);
	    
	    
	    JLabel label_5 = new JLabel("轨颚:");
	    JTextField tf_4 = new JTextField();
	    tf_4.setColumns(10);
	    
	    JLabel label_6 = new JLabel("轨头:");
	    JTextField tf_5 = new JTextField();
	    tf_5.setColumns(10);
	    
		JLabel label_8 = new JLabel("命令:");
		label_8.setBounds(19, 375, 50, 30);
		panel_1.add(label_8);
		
		
	    
	    panel_1.add(label_1);
	    label_1.setBounds(margleft, margtop, 50, 30);   
	    
	    panel_1.add(label_2);
	    label_2.setBounds(margleft, margtop+vgap, 50, 30);   
	    
	    panel_1.add(tf_1);
	    
	    tf_1.setBounds(80, 60, 138, 30);
	    tf_1.setColumns(10);
	    
	    
	    panel_1.add(label_3);
	    label_3.setBounds(20, 100, 50, 30);   
	    
    panel_1.add(tf_2);
	    
	    tf_2.setBounds(80, 100, 138, 30);
	    tf_2.setColumns(10);
	    
	    
	    panel_1.add(label_4);
	    label_4.setBounds(20, 140, 50, 30);   
	    
    panel_1.add(tf_3);
	    
	    tf_3.setBounds(80, 140, 138, 30);
	    tf_3.setColumns(10);
	    
	    
	    
	    panel_1.add(label_5);
	    label_5.setBounds(20, 180, 50, 30);   
	    
    panel_1.add(tf_4);
	    
	    tf_4.setBounds(80, 180, 138, 30);
	    tf_4.setColumns(10);
	    
	    
	    
	    panel_1.add(label_6);
	    label_6.setBounds(20, 220, 50, 30);   
         panel_1.add(tf_5);
	    
	    tf_5.setBounds(80, 220, 138, 30);
	    tf_5.setColumns(10);
	    
	     
	   	JPanel panel_2 = new JPanel();
	      panel_2.setLayout(null);
	    
	      JLabel label_7 = new JLabel("控制面板:");
	     
	      
	      panel_2.add(label_7);
	      label_7.setBounds(margleft, margtop, 100, 30);
	    
		
	
		JButton btnNewButton = new JButton("上");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpport.writedata("3v-100");
			}
		});
		btnNewButton.setBounds(63, 67, 54, 29);
		panel_2.add(btnNewButton);
		
		JButton button = new JButton("前");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpport.writedata("2v-100");
			}
		});
		button.setBounds(30, 105, 54, 29);
		panel_2.add(button);
		
		JButton button_1 = new JButton("后");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpport.writedata("2v100");
			}
		});
		button_1.setBounds(90, 105, 54, 29);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("下");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpport.writedata("3v100");
			}
		});
		button_2.setBounds(63, 138, 54, 29);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("左");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpport.writedata("1v-100");
			}
		});
		button_3.setBounds(30, 196, 54, 29);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("右");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpport.writedata("1v100");
			}
		});
		button_4.setBounds(90, 196, 54, 29);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("顺");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpport.writedata("4v-100");
				
			}
		});
		button_5.setBounds(30, 240, 54, 29);
		panel_2.add(button_5);
		
		JButton button_6 = new JButton("确定");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cpport.writedata("HO");
				
			}
		});
		button_6.setBounds(183, 152, 100, 29);
		panel_2.add(button_6);
		
		JLabel lblNewLabel = new JLabel("关");
		lblNewLabel.setBounds(183, 54, 100, 21);
		panel_2.add(lblNewLabel);
		
		JButton button_7 = new JButton("逆");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpport.writedata("4v100");
				
			}
		});
		button_7.setBounds(90, 240, 54, 29);
		panel_2.add(button_7);
		
		JToggleButton toggleButton = new JToggleButton("夹紧");
		toggleButton.setBounds(183, 240, 100, 29);
		panel_2.add(toggleButton);
		
		JToggleButton toggleButton_1 = new JToggleButton("开");
		toggleButton_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 int state = e.getStateChange();
				    if (state == ItemEvent.SELECTED) {
				    	
				    	cpport.writedata("EN");
				    	toggleButton_1.setText("关");
				    	
				    					    
				    }  else {
				    	
				    	cpport.writedata("DI");
				    	toggleButton_1.setText("开");
				    	
				    }
				
			}
		});
		toggleButton_1.setBounds(310, 50, 100, 29);
		panel_2.add(toggleButton_1);
		
		JButton button_8 = new JButton("复位");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cpport.writedata("LA0");
				cpport.writedata("SP200");
				cpport.writedata("NP");
				cpport.writedata("M");
				
			}
		});
		button_8.setBounds(310, 105, 100, 29);
		panel_2.add(button_8);
		
		JButton button_9 = new JButton("降温");
		button_9.setBounds(310, 171, 100, 29);
		panel_2.add(button_9);
		
		JButton button_10 = new JButton("送丝");
		button_10.setBounds(310, 240, 100, 29);
		panel_2.add(button_10);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
	
		
		JLabel label = new JLabel("波形显示:");
		label.setBounds(margleft,margtop,100,30);
		
		panel_3.add(label);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(20, 60, 365, 200);
		panel_4.setBackground(Color.BLUE);
		panel_3.add(panel_4);
		
		
		
		
		
		
		panel.add(panel_1);		
		panel_1.setBounds(0, 0, 230, 501);
		
		JTextField textField_4 = new JTextField("EN");
		textField_4.setColumns(10);
		textField_4.setBounds(80, 377, 138, 30);
		panel_1.add(textField_4);
		
		JButton btnNewButton_1 = new JButton("\u53D1\u9001");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cpport.writedata(textField_4.getText());	
				System.out.println(textField_4.getText());
				
				
			}
		});
		btnNewButton_1.setBounds(137, 436, 81, 29);
		panel_1.add(btnNewButton_1);
		
		JLabel label_9 = new JLabel("端口:");
		label_9.setBounds(19, 305, 50, 30);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("波特率:");
		label_10.setBounds(19, 337, 50, 30);
		panel_1.add(label_10);
		
		final String[] itemscom=new String[]{"COM1","COM2","COM3","COM4"};
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(itemscom);
		JComboBox comboBox = new JComboBox(comboModel);
		comboBox.setSelectedItem("COM3");
		comboBox.setToolTipText("");
		comboBox.setBounds(80, 307, 138, 27);
		comboBox.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	portname = (String)comboBox.getSelectedItem();	
		    	System.out.println(portname);
		      }
		    });

		panel_1.add(comboBox);
		
		final String[] itemsbau=new String[]{"9600","19200"};
		DefaultComboBoxModel<String> comboModel_1 = new DefaultComboBoxModel<String>(itemsbau);
		JComboBox comboBox_1 = new JComboBox(comboModel_1);
		comboBox_1.setBounds(80, 339, 138, 27);
		comboBox_1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	botelv=(String)comboBox_1.getSelectedItem();
		    	System.out.println(botelv);
		      }
		    });
		
		panel_1.add(comboBox_1);
		
		JToggleButton toggleButton_3 = new JToggleButton("连接");
		toggleButton_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				 int state = e.getStateChange();
				    if (state == ItemEvent.SELECTED) {
				    	
				    	try
				    	{
				    	cpport.connect(portname, botelv);
				    	
				    	toggleButton_3.setSelected(true);
				    	toggleButton_3.setText("断开");
				    	lblNewLabel.setText("已连接");
				    	}
				    	catch (Exception e1)
				    	{
				    	toggleButton_3.setSelected(false);
				    	e1.printStackTrace();
				    	}
				    					    
				    }  else {
				    	cpport.close();
				      toggleButton_3.setSelected(false);
				      toggleButton_3.setText("连接");
				      lblNewLabel.setText("连接断开");
				     
				      
				    }
			}
		});
		
		
		
		
		
		
		toggleButton_3.setBounds(12, 436, 81, 28);
		panel_1.add(toggleButton_3);
			
		
		panel.add(panel_2);
		panel_2.setBounds(230, 0, 430, 501);
		
		JButton button_11 = new JButton("运行轨迹");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				for (int i=0;i<lis.size();i++)
				{
					String str = lis.get(i);
					String[] arrstr = str.split(";");
					for (int j=1;j<arrstr.length;j++)
					{
						vec.add(arrstr[j]);
						
					}
					
					  
				}
				
				
				for (int i = 0; i <vec.size(); i++) {
					if (vec.get(i)!="")
					{
					   cpport.writedata(vec.get(i));
					   System.out.println(vec.get(i));
					  }
				}
				
				
			}
		});
		button_11.setBounds(310, 430, 100, 29);
		panel_2.add(button_11);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLUE);
		panel_5.setBounds(30, 330, 253, 129);
		panel_2.add(panel_5);
		
		
		lblNewLabel_1.setBounds(310, 400, 55, 18);
		panel_2.add(lblNewLabel_1);
		
		JButton button_12 = new JButton("停止");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpport.writedata("v0");
			}
		});
		button_12.setBounds(183, 196, 100, 29);
		panel_2.add(button_12);
		
		panel.add(panel_3);
		panel_3.setBounds(660, 0, 400, 501);
		
		
				
		
	}
	
	
	
	
	
   Comport cpport = new Comport();
}
