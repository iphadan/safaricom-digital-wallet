package com.safaricom.degital.wallet.dto;


import com.safaricom.degital.wallet.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class WalletResponse extends BaseDto{
      public WalletResponse(Long id,BigDecimal balance, String currency,Customer customer, String    walletNumber, LocalDateTime createdAt,String createdBy){
                this.balance = balance;
                this.customer = customer;
                this.walletNumber = walletNumber;
                super.setId(id);
                super.setCreatedBy(createdBy);
                super.setCreatedAt(createdAt);
                this.currency = currency;
        }
        private BigDecimal balance= BigDecimal.valueOf(0);
        private Customer customer;
        private String walletNumber;
        private String currency;
}
