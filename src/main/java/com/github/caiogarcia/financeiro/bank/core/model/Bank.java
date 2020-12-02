package com.github.caiogarcia.financeiro.bank.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    private Integer idBank;
    private String code;
    private String name;

}
