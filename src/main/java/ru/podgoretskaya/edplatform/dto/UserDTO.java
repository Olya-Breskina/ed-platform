package ru.podgoretskaya.edplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.podgoretskaya.edplatform.enums.UserRole;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String username;
    private String password;
    private String lastName;
    private UserRole role;
    private String firstName;
    private LocalDate birthdate;
    private String email;
}
