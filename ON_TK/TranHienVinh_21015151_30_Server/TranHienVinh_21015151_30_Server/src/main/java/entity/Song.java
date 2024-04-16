/*
 * @ {#} Song.java   1.0     15/04/2024
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
@NoArgsConstructor
@ToString
@Entity
@Table(name = "songs")
public class Song implements Serializable {
    @Id
    @Column(name = "song_id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "runtime")
    private String runtime;
    @Column(name = "lyric")
    private String lyric;
    @Column(name = "file_link")
    private String fileLink;

    @ManyToMany(mappedBy = "songs")
    private Set<Album> albums;
}
