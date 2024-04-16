/*
 * @ (#) OfficeAssignment.java    1.0    15/04/2024
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
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "OfficeAssignment")
public class OfficeAssignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Location")
    private String location;
    @Column(name = "Timestamp", columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;
    //
    @Id
    @OneToOne
    @JoinColumn(name = "InstructorID")
    private Instructor instructor;
    //

    public OfficeAssignment(String location, Timestamp timestamp, Instructor instructor) {
        this.location = location;
        this.timestamp = timestamp;
        this.instructor = instructor;
    }

    public OfficeAssignment() {
    }

    @Override
    public String toString() {
        return "OfficeAssignment{" +
                "location='" + location + '\'' +
                ", timestamp=" + timestamp +
                ", instructor=" + instructor +
                '}';
    }
}
