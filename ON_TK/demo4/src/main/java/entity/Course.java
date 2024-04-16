/*
 * @ (#) Course.java    1.0    16/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;/*
 * @description:
 * @author: Bao Thong
 * @date: 16/04/2024
 * @version: 1.0
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Map;
import org.hibernate.mapping.Set;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Course")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CourseID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int courseID;

    protected String title;
    protected int credits;

    public Course(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "CourseInstructor",
            joinColumns = @JoinColumn(name = "CourseID"),
            inverseJoinColumns = @JoinColumn(name = "InstructorID"))
    private Set<Instructor> instructors;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected Set<StudentGrades> studentGrades;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DepartmentID")
    protected Department department;
    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                '}';
    }
}
