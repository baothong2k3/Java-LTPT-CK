package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DepartmentDAO;
import entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class DepartmentImpl extends UnicastRemoteObject implements DepartmentDAO {

    /**
     *
     */
    private static final long serialVersionUID = -6262287994424311129L;
    private EntityManager em;

    public DepartmentImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("jpa-mssql")
                .createEntityManager();
    }

    @Override
    public List<Department> findDepartmentNotOwnerCourse() throws RemoteException {
        return em.createNamedQuery("Department.findDepartmentNotOwnerCourse", Department.class).getResultList();
    }

    @Override
    public Map<String, Integer> countCoursesByDepartment() throws RemoteException {
        String query = "SELECT d.Name AS DepartmentName, COUNT(c.CourseID) AS CourseCount FROM [StudentDB].[dbo].[Course] c INNER JOIN [StudentDB].[dbo].[Department] d ON c.DepartmentID = d.DepartmentID GROUP BY d.Name";
        List<Object[]> results = em.createNativeQuery(query).getResultList();
        Map<String, Integer> resultMap = new HashMap<>();
        for (Object[] result : results) {
            resultMap.put((String) result[0], (Integer) result[1]);
        }
        return resultMap;
    }

}
