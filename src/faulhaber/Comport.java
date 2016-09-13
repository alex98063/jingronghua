package faulhaber;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TooManyListenersException;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;


public class Comport implements SerialPortEventListener
{

	public static SerialPort serialport;
    public static OutputStream out;  
	public static InputStream in;  
	public CommPortIdentifier  portid;
	public static String test = "";

	
	
	@Override
	public void serialEvent(SerialPortEvent event) {
		// TODO Auto-generated method stub
	
		switch (event.getEventType())
		{
		case SerialPortEvent.DATA_AVAILABLE://获取到串口返回信息
			readdata();
			break;
			default:
				break;
				
		}
		
	}
	
	public void readdata() {
	
		byte[] readBuffer = new byte[512];
		try {
			in = serialport.getInputStream();
			int len = 0;
			String test="";
			
			while ((len = in.read(readBuffer)) != -1) 
			{
				
				test=new String(readBuffer, 0, len);		
				
				break;
				
			}			
			
			System.out.print(test.trim());
			//in.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void writedata(String data)
	{ 
		System.out.println();	
		System.out.print(data+":");	
		
		  try{
			
			  data += "\r\n";
			  
              out = serialport.getOutputStream();              
              out.write(data.getBytes());  
              try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              out.flush();
              out.close();
              
          } catch (IOException e) {
              e.printStackTrace();
          }
         
	}
	
	
	public void close()
	{
	    String pn = portid.getName();
	    try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		serialport.close();
		System.out.println(pn+"串口已经关闭!");
		
	}
	
	
	
	public void connect(String portname,String botelv)
	{
		try {
    		
			 portid = CommPortIdentifier.getPortIdentifier(portname);
			 
			 serialport = (SerialPort) portid.open("JavaRs232", 2000);
			 serialport.setSerialPortParams(Integer.valueOf(botelv), 8, 1, 0);
			
			 try {
				serialport.addEventListener(new Comport());
				serialport.notifyOnDataAvailable(true);
			} catch (TooManyListenersException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     System.out.println(portname+"串口已经打开!");
			
   	}
   	catch (NoSuchPortException e1) {
			// TODO Auto-generated catch block
   		
			e1.printStackTrace();
			
		}
    	catch (PortInUseException e2) {
		// TODO Auto-generated catch block
   		
			e2.printStackTrace();
			
		} catch (NumberFormatException e3) {
			// TODO Auto-generated catch block
			
			e3.printStackTrace();
		} catch (UnsupportedCommOperationException e4) {
			// TODO Auto-generated catch block
		
			e4.printStackTrace();
		}  
         
	}

}


