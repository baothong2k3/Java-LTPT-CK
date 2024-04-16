/*
 * @ (#) OnlineCourse.java    1.0    15/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/04/2024
 * @version: 1.0
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OnlineCourse")
public class OnlineCourse extends Course {
    @Column(name = "URL")
    private String url;

    public OnlineCourse() {
    }

    public OnlineCourse(String title, int credits, String url) {
        super(title, credits);
        this.url = url;
    }

    @Override
    public String toString() {
        return "OnlineCourse{" +
                "url='" + url + '\'' +
                ", course_id=" + course_id +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                '}';
    }
}
