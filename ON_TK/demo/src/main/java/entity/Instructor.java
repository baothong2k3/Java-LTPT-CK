/*
 * @ (#) Instructor.java    1.0    15/04/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package entity;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/04/2024
 * @version: 1.0
 */

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Instructor")
public class Instructor extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDateTime hireDate;

    public Instructor(String firstName, String lastName, LocalDateTime hireDate) {
        super(firstName, lastName);
        this.hireDate = hireDate;
    }

    public Instructor() {
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "hireDate=" + hireDate +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
