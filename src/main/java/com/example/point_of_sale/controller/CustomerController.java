package com.example.point_of_sale.controller;

import com.example.point_of_sale.dto.CustomerDTO;
import com.example.point_of_sale.dto.CustomerUpdateDTO;
import com.example.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping("/update")
    public String udateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        customerService.updateCustomer(customerUpdateDTO);
        return "updated";
    }
    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping("/get-all-customers")
    public List<CustomerDTO> getALLCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(
            path = "delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String deleted  = customerService.deleteCustomer(customerId);
        return deleted;
    }


}
