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
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Long id;

    private String name;

    private String description;

    private double targetAmount;

    private String status;

    private LocalDate targetDate;

    @Transient
    private Customer user;


}
