package com.techwaala.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {

    @Id
    private Long id;

    private String name;

    private String email;

    private LocalDate date_of_birth;


}
