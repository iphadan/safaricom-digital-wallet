package com.safaricom.degital.wallet.model;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Wallet extends BaseEntity{
    private double balance=0.0;
    @Column(length = 3)
    private String currency =  "ETB";
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    @Column(length = 13)
    private int walletNumber;
}
