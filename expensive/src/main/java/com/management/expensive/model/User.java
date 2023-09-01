package com.management.expensive.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "userT")
public class User {
    @Id
    private long id;
    private String name;
}
