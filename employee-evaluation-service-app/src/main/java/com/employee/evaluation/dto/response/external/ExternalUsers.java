package com.employee.evaluation.dto.response.external;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExternalUsers {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Address address;
    private Company company;
}
