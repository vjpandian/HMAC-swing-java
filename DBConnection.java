import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection
{
	private Connection connection;
	public Connection dbConnect() throws Exception{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection=DriverManager.getConnection("jdbc:odbc:HMAC");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}
}