package ru.podgoretskaya.edplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.podgoretskaya.edplatform.entity.UserEntity;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}