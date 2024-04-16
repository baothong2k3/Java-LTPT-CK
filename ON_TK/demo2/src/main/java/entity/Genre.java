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
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Genre")
public class Genre implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    @Id
    @Column(name = "genre_id")
    protected String id;
    //
    @Column(name = "name")
    protected String name;
    //
    @Column(name = "description")
    protected String description;

    public Genre() {
    }

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }
    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private Set<Albums> albums;
    //
    @Override
    public String toString() {
        return "Genre{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
