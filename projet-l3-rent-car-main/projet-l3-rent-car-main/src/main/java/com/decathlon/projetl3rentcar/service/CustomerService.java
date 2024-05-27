package com.decathlon.projetl3rentcar.service;

import com.decathlon.projetl3rentcar.controller.in.CustomerDtoIn;
import com.decathlon.projetl3rentcar.controller.in.VehicleDtoIn;
import com.decathlon.projetl3rentcar.controller.out.CustomerDtoOut;
import com.decathlon.projetl3rentcar.controller.out.VehicleDtoOut;
import com.decathlon.projetl3rentcar.entity.Customer;
import com.decathlon.projetl3rentcar.entity.Vehicle;
import com.decathlon.projetl3rentcar.repository.CustomerRepository;
import com.decathlon.projetl3rentcar.repository.VehicleRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@Service
@RequiredArgsConstructor
@Validated
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;
    public List<CustomerDtoOut> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerDtoOut::new).toList();
    }

    public CustomerDtoOut createCustomer(@Valid CustomerDtoIn customerDtoIn) {
        //validateComponent(componentDtoIn);
        Customer customer = Customer.builder()
                .email(customerDtoIn.getEmail())
                .name(customerDtoIn.getName())
                .phone(customerDtoIn.getPhone())
                .build();
        customer = customerRepository.save(customer);
        return new CustomerDtoOut(customer);
    }

//    public void deleteVehicle(Integer vehicleId){
//        Vehicle vehicle = vehicleRepository.findById(vehicleId)
//                .orElseThrow(() -> new ResponseStatusException(NO_CONTENT, "Vehicle for id " + vehicleId + " already deleted or never created"));
//        vehicleRepository.delete(vehicle);
//    }


}
