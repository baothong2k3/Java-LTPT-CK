/*
 * @ (#) Department.java    1.0    15/04/2024
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
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Department")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "DepartmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Administator")
    private int administrator;
    @Column(name = "Budget")
    private double budget;
    @Column(name = "Name")
    private String name;
    @Column(name = "StartDate")
    private LocalDateTime startDate;
    //
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Course> courses;
    //
    public Department(String name, LocalDateTime startDate, double budget, int administrator) {
        this.name = name;
        this.startDate = startDate;
        this.budget = budget;
        this.administrator = administrator;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", administrator=" + administrator +
                ", budget=" + budget +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
