package com.example.plannerbackendmonolith.exceptionutil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorResponse {

    private List<Violation> violations = new ArrayList<>();
}
