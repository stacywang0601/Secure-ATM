 package dao.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import commons.db.JdbcUtils;
import commons.math.math;
import dao.IAccountdao;

public class Accountdao implements IAccountdao {

	@Override
	public boolean findAccoutByIdandPin(String cardnum, String pin) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//password与数据库列表一致
		String sql = "select * from accounts where cardnum=? and password=?";
		boolean flag = false;
		
		try{
			//创建连接
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cardnum);
			pstmt.setString(2, pin);
			rs = pstmt.executeQuery();
			if(rs.next()){
				flag = true;
			}
				
			
		}catch(Exception e){
			//严重的错误，要运行错误
			new RuntimeException(e);
		}finally{
			//保证释放正常运行
			try {
				JdbcUtils.release(rs, pstmt, conn);
			} catch (SQLException e) {
				// 没释放也没有太多关系，所以直接打印处理
				e.printStackTrace();
			}
		}
		//返回false
		return flag;
	}

	@Override
	public boolean changepin(String cardnum, String pin, String newpin) {
		return false;	
	}

	@Override
	public double queryaccount(String cardnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from accounts where cardnum=?";
		double money = -1;
		
		try{
			//创建连接
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cardnum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				money = rs.getDouble("account");
			}				
		}catch(Exception e){
			//���������������������������������������������������������������������������������������������������
			new RuntimeException(e);
		}finally{
			//������������������������������������������������������������������������
			try {
				JdbcUtils.release(rs, pstmt, conn);
			} catch (SQLException e) {
				// ���������������������������������������������������������������������������������������������������������������������������������������������������������������������������
				e.printStackTrace();
			}
		}
		//������������������false
		return money;
	}

	@Override
	public boolean fetch(String cardnum, double money) {
		Connection  conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//先查看原来有多少钱，再更新
		String querysql = "select account from accounts where cardnum=?";
		String updatesql = "update accounts set account = ? where cardnum=?";
		boolean flag = false;
		try{
			conn = JdbcUtils.getConnection();
			//先设置sql语句 
			pstmt = conn.prepareStatement(querysql);
			//传卡号进去
			pstmt.setString(1, cardnum);
			//执行查询获得结果集
			rs = pstmt.executeQuery();
			double old_money = -1,new_money = -1;
			//如果有下一行，取出这个原来的钱，进行运算；
			//公式单独拿出来，不要写到sql语句里面，因为不同的利息算法不同
			if(rs.next()){
				old_money = rs.getDouble("account");
				new_money = math.sub(old_money, money);
				//如果新的有钱，执行更新
				if (new_money>0){
					pstmt = conn.prepareStatement(updatesql);
					pstmt.setDouble(1, new_money);
					pstmt.setString(2, cardnum);
					int i = pstmt.executeUpdate();
					if(i>0)
						flag = true;
				}
			}
		}catch (Exception e) {
			new RuntimeException(e);
		}finally{
			try {
				JdbcUtils.release(rs, pstmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return flag; 
	}


	@Override
	public boolean deposit(String cardnum, double money) {
		Connection  conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//先查看原来有多少钱，再更新
		String querysql = "select account from accounts where cardnum=?";
		String updatesql = "update accounts set account = ? where cardnum=?";
		boolean flag = false;
		try{
			conn = JdbcUtils.getConnection();
			//先设置sql语句 
			pstmt = conn.prepareStatement(querysql);
			//传卡号进去
			pstmt.setString(1, cardnum);
			//执行查询获得结果集
			rs = pstmt.executeQuery();
			double old_money = -1,new_money = -1;
			//如果有下一行，取出这个原来的钱，进行运算；
			//公式单独拿出来，不要写到sql语句里面，因为不同的利息算法不同
			if(rs.next()){
				old_money = rs.getDouble("account");
				new_money = math.add(old_money,money);
				//如果新的有钱，执行更新
				if (new_money>0){
					pstmt = conn.prepareStatement(updatesql);
					pstmt.setDouble(1, new_money);
					pstmt.setString(2, cardnum);
					int i = pstmt.executeUpdate();
					if(i>0)
						flag = true;
				}
			}
		}catch (Exception e) {
			new RuntimeException(e);
		}finally{
			try {
				JdbcUtils.release(rs, pstmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return flag; 
	}

}
