/*
 * @ (#) OfficeAssignment.java    1.0    16/04/2024
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

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "OfficeAssignment")
public class OfficeAssignment{
    @Column(name = "Location")
    private String location;
    @Column(name = "Timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp timestamp;

    @Id
    @OneToOne
    @JoinColumn(name = "InstructorID")
    private Instructor instructor;

    public OfficeAssignment() {
    }

    public OfficeAssignment(String location, Timestamp timestamp) {
        this.location = location;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "OfficeAssignment{" +
                "location='" + location + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
