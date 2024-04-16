/*
 * @ (#) Album.java    1.0    15/04/2024
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
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "albums")
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "album_id")
    private String albumId;

    @Column(name = "download_link")
    private String downloadLink;

    @Column(name = "price")
    private double price;

    @Column(name = "title")
    private String title;

    @Column(name = "year_of_release")
    private int yearOfRelease;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "album_artist",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<Artist> artists;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "album_song",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private Set<Song> songs;
    public Album(String albumId, String downloadLink, double price, String title, int yearOfRelease) {
        this.albumId = albumId;
        this.downloadLink = downloadLink;
        this.price = price;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId='" + albumId + '\'' +
                ", downloadLink='" + downloadLink + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
