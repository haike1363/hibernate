package pers.haike.demo.hibernate.entity;

import lombok.Data;

@Data
public class Contact {
    private String email;
    private String address;
    private String zipCode;
    private String contactTel;
}