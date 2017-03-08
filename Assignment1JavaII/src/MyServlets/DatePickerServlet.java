package MyServlets;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MyBeans.*;

/**
 * Servlet implementation class DatePickerServlet
 */
@WebServlet("/DatePickerServlet")
public class DatePickerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatePickerServlet() {
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
		ArrayList<Detail> storedDetails = new ArrayList<Detail>();
		String dates = request.getParameter("test");
		if(dates != null){
			String line = null;
			StringTokenizer st = new StringTokenizer(dates);
			while(st.hasMoreTokens()){
				line = st.nextToken("\",\"").trim();
				if(!line.equals("]") && !line.equals("[")){
					storedDetails.add(new Detail(line));
				}
			}
			//store in session
			session.setAttribute("details", storedDetails);
		}	
		response.sendRedirect("select_dates.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
