import java.net.*;
import java.io.*;
import java.rmi.*;
public class NodeProcess extends Thread
{
	static	String getinfo="";
	int portno;
	int i;
	int defalut=15;
	String binaryKey="";
	String port1="";
	NodeProcess(String port){
		System.out.println("just to let you know that you are in the constructor"+port);
		port1=port;
		port1=port1.trim();
		portno=Integer.parseInt(port1);
	
	}
public void run(){
	String address="";
	//String status="";
	int ch=0;
						try
						{
						String rr="";
						ServerSocket server_1=new ServerSocket(portno);
						Socket socket_1=server_1.accept();	
						Node1.jTextArea3.setText("");
						DataInputStream dis=new DataInputStream(socket_1.getInputStream());
						String kk=dis.readUTF();
						binaryKey=kk;
						//String status[]=kk.split("@");
						//if(status[0].equalsIgnoreCase("key")){
								//binaryKey=status[1];
								System.out.println("binary Key============"+binaryKey);
					//	}
						int length=dis.readInt();
						System.out.println("Packet Length :"+length);
							while(length>0)
							{
								rr=dis.readUTF();	
								
								String deString = rr;
								String textString = "";
								String keyString ="";
								String  originalString = "";
							//  textString = new BinaryToText().binaryToText(deString);
							  XorCalculation xorCalculation = new XorCalculation();
							 deString = xorCalculation.xorCalculator(deString, Integer.toBinaryString(defalut));
							System.out.println("Destring :"+deString);
								textString=xorCalculation.xorCalculator(deString, binaryKey);
						     //originalString = new BinaryToText().binaryToText();

								System.out.println("textString   =="+ textString);

			
								Node1.jTextArea3.append(new BinaryToText().binaryToText(textString+"\n"));
								length--;
								i++;
							}
					
						}
						catch (Exception exp)
						{
							exp.printStackTrace();
						}
			
		}
	
}
