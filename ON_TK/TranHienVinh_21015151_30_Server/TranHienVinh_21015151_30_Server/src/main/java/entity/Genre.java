/*
 * @ {#} Genre.java   1.0     15/04/2024
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
@Table(name = "genres")
public class Genre implements Serializable {
    @Id
    @Column(name = "genre_id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private Set<Album> albums;
}
