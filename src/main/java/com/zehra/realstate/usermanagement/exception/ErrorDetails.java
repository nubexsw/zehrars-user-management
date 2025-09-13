package com.zehra.realstate.usermanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ErrorDetails {
    private LocalDate localDate;
    private String message;
    private String details;
}
