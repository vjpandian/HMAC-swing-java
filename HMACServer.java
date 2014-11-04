import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class HMACServer {
	public static void main(String arg[])throws RemoteException,MalformedURLException{
		HMACInf hmacInf=new DBUtility();
		Naming.rebind("hmac",hmacInf );
	}
}
