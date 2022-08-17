package com.checkconsulting.marketplace.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Customer {
    @Id
    private Integer id;
    private String username;
    private String lastname;
    private String firstname;
    private Float amount;
}
