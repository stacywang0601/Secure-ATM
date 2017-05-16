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
		//根据op不同，选择不同操作
		String op = request.getParameter("op");
		//创建业务逻辑层类
		IAccountManager accountManager = new AccountManager();
		//创建session
		HttpSession session = request.getSession();
		//卡号放入session,获取的是对象类型，所以要转换为string
		String cardNum = (String)session.getAttribute("cardnum");
		if(op.equals("queryBalance")){
			//调用查询余额
			double money = accountManager.querybalance(cardNum);
			//余额放到request，balance里面加上${cardnum} ，当存放后可以显示
			request.setAttribute("cardnum", money);
			//请求转发过去，直接显示余额
			request.getRequestDispatcher("/WEB-INF/jsp/balance.jsp").forward(request, response);
		}else if(op.equals("deposit")){
			request.getRequestDispatcher("/WEB-INF/jsp/deposit.jsp").forward(request, response);
		}else if(op.equals("fetch")){
			//取钱：1跳转到fetch页面，在里面输入钱数提交；2再选择op，传着金额选择，此次是post请求，见下方!!!
			request.getRequestDispatcher("/WEB-INF/jsp/fetch.jsp").forward(request, response);
		}else if(op.equals("changePwd")){
			
		}else if(op.equals("exit")){
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//前面公共部分一样
		String op = request.getParameter("op");
		IAccountManager accountManager = new AccountManager();
		HttpSession session = request.getSession();
		String cardNum = (String)session.getAttribute("cardnum");
		//fetch里面hidden了op fetch money
		if(op.equals("fetchmoney")){
			//卡号从session里面取出来，钱数从表单（request.getparameter ）里面得出，得出的是string
			String money = request.getParameter("money");
			//定义方法时，是double类型，所以转换一下；验证是否成功
			boolean flag = accountManager.fetch(cardNum, Double.parseDouble(money));
			if(flag){
				//main页面里面加上${message }显示成功信息
				request.setAttribute("message", "Withdrawals success");
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			}else{
				//fetch页面里面加上${message }显示失败信息
				request.setAttribute("message", "Withdrawals failure");
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			}
				
		} else if(op.equals("deposit")){
			//卡号从session里面取出来，钱数从表单（request.getparameter ）里面得出，得出的是string
			String money = request.getParameter("money");
			//定义方法时，是double类型，所以转换一下；验证是否成功
			boolean flag = accountManager.deposit(cardNum, Double.parseDouble(money));
			if(flag){
				//main页面里面加上${message }显示成功信息
				request.setAttribute("message", "Deposit success");
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			}else{
				//fetch页面里面加上${message }显示失败信息
				request.setAttribute("message", "Deposit failure");
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			}
			
		}
	}

}
