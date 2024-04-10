package com.employee.evaluation.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class EvaluationScoreId implements Serializable {
    private Integer evaluationId;
    private Integer itemId;
}

