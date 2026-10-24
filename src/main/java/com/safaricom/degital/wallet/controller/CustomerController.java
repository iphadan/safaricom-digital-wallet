package com.safaricom.degital.wallet.controller;

import com.safaricom.degital.wallet.dto.CustomerResponse;
import com.safaricom.degital.wallet.dto.GeneralResponse;
import com.safaricom.degital.wallet.model.Customer;
import com.safaricom.degital.wallet.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<GeneralResponse<CustomerResponse>> createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public ResponseEntity<GeneralResponse<List<CustomerResponse>>> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse<CustomerResponse>> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse<CustomerResponse>> getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}
