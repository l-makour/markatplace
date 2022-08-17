package com.checkconsulting.marketplace.utils;

import com.checkconsulting.marketplace.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomResponse <T>{
    T customDto;
    String errorMessage;
    ResponseStatus responseStatus;
}
