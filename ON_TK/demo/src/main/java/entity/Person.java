/*
 * @ (#) Person.java    1.0    15/04/2024
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
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator", discriminatorType = DiscriminatorType.STRING)
public class Person implements Serializable{
    private static final long serialVersionUID = 823163718038191778L;
    @Id
    @Column(name = "PersonID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name = "FirstName")
    protected String firstName;
    @Column(name = "LastName")
    protected String lastName;
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
