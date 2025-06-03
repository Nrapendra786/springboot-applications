package com.techwaala.crud_demo;

import lombok.*;
import jakarta.persistence.*;

@Table(name = "crud_demo")
@Entity
@Data
public class CrudDemo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;
}

