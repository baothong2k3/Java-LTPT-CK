/*
 * @ (#) Person.java    1.0    16/04/2024
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
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator", discriminatorType = DiscriminatorType.STRING)
public abstract class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID")
    protected int personID;
    @Column(name = "FirstName")
    protected String firstName;
    @Column(name = "LastName")
    protected String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
