package com.safaricom.degital.wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerResponse extends BaseDto{
    private String customerFullName;
    private int age;
    private String gender;
    private String phoneNumber;
    private String email;
    private String customerShortName;


    public CustomerResponse(String customerShortName, int age, String gender, String phoneNumber, String email, String customerFullName, Long id){
   super.setId(id);
   this.customerFullName = customerFullName;
   this.customerShortName = customerShortName;
   this.gender = gender;
   this.email = email;
   this.age = age;
   this.phoneNumber = phoneNumber;

    }
}


