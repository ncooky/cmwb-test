package com.customer.demotest.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name= "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cust_id")
    private Long id;

    @Column(name="cust_name")
    @NotEmpty(message="* Please Enter Customer Name")
    private String name;

    @NotEmpty(message=" * Please Provide customer Phone Number")
    @Column(name="cust_phone")
    private String phone;

}