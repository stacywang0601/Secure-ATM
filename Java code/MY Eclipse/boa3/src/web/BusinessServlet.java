package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import domain.IAccountManager;
import domain.imp.AccountManager;

/**
 * Servlet implementation class BusinessServlet
 */
@WebServlet("/BusinessServlet")
public class BusinessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//choose different option based on parameter op
		String op = request.getParameter("op");
		//web call manager of logic layer
		IAccountManager accountManager = new AccountManager();
		//get session from request
		HttpSession session = request.getSession();
		//get cardnum from session
		String cardNum = (String)session.getAttribute("cardnum");
		if(op.equals("queryBalance")){
			//call querybalance function from logic layer
			double money = accountManager.querybalance(cardNum);
			//put money into request
			request.setAttribute("cardnum", money);
			//forward request to balance.jsp
			request.getRequestDispatcher("/WEB-INF/jsp/balance.jsp").forward(request, response);
		}else if(op.equals("deposit")){
			request.getRequestDispatcher("/WEB-INF/jsp/deposit.jsp").forward(request, response);
		}else if(op.equals("fetch")){
			//first forward to fetch.jsp ,then get money by post, so deal with it using doPost function
			request.getRequestDispatcher("/WEB-INF/jsp/fetch.jsp").forward(request, response);
		}else if(op.equals("changePwd")){
			
		}else if(op.equals("exit")){
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//same as do Get
		String op = request.getParameter("op");
		IAccountManager accountManager = new AccountManager();
		HttpSession session = request.getSession();
		String cardNum = (String)session.getAttribute("cardnum");
		//hidden op in the fetch.jsp
		if(op.equals("fetchmoney")){
			String money = request.getParameter("money");
			//call fetch function in logic layer
			boolean flag = accountManager.fetch(cardNum, Double.parseDouble(money));
			if(flag){
				//add success ${message } to main.jsp
				request.setAttribute("message", "Withdrawals success");
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			}else{
				//add failure ${message } to main.jsp
				request.setAttribute("message", "Withdrawals failure");
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			}
				
		} else if(op.equals("deposit")){
			String money = request.getParameter("money");
			boolean flag = accountManager.deposit(cardNum, Double.parseDouble(money));
			if(flag){
				request.setAttribute("message", "Deposit success");
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "Deposit failure");
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			}
			
		}
	}

}
