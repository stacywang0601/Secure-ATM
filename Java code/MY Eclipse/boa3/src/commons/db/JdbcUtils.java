package commons.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;



public class JdbcUtils {
	//static to share
	private static DataSource dataSource = null;
	//can't throw exception in static block, so try
	static{
		Properties prop = new Properties();
		//use relative path instead of absolute path
	    InputStream inStream = JdbcUtils.class.getClassLoader().getResourceAsStream("commons//db//dbcpconfig.properties");//zuoxiayoushang
	     //InputStream inStream = new FileInputStream("/Users/wenchaowang/Documents/workspace1/dbpc/src/dbcpconfig.properties");
		try {
			prop.load(inStream);
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			//can't connect to db if it can't find properties, serious problem, throw
			throw new ExceptionInInitializerError();
		}finally{
			//ensure to close it
			try {
				inStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//get datasource
	public static DataSource getDataSource(){
		return dataSource; 
	}
	//get connection；throw exception since it is an util class
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection(); 
	}

	//throw exception instead of catch since it is an tuil class
	public static void release(ResultSet rs,Statement pstmt, Connection con) throws SQLException{
		//use funally to ensure the code to be excuted
		try {
				if (rs != null){
				rs.close();
				} 
		}finally {
				try{
					if (pstmt != null){
					pstmt.close();
					}
				}finally{
					if (con != null){
						con.close();
					}
				}	
		}
		}
}
