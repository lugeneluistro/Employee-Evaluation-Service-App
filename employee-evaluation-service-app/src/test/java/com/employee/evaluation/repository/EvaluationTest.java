package com.employee.evaluation.repository;


import com.employee.evaluation.Utils;
import com.employee.evaluation.entity.Employee;
import com.employee.evaluation.entity.Evaluation;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EvaluationTest {

    @Autowired
    private IEvaluationRepository evaluationRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    private Evaluation savedEvaluation;

    @BeforeEach
    void setUp() {

        Long supervisorId = 100023L;
        Long employeeId = 100027L;

        Optional<Employee> evaluator = employeeRepository.findById(supervisorId);
        Assertions.assertTrue(evaluator.isPresent());

        Optional<Employee> toEvaluate = employeeRepository.findById(employeeId);
        Assertions.assertTrue(toEvaluate.isPresent());

        Evaluation evaluation = new Evaluation();
        evaluation.setEmployee(toEvaluate.get());
        evaluation.setEvaluator(evaluator.get());
        evaluation.setEvaluationDate(new Date());

        savedEvaluation = evaluationRepository.save(evaluation);
    }

    @AfterEach
    void tearDown() {
        log.info(Utils.LOG_PREFIX.concat("Evaluation Id created: {}"), savedEvaluation.getEvaluationId());
        // Clean up after each test
        evaluationRepository.deleteAll();
    }

    @Test
    void whenFindById_thenReturnEvaluation() {
        Optional<Evaluation> foundEvaluation = evaluationRepository.findById(savedEvaluation.getEvaluationId());
        assertThat(foundEvaluation).isPresent().contains(savedEvaluation);
    }

    @Test
    void whenDelete_thenRemovedFromDatabase() {
        evaluationRepository.deleteById(savedEvaluation.getEvaluationId());
        Optional<Evaluation> foundEvaluation = evaluationRepository.findById(savedEvaluation.getEvaluationId());
        assertThat(foundEvaluation).isNotPresent();
    }

}
