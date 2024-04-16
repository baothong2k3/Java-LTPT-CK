/*
 * @ (#) Artist.java    1.0    15/04/2024
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
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "artists")
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "artist_id")
    private String artistId;

    @Column(name = "birth_date")
    private LocalDate dateOfBirth;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @ManyToMany(mappedBy = "artists", cascade = CascadeType.ALL)
    private Set<Album> albums;
    public Artist(String artistId, LocalDate dateOfBirth, String name, String url) {
        this.artistId = artistId;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId='" + artistId + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
