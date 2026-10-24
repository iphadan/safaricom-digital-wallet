package com.safaricom.degital.wallet.service;

import com.safaricom.degital.wallet.dto.CustomerResponse;
import com.safaricom.degital.wallet.dto.GeneralResponse;
import com.safaricom.degital.wallet.mapper.CustomerMapper;
import com.safaricom.degital.wallet.model.Customer;
import com.safaricom.degital.wallet.repo.CustomerRepo;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;


    public CustomerService(CustomerRepo customerRepo, CustomerMapper customerMapper){
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    public ResponseEntity<GeneralResponse<CustomerResponse>> createCustomer(Customer customer){
        customer.setCreatedBy("SELF");
        Customer createdCustomer = customerRepo.save(customer);
       GeneralResponse<CustomerResponse> generalResponse = new GeneralResponse();
       if(createdCustomer == null){
           generalResponse.setMessage("Customer Creation failed!");
           generalResponse.setResult(null);
           generalResponse.setStatus(false);
           return ResponseEntity.ok(generalResponse);
       }
       CustomerResponse customerResponse = new CustomerResponse();
       customerResponse = customerMapper.customerToResponse(createdCustomer);
       generalResponse.setResult(customerResponse);
       generalResponse.setMessage("Customer Successfully Created");
       generalResponse.setStatus(true);

       return ResponseEntity.ok(generalResponse);


    }
    public ResponseEntity<GeneralResponse<List<CustomerResponse>>> getAllCustomers(){
        List<Customer> customers = customerRepo.findAll();
        GeneralResponse<List<CustomerResponse>> generalResponse = new GeneralResponse<>();
        if(customers.size() == 0){
            generalResponse.setStatus(true);
            generalResponse.setResult(List.of());
            generalResponse.setMessage("No Record Found");
            return ResponseEntity.ok(generalResponse);
        }
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer : customers){
            customerResponses.add(customerMapper.customerToResponse(customer));
        }

        generalResponse.setMessage("Successfully Fetched");
        generalResponse.setResult(customerResponses);
        generalResponse.setStatus(true);
        return  ResponseEntity.ok(generalResponse);
    }

    public ResponseEntity<GeneralResponse<CustomerResponse>> getCustomer(Long id){
        Customer customer = customerRepo.findById(id).orElse(null);

        if(customer == null){


            return ResponseEntity.ok(new GeneralResponse<>(
                    "No Record Found",
                    false,
                    null
            ));
        }

        return ResponseEntity.ok(
                new GeneralResponse<>(
                        "Successfully Fetched the Record",
                        true,
                        customerMapper.customerToResponse(customer))

        );


    }

    public ResponseEntity<GeneralResponse<CustomerResponse>> updateCustomer(Long id, Customer customer){
        Customer existingCustomer = customerRepo.findById(id).orElse(null);
        if(customer == null){


            return ResponseEntity.ok(new GeneralResponse<>(
                    "No Record Found",
                    false,
                    null
            ));
        }

        if(customer.getCustomerFullName() != existingCustomer.getCustomerFullName() && customer.getCustomerFullName() != null){
existingCustomer.setCustomerFullName(customer.getCustomerFullName());
        }

        if(customer.getCustomerShortName() != existingCustomer.getCustomerShortName() && customer.getCustomerShortName() != null){
            existingCustomer.setCustomerShortName(customer.getCustomerShortName());

        }

        if(customer.getPhoneNumber() != existingCustomer.getPhoneNumber() && customer.getPhoneNumber() != null){
existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        }

        if(customer.getAge() != existingCustomer.getAge() && customer.getAge() != 0){
existingCustomer.setAge(customer.getAge());
        }

        if(customer.getGender() != existingCustomer.getGender() && customer.getGender() != null){
existingCustomer.setGender(customer.getGender());
        }

        if(customer.getEmail() != existingCustomer.getEmail() && customer.getEmail() != null){
existingCustomer.setEmail(customer.getEmail());
        }

        existingCustomer.setModifiedBy("SELF");

        Customer savedCustomer = customerRepo.save(existingCustomer);

        return ResponseEntity.ok(
                new GeneralResponse<>(
                        "Successfully updated",
                        true,
                        customerMapper.customerToResponse(savedCustomer)
                )
        );


    }

    public ResponseEntity<GeneralResponse> deleteCustomer(Long id){
        Customer tobeDeleted = customerRepo.findById(id).orElse(null);
        if(tobeDeleted == null){


            return ResponseEntity.ok(new GeneralResponse<>(
                    "No Record Found",
                    false,
                    null
            ));
        }
        customerRepo.delete(tobeDeleted);

        return ResponseEntity.ok(
                new GeneralResponse(
                        "Successfully deleted the customer",
                        true,
                        null
                )


        );



    }

}
