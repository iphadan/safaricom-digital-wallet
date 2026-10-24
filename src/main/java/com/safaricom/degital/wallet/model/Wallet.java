package com.safaricom.degital.wallet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Wallet extends BaseEntity{
    private BigDecimal balance= BigDecimal.valueOf(0);
    @Column(length = 3)
    @NotBlank(message = "Currency is Required")
    private String currency =  "ETB";
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id",nullable = false)
    @NotNull(message = "Customer id should be sent")
    private Customer customer;
    @Column(length = 13)
    @NotNull(message = "Wallet  Can not be empty")
    @Min(message = "Wallet Number Can not be less than 13", value = 13)

    private String walletNumber;
}
