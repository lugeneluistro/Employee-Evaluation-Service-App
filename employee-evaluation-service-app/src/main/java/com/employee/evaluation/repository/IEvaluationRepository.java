package com.employee.evaluation.repository;

import com.employee.evaluation.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvaluationRepository extends JpaRepository<Evaluation, Integer> {
}
