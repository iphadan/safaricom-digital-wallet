package com.safaricom.degital.wallet.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Customer extends BaseEntity{
@NotBlank(message = "Full name can Not be empty or Blank")
    private String customerFullName;
@Min(message = "Age can not be less than 10", value = 10)
@Max(message = "Age can not be more than 100",value = 100)
    private int age;
    private String gender;
    @NotNull(message = "customer phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;
    @NotNull(message = "short name is required")
    private String customerShortName;

}
