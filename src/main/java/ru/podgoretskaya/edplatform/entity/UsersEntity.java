package ru.podgoretskaya.edplatform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.podgoretskaya.edplatform.enums.UserRole;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String name;
    private String lastName;
    private String email;
    private LocalDate dataRegistry;
    @Column( unique = true)
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
