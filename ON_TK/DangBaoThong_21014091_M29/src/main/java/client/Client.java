/*
 * @ (#) Client.java    1.0    15/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package client;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/04/2024
 * @version: 1.0
 */

import dao.AlbumDAO;

import java.rmi.Naming;

public class Client {
    private static final String URL = "rmi://localhost:7878/";

    public static void main(String[] args) {
        try {
            AlbumDAO albumDAO = (AlbumDAO) Naming.lookup(URL + "albumDAO");
            albumDAO.listAlbumsByGenre("Pop").forEach(x -> System.out.println(x));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
