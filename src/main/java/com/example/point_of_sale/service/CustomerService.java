package com.example.point_of_sale.service;

import com.example.point_of_sale.dto.CustomerDTO;
import com.example.point_of_sale.dto.CustomerUpdateDTO;

import java.util.List;


public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);
}
