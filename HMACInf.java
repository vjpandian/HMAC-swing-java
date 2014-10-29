import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;

public interface HMACInf extends Remote {
	public int insertNode(String nodename,String pwd) throws RemoteException;
	public int checkNodeLogin(String nodename,String pwd) throws RemoteException;
	public int setNodeIPAddress(String ipaddress, String nodename) throws RemoteException;
	public String getNodePort(String nodename) throws RemoteException;
	public String getNodeList(String nodename) throws RemoteException;
	public String getNodeDetails(String nodename) throws RemoteException;	
	public int  setNodeStatus(String nodename) throws RemoteException;
}
