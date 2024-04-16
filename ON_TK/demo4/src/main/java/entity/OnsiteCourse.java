/*
 * @ (#) OnsiteCourse.java    1.0    16/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;/*
 * @description:
 * @author: Bao Thong
 * @date: 16/04/2024
 * @version: 1.0
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.Time;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "OnsiteCourse")
public class OnsiteCourse extends Course{
    private String location;
    private String days;
    private Time times;

    public OnsiteCourse(String location, String days, Time times) {
        this = location;
        this.days = days;
        this.times = times;
    }

    @Override
    public String toString() {
        return "OnsiteCourse{" +
                "location='" + location + '\'' +
                ", days='" + days + '\'' +
                ", times=" + times +
                ", courseID=" + courseID +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                '}';
    }
}
