/*
 * @ (#) Instructor.java    1.0    16/04/2024
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
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Entity
@DiscriminatorValue("Instructor")
public abstract class Instructor extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "HireDate")
    private LocalDateTime hireDate;

    @OneToOne(mappedBy = "instructors", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private OfficeAssignment officeAssignment;
    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String hireDate) {
        super(firstName, lastName);
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "personID=" + personID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hireDate='" + hireDate + '\'' +
                '}';
    }
}
