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
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "Account ID", example = "1", required = false)
    private Long id;

    @Column
    @NotBlank(message = "Debe tener valor")
    @NotNull
    @Size(min = 3, max = 50)
    private String type;

    LocalDate openingDate;

    private double balance;

    private double maxOverdraft;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer owner;

    private boolean active;

     public Account(Long id){
        this.id =id;
    }

}
