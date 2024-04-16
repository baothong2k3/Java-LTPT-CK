/*
 * @ (#) AlbumDAO.java    1.0    15/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package dao;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/04/2024
 * @version: 1.0
 */

import entity.Album;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface AlbumDAO extends Remote {
    public boolean updatePriceOfAlbum(String albumName, double newPrice) throws RemoteException;
    public List<Album> listAlbumsByGenre(String genreName) throws RemoteException;
    public Map<String, Long> getNumberOfAlbumsByGenre() throws RemoteException;
}
