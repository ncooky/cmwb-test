package com.customer.demotest.controllers;

import com.customer.demotest.entity.Customer;
import com.customer.demotest.services.CustomerServices;
import java.util.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
  @Autowired
  private CustomerServices customerService;

  @GetMapping("/customers")
  public List<Customer> all() {
    return customerService.getAllCustomers();
  }

  @GetMapping("/customers/{phone}")
  public Customer fCustomers(@PathVariable String phone){
    return customerService.findByPhone(phone);
  }

  @PostMapping("/customers")
  public ResponseEntity<Customer> createCustomer(
    @Valid @RequestBody Customer customer
  ) {
    return ResponseEntity.ok(customerService.saveCustomers(customer));
  }

  @PutMapping("/customers/{id}")
  public ResponseEntity<Customer> updateCustomer(
    @Valid @RequestBody Customer customer,
    @PathVariable(value = "id") Long id
  ) {
    return ResponseEntity.ok(customerService.updateCustomers(customer, id));
  }

  @DeleteMapping("/customers/{id}")
  public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
    Map<String, String> response = new HashMap<String, String>();
    if (customerService.deleteCustomers(id)) {
      response.put("status", "success");
      response.put("message", "customer deleted successfully");
      return ResponseEntity.ok(response);
    } else {
      response.put("status", "error");
      response.put("message", "Somthing went wrong when delete the member");
      return ResponseEntity.status(500).body(response);
    }
  }
}
