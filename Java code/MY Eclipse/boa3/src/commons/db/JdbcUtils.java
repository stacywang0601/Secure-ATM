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
	//放在外侧：都可以用
	private static DataSource dataSource = null;
	//静态代码块放公用的东西；的没办法抛，就try处理掉
	static{
		Properties prop = new Properties();
	    InputStream inStream = JdbcUtils.class.getClassLoader().getResourceAsStream("commons//db//dbcpconfig.properties");//zuoxiayoushang
	     //InputStream inStream = new FileInputStream("/Users/wenchaowang/Documents/workspace1/dbpc/src/dbcpconfig.properties");
		try {
			prop.load(inStream);
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			//因为找不到东西根本连不上数据库，所以try完了不处理，直接抛出严重错误
			throw new ExceptionInInitializerError();
			//finally 即使出异常，依旧可以关闭输入流，关闭不了顶多浪费点资源，所以打印一下即可
		}finally{
			try {
				inStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//获取数据源
	public static DataSource getDataSource(){
		return dataSource; 
	}
	//获取连接；直接抛出，工具类，被别人调用，你要是认为严重就抛
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection(); 
	}
	public static void release(ResultSet rs,Statement pstmt, Connection con) throws SQLException{
		//finally上面异常，下面依旧可以执行；没有catch，没有处理，抛出去，工具类，被别人调用，你要是认为严重就抛
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
