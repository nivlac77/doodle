package MyServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MyBeans.Detail;

/**
 * Servlet implementation class DateDelete
 */
@WebServlet("/DateDelete")
public class DateDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//define session 
		HttpSession session = request.getSession();
		//get chosen dates
		ArrayList<Detail> storedDetails = (ArrayList<Detail>) session.getAttribute("details");
		//get date to delete
		String dateToDelete = request.getParameter("dateToDelete");
		//find it
		int indexToDelete = 100;
		for(int i = 0; i < storedDetails.size(); i++){
			if(storedDetails.get(i).getDate().equals(dateToDelete)){
				indexToDelete = i;
			}
		}
		//remove
		storedDetails.remove(indexToDelete);
		//update session
		session.setAttribute("details", storedDetails);
		response.sendRedirect("select_dates.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
