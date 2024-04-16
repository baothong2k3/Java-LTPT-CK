/*
 * @ (#) Song.java    1.0    15/04/2024
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
@Table(name = "songs")
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "song_id")
    private String songId;

    @Column(name = "file_link")
    private String fileLink;

    @Column(name = "lyric")
    private String lyric;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @ManyToMany(mappedBy = "songs", cascade = CascadeType.ALL)
    private Set<Album> albums;
    public Song(String songId, String fileLink, String lyric, String name, String url) {
        this.songId = songId;
        this.fileLink = fileLink;
        this.lyric = lyric;
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId='" + songId + '\'' +
                ", fileLink='" + fileLink + '\'' +
                ", lyric='" + lyric + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
