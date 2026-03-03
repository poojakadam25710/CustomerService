package com.customer_service.controller;

import com.customer_service.dto.CustomerRequest;
import com.customer_service.dto.CustomerResponse;
import com.customer_service.dto.PagedResponse;
import com.customer_service.entity.Customer;
import com.customer_service.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping

    @Operation(
            summary = "Create new Customer",
            description = "This API is useful for creating a Customer"
    )
    public Customer creatCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.createCustomer(customerRequest);
    }

    @GetMapping("/customerId/{id}")
    public CustomerResponse getCustomerByName(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customerName/{name}")
    public CustomerResponse getCustomerByName(@PathVariable String name){
        return customerService.getCustomerByname(name);
    }

    @GetMapping("/customerEmail/{email}")
    public CustomerResponse getCustomerByEmail(@PathVariable String email){
        return customerService.getCustomerByemail(email);
    }
    @GetMapping("AllCustomersDetails")
    public ResponseEntity<PagedResponse<CustomerResponse>> getAllCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {

        return ResponseEntity.ok(
                customerService.getAllCustomers(page, size, sortBy)
        );
    }
    @PutMapping("/updateCustomer/{id}")
    public CustomerResponse updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerRequest customerRequest) {
        return customerService.updateCustomer(id, customerRequest);
    }


    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully with id: " + id);
    }
    // ================= PATCH (Partial Update) =================
    @PatchMapping("/{id}")
    @Operation(
            summary = "Partially update Customer",
            description = "Update one or more fields of a Customer without affecting other fields"
    )
    public CustomerResponse patchCustomer(
            @PathVariable Long id,
            @RequestBody CustomerRequest customerRequest
    ) {
        return customerService.patchCustomer(id, customerRequest);
    }

}
