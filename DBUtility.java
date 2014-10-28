
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBUtility extends UnicastRemoteObject implements HMACInf{
	Connection connection,connection1;
	PreparedStatement preparedStatement,preparedStatement1;
	ResultSet resultSet,resultSet1;
	DBConnection dbConnection=new DBConnection();
	int update=0;
	int count=0;
	
	public DBUtility() throws RemoteException{		
		// TODO Auto-generated constructor stub
	}
	public int insertNode(String nodename,String pwd) throws  RemoteException {
			String status="Disconnected";
		try{String port="",ipaddress="";

			//DBConnection dbConnection=new DBConnection();
			connection=dbConnection.dbConnect();
			preparedStatement=connection.prepareStatement("select count(*) from node");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				count=resultSet.getInt(1);
			}
			port="100"+count;
			connection.close();
			connection=dbConnection.dbConnect();
			preparedStatement=connection.prepareStatement("insert into node values(?,?,?,?,?)");
			preparedStatement.setString(1,nodename);
			preparedStatement.setString(2,pwd);
			preparedStatement.setString(3,ipaddress);
			preparedStatement.setString(4,port);
			preparedStatement.setString(5,status);

			
			update=preparedStatement.executeUpdate();
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return update;
	}
	
	public int checkNodeLogin(String nodename,String pwd) {
		try{
			
			connection=dbConnection.dbConnect();
			preparedStatement=connection.prepareStatement("select * from node where nodename=? and pwd=? ");
			preparedStatement.setString(1,nodename);
			preparedStatement.setString(2,pwd);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				update=1;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return update;
		
	}
	public int setNodeIPAddress(String ipaddress,String nodename)throws  RemoteException{
		try {
	
			connection=dbConnection.dbConnect();
			preparedStatement1=connection.prepareStatement("update node set ipaddress=?, status='connected' where nodename=?");
			preparedStatement1.setString(1,ipaddress);
			preparedStatement1.setString(2,nodename);
			update=preparedStatement1.executeUpdate();
			System.out.println("update"+"<------------>"+update);
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return update;
	}

	public String getNodePort(String nodename) throws RemoteException{
			String status="";
			try {
			
			connection1=dbConnection.dbConnect();
			preparedStatement1=connection1.prepareStatement("select * from node where nodename=?");
			preparedStatement1.setString(1,nodename);
			resultSet1=preparedStatement1.executeQuery();

			if(resultSet1.next()){
					status=resultSet1.getString("port");
			}
			System.out.println("<<  Status >>"+status);
			connection1.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return status;
}
	public String getNodeList(String nodename) throws RemoteException{
	String status="";
	try{
			connection1=dbConnection.dbConnect();
			preparedStatement1=connection1.prepareStatement("select * from node where nodename<>? ");
			preparedStatement1.setString(1,nodename);
			resultSet1=preparedStatement1.executeQuery();

			while(resultSet1.next()){
					status+=resultSet1.getString("nodename")+"@";
			}
			connection1.close();
	}catch(Exception e){
		e.printStackTrace();
	}
		return status;
	}
	public String getNodeDetails(String nodename) throws RemoteException{
	String status="";
	try{
			connection1=dbConnection.dbConnect();
			preparedStatement1=connection1.prepareStatement("select * from node where nodename=? ");
			preparedStatement1.setString(1,nodename);
			resultSet1=preparedStatement1.executeQuery();

			if(resultSet1.next()){
					status=resultSet1.getString("ipaddress")+"@"+resultSet1.getString("port");
			}
			connection1.close();
	}catch(Exception e){
		e.printStackTrace();
	}
		return status;
	}
	public int  setNodeStatus(String nodename) throws RemoteException{
	try {
			String ipaddress="";
			connection=dbConnection.dbConnect();
			preparedStatement1=connection.prepareStatement("update node set ipaddress=?, status='Disconnected' where nodename=?");
			preparedStatement1.setString(1,ipaddress);
			preparedStatement1.setString(2,nodename);
			update=preparedStatement1.executeUpdate();
			System.out.println("update"+"<------------>"+update);
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return update;
	}
	


}
