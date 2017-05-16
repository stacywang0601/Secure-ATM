 package web;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.IAccountManager;
import domain.imp.AccountManager;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//创建session
		HttpSession session = request.getSession();
		//获取卡号密码，
		String cardNum = request.getParameter("cardnum");
		String pwd = request.getParameter("pwd");
		String mdpwd = null;
	
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");  
		    byte[] cipherData = md5.digest(pwd.getBytes());  
		    StringBuilder builder = new StringBuilder();  
		    for(byte cipher : cipherData) {  
		        String toHexStr = Integer.toHexString(cipher & 0xff);  
		        builder.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);  
		    }  
		    mdpwd = builder.toString();
		    //System.out.println(mdpwd);  
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//web调用业务逻辑层
		IAccountManager accountManager = new AccountManager();
		boolean flag = accountManager.login(cardNum, mdpwd);
		//如果匹配进入main
		if(flag){
			//session里面存放卡号，便于后续操作
			session.setAttribute("cardnum", cardNum);
			//转发至main
			request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
		}else{
			//再login里面添加message
			request.setAttribute("message", "Wrong carnum or PIN");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
		
	}
	
	
}
