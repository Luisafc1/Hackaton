package com.banana.bananamint.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Integer Id;

    @Transient
    private Customer user;

    private double amount;

    private LocalDate enterDate;

    @Transient
    private Account moneyTo;

    private String status;

}
