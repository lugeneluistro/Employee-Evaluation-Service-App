package com.employee.evaluation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "evaluation_scores")
@IdClass(EvaluationScoreId.class)
@Getter
@Setter
public class EvaluationScore {

    @Id
    @Column(name = "evaluation_id")
    private Long evaluationId;

    @Id
    @Column(name = "item_id")
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "evaluation_id")
    private Evaluation evaluation;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private EvaluationItem item;

    private Integer score;
    private String comments;

}
