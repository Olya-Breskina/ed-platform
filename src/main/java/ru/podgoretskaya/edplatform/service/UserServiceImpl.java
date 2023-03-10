package ru.podgoretskaya.edplatform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.podgoretskaya.edplatform.dto.ManagementDTO;
import ru.podgoretskaya.edplatform.dto.UserDTO;
import ru.podgoretskaya.edplatform.entity.UserEntity;
import ru.podgoretskaya.edplatform.enums.UserRole;
import ru.podgoretskaya.edplatform.mapper.UserMapper;
import ru.podgoretskaya.edplatform.repository.UserRepo;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static ru.podgoretskaya.edplatform.enums.UserRole.ANONYMOUS;
import static ru.podgoretskaya.edplatform.enums.UserRole.STUDENT;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public void registration(UserDTO userDTO) {
        UserEntity userEntity = userMapper.toEntity(userDTO);
        userEntity.setRole(STUDENT);
        userEntity.setPassword(encryptedPassword(userEntity.getPassword()));
        userRepo.save(userEntity);
    }

    @Override
    public UserRole login(String login, String password) {
        UserEntity userEntity = userRepo.findByUsername(login).orElseThrow(IllegalArgumentException::new);
        if (userEntity.getUsername().equals(login) &&
                (userEntity.getPassword().equals(encryptedPassword(password)))) {
            return userEntity.getRole();
        } else return ANONYMOUS;
    }


    @Override
    public void registrationManagement(ManagementDTO managementDTO) {
        UserEntity userEntity = userMapper.managementToEntity(managementDTO);
        userRepo.save(userEntity);
    }

    private String encryptedPassword(String password) {
        return new String(Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8)));
    }
}
