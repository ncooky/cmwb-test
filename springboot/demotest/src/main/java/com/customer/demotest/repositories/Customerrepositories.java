package com.customer.demotest.repositories;
import com.customer.demotest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("customersRepository")
public interface Customerrepositories extends JpaRepository<Customer, Long>  {
    Customer findByName(String name);

    Customer findByPhone(String phone);
}
