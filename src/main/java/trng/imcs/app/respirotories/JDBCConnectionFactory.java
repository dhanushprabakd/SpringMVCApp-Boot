package trng.imcs.app.respirotories;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class JDBCConnectionFactory {

	private static JDBCConnectionFactory jdbcConnectionFactory;
	private Connection connection;
	private static final String FILENAME="credentials.properties";
	private JDBCConnectionFactory(){
		
	}
	
	public static JDBCConnectionFactory createInstance(){
		if(jdbcConnectionFactory==null)
			jdbcConnectionFactory = new JDBCConnectionFactory();
		return jdbcConnectionFactory;
	}
	
	public static Connection getConnection(){
		return createInstance().createConnection();
	} 
	
	private Connection createConnection(){
		Properties credentialsProperties = null;
		boolean connectionStatus = false;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			credentialsProperties= new Properties();
			InputStream inputStream = classLoader.getResourceAsStream(FILENAME);
			credentialsProperties.load(inputStream);
			Class.forName(credentialsProperties.getProperty("driver"));
			String url = credentialsProperties.getProperty("url");
			String user = credentialsProperties.getProperty("user");
			String password = credentialsProperties.getProperty("password");
			connection = DriverManager.getConnection(url, user, password);
			connectionStatus=true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		if(connectionStatus)
			return connection;
		else
			return null;
	}
}
