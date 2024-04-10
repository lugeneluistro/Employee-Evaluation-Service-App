package com.employee.evaluation.repository;


import com.employee.evaluation.Utils;
import com.employee.evaluation.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.Set;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

    @Autowired
    private IEmployeeRepository employeeRepository;

    private final Long supervisorId = 100023L;


    @Test
    void findByIdTest() {

        Optional<Employee> employee = employeeRepository.findById(supervisorId);

        Assertions.assertTrue(employee.isPresent());
        log.info(Utils.LOG_PREFIX.concat("Email: {}"), employee.get().getEmail());
        Assertions.assertFalse(employee.get().getSubordinates().isEmpty());
    }

    @Test
    void findByIdLazyTest() {

        Optional<Employee> employee = employeeRepository.findById(supervisorId);
        Assertions.assertTrue(employee.isPresent());

        Set<Employee> subordinates = employee.get().getSubordinates();

        // Assert that the subordinates collection was not loaded initially
        Assertions.assertFalse(Hibernate.isInitialized(subordinates));

        // Trigger lazy loading by accessing the collection
        log.info(Utils.LOG_PREFIX.concat("Employee {} subordinates count: {}"), supervisorId, subordinates.size());

        Assertions.assertTrue(Hibernate.isInitialized(subordinates));
    }


    @Test
    void findSupervisorTest() {
        Long employeeId = 100027L;
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Assertions.assertTrue(employee.isPresent());
        Assertions.assertEquals(employee.get().getSupervisor().getEmployeeId(), supervisorId);
    }

    @Test
    void findAllSubordinatesTest() {

        Optional<Employee> employee = employeeRepository.findById(supervisorId);
        Assertions.assertTrue(employee.isPresent());

        employee.get().getSubordinates().forEach(emp -> {
            Assertions.assertEquals(emp.getSupervisor().getEmployeeId(), supervisorId);
            log.info(Utils.LOG_PREFIX.concat("{} {} {}"), emp.getEmployeeId(), emp.getFirstName(), emp.getLastName());
        });
    }
}
