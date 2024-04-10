package com.employee.evaluation.repository;

import com.employee.evaluation.Utils;
import com.employee.evaluation.entity.Employee;
import com.employee.evaluation.entity.EvaluationItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EvaluationItemTest {

    @Autowired
    private IEvaluationItemRepository evaluationItemRepository;

    @Test
    void findAllItemsTest() {

        List<EvaluationItem> items = evaluationItemRepository.findAll();
        Assertions.assertNotNull(items);

        items.forEach(item -> {
            Assertions.assertNotNull(item.getItemName());
            log.info(Utils.LOG_PREFIX.concat("{} | {} | {} | {}"),
                    item.getCategory(), item.getItemName(), item.getDescription(), item.getWeight());
        });

    }

}
