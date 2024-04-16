/*
 * @ (#) StudentGrade.java    1.0    15/04/2024
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
@Table(name = "StudentGrade")
public class StudentGrade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "EmrollmentID")
    private String enrollment_id;
    @Column(name = "Grade")
    private double grade;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "StudentID")
    private Student student;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CourseID")
    private Course course;
    //
    public StudentGrade() {
    }
    //

    public StudentGrade(double grade, Student student, Course course) {
        this.grade = grade;
        this.student = student;
        this.course = course;
    }

    @Override
    public String toString() {
        return "StudentGrade{" +
                "enrollment_id='" + enrollment_id + '\'' +
                ", grade=" + grade +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
