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
public class ResponseGeneric<T>{
    T Dto;
    String errorMessage;
    ResponseStatus responseStatus;
}
