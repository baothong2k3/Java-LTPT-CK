/*
 * @ (#) D.java    1.0    15/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package test;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/04/2024
 * @version: 1.0
 */

import dao.impl.DepartmentImpl;
import entity.Department;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.rmi.RemoteException;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class D {
    private DepartmentImpl departmentDAO;
    @BeforeAll
    void setUp(){
        try {
            departmentDAO = new DepartmentImpl();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void countDepartment(){
        int count = 0;
        try {
            Map<String, Integer> map = departmentDAO.countCoursesByDepartment();
            map.forEach((k, v) -> System.out.println(k + " : " + v));

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterAll
    public void tearDown(){
        departmentDAO = null;
    }
}
