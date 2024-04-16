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
@Getter
@Setter
@Entity
@Table(name = "Artist")
public class Artist implements Seri{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "artist_id")
    @GereratedValue(strategy = GenerationType.IDENTITY)
    private String id;

}
