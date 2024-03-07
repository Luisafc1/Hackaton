package com.banana.bananamint.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Integer id;

    private double amount;

    private String description;

    private String paymentType;

    @Transient
    private Category category;

    @Transient
    private Account account;

    @Transient
    private Customer user;

    private boolean isDeleted;

    private Long dateTime;

    private LocalDate createdAt;

    private LocalDate updatedAt;


}
