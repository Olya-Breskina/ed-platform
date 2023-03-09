package ru.podgoretskaya.edplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.podgoretskaya.edplatform.entity.TestsEntity;

public interface TestsRepo extends JpaRepository<TestsEntity, Integer> {

}
