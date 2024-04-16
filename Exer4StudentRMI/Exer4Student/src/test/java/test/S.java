/*
 * @ (#) S.java    1.0    16/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package test;/*
 * @description:
 * @author: Bao Thong
 * @date: 16/04/2024
 * @version: 1.0
 */

import dao.StudentDAO;
import dao.impl.StudentImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.rmi.RemoteException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class S {
    private StudentImpl studentDAO;
    @BeforeAll
    void setUp() {
        try {
            studentDAO = new StudentImpl();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void findAll() {
        try {
            studentDAO.findAll().forEach(System.out::println);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
