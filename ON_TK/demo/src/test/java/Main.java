/*
 * @ (#) Main.java    1.0    15/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-mssql");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();
    }
}
