/*
 * @ (#) AlbumImpl.java    1.0    15/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package dao.impl;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/04/2024
 * @version: 1.0
 */

import dao.AlbumDAO;
import entity.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

public class AlbumImpl extends UnicastRemoteObject implements AlbumDAO {
    private static final long serialVersionUID = -6262287994424311129L;
    private EntityManager em;

    public AlbumImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("jpa-mssql")
                .createEntityManager();
    }

    @Override
    public boolean updatePriceOfAlbum(String albumName, double newPrice) throws RemoteException {
        return false;
    }

    @Override
    public List<Album> listAlbumsByGenre(String genreName) throws RemoteException {
        return null;
    }

    @Override
    public Map<String, Long> getNumberOfAlbumsByGenre() throws RemoteException {
        return null;
    }
}
