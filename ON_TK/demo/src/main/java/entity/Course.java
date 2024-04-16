/*
 * @ (#) Course.java    1.0    15/04/2024
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
@Table(name = "Course")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    @Id
    @Column(name = "CourseID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int course_id;
    //
    @Column(name = "Title", unique = true, nullable = false)
    protected String title;
    @Column(name = "Credits")
    protected int credits;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DepartmentID")
    protected Department department;
    //
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StudentGrade> studentGrades;
    //
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "CourseInstructor",
            joinColumns = @JoinColumn(name = "CourseID"),
            inverseJoinColumns = @JoinColumn(name = "PersonID")
    )
    protected Set<Instructor> instructors;

    //
    public Course() {
    }

    //
    public Course(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                '}';
    }
}
