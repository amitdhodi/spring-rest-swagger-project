package com.example.swagger.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Resource")
@Getter
@Setter
public class Resource {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
}
