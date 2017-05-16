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
		
		//set up http session
		HttpSession session = request.getSession();
		//get cardnum and pwd
		String cardNum = request.getParameter("cardnum");
		String pwd = request.getParameter("pwd");
		String mdpwd = null;
	    
	    //encrpyt pwd using md5 digest algorithm
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
		
		//web call manager 
		IAccountManager accountManager = new AccountManager();
		boolean flag = accountManager.login(cardNum, mdpwd);
		//if it matched, then go to main.jsp
		if(flag){
			//put cardnum into session so that it would be easy later
			session.setAttribute("cardnum", cardNum);
			//go to main
			request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
		}else{
			//if not matched, return worng message,stay at login.jsp
			request.setAttribute("message", "Wrong carnum or PIN");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
		
	}
	
	
}
