package com.employee.evaluation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "evaluations")
@Getter
@Setter
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer evaluationId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "evaluator_id")
    private Employee evaluator;

    @Temporal(TemporalType.DATE)
    private Date evaluationDate;
}
