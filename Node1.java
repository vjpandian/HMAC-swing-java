
 /****************************************************************/ 
 /*                      Node1	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 import javax.swing.event.*; 
 import java.io.*;
  import java.net.*;
  import java.rmi.*;
 /** 
  * Summary description for Node1 
  * 
  */ 
 public class Node1 extends JFrame 
 { 
	String nodename="";
	String address="";
	int ch=0;
	int port=0;
	String readinfo="";
	String binaryKey="";
	int defalut = 15;
 	// Variables declaration 
 	private JTabbedPane jTabbedPane1; 
 	private JPanel contentPane; 
 	//----- 
 	private JTextArea jTextArea1; 
 	private JScrollPane jScrollPane1; 
 	private JButton jButton1; 
 	private JButton jButton2; 
 	private JButton jButton3; 
	private JButton jButton4; 
	private JButton jButton5; 
	private JButton jButton6; 
 	private JPanel jPanel1; 
	private JComboBox jc1;
 	//----- 
 	 static public  JTextArea jTextArea3; 
 	private JScrollPane jScrollPane3; 
 	private JPanel jPanel2; 
	private JLabel jLabel1; 
 	private JTextField jTextField1; 
	private JLabel jLabel3; 

	 		
	private int PORT=1111;
	private String node1="";
	
	ServerSocket serversocket;
	Socket socket;
	int limit=1;
 	//----- 
 	// End of variables declaration 
  
  
 	public Node1(String nodename,String port) 
 	{ 
 		super(); 
		this.nodename=nodename;
 		initializeComponent(); 
	

		//String Portno=new javax.swing.JOptionPane().showInputDialog(null,"Enter the Input For Server ");
		try
		{
			FileInputStream fileInputStream=new FileInputStream("address.txt");
        	while((ch=fileInputStream.read())!=-1){
        		address+=(char)ch;
        	}
			
				 new NodeProcess(port).start();
				 HMACInf dbUtility=(HMACInf)Naming.lookup(address+"/hmac");
				 String nodelist=dbUtility.getNodeList(nodename);
    		     String list[]=nodelist.split("@");
				  jc1.removeAllItems();
					
				  jc1.addItem("Select");
				  //JOptionPane.showMessageDialog(null,list.length);
    			for(int i=0;i<list.length;i++){
    			       	jc1.addItem(list[i]);    				        	
    			 }

		}
		catch (Exception exp)
		{
			exp.printStackTrace();
		}
 		// 
 		// TODO: Add any constructor code after initializeComponent call 
 		// 
  
 		this.setVisible(true); 
 	} 
  
 	/** 
 	 * This method is called from within the constructor to initialize the form. 
 	 * WARNING: Do NOT modify this code. The content of this method is always regenerated 
 	 * by the Windows Form Designer. Otherwise, retrieving design might not work properly. 
 	 * Tip: If you must revise this method, please backup this GUI file for JFrameBuilder 
 	 * to retrieve your design properly in future, before revising this method. 
 	 */ 
 	private void initializeComponent() 
 	{ 
	//	 String list[]={"Node 2","Node 3","Node 4"};
 		jTabbedPane1 = new JTabbedPane(); 
 		contentPane = (JPanel)this.getContentPane(); 
 		//----- 
 		jTextArea1 = new JTextArea(); 
 		jScrollPane1 = new JScrollPane(); 
 		jButton1 = new JButton(); 
 		jButton2 = new JButton(); 
 		jButton3 = new JButton(); 
		jButton4 = new JButton(); 
		jButton5 = new JButton(); 
		jButton6 = new JButton();
		 jc1=new JComboBox();
		jLabel1 = new JLabel(); 
		jLabel3 = new JLabel(); 
 		jTextField1 = new JTextField(); 
 		jPanel1 = new JPanel(); 
 		//----- 
 		jTextArea3 = new JTextArea(); 
 		jScrollPane3 = new JScrollPane(); 
 		jPanel2 = new JPanel(); 
 		//----- 
  
 		// 
 		// jTabbedPane1 
 		// 
 		jTabbedPane1.addTab("Process", jPanel1); 
 		jTabbedPane1.addTab("Message", jPanel2); 
 		jTabbedPane1.addChangeListener(new ChangeListener() { 
 			public void stateChanged(ChangeEvent e) 
 			{ 
 				jTabbedPane1_stateChanged(e); 
 			} 
  
 		}); 
 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null); 
 		addComponent(contentPane, jTabbedPane1, 35,64,588,341); 
 		// 
 		// jTextArea1 
 		// 
			// jButton4 
 		// 
 		jButton4.setText("Conversion_PROCESS"); 
 		jButton4.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton4_actionPerformed(e); 
 			} 
  
 		}); 
		jButton5.setText("Exit"); 
 		jButton5.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton5_actionPerformed(e); 
 			} 
  
 		}); 
		jButton6.setText("Browse"); 
 		jButton6.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton6_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jScrollPane1 
 		// 
 		jScrollPane1.setViewportView(jTextArea1); 
 		// 
 		// jButton1 
 		// 
 		jButton1.setText("Generate_KEY"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton2 
 		// 
 	//	jButton2.setText("Encryption_PROCESS"); 
 		jButton2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton2_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton3 
 		// 
 		jButton3.setText("Send_DATA"); 
 		jButton3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton3_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jPanel1 
 		// 
		jLabel3.setText("Select the Destination");
 		jPanel1.setLayout(null); 
		addComponent(jPanel1, jLabel1, 21,6,144,23); 
		addComponent(jPanel1, jLabel3, 371,63,144,23);
		addComponent(jPanel1, jc1, 371,97,164,23);
 		addComponent(jPanel1, jScrollPane1, 21,60,325,232); 
		addComponent(jPanel1, jTextField1, 21,33,325,25);
 		addComponent(jPanel1, jButton1, 371,130,161,26); 
 //		addComponent(jPanel1, jButton2, 371,196,161,26); 
 		addComponent(jPanel1, jButton3, 371,222,161,26); 
		
		//addComponent(jPanel1, jButton4, 371,173,161,26); 		
		addComponent(jPanel1, jButton6, 357,31,83,28); 
		addComponent(contentPane, jButton5, 291,435,101,28); 
 		// 
 		// jTextArea3 
 		// 
 		// 
 		// jScrollPane3 
 		// 
 		jScrollPane3.setViewportView(jTextArea3); 
 		// 
 		// jPanel2 
 		// 
 		jPanel2.setLayout(null); 
 		addComponent(jPanel2, jScrollPane3, 3,16,557,285); 
 		// 
 		// Node1 
 		// 
 		this.setTitle(nodename); 
 		this.setLocation(new Point(107, 10)); 
 		this.setSize(new Dimension(664, 528)); 
		//this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
 	 	addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
 	} 
  private void formWindowClosing(java.awt.event.WindowEvent evt) {
    	// TODO add your handling code here:
		
		try{
				HMACInf dbUtility=(HMACInf)Naming.lookup(address+"/hmac");
				dbUtility.setNodeStatus(nodename);
				JOptionPane.showMessageDialog(null,"Thanks for using this application");
				this.dispose();
			
		
		}catch (Exception e){
			e.printStackTrace();
		}		
			

   }
 	/** Add Component Without a Layout Manager (Absolute Positioning) */ 
 	private void addComponent(Container container,Component c,int x,int y,int width,int height) 
 	{ 
 		c.setBounds(x,y,width,height); 
 		container.add(c); 
 	} 
  
 	// 
 	// TODO: Add any appropriate code in the following Event Handling Methods 
 	// 
 	private void jTabbedPane1_stateChanged(ChangeEvent e) 
 	{ 
 		System.out.println("\njTabbedPane1_stateChanged(ChangeEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton1_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
		try{
			SessionKey sk=new SessionKey();
			String key=sk.getSessionKey();
			binaryKey=new TextToBinary().textToBinary(key);
			JOptionPane.showMessageDialog(null,"key generated");

		}catch(Exception ex){
			ex.printStackTrace();
		}
  
 	} 
  
 	private void jButton2_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton2_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jButton3_actionPerformed(ActionEvent e) 
 	{ 
		String info="";
 		System.out.println("\njButton3_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
		try{
			//JOptionPane.showMessageDialog(null,"Choose the destination");
			HMACInf dbUtility=(HMACInf)Naming.lookup(address+"/hmac");
			 
			  
			String ip="";
			String portno="";
			String readinfo="";

			String status=dbUtility.getNodeDetails(jc1.getSelectedItem().toString());

			String result[]=status.split("@");
			if(result.length>1){
				ip=result[0];
				portno=result[1];
				ip=ip.trim();
				portno=portno.trim();
				port=Integer.parseInt(portno);
			//	Socket socket=new Socket(ip,port);
			//	DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
				//dataOutputStream.writeUTF(info);

		sendData(ip,port);

			}
			 
		}catch (Exception e1){
			e1.printStackTrace();
		}

  
 	} 


		private void jButton4_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton4_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
		

  
 	} 
  	private void jButton5_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton3_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
			try{
				HMACInf dbUtility=(HMACInf)Naming.lookup(address+"/hmac");
				dbUtility.setNodeStatus(nodename);
				JOptionPane.showMessageDialog(null,"Thanks for using this application");
				this.dispose();
			
		
		}catch (Exception e3){
			e3.printStackTrace();
		}		
			
  
 	} 
	private void jButton6_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njButton3_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
		try{
			FileDialog fileDialog= new  FileDialog(this,"open",FileDialog.LOAD);
        	fileDialog.show();
        	if(fileDialog.getDirectory()==null){
        		jTextField1.setText("");
        	}else{
        		jTextField1.setText(fileDialog.getDirectory()+fileDialog.getFile());
        	}
			String file=fileDialog.getDirectory()+fileDialog.getFile();
			JOptionPane.showMessageDialog(null,file);

			readinfo="";
			BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
    				String content="";
	    			while((content=bufferedReader.readLine())!=null){
						readinfo+=content+"\n";
    				}
					jTextArea1.append("\nThe content is \n\t"+readinfo+"\n");
		}catch (Exception e2){
			e2.printStackTrace();
		}
  
 	} 
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
  
  
  
  
  
  
  
  /**  To Send Data Into Packets   **/

	public void sendData(String name,int port)
	{
		String binaryString="";
		String inputString="";
		String resultString1="";
		String	resultString2="";
		try
		{
			System.out.println("~~~~~~~~~~~~~~~~"+name+"~~~~~~~~~"+port);

			Socket n1_client=new Socket(name,port);
			DataOutputStream out=new DataOutputStream(n1_client.getOutputStream());
			String kk=binaryKey;
			out.writeUTF(kk);
			if(out!=null)
			{
					out.flush();
			}
					int outgoing=0;
					byte buffer[]=readinfo.getBytes();
					int len=buffer.length;
					int tlength=buffer.length/20;
					int length11=buffer.length%20;
					int len1=len;
				if(length11!=0)
				{
					tlength++;
				}
				out.writeInt(tlength);

				int st=0;
				int end=20;
           		
				
				System.out.println("Message Length:    "+len);

				
			if(len<=20)
			 {

			
				 System.out.println("Message: "+readinfo);
				 System.out.println("Out going Packets: "+(++outgoing));
				inputString=readinfo;
				binaryString = new TextToBinary().textToBinary(inputString);  
				System.out.println("binary String ^^^^^^^^^^^^^^^"+binaryString);
				resultString1 = new XorCalculation().xorCalculator(binaryString, binaryKey);
				resultString2 = new XorCalculation().xorCalculator(resultString1, Integer.toBinaryString(defalut));
				System.out.println("resultString"+resultString2);
				out.writeUTF(resultString2);
				 			

			 }
			 else
			  {
			
				System.out.println("Message: "+readinfo.substring(st,end));
				 System.out.println("Out going Packets: "+(++outgoing));
				inputString=readinfo.substring(st,end);
				binaryString = new TextToBinary().textToBinary(inputString);  
					System.out.println("binary String ^^^^^^^^^^^^^^^"+binaryString);
				resultString1 = new XorCalculation().xorCalculator(binaryString, binaryKey);
				resultString2 = new XorCalculation().xorCalculator(resultString1, Integer.toBinaryString(defalut));
				System.out.println("resultString"+resultString2);
				out.writeUTF(resultString2);
							
						if(outgoing>limit)
						  {
								Thread.sleep(2);
						  }
						else
						  {
								Thread.sleep(1);
						  }
				  while(len1>20)
				  {
					 len1-=20;
					 if(len1<=20)
					  {
					
					 System.out.println("Message: "+readinfo.substring(end,len));
					  System.out.println("Out going Packets: "+(++outgoing));
					inputString=readinfo.substring(end,len);
					binaryString = new TextToBinary().textToBinary(inputString);  
						System.out.println("binary String ^^^^^^^^^^^^^^^"+binaryString);
					resultString1 = new XorCalculation().xorCalculator(binaryString, binaryKey);
					resultString2 = new XorCalculation().xorCalculator(resultString1, Integer.toBinaryString(defalut));
					System.out.println("resultString"+resultString2);
					out.writeUTF(resultString2);
					
					 		
  					 	if(outgoing>=limit)
						  {
								Thread.sleep(2);
						  }
						else
						  {
							Thread.sleep(1);
						  }
					  }
					  else
					  {
					
							int sp=end+20;
							System.out.println("Message: "+readinfo.substring(end,sp));
							 System.out.println("Out going Packets: "+(++outgoing));
							
							inputString=readinfo.substring(end,sp);
							binaryString = new TextToBinary().textToBinary(inputString);  
								System.out.println("binary String ^^^^^^^^^^^^^^^"+binaryString);
							resultString1 = new XorCalculation().xorCalculator(binaryString, binaryKey);
							resultString2 = new XorCalculation().xorCalculator(resultString1, Integer.toBinaryString(defalut));
							System.out.println("resultString"+resultString2);
							out.writeUTF(resultString2);
							
							
							end=sp;
						if(outgoing>=limit)
						  {
								Thread.sleep(2);
						  }
						else
						  {
							Thread.sleep(1);
						  }
					  }
				  }
			   }
		}
		catch (Exception exp)
		{
			exp.printStackTrace();
		}
	
	
	
	}

  /*****/
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

  
  
  
  
   
  
 //============================= Testing ================================// 
 //=                                                                    =// 
 //= The following main method is just for testing this class you built.=// 
 //= After testing,you may simply delete it.                            =// 
 //======================================================================// 
 	public static void main(String[] args) 
 	{ 
 		JFrame.setDefaultLookAndFeelDecorated(true); 
 		JDialog.setDefaultLookAndFeelDecorated(true); 
 		try 
 		{ 
 			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
 		} 
 		catch (Exception ex) 
 		{ 
 			System.out.println("Failed loading L&F: "); 
 			System.out.println(ex); 
 		} 
 		new Node1("Test","1111"); 
 	} 
 //= End of Testing = 
  
  
 } 
  
 