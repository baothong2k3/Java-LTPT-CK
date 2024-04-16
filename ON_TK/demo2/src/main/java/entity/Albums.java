/*
 * @ (#) albums.java    1.0    15/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/04/2024
 * @version: 1.0
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Albums")
public class Albums implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    @Id
    @Column(name = "albums_id")
    protected String id;
    //
    @Column(name = "download_link")
    protected String downloadLink;
    @Column(name = "price")
    protected double price;
    @Column(name = "title")
    protected String title;
    @Column(name = "year_of_release")
    protected int yearOfRelease;
    //
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    protected Genre genre;
    //
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "albums_artist",
            joinColumns = @JoinColumn(name = "albums_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    protected Set<Artist> artists;
    //
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "albums_song",
            joinColumns = @JoinColumn(name = "albums_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    protected Set<Song> songs;

    public Albums() {
    }

    public Albums(String downloadLink, double price, String title, int yearOfRelease) {
        this.downloadLink = downloadLink;
        this.price = price;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "albums{" +
                "id='" + id + '\'' +
                ", downloadLink='" + downloadLink + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
