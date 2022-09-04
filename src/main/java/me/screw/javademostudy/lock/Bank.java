package me.screw.javademostudy.lock;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {
    @Id
    private Long id;

    private Long accountId;
    private String category;
}
