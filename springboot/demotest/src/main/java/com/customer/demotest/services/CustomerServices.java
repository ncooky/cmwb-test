package com.customer.demotest.services;


import com.customer.demotest.entity.Customer;
import com.customer.demotest.repositories.Customerrepositories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServices {
  @Autowired
  private Customerrepositories customersRepository;

  public Customer findByName(String name) {
    return customersRepository.findByName(name);
  }

  public Customer findByPhone(String phone) {
    return customersRepository.findByPhone(phone);
  }

  public List<Customer> getAllCustomers() {
    return customersRepository.findAll();
  }

  public Customer saveCustomers(Customer Customers) {
    return customersRepository.save(Customers);
  }

  public Customer updateCustomers(Customer Customers, Long id) {
    Customer updateCustomers = customersRepository.findById(id).orElse(null);
    if (updateCustomers != null) {
      updateCustomers.setName(Customers.getName());
    }
    final Customer myCustomers = customersRepository.save(updateCustomers);
    return myCustomers;
  }

  public Boolean deleteCustomers(Long id) {
    Customer delCustomers = customersRepository.findById(id).orElse(null);
    if (delCustomers != null) {
      customersRepository.delete(delCustomers);
      return true;
    }
    return false;
  }
}

