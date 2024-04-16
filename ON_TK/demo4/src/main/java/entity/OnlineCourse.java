/*
 * @ (#) OnlineCourse.java    1.0    16/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;/*
 * @description:
 * @author: Bao Thong
 * @date: 16/04/2024
 * @version: 1.0
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "OnlineCourse")
public class OnlineCourse extends Course implements Serializable {
    @Column(name = "URL")
    private String url;

    public OnlineCourse(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "OnlineCourse{" +
                "url='" + url + '\'' +
                ", courseID=" + courseID +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                '}';
    }
}
