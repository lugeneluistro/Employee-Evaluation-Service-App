package com.employee.evaluation.repository;

import com.employee.evaluation.entity.EvaluationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEvaluationItemRepository extends JpaRepository<EvaluationItem, Long> {
}
