/*
 * @ {#} Album.java   1.0     15/04/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   15/04/2024
 * @version:    1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "albums")
public class Album implements Serializable {
    @Id
    @Column(name = "album_id")
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private double price;
    @Column(name = "year_of_release")
    private int yearOfRelease;
    @Column(name = "download_link")
    private String downloadLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToMany
    @JoinTable(
            name = "albums_artists",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<Artist> artists;

    @ManyToMany
    @JoinTable(
            name = "albums_songs",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private Set<Song> songs;
}
