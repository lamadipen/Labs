package mum.waa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mum.waa.model.User;
import mum.waa.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("view/index.jsp");
		RequetsDispatcherObj.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserService userService = new UserService();
		
		if(userService.validateUser(user) == true)
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
		
			response.sendRedirect(request.getContextPath() + "/view/success.jsp");
			
			//RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("view/success.jsp");
			//RequetsDispatcherObj.forward(request, response);
		}
		else
		{
			RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("view/index.jsp");
			RequetsDispatcherObj.forward(request, response);
		}
		
	}

}
