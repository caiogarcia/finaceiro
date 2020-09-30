package com.github.caiogarcia.financeiro.banco.entrypoint.entity;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BancoEntity {

    private Integer idBanco;
    @NotBlank(message = "Campo obrigatório.")
    private String codigo;
    @NotBlank(message = "Campo obrigatório.")
    private String nome;
}
