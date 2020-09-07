package com.github.caiogarcia.financeiro.configuration.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroDetalhado {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
