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
		//cardnum password same as in db
		String sql = "select * from accounts where cardnum=? and password=?";
		boolean flag = false;
		
		try{
			//set up connection using JdbcUtils
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cardnum);
			pstmt.setString(2, pin);
			rs = pstmt.executeQuery();
			if(rs.next()){
				flag = true;
			}
				
			
		}catch(Exception e){
			//serious problem
			new RuntimeException(e);
		}finally{
			//ensure to close properly
			try {
				JdbcUtils.release(rs, pstmt, conn);
			} catch (SQLException e) {
				// not too serious ,just print
				e.printStackTrace();
			}
		}
		//return false if no account found
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
			//set up connection
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cardnum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				money = rs.getDouble("account");
			}				
		}catch(Exception e){
			new RuntimeException(e);
		}finally{
			try {
				JdbcUtils.release(rs, pstmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return money;
	}

	@Override
	public boolean fetch(String cardnum, double money) {
		Connection  conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//first get the original account then update
		String querysql = "select account from accounts where cardnum=?";
		String updatesql = "update accounts set account = ? where cardnum=?";
		boolean flag = false;
		try{
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(querysql);
			pstmt.setString(1, cardnum);
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
		//first check account and then compute the new account
		String querysql = "select account from accounts where cardnum=?";
		String updatesql = "update accounts set account = ? where cardnum=?";
		boolean flag = false;
		try{
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(querysql);
			pstmt.setString(1, cardnum);
			rs = pstmt.executeQuery();
			double old_money = -1,new_money = -1;
			if(rs.next()){
				old_money = rs.getDouble("account");
				new_money = math.add(old_money,money);
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
