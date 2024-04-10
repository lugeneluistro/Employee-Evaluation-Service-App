package com.employee.evaluation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "evaluation_items")
@Getter
@Setter
public class EvaluationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    private String category;
    private String itemName;
    private String description;
    private BigDecimal weight;

}

