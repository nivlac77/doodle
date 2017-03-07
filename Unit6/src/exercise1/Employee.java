package exercise1;

public class Employee {
	private int id;
	private String name;
	private String department;
	private String gender;
	private String country;
	private double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employee(int id, String name, String department, String gender,
			String country, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.gender = gender;
		this.country = country;
		this.salary = salary;
	}
	
	public Employee() {
	}
}
