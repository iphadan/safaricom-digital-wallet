package com.safaricom.degital.wallet.mapper;

import com.safaricom.degital.wallet.dto.CustomerResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;
import com.safaricom.degital.wallet.model.Customer;
@Component
@Data

public class CustomerMapper {

    public CustomerResponse customerToResponse(Customer customer){
        return new CustomerResponse(
                customer.getCustomerShortName(),
                customer.getAge(),
                customer.getGender(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getCustomerShortName(),
                customer.getId()

        );
    }
}
