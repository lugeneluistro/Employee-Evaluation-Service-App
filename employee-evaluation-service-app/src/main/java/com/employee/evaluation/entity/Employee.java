package com.employee.evaluation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private String department;

    @Temporal(TemporalType.DATE)
    private Date dateJoined;
    private String status;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Employee supervisor;

    @OneToMany(mappedBy = "supervisor", fetch = FetchType.LAZY)
    private Set<Employee> subordinates;
}
