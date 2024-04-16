/*
 * @ (#) Student.java    1.0    16/04/2024
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
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@DiscriminatorValue("Student")
public class Student extends Person implements Serializable{
    @Column(name = "EnrollmentDate")
    private LocalDateTime enrollmentDate;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StudentGrades> studentGrades;
}
