/*
 * @ (#) OnsiteCourse.java    1.0    15/04/2024
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
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "OnsiteCourse")
public class OnsiteCourse extends Course implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    @Column(name = "Day")
    private String day;
    //
    @Column(name = "Time")
    private LocalDateTime time;
    //
    @Column(name = "Location")
    private String location;
    //
    public OnsiteCourse(String day, LocalDateTime time, String location) {
        this.day = day;
        this.time = time;
        this.location = location;
    }

    public OnsiteCourse() {
    }

    @Override
    public String toString() {
        return "OnsiteCourse{" +
                "day='" + day + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                '}';
    }
}
