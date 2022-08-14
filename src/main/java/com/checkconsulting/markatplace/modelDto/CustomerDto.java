package com.checkconsulting.markatplace.modelDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private Integer id;
    private String username;
    private String lastname;
    private String firstname;
    private float amount;
}
