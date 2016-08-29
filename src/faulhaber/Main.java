package faulhaber;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.io.OutputStream;

import javax.comm.SerialPort;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Main {

	private JFrame frame;
	
	
	
	
	private JPanel panel;
	   int margleft =20;
	    int margtop =20;
	    int vgap =40;
	    int hgap =60;
	    int hgap1 = 100;
	   
	    protected OutputStream outputStream = null;   
	    JPanel jpanelconfig;
	    String portname;
	    String botelv;
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
		frame.setTitle("\u710A\u63A5\u5DE5\u827A\u5B9E\u9A8C\u8F6F\u4EF6");
		
		//Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();   
		
		frame.setBounds(100, 100, 1100, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6587\u4EF6");
		menuBar.add(menu);
		
		JMenuItem mntmDaad = new JMenuItem("DAAD\u6587\u4EF6\u8BFB\u5165");
		menu.add(mntmDaad);
		
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA");
		menu.add(menuItem);
		
		JMenu mnNewMenu = new JMenu("\u64CD\u4F5C");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u8FDE\u63A5");
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
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u542F\u52A8");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u505C\u6B62");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("\u8BBE\u7F6E");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u8FDE\u63A5\u8BBE\u7F6E");
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
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u53C2\u6570\u8BBE\u7F6E");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5E2E\u52A9");
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
			}
		});
		btnNewButton.setBounds(63, 67, 54, 29);
		panel_2.add(btnNewButton);
		
		JButton button = new JButton("左");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(30, 105, 54, 29);
		panel_2.add(button);
		
		JButton button_1 = new JButton("右");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(90, 105, 54, 29);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("下");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(63, 138, 54, 29);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("左");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(30, 196, 54, 29);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("右");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setBounds(90, 196, 54, 29);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("顺");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_5.setBounds(30, 240, 54, 29);
		panel_2.add(button_5);
		
		JButton button_6 = new JButton("确定");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		button_7.setBounds(90, 240, 54, 29);
		panel_2.add(button_7);
		
		JToggleButton toggleButton = new JToggleButton("夹紧");
		toggleButton.setBounds(183, 240, 100, 29);
		panel_2.add(toggleButton);
		
		JToggleButton toggleButton_1 = new JToggleButton("开关");
		toggleButton_1.setBounds(310, 50, 100, 29);
		panel_2.add(toggleButton_1);
		
		JToggleButton toggleButton_2 = new JToggleButton("暂停");
		toggleButton_2.setBounds(183, 196, 100, 29);
		panel_2.add(toggleButton_2);
		
		JButton button_8 = new JButton("复位");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(80, 377, 138, 30);
		panel_1.add(textField_4);
		
		JButton btnNewButton_1 = new JButton("\u53D1\u9001");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(137, 422, 81, 29);
		panel_1.add(btnNewButton_1);
		
		JLabel label_9 = new JLabel("端口:");
		label_9.setBounds(19, 305, 50, 30);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("波特率:");
		label_10.setBounds(19, 337, 50, 30);
		panel_1.add(label_10);
		
		String[] itemscom=new String[]{"Com1","Com2","Com3"};

		JComboBox<String> comboBox = new JComboBox<String>(itemscom);
		comboBox.setToolTipText("");
		comboBox.setBounds(80, 307, 138, 27);
		comboBox.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	portname = (String)comboBox.getSelectedItem();		    	
		      }
		    });

		panel_1.add(comboBox);
		
		String[] itemsbau=new String[]{"9600","19200"};
		JComboBox<String> comboBox_1 = new JComboBox<String> (itemsbau);
		comboBox_1.setBounds(80, 339, 138, 27);
		comboBox_1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	botelv=(String)comboBox_1.getSelectedItem();
		      }
		    });
		
		panel_1.add(comboBox_1);
			
		
		panel.add(panel_2);
		panel_2.setBounds(230, 0, 430, 501);
		
		panel.add(panel_3);
		panel_3.setBounds(660, 0, 400, 501);
		
		
				
		
	}
	
	
	
	
	public static String PortName;  
	public static SerialPort serialport;
    public static OutputStream out;  
	public static InputStream in;  
}
