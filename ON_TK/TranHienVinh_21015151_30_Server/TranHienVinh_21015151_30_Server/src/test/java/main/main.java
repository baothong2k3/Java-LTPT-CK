package main;/*
 * @ {#} main.main.java   1.0     15/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   15/04/2024
 * @version:    1.0
 */
public class main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA_MSSQL");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        try {
            tx.begin();
            // do something
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
