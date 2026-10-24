package com.safaricom.degital.wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GeneralResponse <T>{
    private String message;
    private boolean status;
    private T result;
}
