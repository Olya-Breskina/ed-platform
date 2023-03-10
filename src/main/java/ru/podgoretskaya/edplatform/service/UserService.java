package ru.podgoretskaya.edplatform.service;

import ru.podgoretskaya.edplatform.dto.ManagementDTO;
import ru.podgoretskaya.edplatform.dto.UserDTO;
import ru.podgoretskaya.edplatform.enums.UserRole;

public interface UserService {
    void registration(UserDTO userDTO);

    UserRole login(String login, String password);

    void registrationManagement(ManagementDTO managementDTO);
}
