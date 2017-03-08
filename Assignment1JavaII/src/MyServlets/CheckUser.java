package MyServlets;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBConnection;
import MyBeans.User;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//define session 
		HttpSession session = request.getSession();
		//define connection
		DBConnection db = new DBConnection();
		//if sign in
		if(request.getParameter("btn").equals("Sign In")){
			System.out.println(request.getParameter("usernameIn"));
			User user = new User(request.getParameter("usernameIn"),request.getParameter("passwordIn"));
			if(db.findUsername(user.getUsername())){
				session.setAttribute("username", user.getUsername());
			}
			else{
				session.setAttribute("error", "this user doesn't exist");
			}
		}else{
			User user = new User(request.getParameter("usernameUp"),request.getParameter("passwordUp"));
			if(!db.findUsername(user.getUsername())){
				db.insertUser(user);
			}
			else{
				session.setAttribute("error", "this user already exists");
			}
		}
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
