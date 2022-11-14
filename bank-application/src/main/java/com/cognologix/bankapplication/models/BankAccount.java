package com.cognologix.bankapplication.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Long accountNumber;

    // foreign key from User table
    @NotNull
    private Long customerId;

    @NotNull
    private LocalDate accountCreationDate;

    @NotNull
    private String accountType;

    @NotNull
    private String accountCurrency;

    @NotNull
    private String branchCode;

    @NotNull
    private String branchName;

    @NotNull
    private String branchAddress;

    @NotNull
    private String branchCity;

    @NotNull
    private String branchState;

    @NotNull
    private String branchCountry;

    @NotNull
    private String branchPincode;

    @NotNull
    private String branchContact;

    @NotNull
    private String IFSCCode;
}
