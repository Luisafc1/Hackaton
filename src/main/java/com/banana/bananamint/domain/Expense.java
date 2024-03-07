package com.banana.bananamint.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "Expense ID", example = "1", required = false)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer user;

    private double amount;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account moneyFrom;

    @Column
    @NotBlank(message = "Debe tener valor")
    @NotNull
    @Size(min = 3, max = 50)
    private String status;

}
