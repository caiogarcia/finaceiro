package com.github.caiogarcia.financeiro.bank.entrypoint.entity;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankEntity {

    private Integer idBank;
    @NotBlank(message = "Campo obrigatório.")
    private String code;
    @NotBlank(message = "Campo obrigatório.")
    private String name;
}
