package restaurantsoftware;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author kiran_000
 */
public class DBConnector {
    protected static Statement  stmt = null;
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1995");
        return connection;
}

  
    public static void write(String query) {
		PreparedStatement preparedStatement1 = null;
		
		try {
			preparedStatement1 = getConnection().prepareStatement(query);
			preparedStatement1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement1.close();
				getConnection().close();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
} 
     
}