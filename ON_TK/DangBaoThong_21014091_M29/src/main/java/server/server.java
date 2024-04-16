/*
 * @ (#) server.java    1.0    15/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package server;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/04/2024
 * @version: 1.0
 */

import dao.AlbumDAO;
import dao.impl.AlbumImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class server {
    private static final String URL = "rmi://localhost:7878/";

    public static void main(String[] args) {
        try{
            Context context = new InitialContext();
            AlbumDAO albumDAO = new AlbumImpl(); // Remote Object
            LocateRegistry.createRegistry(7878);
            context.bind(URL + "albumDAO", albumDAO);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
