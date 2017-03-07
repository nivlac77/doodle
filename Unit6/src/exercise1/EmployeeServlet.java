package exercise1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnSubmit").equals("add new employee")){
			Employee employee = new Employee();
			employee.setId(1);
			employee.setName(request.getParameter("name"));
			employee.setDepartment(request.getParameter("dept"));
			employee.setGender(request.getParameter("gender"));
			employee.setCountry(request.getParameter("country"));
			employee.setSalary(Double.parseDouble(request
					.getParameter("salary")));

			// add to db
			DBConnection db = new DBConnection();
			db.insertEmployee(employee);

			// send to employees table
			response.sendRedirect("index.jsp");
		} else if(request.getParameter("btnSubmit").equals("delete")){
			// delete from db
			DBConnection db = new DBConnection();
			int id = Integer.parseInt(request.getParameter("selectedEmployee"));
			db.deleteEmployee(id);
			// send to employees table
			response.sendRedirect("index.jsp");
		} else if(request.getParameter("btnSubmit").equals("update")){
			// update from db
			DBConnection db = new DBConnection();
			Employee e = new Employee();
			e.setId(Integer.parseInt(request.getParameter("employeeId")));
			e.setName(request.getParameter("name"));
			e.setDepartment(request.getParameter("dept"));
			e.setGender(request.getParameter("gender"));
			e.setCountry(request.getParameter("country"));	
			e.setSalary(Double.parseDouble(request.getParameter("salary")));
			db.updateEmployee(e);
			// send to employees table
			response.sendRedirect("index.jsp");
		} else if(request.getParameter("btnSubmit").equals("Apply")){
			HttpSession session = request.getSession();
			DBConnection db = new DBConnection();
			ArrayList<Employee> employees = db.findAllEmployees();
			ArrayList<Employee> filteredEmployees = new ArrayList<Employee>();
			String filter = request.getParameter("filter");
			if(filter.equals("findAll")){
				session.setAttribute("employees", employees);
			}else if(filter.equals("sortBySalary") && employees.size() > 0){
		
				
				for(int i = 0; i < employees.size(); i++){
					double minSalary = employees.get(i).getSalary();
					Employee minEmployee = employees.get(i);
					int minIndex = i;
					for(int j = i + 1; j < employees.size(); j++){
						if(minSalary > employees.get(j).getSalary()){
							minIndex = j;
							minSalary = employees.get(j).getSalary();
							minEmployee = employees.get(j);
						}
					}
					filteredEmployees.add(minEmployee);
					if(minIndex != i){
						Employee temp = employees.get(i);
						employees.set(i, minEmployee);
						employees.set(minIndex, temp);
					}
				}
				session.setAttribute("employees", filteredEmployees);
			}else if(filter.equals("findMale")){
				for(Employee e : employees){
					if(e.getGender().toLowerCase().equals("male"))
						filteredEmployees.add(e);
				}
				session.setAttribute("employees", filteredEmployees);
			}else if(filter.equals("findFemale")){
				for(Employee e : employees){
					if(e.getGender().toLowerCase().equals("female"))
						filteredEmployees.add(e);
				}
				session.setAttribute("employees", filteredEmployees);
			}
			// send to employees table
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
