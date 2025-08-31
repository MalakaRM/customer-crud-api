package com.example.point_of_sale.service.impl;

import com.example.point_of_sale.dto.CustomerDTO;
import com.example.point_of_sale.dto.CustomerUpdateDTO;
import com.example.point_of_sale.entity.Customer;
import com.example.point_of_sale.repository.CustomerRepository;
import com.example.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.isActive(),
                customerDTO.getContactNumber()

        );
        customerRepository.save(customer);
        return customerDTO.getCustomerName();



    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepository.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepository.getReferenceById(customerUpdateDTO.getCustomerId());
                customer.setCustomerId(customerUpdateDTO.getCustomerId());
                customer.setCustomerName(customerUpdateDTO.getCustomerName());
                customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
                customer.setContactNumber(customerUpdateDTO.getContactNumber());


                customerRepository.save(customer);
                return customerUpdateDTO.getCustomerName() +"updated successfull";
        }else{
            throw new RuntimeException("no data found for that id");
        }


    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepository.existsById(customerId)){
            Customer customer = customerRepository.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive(),
                    customer.getContactNumber()

            );
            return customerDTO;
        }else{
            throw new RuntimeException("no customer");
        }


    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepository.findAll();

        List<CustomerDTO> CustomerDTOList = new ArrayList<>();
        for (Customer customer : getAllCustomers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive(),
                    customer.getContactNumber()
            );
            CustomerDTOList.add(customerDTO);
        }
        return CustomerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepository.existsById(customerId)){
            customerRepository.deleteById(customerId);
            return "deleted successully";
        }else{
            throw new RuntimeException("No customer");
        }

    }
}
