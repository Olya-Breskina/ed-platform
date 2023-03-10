package ru.podgoretskaya.edplatform.mapper;

import org.springframework.stereotype.Component;
import ru.podgoretskaya.edplatform.dto.ManagementDTO;
import ru.podgoretskaya.edplatform.dto.UserDTO;
import ru.podgoretskaya.edplatform.entity.UserEntity;

@Component
public class UserMapper {
    public UserDTO toDTO(UserEntity user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setBirthdate(user.getBirthdate());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    public UserEntity toEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setBirthdate(userDTO.getBirthdate());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setRole(userDTO.getRole());
        return userEntity;
    }

    public UserEntity managementToEntity(ManagementDTO managementDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(managementDTO.getUsername());
        userEntity.setPassword(managementDTO.getPassword());
        userEntity.setFirstName(managementDTO.getFirstName());
        userEntity.setLastName(managementDTO.getLastName());
        userEntity.setBirthdate(managementDTO.getBirthdate());
        userEntity.setEmail(managementDTO.getEmail());
        userEntity.setRole(managementDTO.getRole());
        return userEntity;
    }
}
