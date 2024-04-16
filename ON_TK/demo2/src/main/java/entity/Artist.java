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
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Artist")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "artist_id")
    protected String id;
    @Column(name = "name")
    protected String name;
    @Column(name = "birth_date")
    protected LocalDate birthDate;
    @Column(name = "url")
    protected String url;

    @ManyToMany(mappedBy = "artists")
    private Set<Albums> albums;
    public Artist() {
    }

    public Artist(String name, LocalDate birthDate, String url) {
        this.name = name;
        this.birthDate = birthDate;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", url='" + url + '\'' +
                '}';
    }
}
