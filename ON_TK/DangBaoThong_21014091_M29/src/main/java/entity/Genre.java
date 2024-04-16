/*
 * @ (#) Genre.java    1.0    15/04/2024
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
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "genres")
public class Genre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "genre_id")
    private String genreId;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private Set<Album> albums;
    public Genre(String genreId, String description, String name) {
        this.genreId = genreId;
        this.description = description;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId='" + genreId + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
