package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entity.Department;

public interface DepartmentDAO extends Remote{
	public List<Department> findDepartmentNotOwnerCourse() throws RemoteException;
	public Map<String, Integer> countCoursesByDepartment() throws RemoteException;
}
