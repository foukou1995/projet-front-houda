package com.decathlon.projetl3rentcar.controller.in;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDtoIn {
    private String name;
    private String email;
    private String phone;
}
