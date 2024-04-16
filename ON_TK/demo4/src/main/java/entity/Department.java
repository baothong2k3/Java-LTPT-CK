/*
 * @ (#) Department.java    1.0    16/04/2024
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

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Department")
public class Department implements Serializable {
    @Id
    @Column(name = "DepartmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Budget")
    private double budget;
    @Column(name = "StartDate")
    private LocalDateTime startDate;
    @Column(name = "Administrator")
    private int administrator;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Course> courses;
    public Department(String name, double budget, LocalDateTime startDate, int administrator) {
        this.name = name;
        this.budget = budget;
        this.startDate = startDate;
        this.administrator = administrator;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", startDate=" + startDate +
                ", administrator=" + administrator +
                '}';
    }
}
