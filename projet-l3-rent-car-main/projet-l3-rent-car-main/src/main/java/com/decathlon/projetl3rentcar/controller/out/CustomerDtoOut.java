package com.decathlon.projetl3rentcar.controller.out;

import com.decathlon.projetl3rentcar.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDtoOut {
    private int id;
    private String name;
    private String email;
    private String phone;

    public CustomerDtoOut(Customer customer ) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
    }

}
