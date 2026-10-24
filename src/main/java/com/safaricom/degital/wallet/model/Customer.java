package com.safaricom.degital.wallet.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Customer extends BaseEntity{

    private String customerFullName;
    private int age;
    private String gender;
    private String phoneNumber;
    private String email;
    private String customerShortName;

}
