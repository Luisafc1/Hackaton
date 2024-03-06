package com.banana.bananamint.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Long id;

    private String type;

    LocalDate openingDate;

    private double balance;

    private double maxOverdraft;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer owner;

    private boolean active;

}
