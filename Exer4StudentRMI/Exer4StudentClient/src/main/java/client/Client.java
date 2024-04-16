package client;

import java.rmi.Naming;
import java.util.Map;

import dao.CourseDAO;
import dao.DepartmentDAO;
import dao.StudentDAO;

public class Client {
	private static final String URL = "rmi://127.0.0.1:7878/";
	public static void main(String[] args) {
		try {
			CourseDAO courseDAO = (CourseDAO) Naming.lookup(URL + "courseDAO");
			StudentDAO studentDAO = (StudentDAO) Naming.lookup(URL + "studentDAO");
			DepartmentDAO departmentDAO = (DepartmentDAO) Naming.lookup(URL + "departmentDAO");
			
			
			departmentDAO.findDepartmentNotOwnerCourse().forEach(x -> System.out.println(x));
			
			studentDAO.findAll().forEach(x -> System.out.println(x));

			departmentDAO.countCoursesByDepartment().forEach((k, v) -> System.out.println(k + " : " + v));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
