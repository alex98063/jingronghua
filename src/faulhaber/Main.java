package faulhaber;

import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private JPanel panel;

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
		
		frame.setBounds(100, 100, 800, 600);
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
				
				
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				panel.setVisible(true);
				frame.setVisible(true);
			
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
				JPanel jpanelconfig= new JPanel();
				frame.getContentPane().add(jpanelconfig, BorderLayout.CENTER);
				jpanelconfig.setLayout(null);
		        				
				JLabel lblDd = new JLabel("\u8F68\u578B\uFF1A");
				lblDd.setBounds(31, 66, 102, 21);
				jpanelconfig.add(lblDd);
				
				String[] item = {"60","70","45"};
				JComboBox<String> comboBox = new JComboBox<String>(item);
				comboBox.setBounds(164, 63, 123, 27);
				jpanelconfig.add(comboBox);
				comboBox.setSelectedIndex(0);
				
				JLabel label = new JLabel("\u710A\u7F1D\u5E95\u5BBD\uFF1A");
				label.setBounds(31, 118, 102, 21);
				jpanelconfig.add(label);
				
				JLabel label_1 = new JLabel("\u710A\u7F1D\u9876\u5BBD\uFF1A");
				label_1.setBounds(31, 154, 102, 21);
				jpanelconfig.add(label_1);
				
				JLabel label_2 = new JLabel("\u710A\u4E1D\u66F2\u7387\u534A\u5F84\uFF1A");
				label_2.setBounds(31, 190, 102, 21);
				jpanelconfig.add(label_2);
				
				JLabel label_3 = new JLabel("\u73AF\u5883\u6E29\u5EA6\uFF1A");
				label_3.setBounds(31, 226, 102, 21);
				jpanelconfig.add(label_3);
				
				textField = new JTextField();
				textField.setBounds(164, 104, 123, 27);
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
				
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(164, 146, 123, 27);
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
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(164, 187, 123, 27);
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
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(164, 223, 123, 27);
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
				
				JButton button = new JButton("\u53D6\u6D88");
				button.setBounds(31, 304, 123, 29);
				jpanelconfig.add(button);
				button.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		               
		            	
		            	jpanelconfig.setVisible(false);
		            	
		            }
		        });
				
				JButton button_1 = new JButton("\u786E\u5B9A");
				button_1.setBounds(164, 304, 123, 29);
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
		
		panel = new JPanel();	
		panel.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.add(new JLabel("ddddddddd"));
		panel.add(panel_1, BorderLayout.WEST);	
		
		
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.EAST);
		
		
		
	
		
		
		
		
		
	}
}
