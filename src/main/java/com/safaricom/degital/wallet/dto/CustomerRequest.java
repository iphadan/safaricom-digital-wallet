package com.safaricom.degital.wallet.dto;

import lombok.Data;

@Data
public class CustomerRequest {
    private String customerFullName;
    private String age;
    private String gender;
    private String phoneNumber;
    private String email;
    private String customerShortName;
}
