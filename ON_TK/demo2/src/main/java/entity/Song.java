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
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "Song")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "song_id")
    protected String id;
    @Column(name = "name")
    protected String name;
    @Column(name = "file_link")
    protected String fileLink;
    @Column(name = "runtime")
    protected String runtime;
    @Column(name = "lyric")
    protected String lyric;

    @ManyToMany(mappedBy = "songs")
    private Set<Albums> albums;
    public Song() {
    }

    public Song(String name, String fileLink, String runtime, String lyric) {
        this.name = name;
        this.fileLink = fileLink;
        this.runtime = runtime;
        this.lyric = lyric;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fileLink='" + fileLink + '\'' +
                ", runtime='" + runtime + '\'' +
                ", lyric='" + lyric + '\'' +
                '}';
    }
}
